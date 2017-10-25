package com.kobio.dao;

import java.util.List;


import com.kobio.model.*;

public interface PersonDao {
	
	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPerson();
	public Person getPersonById(int id);
	public Person getPersonbyPersonname(String username);
	public void removePerson(String id);

}
