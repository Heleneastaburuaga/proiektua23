package gui;

import java.awt.Font;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableModel;

import domain.ApustuAnitza;
import domain.Apustua;
import domain.Registered;
import domain.UserAdapter;

public class TableGUI extends JFrame {
    JTable table;
    Registered registered;

    public TableGUI(Registered registered) {
        this.setTitle(registered.getUsername());
        this.registered = registered;
        setFonts();
        TableModel tm = new UserAdapter(registered);
        table = new JTable(tm);

        table.setRowHeight(36);
        JScrollPane pane = new JScrollPane(table);
        this.getContentPane().add(pane);

        // Configurar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar la ventana
    }

    private static void setFonts() {
        Font font = new Font("Dialog", Font.PLAIN, 18);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
    }
}