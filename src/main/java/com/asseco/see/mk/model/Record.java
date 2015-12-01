package com.asseco.see.mk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "records")
public class Record implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToMany
	private Set<Client> clients;

	@ManyToMany
	private Set<Sector> sectors;

	@ManyToMany
	private Set<Project> projects;

	@ManyToMany
	private Set<Seller> sellers;

	@ManyToMany
	private Set<Status> statuses;
	
	@Column(name="plan_date")
	private Date pDate;
	
	@Column(name="plan_cogs")
	private float pCogs;
	
	@Column(name="plan_opex")
	private float pOpex;
	
	@Column(name="provision_cost_date")
	private Date cpDate;
	
	@Column(name="provision_cost_cogs")
	private float cpCogs;
	
	@Column(name="closing_provision_opex")
	private float cpOpex;
	
	@Column(name="closing_provision_date")
	private Date closingProvisionDate;
	
	@Column(name="closing_provision_cogs")
	private float closingProvisionCogs;
	
	@Column(name="closing_provision_opex")
	private float closingProvisionOpex;
	
	@Column(name="remaining_amount_cogs")
	private float remAmountCogs;
	
	@Column(name="remainig_mmount_opex")
	private float remAmountOpex;
	

	public Record() {
	}


	public Set<Client> getClients() {
		return clients;
	}


	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}


	public Set<Sector> getSectors() {
		return sectors;
	}


	public void setSectors(Set<Sector> sectors) {
		this.sectors = sectors;
	}


	public Set<Project> getProjects() {
		return projects;
	}


	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}


	public Set<Seller> getSellers() {
		return sellers;
	}


	public void setSellers(Set<Seller> sellers) {
		this.sellers = sellers;
	}


	public Set<Status> getStatuses() {
		return statuses;
	}


	public void setStatuses(Set<Status> statuses) {
		this.statuses = statuses;
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
		return cpDate;
	}


	public void setCpDate(Date cpDate) {
		this.cpDate = cpDate;
	}


	public float getCpCogs() {
		return cpCogs;
	}


	public void setCpCogs(float cpCogs) {
		this.cpCogs = cpCogs;
	}


	public float getCpOpex() {
		return cpOpex;
	}


	public void setCpOpex(float cpOpex) {
		this.cpOpex = cpOpex;
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
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("sectors", this.sectors).append("clients", this.clients).append("projects",this.projects).append("sales persons", this.sellers).append("plan date", this.pDate).append("plan cogs(eur)",this.pCogs).append("").toString();
	}
}
