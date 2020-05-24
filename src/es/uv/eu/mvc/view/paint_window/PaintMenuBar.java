package es.uv.eu.mvc.view.paint_window;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PaintMenuBar extends JMenuBar {
    
    private JMenu file;
    private JMenuItem save;
    private JMenuItem authors;
    private JMenuItem exit;
    private JMenu settings;
    private JMenuItem changeDefaultValues;
    private JMenuItem setForDefaultValues;
    
    public PaintMenuBar() {
        
        this.file = new JMenu("File");
        this.save = new JMenuItem("Save as");
        this.authors = new JMenuItem("Authors");
        this.exit = new JMenuItem("Exit");
        
        this.settings = new JMenu("Settings");
        this.changeDefaultValues = new JMenuItem("Change default values");
        this.setForDefaultValues = new JMenuItem("Set current values to default");
        
        save.setActionCommand("saveImage");
        authors.setActionCommand("showAuthors");
        exit.setActionCommand("exit");
        changeDefaultValues.setActionCommand("changeDefaultValues");
        setForDefaultValues.setActionCommand("setCurrentValuesToDefault");
        
        file.add(save);
        file.add(authors);
        file.add(exit);
        settings.add(changeDefaultValues);
        settings.add(setForDefaultValues);
        
        this.add(file);
        this.add(settings);
    }
    
    public void setActionListener(ActionListener al) {
        save.addActionListener(al);
        authors.addActionListener(al);
        exit.addActionListener(al);
        changeDefaultValues.addActionListener(al);
        setForDefaultValues.addActionListener(al);
    }  
}
