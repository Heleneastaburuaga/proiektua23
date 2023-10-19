package test.dataAccess;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import dataAccess.DataAccess;
import dataAccess.DataAccessGertaeraEzabatu;
import domain.Event;

public class DataAccessGertaeraEzabatuTest {
	static DataAccessGertaeraEzabatu sut=new DataAccessGertaeraEzabatu();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();

	private Event ev;
	@Test
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

}
