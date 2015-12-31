package com.asseco.see.mk.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "records")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Client client;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn
	private Sector sectorr;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn
	private Project project;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn
	private Seller seller;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn
	private Status status;

//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	@JoinColumn
//	private Report report;

	@Column(name = "plan_date")
	private String pDate;

	@Column(name = "plan_cogs")
	private float pCogs;

	@Column(name = "plan_opex")
	private float pOpex;

	@Column(name = "provision_cost_date")
	private String provCostDate;

	@Column(name = "provision_cost_cogs")
	private float provCostCogs;

	@Column(name = "provision_cost_opex")
	private float provCostOpex;

	@Column(name = "closing_provision_date")
	private String closingProvisionDate;

	@Column(name = "closing_provision_cogs")
	private float closingProvisionCogs;

	@Column(name = "closing_provision_opex")
	private float closingProvisionOpex;

	@Column(name = "remaining_amount_cogs")
	private float remAmountCogs;

	@Column(name = "remainig_mmount_opex")
	private float remAmountOpex;

	public Reservation() {
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sector getSectorr() {
		return sectorr;
	}

	public void setSectorr(Sector sectorr) {
		this.sectorr = sectorr;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public float getpCogs() {
		return pCogs;
	}

	public void setpCogs(float pCogs) {
		this.pCogs = pCogs;
	}

	public float getpOpex() {
		return pOpex;
	}

	public void setpOpex(float pOpex) {
		this.pOpex = pOpex;
	}

	public String getProvCostDate() {
		return provCostDate;
	}

	public void setProvCostDate(String cpDate) {
		this.provCostDate = cpDate;
	}

	public float getProvCostCogs() {
		return provCostCogs;
	}

	public void setProvCostCogs(float cpCogs) {
		this.provCostCogs = cpCogs;
	}

	public float getProvCostOpex() {
		return provCostOpex;
	}

	public void setProvCostOpex(float cpOpex) {
		this.provCostOpex = cpOpex;
	}

	public String getClosingProvisionDate() {
		return closingProvisionDate;
	}

	public void setClosingProvisionDate(String closingProvisionDate) {
		this.closingProvisionDate = closingProvisionDate;
	}

	public float getClosingProvisionCogs() {
		return closingProvisionCogs;
	}

	public void setClosingProvisionCogs(float closingProvisionCogs) {
		this.closingProvisionCogs = closingProvisionCogs;
	}

	public float getClosingProvisionOpex() {
		return closingProvisionOpex;
	}

	public void setClosingProvisionOpex(float closingProvisionOpex) {
		this.closingProvisionOpex = closingProvisionOpex;
	}

	public float getRemAmountCogs() {
		return remAmountCogs;
	}

	public void setRemAmountCogs(float remAmountCogs) {
		this.remAmountCogs = remAmountCogs;
	}

	public float getRemAmountOpex() {
		return remAmountOpex;
	}

	public void setRemAmountOpex(float remAmountOpex) {
		this.remAmountOpex = remAmountOpex;
	}

	public Long getId() {
		return id;
	}

//	public Report getReport() {
//		return report;
//	}
//
//	public void setReport(Report report) {
//		this.report = report;
//	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(sectorr).append(client).append(project).append(seller)
				.append(status).append(pDate).append(pCogs).append(pOpex).append(provCostDate).append(provCostCogs)
				.append(provCostOpex).append(closingProvisionDate).append(closingProvisionCogs)
				.append(closingProvisionOpex).append(remAmountCogs).append(remAmountOpex).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Reservation))
			return false;
		if (obj == this)
			return true;

		Reservation rhs = (Reservation) obj;
		return new EqualsBuilder().append(id, rhs.id).append(sectorr, rhs.sectorr).append(project, rhs.project)
				.append(seller, rhs.seller).append(status, rhs.status).append(pDate, rhs.pDate).append(pCogs, rhs.pCogs)
				.append(pOpex, rhs.pOpex).append(provCostDate, rhs.provCostDate).append(provCostCogs, rhs.provCostCogs)
				.append(provCostOpex, rhs.provCostOpex).append(closingProvisionDate, rhs.closingProvisionDate)
				.append(closingProvisionCogs, rhs.closingProvisionCogs)
				.append(closingProvisionOpex, rhs.closingProvisionOpex).append(remAmountCogs, rhs.remAmountCogs)
				.append(remAmountOpex, rhs.remAmountOpex).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("sectorr", this.sectorr)
				.append("client", this.client).append("project", this.project).append("sales person", this.seller)
				.append("status", this.status).append("plan date", this.pDate).append("plan cogs(eur)", this.pCogs)
				.append("plan opex(eur)", this.pOpex).append("provision cost date", this.provCostDate)
				.append("provision cost cogs(eur)", this.provCostCogs)
				.append("provision cost opex(eur)", this.provCostOpex)
				.append("closing provision date", this.closingProvisionDate)
				.append("closing provision cogs(eur)", this.closingProvisionCogs)
				.append("closing provision opex(eur)", this.closingProvisionOpex)
				.append("remaining amount COGS(eur)", this.remAmountCogs)
				.append("remainng amount OPEX(eur)", this.remAmountOpex).toString();
	}
}
