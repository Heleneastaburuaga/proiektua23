import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;

public class GertaeraEzabatuBLBMTest {
	DataAccess dataAccess=Mockito.mock(DataAccess.class);
	Event mockedEvent=Mockito.mock(Event.class);
		
	@InjectMocks
	BLFacade sut=new BLFacadeImplementation(dataAccess);
		
		//sut.createQuestion:  The event has one question with a queryText. 

		
	@Test
	//sut.createQuestion:  The event has NOT a question with a queryText. 
	public void test1() {
		String eventText="event1";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate=null;
		Float betMinimum=new Float(2);
		String questionText="query2";
		try {
			oneDate = sdf.parse("05/10/2022");
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		Event ev= new Event(eventText,oneDate);
		ev.addQuestion(questionText, betMinimum);
		Mockito.doReturn(false).when(dataAccess).gertaeraEzabatu(ev);
		try {
			boolean emaitza =sut.gertaeraEzabatu(ev);
			assertEquals(false,emaitza);
		} catch (Exception  e) {
				fail();
		}
	}
	
	@Test
	//sut.createQuestion:  The event has NOT a question with a queryText. 
	public void test2() {
		String eventText="event1";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate=null;
		Float betMinimum=new Float(2);
		String questionText="query2";
		try {
			oneDate = sdf.parse("05/10/2022");
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		Event ev= new Event(eventText,oneDate);
		ev.addQuestion(questionText, betMinimum);
		
		Mockito.doReturn(true).when(dataAccess).gertaeraEzabatu(ev);
		try {
			boolean emaitza =sut.gertaeraEzabatu(ev);
			assertEquals(true,emaitza);
		} catch (Exception  e) {
				fail();
		}
	}
	
	@Test
	//sut.createQuestion:  The event has NOT a question with a queryText. 
	public void test3() {
		Event ev= null;
		
		Mockito.doReturn(false).when(dataAccess).gertaeraEzabatu(ev);
		try {
			boolean emaitza =sut.gertaeraEzabatu(ev);
			assertEquals(false,emaitza);
		} catch (Exception  e) {
				fail();
		}
	}
	@Test
	//sut.createQuestion:  The event is not in db.
	public void test4() {
		String eventText="event1";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate=null;
		try {
			oneDate = sdf.parse("30/11/2022");
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		Event ev=new Event(eventText,oneDate);
		Mockito.doReturn(false).when(dataAccess).gertaeraEzabatu(ev);
		try {	
			boolean emaitza=sut.gertaeraEzabatu(ev);
			assertEquals(false,emaitza);
		} catch (Exception e) {
			fail();
		} 
	}
	@Test
	//sut.gertaeraEzabatu: Ebentuak ez du galderarik eta oraindik ez da gertatu
	public void test5() {
		Float betMinimum=new Float(2);
		String questionText="query2";
		String eventText="event1";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate=null;
		try {
			oneDate = sdf.parse("30/11/2023");
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		Event ev= new Event(eventText,oneDate);
		ev.addQuestion(questionText, betMinimum);
		Mockito.doReturn(false).when(dataAccess).gertaeraEzabatu(ev);
		try {
			boolean emaitza =sut.gertaeraEzabatu(ev);
			assertEquals(false,emaitza);
		}catch(Exception e) {
			fail();
		}
	}
}
