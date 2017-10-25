package com.kobio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;




/**
 * Represents a User who takes out and returns Equipments
 * @author
 *
 */


@Entity
@Table(name="Person")
public class Person 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;
	
	@NotEmpty
	private String username;
	
	@Size(min=3, max=4)
	@NotEmpty
	private String password;
	
	private int role;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private List<Equipment>equipment = new ArrayList<Equipment>();
	
	@NotEmpty
	private String firstname;
	
	private String lastname;
	
	
	@NotEmpty
	private String university;
	
	
	@NotEmpty
	private String location;

	
	public void setusername(String username)
	{
		this.username= username;
	}
	
	public String getusername()
	{
		return username;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}

	public void setpassword(String password)
	{
		this.password = password;
	}
	
	public String getpassword()
	{
		return password;
	}

	public String getuniversity() {
		return university;
	}

	public void setuniversity(String university) {
		this.university = university;
	}

	public String getlocation() {
		return location;
	}

	public void setlocation(String location) {
		this.location = location;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	
	public List<Equipment>getequipments()
	{
		return equipment;
		
	}
	public void setequipments(List<Equipment>equipment)
	{
		this.equipment = equipment;
	}
}