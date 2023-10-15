import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Quote;
import exceptions.QuestionAlreadyExist;
import test.dataAccess.TestDataAccess;

public class GertaeraEzabatuDAWTest {
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();

	private Event ev;
	private Question gal;
	private Quote q;
	
	@Test
	//sut.gertaeraEzabatu: Ebentuak ez du galderarik eta oraindik ez da gertatu
	public void test1() {
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
	//sut.gertaeraEzabatu:  Ebentuak galdera bat du baina emaitzrik gabe beraz false izan beharko litzake
	public void test2() {
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
	//sut.gertaeraEzabatu:  Ebentuak galdera bat du emaitzarekin
	
	public void test3() {
		try {
			//define paramaters
			String eventText="event30";
			Integer eventNum=30;
			Float betMinimum=new Float(2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;;
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				e.printStackTrace();
			}	
			
			testDA.open();
			ev = testDA.addEventWithQuestion2(eventText,oneDate,"query2", betMinimum,eventNum);
			gal = testDA.addQuestion(54,"query2", betMinimum,"Reala",ev);
			q= testDA.addQuote(15,2.0,"Reala", gal);
			
			testDA.close();	
			
			boolean q=sut.gertaeraEzabatu(ev);
			assertTrue(q==true);
			
			testDA.open();
			boolean exist = testDA.existEvent(ev);
			assertTrue(exist==false);
			testDA.close();
			
	
		} catch (Exception  e) {
			fail();
		} finally {
			testDA.open();
			boolean b3=testDA.removeQuote(q);
			boolean b2=testDA.removeQuestion(gal);
			boolean b=testDA.removeEvent(ev);
			testDA.close();
		}
	}
	


}
