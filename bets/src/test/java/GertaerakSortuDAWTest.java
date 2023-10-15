import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import dataAccess.DataAccess;

public class GertaerakSortuDAWTest {
	DataAccess sut=new DataAccess();

	@Test
	public void test1() {

			Date d = new Date(2023, 10, 8);
			boolean emaitza = sut.gertaerakSortu("Alaves-Betis", d, "Beisbol");
			assertFalse(emaitza);

	}
	
	@Test
	public void test2() {

			Date d = new Date(2023, 10, 8);	
			boolean emaitza = sut.gertaerakSortu("Alaves-Betis", d, "Futbol");
/*
			Team lokala = new Team("Alaves");
			Team kanpokoa = new Team("Betis");
			Event ev = new Event("Alaves-Betis", d, lokala, kanpokoa);		
			sut.gertaeraEzabatu(ev);
*/
			assertTrue(emaitza);

	}
	
	@Test
	public void test3() {

			Date d = new Date(2023, 9, 22);	
			boolean emaitza = sut.gertaerakSortu("Betis-Alaves", d, "Futbol");
/*
			Team lokala = new Team("Athetic");
			Team kanpokoa = new Team("Alaves");
			Event ev = new Event("Athetic-Alavess", d, lokala, kanpokoa);		
			sut.gertaeraEzabatu(ev);
*/
			assertTrue(emaitza);
			
	}
	
	@Test
	public void test5() {

			Date d = new Date(2023, 9, 22);
			boolean emaitza = sut.gertaerakSortu("Athletic-Alaves", d, "Futbol");
/*
			Team lokala = new Team("Athetic");
			Team kanpokoa = new Team("Alaves");
			Event ev = new Event("Athetic-Alavess", d, lokala, kanpokoa);		
			sut.gertaeraEzabatu(ev);
*/
			assertFalse(emaitza);

	}
	
	@Test
	public void test6() {

			Date d = new Date(2023, 12, 2);	
			boolean emaitza = sut.gertaerakSortu("Osasuna-Erreala", d, "Futbol");
/*
			Team lokala = new Team("Osasuna");
			Team kanpokoa = new Team("Erreala");
			Event ev = new Event("Osasuna-Erreala", d, lokala, kanpokoa);		

			sut.gertaeraEzabatu(ev);
*/
			assertTrue(emaitza);

	}
}
