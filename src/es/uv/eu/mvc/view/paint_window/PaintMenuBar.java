package es.uv.eu.mvc.view.paint_window;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PaintMenuBar extends JMenuBar {
    
    private JMenu file;
    private JMenuItem exit;
    private JMenu settings;
    private JMenuItem defaultValues;
    
    public PaintMenuBar() {
        
        this.file = new JMenu("File");
        this.exit = new JMenuItem("Exit");
        
        this.settings = new JMenu("Settings");
        this.defaultValues = new JMenuItem("Set current values to default");
        
        exit.setActionCommand("exit");
        defaultValues.setActionCommand("setCurrentValuesToDefault");
        
        file.add(exit);
        settings.add(defaultValues);
        
        this.add(file);
        this.add(settings);
    }
    
    public void setActionListener(ActionListener al) {
        exit.addActionListener(al);
        defaultValues.addActionListener(al);
    }  
}
