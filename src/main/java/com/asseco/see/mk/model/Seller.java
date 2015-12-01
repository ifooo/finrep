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
@Table(name="sellers")
public class Seller implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="seller")
	private String seller;
	
	public Seller(){}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(seller).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Seller))
			return false;
		if (obj == this)
			return true;

		Seller rhs = (Seller) obj;
		return new EqualsBuilder().append(id, rhs.id).append(seller, rhs.seller).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("seller", this.seller).toString();
	}


}
