package businessLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import domain.Event;

public class Main {
	public static void main(String[]    args)    {
	    BLFacadeFactory factory = new LocalBLFacadeFactory();
	    BLFacade blFacade = factory.createBLFacade();
	    SimpleDateFormat  sdf =  new SimpleDateFormat("dd/MM/yyyy");
	    Date    date;
	    try {
	        date =    sdf.parse("17/12/2023");
	        ExtendedIterator<Event> i = blFacade.getEventsIterator(date);
	        Event    e;
	        i.goLast();    //    Hacia atrás
	        while (i.hasPrevious())    {
	            e =    i.previous();
	            System.out.println(e.toString());
	        }
	        System.out.println();

	        i.goFirst();
	        while (i.hasNext())    {
	            e =    i.next();
	            System.out.println(e.toString());
	        }
	    }    catch (ParseException    e1)    {
	        System.out.println("Data arazoak     " +    "17/12/2023");
	    }
	}
}
