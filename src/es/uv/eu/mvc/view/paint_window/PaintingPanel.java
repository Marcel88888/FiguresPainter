package es.uv.eu.mvc.view.paint_window;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;

public class PaintingPanel extends JPanel {
    
    private PaintView paintView;
    
    public PaintingPanel(PaintView paintView) {
        
        this.paintView = paintView;
        this.setBackground(paintView.getModel().getBackgroundColor());
    }
    
    public void drawRectangle(int x1, int y1, int x2, int y2, Color outlineColor, Color backgroundColor, int thickness){
        Graphics2D gr = (Graphics2D)this.getGraphics();
        gr.setStroke(new BasicStroke(thickness));
        gr.setColor(backgroundColor);
        if (x1<x2 && y1<y2) {
            gr.fillRect(x1, y1, x2-x1, y2-y1);
            if(thickness > 0) {
                gr.setColor(outlineColor);
                gr.drawRect(x1, y1, x2-x1, y2-y1);
            }
        }
        else if (x1<x2 && y1>y2) {
            gr.fillRect(x1, y2, x2-x1, y1-y2);
            if(thickness > 0) {
                gr.setColor(outlineColor);
                gr.drawRect(x1, y2, x2-x1, y1-y2);
            }
        }
        else if (x1>x2 && y1<y2) {
            gr.fillRect(x2, y1, x1-x2, y2-y1);
            if(thickness > 0) {
                gr.setColor(outlineColor);
                gr.drawRect(x2, y1, x1-x2, y2-y1);
            }   
        }
        else if (x1>x2 && y1>y2) {
            gr.fillRect(x2, y2, x1-x2, y1-y2);
            if(thickness > 0) {
                gr.setColor(outlineColor);
                gr.drawRect(x2, y2, x1-x2, y1-y2);
            }
        }
    }
    
    public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color outlineColor, Color backgroundColor, 
            int thickness) {
        Graphics2D gr = (Graphics2D)this.getGraphics();
        Polygon triangle = new Polygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
        gr.setStroke(new BasicStroke(thickness));
        gr.setColor(backgroundColor);
        gr.fillPolygon(triangle);
        if(thickness > 0) {
            gr.setColor(outlineColor);
            gr.drawPolygon(triangle);
        }
    }
    
    public void drawCircle(int x, int y, int r, Color outlineColor, Color backgroundColor, int thickness) {
        Graphics2D gr = (Graphics2D)this.getGraphics();
        gr.setStroke(new BasicStroke(thickness));
        gr.setColor(backgroundColor);
        gr.fillOval(x-r, y-r, 2*r, 2*r);
        if(thickness > 0) {
            gr.setColor(outlineColor);
            gr.drawOval(x-r, y-r, 2*r, 2*r);
        }
    }
}
