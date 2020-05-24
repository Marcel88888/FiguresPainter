package es.uv.eu.mvc.view.default_values_window;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DVWMenuBar extends JMenuBar {
    
    private JMenu menu;
    private JMenuItem exit;
    
    public DVWMenuBar() {

        this.menu = new JMenu("Menu");
        this.exit = new JMenuItem("Exit");
        exit.setActionCommand("exitDVW");
        menu.add(exit);
        this.add(menu);
    }
    
    public void setActionListener(ActionListener al) {
        exit.addActionListener(al);
    }  
}
