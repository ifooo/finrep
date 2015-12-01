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
@Table(name="sectors")
public class Sector implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="sector")
	private String sector;
	
	public Sector(){
		
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(sector).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Sector))
			return false;
		if (obj == this)
			return true;

		Sector rhs = (Sector) obj;
		return new EqualsBuilder().append(id, rhs.id).append(sector, rhs.sector).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("sector", this.sector).toString();
	}


}
