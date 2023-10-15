import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import dataAccess.DataAccess;

public class GertaerakSortuDABTest {
	DataAccess sut=new DataAccess();

	@Test
	public void test1() {

			Date d = new Date(2023, 9, 22);
			boolean emaitza = sut.gertaerakSortu("Athletic-Alaves", d, "Futbol");
			assertFalse(emaitza);

	}
	
	@Test
	public void test2() {
			
			Date d = new Date(2023, 10, 8);
/*		
			Team lokala = new Team("Betis");
			Team kanpokoa = new Team("Alaves");
			Event ev = new Event("Betis-Alaves", d, lokala, kanpokoa);		
			sut.gertaeraEzabatu(ev);
*/			
			boolean emaitza = sut.gertaerakSortu("Betis-Alaves", d, "Futbol");
			assertTrue(emaitza);

	}
	
	@Test
	public void test3() {
	//	try {

			Date d = new Date(2023, 10, 29);
			sut.gertaerakSortu(null, d, "Baloncesto");
			fail();
/*
		} catch(NullPointerException e) {
			System.out.println("Deskribapena ezin da null izan.");
			assertTrue(true);
			e.printStackTrace();
		
		}*/
	}
	
	@Test
	public void test4() {

			Date d = new Date(2023, 10, 20);
			boolean emaitza = sut.gertaerakSortu("Betis-Betis", d, "Futbol");
			fail();

	}
	
	@Test
	public void test5() {
	//	try {

			Date d = new Date(2023, 9, 20);
			sut.gertaerakSortu("Betisalaves", d, "Futbol");
			fail();

	/*	} catch(ArrayIndexOutOfBoundsException e) {

			System.out.println("Ez daude bi talde gidoi batez banandutaz.");
			assertTrue(true);
			e.printStackTrace();

		}*/
	}
	
	@Test
	public void test6() {
		//try {

		Date d = new Date();
		boolean emaitza = sut.gertaerakSortu("Betis-Alaves", d, "Futbol");
		fail();
/*
		} catch(Exception e) {

			System.out.println("Data ezin da null izan.");
			assertTrue(true);
			e.printStackTrace();

		}*/
	}
	
	@Test
	public void test7() {
//		try {

			Date d = new Date("234");
			sut.gertaerakSortu("Betisalaves", d, "Futbol");
			fail();
/*
		} catch(IllegalArgumentException e) {

			System.out.println("Data bat jarri behar duzu.");
			assertTrue(true);
			e.printStackTrace();

		}
		*/
	}
	
	@Test
	public void test8() {
	//	try {

			Date d = new Date(2023, 9, 22);
			sut.gertaerakSortu("Betis-Alaves", d, null);
			fail();
/*
		} catch(IllegalArgumentException e) {

			System.out.println("Kirola ezin da null izan.");
			assertTrue(true);
			e.printStackTrace();

		}
		*/
	}
	
	@Test
	public void test9() {

			Date d = new Date(2023, 9, 22);
			boolean emaitza = sut.gertaerakSortu("Betis-Alaves", d, "Beisbol");
			assertFalse(emaitza);

	}
}
