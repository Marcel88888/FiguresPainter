package es.uv.eu.mvc.view.figures_painter_window;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PaintingPanel extends JPanel {
    
    private FiguresPainterView figuresPainterView;
    
    public PaintingPanel(FiguresPainterView figuresPainterView) {
        this.figuresPainterView = figuresPainterView;
    }
    
    @Override
    protected void paintComponent(Graphics graphic) { 
        super.paintComponent(graphic);
        graphic.drawImage(figuresPainterView.getModel().getImage(), 0, 0, this);
    }
}
