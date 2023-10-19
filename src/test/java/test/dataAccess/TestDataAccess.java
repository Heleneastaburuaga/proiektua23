package test.dataAccess;

import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import configuration.ConfigXML;
import domain.Event;
import domain.Question;
import domain.Quote;

public class TestDataAccess {
	protected  EntityManager  db;
	protected  EntityManagerFactory emf;

	ConfigXML  c=ConfigXML.getInstance();


	public TestDataAccess()  {
		
		System.out.println("Creating TestDataAccess instance");

		open();
		
	}

	
	public void open(){
		
		System.out.println("Opening TestDataAccess instance ");

		String fileName=c.getDbFilename();
		
		if (c.isDatabaseLocal()) {
			  emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
			  db = emf.createEntityManager();
		} else {
			Map<String, String> properties = new HashMap<String, String>();
			  properties.put("javax.persistence.jdbc.user", c.getUser());
			  properties.put("javax.persistence.jdbc.password", c.getPassword());

			  emf = Persistence.createEntityManagerFactory("objectdb://"+c.getDatabaseNode()+":"+c.getDatabasePort()+"/"+fileName, properties);

			  db = emf.createEntityManager();
    	   }
		
	}
	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}

	public boolean removeEvent(Event ev) {
		System.out.println(">> DataAccessTest: removeEvent");
		Event e = db.find(Event.class, ev.getEventNumber());
		if (e!=null) {
			db.getTransaction().begin();
			db.remove(e);
			db.getTransaction().commit();
			return true;
		} else 
		return false;
    }
	public boolean removeQuestion(Question  gal) {
		System.out.println(">> DataAccessTest: removeEvent");
		Question e = db.find(Question.class, gal.getQuestionNumber());
		if (e!=null) {
			db.getTransaction().begin();
			db.remove(e);
			db.getTransaction().commit();
			return true;
		} else 
		return false;
    }
	public boolean removeQuote(Quote  q) {
		System.out.println(">> DataAccessTest: removeEvent");
		Quote e = db.find(Quote.class, q.getQuoteNumber());
		if (e!=null) {
			db.getTransaction().begin();
			db.remove(e);
			db.getTransaction().commit();
			return true;
		} else 
		return false;
    }

		
		public Event addEventWithQuestion(String desc, Date d, String question, float qty) {
			System.out.println(">> DataAccessTest: addEvent");
			Event ev=null;
				db.getTransaction().begin();
				try {
				    ev=new Event(desc,d);
				    ev.addQuestion(question, qty);
					db.persist(ev);
					db.getTransaction().commit();
				}
				catch (Exception e){
					e.printStackTrace();
				}
				return ev;
	    }
		public Event addEventWithQuestion2(String desc, Date d, String question, float qty,Integer evNum) {
			System.out.println(">> DataAccessTest: addEvent");
			Event ev=null;
				db.getTransaction().begin();
				try {
				    ev=new Event(evNum,desc,d);
				    ev.addQuestion(question, qty);
					db.persist(ev);
					db.getTransaction().commit();
				}
				catch (Exception e){
					e.printStackTrace();
				}
				return ev;
	    }
		public Question addQuestion(int num,  String question, float qty,String res,Event ev) {
			System.out.println(">> DataAccessTest: addEvent");
			Question gal=null;
				db.getTransaction().begin();
				try {
					gal = new Question(num,question,qty,ev);
					gal.setResult(res);
					gal.addQuote(2.0, res, gal);
					db.persist(gal);
					db.getTransaction().commit();
				}
				catch (Exception e){
					e.printStackTrace();
				}
				return gal;
	    }
		public Event addEvent(String desc, Date d) {
			System.out.println(">> DataAccessTest: addEvent");
			Event ev=null;
				db.getTransaction().begin();
				try {
				    ev=new Event(desc,d);
					db.persist(ev);
					db.getTransaction().commit();
				}
				catch (Exception e){
					e.printStackTrace();
				}
				return ev;
	    }
		
		public Quote addQuote(int quoteNumber, Double balioa,String forecast, Question question) {
			System.out.println(">> DataAccessTest: addQuote");
			Quote qu=null;
				db.getTransaction().begin();
				try {
				    qu=new Quote(quoteNumber,balioa,forecast,question);
					db.persist(qu);
					db.getTransaction().commit();
				}
				catch (Exception e){
					e.printStackTrace();
				}
				return qu;
	    }
	
		public boolean existQuestion(Event ev,Question q) {
			System.out.println(">> DataAccessTest: existQuestion");
			Event e = db.find(Event.class, ev.getEventNumber());
			if (e!=null) {
				return e.DoesQuestionExists(q.getQuestion());
			} else 
			return false;
		}
		
		public boolean existEvent(Event ev) {
			System.out.println(">> DataAccessTest: existEvent");
			Event e = db.find(Event.class, ev.getEventNumber());
			if (e!=null) {
				return true;
			} else 
				return false;
		}
}

