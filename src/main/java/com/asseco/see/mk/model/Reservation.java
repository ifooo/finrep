package com.asseco.see.mk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "reservation_name")
	private String name;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "date_modified")
	private Date dateModified;

	@OneToMany(mappedBy = "reservation")
	private Set<Record> records;

	public Reservation() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public int getId() {
		return id;
	}

	public Set<Record> getRecords() {
		return records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).append(modifiedBy).append(dateModified).append(records)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Reservation))
			return false;
		if (obj == this)
			return true;

		Reservation rhs = (Reservation) obj;
		return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(modifiedBy, rhs.modifiedBy)
				.append(dateModified, rhs.dateModified).append(records, rhs.records).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("name", this.name)
				.append("modified by", this.modifiedBy).append("date of modification", this.dateModified)
				.append("records", this.records).toString();
	}

}
