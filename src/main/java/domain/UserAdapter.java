package domain;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class UserAdapter extends AbstractTableModel {
    protected Registered registered;
    protected Vector<ApustuAnitza> apustuAnitzak = new Vector<ApustuAnitza>();
    protected String[] columnNames = new String[] { "Event", "Question", "EventDate", "Bet€" };

    public UserAdapter(Registered r) {
        Vector<ApustuAnitza> aa = r.getApustuAnitzak();
        Iterator<ApustuAnitza> i = aa.iterator();
        while (i.hasNext()) {
            apustuAnitzak.add(i.next());
        }
        this.registered = r;
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int i) {
        return columnNames[i];
    }

    public int getRowCount() {
        return registered.getApustuAnitzak().size();
    }

    public Object getValueAt(int row, int col) {
        ApustuAnitza aa = apustuAnitzak.elementAt(row);

        if (!aa.getApustuak().isEmpty()) {
            List<Apustua> apustuak = aa.getApustuak();

            if (apustuak.size() > 1) {
                StringBuilder sb = new StringBuilder();
                for (Apustua apustua : apustuak) {
                    sb.append(apustua.getKuota().getQuestion().getEvent().getDescription()).append(", ");
                }
                return sb.toString().trim();
            } else {
                Apustua apustua = apustuak.get(0);
                if (col == 0) {
                    return apustua.getKuota().getQuestion().getEvent().getDescription();
                } else if (col == 1) {
                    return apustua.getKuota().getQuestion().getQuestion();
                } else if (col == 2) {
                    return apustua.getKuota().getQuestion().getEvent().getEventDate();
                } else if (col == 3) {
                    return apustua.getKuota().getQuote();
                }
            }
        }

        return null;
    }
   
}