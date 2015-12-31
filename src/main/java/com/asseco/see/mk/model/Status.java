package com.asseco.see.mk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="statuses")
public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="status")
	private String status;
	

	public Status() {
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(status).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Status))
			return false;
		if (obj == this)
			return true;

		Status rhs = (Status) obj;
		return new EqualsBuilder().append(id, rhs.id).append(status, rhs.status).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("status", this.status).toString();
	}


}
