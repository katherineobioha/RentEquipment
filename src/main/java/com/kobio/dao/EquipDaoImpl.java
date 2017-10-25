package com.kobio.dao;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kobio.model.Equipment;

/**
 * Equipment Repository and also runs Client Transactional operations
 * @author chidinmaobioha
 *
 */
@Repository
public class EquipDaoImpl implements EquipDao  {

	@Autowired
	private SessionFactory sessionfactory;
	
	private static final Logger logger = LoggerFactory.getLogger(EquipDaoImpl.class);
	
	
	public void setSessionfactory(SessionFactory sf) {
		this.sessionfactory = sf;
	}
	
	//Run only once for backup
     @Transactional
	public void indexEquipment() throws Exception
	   {
	      try
	      {
	         Session session =this.sessionfactory.getCurrentSession();
	      
	         FullTextSession fullTextSession = Search.getFullTextSession(session);
	         fullTextSession.createIndexer().startAndWait();
	      }
	      catch(Exception e)
	      {
	         throw e;
	      }
	   }
	 
	@Transactional
	public void updateEquip(Equipment e) {
		// TODO Auto-generated method stub
		Session session = this.sessionfactory.getCurrentSession();
		session.update(e);
		logger.info("Equipment updated successfully, Equipment Details="+e);
	}
		


	@SuppressWarnings("unchecked")
	@Transactional
	public List<Equipment> listEquip() {
		// TODO Auto-generated method stub
		Session session = this.sessionfactory.getCurrentSession();
		List<Equipment> Equiplist = session.createQuery("from Equipment").list();
		for(Equipment e : Equiplist){
			logger.info("Equipment List::"+e);
		}
		return Equiplist;
	}

	@Transactional
	public Equipment getEquipmentById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionfactory.getCurrentSession();		
		Equipment p = (Equipment) session.load(Equipment.class, new Integer(id));
		logger.info("Equipment loaded successfully, Equipment details="+p);
		return p;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Equipment>getEquipmentsbyUserid(int userid)
	{
		
			Session session = sessionfactory.getCurrentSession();
			List<Equipment> Equipl = session.createQuery("from Equipment where userid =" + userid).list();
			return Equipl;
	   
		}


	
	@SuppressWarnings("unchecked")
	@Transactional
	   public List<Equipment> searchForEquipment(String searchText) throws ObjectNotFoundException
	   {
	      try
	      {
	         Session session = sessionfactory.getCurrentSession();
	         
	         FullTextSession FullTextSession = Search.getFullTextSession(session);

	         QueryBuilder querybuilder = FullTextSession.getSearchFactory()
	           .buildQueryBuilder().forEntity(Equipment.class).get();
	         
	         org.apache.lucene.search.Query LuceneQuery = querybuilder
	           .keyword().onFields("name", "manufacturer", "location")
	           .matching(searchText) 
	           .createQuery();

	         org.hibernate.Query hiberquery = 
	            FullTextSession.createFullTextQuery(LuceneQuery, Equipment.class);
	         
	         List<Equipment> results = hiberquery.list();
	         logger.info("print" + results);
	         return results;
	      }
	      catch(ObjectNotFoundException e)
	      {
	    	  	logger.info("cannot find" + e);
	    	  	return null;
	      }
	      
	     
	   }


	

	

}
