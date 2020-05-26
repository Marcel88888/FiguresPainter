package es.uv.eu.mvc.view.paint_window;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PaintMenuBar extends JMenuBar {
    
    private JMenu file;
    private JMenuItem save;
    private JMenuItem exit;
    private JMenu edit;
    private JMenuItem changeDefaultValues;
    private JMenuItem setForDefaultValues;
    private JMenu about;
    private JMenuItem authors;
    
    public PaintMenuBar() {
        
        this.file = new JMenu("File");
        this.save = new JMenuItem("Save as");
        this.exit = new JMenuItem("Exit");
        
        this.edit = new JMenu("Edit");
        this.changeDefaultValues = new JMenuItem("Change default values");
        this.setForDefaultValues = new JMenuItem("Set current values to default");
        
        this.about = new JMenu("About");
        this.authors = new JMenuItem("Authors");
        
        save.setActionCommand("saveImage");
        exit.setActionCommand("exit");
        changeDefaultValues.setActionCommand("changeDefaultValues");
        setForDefaultValues.setActionCommand("setCurrentValuesToDefault");
        authors.setActionCommand("showAuthors");
        
        file.add(save);
        file.add(exit);
        edit.add(changeDefaultValues);
        edit.add(setForDefaultValues);
        about.add(authors);
        
        this.add(file);
        this.add(edit);
        this.add(about);
    }
    
    public void setActionListener(ActionListener al) {
        save.addActionListener(al);
        exit.addActionListener(al);
        changeDefaultValues.addActionListener(al);
        setForDefaultValues.addActionListener(al);
        authors.addActionListener(al);
    }  
}
