package com.asseco.see.mk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "records")
public class Record implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	private Client client;

	@ManyToOne
	private Sector sector;

	@ManyToOne
	private Project project;

	@ManyToOne
	private Seller seller;

	@ManyToOne
	private Status status;

	@ManyToOne
	private Reservation reservation;

	@Column(name = "plan_date")
	private Date pDate;

	@Column(name = "plan_cogs")
	private float pCogs;

	@Column(name = "plan_opex")
	private float pOpex;

	@Column(name = "provision_cost_date")
	private Date provCostDate;

	@Column(name = "provision_cost_cogs")
	private float provCostCogs;

	@Column(name = "closing_provision_opex")
	private float provCostOpex;

	@Column(name = "closing_provision_date")
	private Date closingProvisionDate;

	@Column(name = "closing_provision_cogs")
	private float closingProvisionCogs;

	@Column(name = "closing_provision_opex")
	private float closingProvisionOpex;

	@Column(name = "remaining_amount_cogs")
	private float remAmountCogs;

	@Column(name = "remainig_mmount_opex")
	private float remAmountOpex;

	public Record() {
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Project getProject() {
		return project;
	}

	public void setProjects(Project project) {
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

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
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

	public Date getCpDate() {
		return provCostDate;
	}

	public void setCpDate(Date cpDate) {
		this.provCostDate = cpDate;
	}

	public float getCpCogs() {
		return provCostCogs;
	}

	public void setCpCogs(float cpCogs) {
		this.provCostCogs = cpCogs;
	}

	public float getCpOpex() {
		return provCostOpex;
	}

	public void setCpOpex(float cpOpex) {
		this.provCostOpex = cpOpex;
	}

	public Date getClosingProvisionDate() {
		return closingProvisionDate;
	}

	public void setClosingProvisionDate(Date closingProvisionDate) {
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

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(sector).append(client).append(project).append(seller)
				.append(status).append(pDate).append(pCogs).append(pOpex).append(provCostDate).append(provCostCogs)
				.append(provCostOpex).append(closingProvisionDate).append(closingProvisionCogs)
				.append(closingProvisionOpex).append(remAmountCogs).append(remAmountOpex).append(reservation)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Record))
			return false;
		if (obj == this)
			return true;

		Record rhs = (Record) obj;
		return new EqualsBuilder().append(id, rhs.id).append(sector, rhs.sector).append(project, rhs.project)
				.append(seller, rhs.seller).append(status, rhs.status).append(pDate, rhs.pDate).append(pCogs, rhs.pCogs)
				.append(pOpex, rhs.pOpex).append(provCostDate, rhs.provCostDate).append(provCostCogs, rhs.provCostCogs)
				.append(provCostOpex, rhs.provCostOpex).append(closingProvisionDate, rhs.closingProvisionDate)
				.append(closingProvisionCogs, rhs.closingProvisionCogs)
				.append(closingProvisionOpex, rhs.closingProvisionOpex).append(remAmountCogs, rhs.remAmountCogs)
				.append(remAmountOpex, rhs.remAmountOpex).append(reservation, rhs.reservation).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("sector", this.sector)
				.append("client", this.client).append("project", this.project).append("sales person", this.seller)
				.append("status", this.status).append("plan date", this.pDate).append("plan cogs(eur)", this.pCogs)
				.append("plan opex(eur)", this.pOpex).append("provision cost date", this.provCostDate)
				.append("provision cost cogs(eur)", this.provCostCogs)
				.append("provision cost opex(eur)", this.provCostOpex)
				.append("closing provision date", this.closingProvisionDate)
				.append("closing provision cogs(eur)", this.closingProvisionCogs)
				.append("closing provision opex(eur)", this.closingProvisionOpex)
				.append("remaining amount COGS(eur)", this.remAmountCogs)
				.append("remainng amount OPEX(eur)", this.remAmountOpex).append("reservation", this.reservation)
				.toString();
	}
}
