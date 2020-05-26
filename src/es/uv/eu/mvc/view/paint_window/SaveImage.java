package es.uv.eu.mvc.view.paint_window;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;

public class SaveImage extends JFileChooser {
    
    public SaveImage() {
        super();
        this.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.setDialogType(JFileChooser.SAVE_DIALOG);
        this.setVisible(true);
    }
  
    public File getFile(Component parent) {
        int ret = showDialog(parent, "Save image");
        if (ret == JFileChooser.APPROVE_OPTION) {
            return getSelectedFile();
        }
        else {
            return null;
        }
    }
}