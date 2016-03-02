package com.asseco.see.mk.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class).csrf().and().authorizeRequests().antMatchers("/resources/**")
				.permitAll().antMatchers("/", "/home").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll();
	}

	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

		

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			
			LdapContextSource contextSource = new DefaultSpringSecurityContextSource(
					"ldap://mksk1dc01.mk.asseco-see.local/DC=mk,DC=asseco-see,DC=local");
			contextSource.setUserDn("assecoseemk\\ivo-sur-pg-pc");
			contextSource.setPassword("P@ssw0rd");
			contextSource.setReferral("follow");
			contextSource.afterPropertiesSet();

			LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> ldapAuthenticationProviderConfigurer = auth
					.ldapAuthentication();

			ldapAuthenticationProviderConfigurer
					.userSearchBase("OU=1. USERS,OU=ASSECO-SEE Macedonia users and groups")
					.userSearchFilter("(&(objectCategory=Person)(sAMAccountName={0})(memberOf:1.2.840.113556.1.4.1941:=CN=FinanceReports,OU=ALL GROUPS,OU=2. GROUPS,OU=ASSECO-SEE Macedonia users and groups,DC=mk,DC=asseco-see,DC=local))")
					.contextSource(contextSource);
		}
	}
}
