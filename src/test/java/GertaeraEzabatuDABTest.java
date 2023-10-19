import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import dataAccess.DataAccess;
import domain.Event;
import test.dataAccess.TestDataAccess;

public class GertaeraEzabatuDABTest {
	static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();

	private Event ev;
	public void test1() {
		try {
			//define paramaters
			String eventText="event1";
			Float betMinimum=new Float(2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;;
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				e.printStackTrace();
			}	
			testDA.open();
			ev = testDA.addEventWithQuestion(eventText,oneDate,"query2", betMinimum);
			testDA.close();			
			boolean q=sut.gertaeraEzabatu(ev);
			assertTrue(q==false);
			
			testDA.open();
			boolean exist = testDA.existEvent(ev);
			assertTrue(exist==true);
			testDA.close();
	
		} catch (Exception  e) {
			fail();
		} finally {
			testDA.open();
			boolean b=testDA.removeEvent(ev);
			testDA.close();
		}
	}
	@Test
	//sut.createQuestion:  The event is not in db. The test fail()
		public void test4() {
			try {
				String eventText="event1";
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date oneDate=null;;
				try {
				oneDate = sdf.parse("30/11/2022");
				} catch (ParseException e) {
					e.printStackTrace();
				}	
				ev=new Event(eventText,oneDate);
				boolean q=sut.gertaeraEzabatu(ev);
				assertTrue(q==false);
				
			} catch (Exception e) {
				fail();
			} 
		}
	@Test
	//sut.gertaeraEzabatu: Ebentuak ez du galderarik eta oraindik ez da gertatu
	public void test5() {
		try {
			String eventText="event1";
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;;
			try {
			oneDate = sdf.parse("30/11/2023");
			} catch (ParseException e) {
				e.printStackTrace();
			}	
			testDA.open();
			ev = testDA.addEvent(eventText,oneDate);
			testDA.close();	
			
			boolean q=sut.gertaeraEzabatu(ev);
			assertTrue(q==true);
			
			testDA.open();
			boolean exist = testDA.existEvent(ev);
			assertTrue(exist==false);
			testDA.close();
		}catch(Exception e) {
			fail();
		}
	}
	@Test
	//sut.createQuestion:  The event is null. The test fail()
		public void test3() {
			try {
				boolean q=sut.gertaeraEzabatu(null);
				assertTrue(q==false);
			
			} catch (Exception e) {
				fail();
			} 
		}
	@Test
	//sut.createQuestion:  The question is null, orduen gertaera ezabatu izanbikozan true galderarik
	//ez dauelako. The test fail eman bikodau true eta ematen dau false
		public void test27() {
			try {
				
				//define paramaters
				String eventText="event1";
				String queryText=null;
				Float betMinimum=new Float(2);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date oneDate=null;;
				try {
					oneDate = sdf.parse("05/10/2022");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				//configure the state of the system (create object in the dabatase)
				testDA.open();
				ev = testDA.addEventWithQuestion(eventText,oneDate,queryText, betMinimum);
				testDA.close();			
				//invoke System Under Test (sut)  
				
				boolean q=sut.gertaeraEzabatu(ev);
				//verify the results
				assertTrue(q==true);
				
				
				//q datubasean dago
				
			   } catch (Exception e) {
				// TODO Auto-generated catch block
				// if the program goes to this point fail  
				fail();
				} finally {
					  //Remove the created objects in the database (cascade removing)   
					testDA.open();
			          boolean b=testDA.removeEvent(ev);
			          testDA.close();
			      //     System.out.println("Finally "+b);          
			        }
			   }
	@Test
	//sut.createQuestion:  Ebentuak ez du galderarik. Errorea ez du izten gertaera ezabatzen 
	//Test fail emanbikozauen true eta ematen dau fail();
		public void test36() {
			try {
				
				//define paramaters
				String eventText="event1";
				String queryText=null;
				Float betMinimum=new Float(2);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date oneDate=null;;
				try {
					oneDate = sdf.parse("05/10/2022");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				Event ebentua= new Event(eventText,oneDate);
				//configure the state of the system (create object in the dabatase)
			
				//invoke System Under Test (sut)  
				testDA.open();
				ev = testDA.addEvent(eventText,oneDate);
				testDA.close();		
				boolean q=sut.gertaeraEzabatu(ebentua);
				//verify the results
				assertTrue(q==true);
				
				//q datubasean dago
				
			   } catch (Exception e) {
				// TODO Auto-generated catch block
				// if the program goes to this point fail  
				fail();
				} finally {
					  //Remove the created objects in the database (cascade removing)   
					testDA.open();
			          boolean b=testDA.removeEvent(ev);
			          testDA.close();
			      //     System.out.println("Finally "+b);          
			        }
			   }
}
