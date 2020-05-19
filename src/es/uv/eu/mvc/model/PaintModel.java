package es.uv.eu.mvc.model;

import java.awt.Color;

public class PaintModel {
    
    private Color defaultFigureOutlineColor = Color.BLACK;
    private Color defaultFigureBackgroundColor = Color.BLACK;
    private int defaultThickness = 50;
    private Color currentFigureOutlinecolor = Color.BLACK;
    private Color currentFigureBackgroundColor = Color.BLACK;
    private int currentThickness = 50;


    public void setDefaultOutlineColor(Color defaultOutlineColor) {
        this.defaultFigureOutlineColor = defaultOutlineColor;
    }

    public void setDefaultBackgroundColor(Color defaultBackgroundColor) {
        this.defaultFigureBackgroundColor = defaultBackgroundColor;
    }

    public void setDefaultThickness(int defaultThickness) {
        this.defaultThickness = defaultThickness;
    }

    public void setCurrentOutlinecolor(Color currentOutlinecolor) {
        this.currentFigureOutlinecolor = currentOutlinecolor;
    }

    public void setCurrentBackgroundColor(Color currentBackgroundColor) {
        this.currentFigureBackgroundColor = currentBackgroundColor;
    }

    public void setCurrentThickness(int currentThickness) {
        this.currentThickness = currentThickness;
    }

    public Color getDefaultOutlineColor() {
        return defaultFigureOutlineColor;
    }

    public Color getDefaultBackgroundColor() {
        return defaultFigureBackgroundColor;
    }

    public int getDefaultThickness() {
        return defaultThickness;
    }

    public Color getCurrentOutlinecolor() {
        return currentFigureOutlinecolor;
    }

    public Color getCurrentBackgroundColor() {
        return currentFigureBackgroundColor;
    }

    public int getCurrentThickness() {
        return currentThickness;
    }

    
    
}
