package com.kobio.security;



import java.util.ArrayList;






import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.kobio.dao.PersonDao;
//import com.kobio.model.Person;
import com.kobio.model.Person;

@Configurable 
@Component
@Service("PersonService")
public class PersonServiceimpl implements PersonService{
	
	@Autowired
	private PersonDao PersonDao;
	
	

	@Transactional
	public void setPersonDao(PersonDao PersonDao) {
		this.PersonDao = PersonDao;
	}

	
	@Override
	@Transactional
	public void addPerson(com.kobio.model.Person p) {
		this.PersonDao.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(com.kobio.model.Person p) {
		this.PersonDao.updatePerson(p);
	}

	@Override
	@Transactional
	public List<com.kobio.model.Person> listPerson() {
		return this.PersonDao.listPerson();
	}

	
	@Override
	@Transactional
	public void removePerson(String id) {
		this.PersonDao.removePerson(id);
	}

	@Override
	@Transactional
	public com.kobio.model.Person getPersonbyPersonname(String Personname) {
		// TODO Auto-generated method stub
		return this.PersonDao.getPersonbyPersonname(Personname);
	}
 

	@Override
	@Transactional
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return this.PersonDao.getPersonById(id);
	}





}

