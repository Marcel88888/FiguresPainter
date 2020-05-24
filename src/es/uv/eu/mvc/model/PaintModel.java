package es.uv.eu.mvc.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PaintModel {
    
    private Color defaultFigureOutlineColor = Color.BLACK;
    private Color defaultFigureBackgroundColor = Color.BLACK;
    private int defaultThickness = 10;
    private Color unconfirmedDefaultFigureOutlineColor;
    private Color unconfirmedDefaultFigureBackgroundColor;
    private int unconfirmedDefaultThickness;
    private Color currentFigureOutlinecolor;
    private Color currentFigureBackgroundColor;
    private int currentThickness;
    private int drawnFiguresNumber = 0;
    private DrawingMode drawingMode = null;
    private Color backgroundColor = Color.WHITE;
    private int eraserSize = 100;
    private BufferedImage image;
    private String imageFileName = "";
    
    public static enum DrawingMode {
        DRAWING_RECTANGLES,
        DRAWING_TRIANGLES,
        DRAWING_CIRCLES,
        ERASER;
    }
    
    public PaintModel() {
        currentFigureOutlinecolor = defaultFigureOutlineColor;
        currentFigureBackgroundColor = defaultFigureBackgroundColor;
        currentThickness = defaultThickness;
        unconfirmedDefaultFigureOutlineColor = defaultFigureOutlineColor;
        unconfirmedDefaultFigureBackgroundColor = defaultFigureBackgroundColor;
        unconfirmedDefaultThickness = defaultThickness;
        try {
            imageFileName = "backgrounds/white_background.png";
            image = ImageIO.read(new File(imageFileName));
        }
        catch (IOException e) {
            System.out.println("Error during reading the background '" + this.imageFileName + "'.");
            System.out.println("Reason: " + e.getLocalizedMessage());
        }
    }

    public void setDefaultFigureOutlineColor(Color defaultFigureOutlineColor) {
        this.defaultFigureOutlineColor = defaultFigureOutlineColor;
    }

    public void setDefaultFigureBackgroundColor(Color defaultFigureBackgroundColor) {
        this.defaultFigureBackgroundColor = defaultFigureBackgroundColor;
    }

    public void setDefaultThickness(int defaultThickness) {
        this.defaultThickness = defaultThickness;
    }

    public void setUnconfirmedDefaultFigureOutlineColor(Color unconfirmedDefaultFigureOutlineColor) {
        this.unconfirmedDefaultFigureOutlineColor = unconfirmedDefaultFigureOutlineColor;
    }

    public void setUnconfirmedDefaultFigureBackgroundColor(Color unconfirmedDefaultFigureBackgroundColor) {
        this.unconfirmedDefaultFigureBackgroundColor = unconfirmedDefaultFigureBackgroundColor;
    }

    public void setUnconfirmedDefaultThickness(int unconfirmedDefaultThickness) {
        this.unconfirmedDefaultThickness = unconfirmedDefaultThickness;
    }

    public void setCurrentFigureOutlineColor(Color currentFigureOutlinecolor) {
        this.currentFigureOutlinecolor = currentFigureOutlinecolor;
    }

    public void setCurrentFigureBackgroundColor(Color currentFigureBackgroundColor) {
        this.currentFigureBackgroundColor = currentFigureBackgroundColor;
    }

    public void setCurrentThickness(int currentThickness) {
        this.currentThickness = currentThickness;
    }

    public void setDrawingMode(DrawingMode drawingMode) {
        this.drawingMode = drawingMode;
    }

    public Color getDefaultFigureOutlineColor() {
        return defaultFigureOutlineColor;
    }

    public Color getDefaultFigureBackgroundColor() {
        return defaultFigureBackgroundColor;
    }

    public int getDefaultThickness() {
        return defaultThickness;
    }

    public Color getUnconfirmedDefaultFigureOutlineColor() {
        return unconfirmedDefaultFigureOutlineColor;
    }

    public Color getUnconfirmedDefaultFigureBackgroundColor() {
        return unconfirmedDefaultFigureBackgroundColor;
    }

    public int getUnconfirmedDefaultThickness() {
        return unconfirmedDefaultThickness;
    }

    public Color getCurrentFigureOutlineColor() {
        return currentFigureOutlinecolor;
    }

    public Color getCurrentFigureBackgroundColor() {
        return currentFigureBackgroundColor;
    }

    public int getCurrentThickness() {
        return currentThickness;
    }

    public int getDrawnFiguresNumber() {
        return drawnFiguresNumber;
    }

    public DrawingMode getDrawingMode() {
        return drawingMode;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public int getEraserSize() {
        return eraserSize;
    }

    public BufferedImage getImage() {
        return image;
    }
    
    public void confirmDefaultValues() {
        defaultFigureOutlineColor = unconfirmedDefaultFigureOutlineColor;
        defaultFigureBackgroundColor = unconfirmedDefaultFigureBackgroundColor;
        defaultThickness = unconfirmedDefaultThickness;
    }
    
    public void clearUnconfirmedValues() {
        unconfirmedDefaultFigureOutlineColor = defaultFigureOutlineColor;
        unconfirmedDefaultFigureBackgroundColor = defaultFigureBackgroundColor;
        unconfirmedDefaultThickness = defaultThickness;
    }

    public void incrementDrawnFigures() {
        drawnFiguresNumber++;
    }
    
    public void setCurrentToDefault() {
        currentThickness = defaultThickness;
        currentFigureOutlinecolor = defaultFigureOutlineColor;
        currentFigureBackgroundColor = defaultFigureBackgroundColor;
    }
    
    public void drawRectangle(int x1, int y1, int x2, int y2, Color outlineColor, Color backgroundColor, int thickness){
        Graphics2D gr = (Graphics2D)image.getGraphics();
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
        Graphics2D gr = (Graphics2D)image.getGraphics();
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
        Graphics2D gr = (Graphics2D)image.getGraphics();
        gr.setStroke(new BasicStroke(thickness));
        gr.setColor(backgroundColor);
        gr.fillOval(x-r, y-r, 2*r, 2*r);
        if(thickness > 0) {
            gr.setColor(outlineColor);
            gr.drawOval(x-r, y-r, 2*r, 2*r);
        }
    }
    
    public void erase(int x, int y, int eraserRadius, Color eraserColor) {
        Graphics2D gr = (Graphics2D)image.getGraphics();
        gr.setColor(eraserColor);
        gr.fillOval(x-eraserRadius, y-eraserRadius, 2*eraserRadius, 2*eraserRadius);
    }
    
    public void clearImage() {
        try {
            image = ImageIO.read(new File(imageFileName));
        }
        catch (IOException e) {
            System.out.println("Error during reading the background '" + this.imageFileName + "'.");
            System.out.println("Reason: " + e.getLocalizedMessage());
        }
        drawnFiguresNumber = 0;
    }
    
    public void saveImage(File imageFile) {
        if (imageFile != null) {
            try {
                this.imageFileName = imageFile.getName();
                ImageIO.write(image,"jpg", imageFile);
            } 
            catch (IOException e) {
                System.out.println("Error during saving the image '" + imageFile.getName() + "'.");
                System.out.println("Reason: " + e.getLocalizedMessage());
            }
        }
    }
}
