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

@Entity
@Table(name = "sectors")
public class Sector implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "sector")
	private String sector;

	public Sector() {

	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "id: " + id + "sector: " + sector;
	}

}
