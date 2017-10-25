package com.kobio.security;

import java.util.List;

import com.kobio.model.*;

public interface PersonService {
	
	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPerson();
	public Person getPersonbyPersonname(String Personname);
	public Person getPersonById(int id);
	public void removePerson(String username);
}
