package gui;

import java.awt.Color;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeFactory;
import businessLogic.BLFacadeImplementation;
import businessLogic.ExtendedIterator;
import businessLogic.ExternalBLFacadeFactory;
import businessLogic.LocalBLFacadeFactory;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Event;

public class ApplicationLauncher { 
	
	
	
	public static void main(String[] args) {

		ConfigXML c=ConfigXML.getInstance();
	
		System.out.println(c.getLocale());
		
		Locale.setDefault(new Locale(c.getLocale()));
		
		System.out.println("Locale: "+Locale.getDefault());
		
		MainGUI a=new MainGUI();
		a.setVisible(false);
		
		MainUserGUI b = new MainUserGUI(); 
		b.setVisible(true);
		boolean isLocal=false;
		try {
			
			BLFacadeFactory factory ;
            if(c.isBusinessLogicLocal()) {
            	factory = new LocalBLFacadeFactory();
            	isLocal=true;
            }else {
            	factory = new ExternalBLFacadeFactory();
            }
            
            BLFacade appFacadeInterface = factory.createBLFacade();
            if(isLocal=true) {
            	SimpleDateFormat  sdf =  new SimpleDateFormat("dd/MM/yyyy");
         	    Date    date;
         	    try {
         	        date =    sdf.parse("17/12/2023");
         	        ExtendedIterator<Event> i = appFacadeInterface.getEventsIterator(date);
         	        Event    e;
         	        i.goLast();    
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
            
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			MainGUI.setBussinessLogic(appFacadeInterface);

			
		}catch (Exception e) {
			a.jLabelSelectOption.setText("Error: "+e.toString());
			a.jLabelSelectOption.setForeground(Color.RED);	
			
			System.out.println("Error in ApplicationLauncher: "+e.toString());
		}
		//a.pack();


	}

}
