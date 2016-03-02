package com.asseco.see.mk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "project")
	private String project;

	public Project() {
	}

//	public Project(String project) {
//		this.project = project;
//	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(project).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Project))
			return false;
		if (obj == this)
			return true;

		Project rhs = (Project) obj;
		return new EqualsBuilder().append(id, rhs.id).append(project, rhs.project).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("project", this.project).toString();
	}

}
