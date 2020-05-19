package es.uv.eu.mvc.view.paint_window;

import es.uv.eu.mvc.model.PaintModel;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class PaintView extends JFrame {
    
    private PaintModel model;
    private SettingsPanel settingsPanel;
    private PaintingPanel paintingPanel;
    
    public PaintView(PaintModel model) {
        
        super("Paint");
        this.setLayout(new BorderLayout());
        this.setSize(1675, 1000);
        this.model = model;
        this.settingsPanel = new SettingsPanel(this);
        this.paintingPanel = new PaintingPanel();
        
        this.add(settingsPanel, BorderLayout.NORTH);
        this.add(paintingPanel, BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    public PaintModel getModel() {
        return model;
    }
}
