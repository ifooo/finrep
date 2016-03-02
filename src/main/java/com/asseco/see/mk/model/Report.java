package com.asseco.see.mk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "reports")
public class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "reservation_name")
	private String name;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "date_modified")
	private Date dateModified;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "rep_rec", joinColumns = {@JoinColumn(name = "reports_id")} , inverseJoinColumns = {@JoinColumn(name = "records_id")} )
	private List<Reservation> records;

	public Report() {
		records = new ArrayList<Reservation>();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Reservation> getRecords() {
		return records;
	}

	public void setRecords(List<Reservation> records) {
		this.records = records;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).append(modifiedBy).append(dateModified).append(records)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Report))
			return false;
		if (obj == this)
			return true;

		Report rhs = (Report) obj;
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
