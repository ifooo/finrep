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
@Table(name="clients")
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="client")
	private String client;
	
	public Client(){}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(client).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Client))
			return false;
		if (obj == this)
			return true;

		Client rhs = (Client) obj;
		return new EqualsBuilder().append(id, rhs.id).append(client, rhs.client).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("client", this.client).toString();
	}


}
