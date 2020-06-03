package es.uv.eu.mvc.view.paint_window;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PaintingPanel extends JPanel {
    
    private PaintView paintView;
    
    public PaintingPanel(PaintView paintView) {        
        this.paintView = paintView;
    }
    
    @Override
    protected void paintComponent(Graphics graphic) { 
        super.paintComponent(graphic);
        graphic.drawImage(paintView.getModel().getImage(), 0, 0, this);
    }
}
