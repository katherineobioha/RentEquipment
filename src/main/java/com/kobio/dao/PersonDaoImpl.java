package com.kobio.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kobio.model.Person;

@Repository("PersonDao")
public class PersonDaoImpl implements PersonDao {

	
	private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionfactory = sf;
	}
	
	@Override
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		Session session = this.sessionfactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
		
	}
	
	@Override
	public void updatePerson(Person p) {
		// TODO Auto-generated method stub
		Session session = this.sessionfactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPerson() {
		// TODO Auto-generated method stub
		Session session = this.sessionfactory.getCurrentSession();
		List<Person> PersonList = session.createQuery("from Person").list();
		for(Person p : PersonList){
			logger.info("Person List::"+p);
		}
		return PersonList;
	}
	
	
	@Override
	public void removePerson(String username) {
		// TODO Auto-generated method stub
		Session session = this.sessionfactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new String(username));
		if(p != null)
		{
			session.delete(p);
		}
		logger.info("Person successfully deleted, Person details::"+p );
		
	}
	
	
	 public Person getperson()
	{
		Session session = this.sessionfactory.getCurrentSession();
		Person p = (Person) session.createQuery("select * from person");
		return p;
		
	}
	
	@Override
	public Person getPersonbyPersonname(String username) {
		// TODO Auto-generated method stub
		logger.info("username");
		Criteria session = this.sessionfactory.getCurrentSession().createCriteria(Person.class);
		//Person u= (Person) session.load(Person.class, new String(username));
		session.add(Restrictions.like("username", username));
		logger.info("Person successfully loaded, Person details=" );
		return (Person) session.uniqueResult();
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionfactory.getCurrentSession();		
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}
	
	public SessionFactory getsessionFactory()
	{
		return sessionfactory;
		
	}
	

}
