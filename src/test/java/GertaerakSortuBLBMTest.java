import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import exceptions.EventFinished;

public class GertaerakSortuBLBMTest {
DataAccess dbMock=Mockito.mock(DataAccess.class);
	
	@InjectMocks
	 BLFacade sut=new BLFacadeImplementation(dbMock);

	@Test
	public void test1() {
		
		String desk = "Athletic-Alaves";
		Date d = new Date(2023, 9, 22);
		String s = "Futbol";
		
		Mockito.doReturn(false).when(dbMock).gertaerakSortu(desk, d, s);
		
		try {
			boolean emaitza = sut.gertaerakSortu(desk, d, s);
			assertFalse(emaitza);
		} catch (EventFinished e) {
			fail();
		}
	}

	@Test
	public void test2() {
		
		String desk = "Betis-Alaves";
		Date d = new Date(2023, 10, 8);
		String s = "Futbol";
		
		Mockito.doReturn(true).when(dbMock).gertaerakSortu(desk, d, s);
		
		try {
			boolean emaitza = sut.gertaerakSortu(desk, d, s);
			assertTrue(emaitza);
		} catch (EventFinished e) {
			fail();
		}
	}
	
	@Test
	public void test3() {
		
		String desk = null;
		Date d = new Date(2023, 12, 29);
		String s = "Baloncesto";
		
		Mockito.when(dbMock.gertaerakSortu(desk, d, s)).thenThrow(NullPointerException.class);
		
		try {
			sut.gertaerakSortu(desk, d, s);
			fail();
		} catch (EventFinished e) {
			fail();
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}

	@Test
	public void test4() {

		String desk = "Betis-Betis";
		Date d = new Date(2023, 11, 20);
		String s = "Futbola";
		
		Mockito.doReturn(true).when(dbMock).gertaerakSortu(desk, d, s);
		
		try {
			boolean emaitza = sut.gertaerakSortu(desk, d, s);
			assertTrue(emaitza);
		} catch (EventFinished e) {
			fail();
		}
	}
	
	@Test
	public void test5() {
		
		String desk = "Betisalaves";
		Date d = new Date(2023, 9, 20);
		String s = "Futbol";
		
		Mockito.when(dbMock.gertaerakSortu(desk, d, s)).thenThrow(ArrayIndexOutOfBoundsException.class);
		
		try {
			sut.gertaerakSortu(desk, d, s);
			fail();
		} catch (EventFinished e) {
			fail();
		} catch(ArrayIndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	public void test6() {
		
		String desk = "Betis-Alaves";
		Date d = new Date();
		String s = "Futbola";
		
		Mockito.doReturn(true).when(dbMock).gertaerakSortu(desk, d, s);
		
		try {
			boolean emaitza = sut.gertaerakSortu(desk, d, s);
			assertTrue(emaitza);
		} catch (EventFinished e) {
			fail();
		}
	}
	
	@Test
	public void test7() {

		String desk = "Betis-Alaves";
		Date d = new Date(234);
		String s = "Futbol";
		
		Mockito.doReturn(true).when(dbMock).gertaerakSortu(desk, d, s);
		
		try {
			sut.gertaerakSortu(desk, d, s);
			fail();
		} catch (EventFinished e) {
			assertTrue(true);
		}
	}

	@Test
	public void test8() {
		
		String desk = "Betis-Alaves";
		Date d = new Date(2023, 9, 22);
		String s = null;
		
		Mockito.when(dbMock.gertaerakSortu(desk, d, s)).thenThrow(IllegalArgumentException.class);
		
		try {
			boolean emaitza = sut.gertaerakSortu(desk, d, s);
			fail();
		} catch (EventFinished e) {
			fail();
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test9() {
		
		String desk = "Betis-Alaves";
		Date d = new Date(2023, 9, 22);
		String s = "Beisbol";
		
		Mockito.doReturn(false).when(dbMock).gertaerakSortu(desk, d, s);
		
		try {
			boolean emaitza = sut.gertaerakSortu(desk, d, s);
			assertEquals(false, emaitza);
		} catch (EventFinished e) {
			fail();
		}
	}

}
