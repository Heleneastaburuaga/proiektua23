package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import domain.ApustuAnitza;
import domain.Apustua;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Registered;
import domain.Sport;
import domain.Team;

public class Main2 {
    public static void main(String[] args) {
        Registered registered = new Registered("Maite", "password", 123456);

        // Añadir 5 apuestas
        for (int i = 0; i < 5; i++) {
            Sport sport = new Sport("Football");
            Team localTeam = new Team("Real Sociedad");
            Team awayTeam = new Team("Real Madrid");
            Event event = new Event("Event " + (i + 1), new Date(), localTeam, awayTeam);
            Question question = new Question("Zeinek irabazi" + (i + 1), 10.0, event);
            Quote quote = new Quote(2.0, "Real Sociedad", question);

            if (quote.getQuote() == null) {
                quote.setQuote(2.0);
            }

            ApustuAnitza apustuAnitza = new ApustuAnitza(registered, 2.0);
            Apustua apustua = new Apustua(apustuAnitza, quote);
            apustua.getApustuAnitza().setBalioa(2.0);
            apustua.getKuota().getQuestion().getEvent().setDescription("Real Sociedad-Real Madrid");
            apustua.getKuota().getQuestion().setQuestion("Zeinek irabazi");
            SimpleDateFormat  sdf =  new SimpleDateFormat("dd/MM/yyyy");
     	    Date  date;
     	    try {
     	    	 date = sdf.parse("17/12/2023");
     	    	apustua.getKuota().getQuestion().getEvent().setEventDate(date);
     	   }   catch (ParseException    e1)    {
    	        System.out.println("Data arazoak     " +    "17/12/2023");
    	    }
 
            apustua.getKuota().setQuote(2.0);
            registered.addApustuAnitza(apustua.getApustuAnitza());
        }

        TableGUI gui = new TableGUI(registered);
        gui.setVisible(true);
    }
}
