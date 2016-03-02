package com.asseco.see.mk.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.asseco.see.mk.repository")
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.asseco.see.mk.configuration", "com.asseco.see.mk.controller",
		"com.asseco.see.mk.service" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	@Autowired
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setCharacterEncoding("UTF-8");
		resolver.setTemplateEngine(templateEngine);
		return resolver;
	}

	@Bean
	@Autowired
	public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(templateResolver);
		springTemplateEngine.addDialect(new SpringSecurityDialect());
		return springTemplateEngine;
	}

	@Bean
	public TemplateResolver templateResolver() {
		TemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/fin-rep-db");
		dataSource.setUsername("finrepdb");
		dataSource.setPassword("asseco$SEE#MK&01");
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10);
		return dataSource;
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource datasource,
			JpaVendorAdapter jpaDataVendor) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		emfb.setDataSource(datasource);
		emfb.setJpaVendorAdapter(jpaDataVendor);
		emfb.setPackagesToScan("com.asseco.see.mk.model");
		emfb.setJpaProperties(properties);
		emfb.afterPropertiesSet();
		return emfb;

	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		return adapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager
				.setEntityManagerFactory(entityManagerFactory(dataSource(), jpaVendorAdapter()).getObject());
		return jpaTransactionManager;
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
