package com.kobio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;


/**
 * @author Katherine Chidinma Obioha
 * 
 * Equipment model class
 */


@Entity
@Indexed
@Table(name="equipment")
public class Equipment {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;
	
	 @Column(name = "name")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String name;
	 
	 @Column(name = "manufacturer")
	 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String manufacturer;
	 
	 @Column(name = "Location")
	 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String location;
	 
	 @Column(name = "taxonomy")
	private String taxonomy;
	 
	 @Column(name = "borrowed")
	private int borrowed;
	
	 
	
	@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "userid", referencedColumnName = "ID", insertable=true, updatable=true, nullable = true)
	private Person person;
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getmanufacturer() {
		return manufacturer;
	}
	public void setmanufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location = location;
	}
	public String getTaxonomy() {
		return taxonomy;
	}
	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}
	public int getborrowed() {
		return borrowed;
	}
	public void setborrowed(int borrowed) {
		this.borrowed = borrowed;
	}
	public Person getperson() {
		return person;
	}
	public void setperson(Person person) {
		this.person = person;
	}
}
