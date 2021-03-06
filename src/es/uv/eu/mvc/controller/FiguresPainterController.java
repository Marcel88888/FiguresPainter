package es.uv.eu.mvc.controller;

import es.uv.eu.mvc.model.FiguresPainterModel;
import es.uv.eu.mvc.view.default_values_window.DVWView;
import es.uv.eu.mvc.view.figures_painter_window.FiguresPainterView;
import es.uv.eu.mvc.view.figures_painter_window.SaveImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class FiguresPainterController {
    
    private FiguresPainterModel model;
    private DVWView defValWindView;
    private FiguresPainterView figuresPainterView;
    
    public FiguresPainterController(FiguresPainterModel model, DVWView defValWindView, FiguresPainterView figuresPainterView) {
        this.model = model;
        this.defValWindView = defValWindView;
        this.figuresPainterView = figuresPainterView;
        
        FiguresPainterWindowListener figuresPainterWindowListener = new FiguresPainterWindowListener();
        
        defValWindView.addWindowListener(figuresPainterWindowListener);
        figuresPainterView.addWindowListener(figuresPainterWindowListener);
        
        FiguresPainterActionListener figuresPainterActionListener = new FiguresPainterActionListener();
        FiguresPainterChangeListener figuresPainterChangeListener = new FiguresPainterChangeListener();
        
        defValWindView.setActionListener(figuresPainterActionListener);
        defValWindView.setChangeListener(figuresPainterChangeListener);
        
        figuresPainterView.setActionListener(figuresPainterActionListener);
        figuresPainterView.setChangeListener(figuresPainterChangeListener);
        figuresPainterView.setMouseListener(new FiguresPainterMouseListener());
        figuresPainterView.setMouseMotionListener(new FiguresPainterMouseMotionListener());
    }
    
    private class FiguresPainterActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            JButton button;
            if (ae.getSource() instanceof JButton) {
                button = (JButton) ae.getSource();
                switch (command) {
                    case "setDrawingRectanglesMode":
                        model.setDrawingMode(FiguresPainterModel.DrawingMode.DRAWING_RECTANGLES);
                        figuresPainterView.displayToolsPanelButtonAsChosen(button);
                        figuresPainterView.displayOtherToolsPanelButtonsAsUnchosen(button);
                        break;
                    case "setDrawingTrianglesMode":
                        model.setDrawingMode(FiguresPainterModel.DrawingMode.DRAWING_TRIANGLES);
                        figuresPainterView.displayToolsPanelButtonAsChosen(button);
                        figuresPainterView.displayOtherToolsPanelButtonsAsUnchosen(button);
                        break;
                    case "setDrawingCirclesMode":
                        model.setDrawingMode(FiguresPainterModel.DrawingMode.DRAWING_CIRCLES);
                        figuresPainterView.displayToolsPanelButtonAsChosen(button);
                        figuresPainterView.displayOtherToolsPanelButtonsAsUnchosen(button);
                        break;
                    case "setEraserMode":
                        model.setDrawingMode(FiguresPainterModel.DrawingMode.ERASER);
                        figuresPainterView.displayToolsPanelButtonAsChosen(button);
                        figuresPainterView.displayOtherToolsPanelButtonsAsUnchosen(button);
                        break;
                    case "changeCurrentOutlineColor":
                        model.setCurrentFigureOutlineColor(figuresPainterView.getCurrentOutlineColorByButton(button));
                        figuresPainterView.updateCurrentOutlineColorLabel(model.getCurrentFigureOutlineColor());
                        break;
                    case "changeCurrentBackgroundColor":
                        model.setCurrentFigureBackgroundColor(figuresPainterView.getCurrentBackgroundColorByButton(button));
                        figuresPainterView.updateCurrentBackgroundColorLabel(model.getCurrentFigureBackgroundColor());
                        break;
                    case "changeDefaultOutlineColor":
                        model.setUnconfirmedDefaultFigureOutlineColor(defValWindView.getDefaultOutlineColorByButton(button));
                        defValWindView.updateDefaultOutlineColorLabel(model.getUnconfirmedDefaultFigureOutlineColor());
                        break;
                    case "changeDefaultBackgroundColor":
                        model.setUnconfirmedDefaultFigureBackgroundColor(defValWindView.getDefaultBackgroundColorByButton(button));
                        defValWindView.updateDefaultBackgroundColorLabel(model.getUnconfirmedDefaultFigureBackgroundColor());
                        break;
                    case "confirmDefaultValues":
                        model.confirmDefaultValues();
                        model.clearUnconfirmedValues();
                        defValWindView.dispatchEvent(new WindowEvent(defValWindView, WindowEvent.WINDOW_CLOSING));
                        figuresPainterView.setEnabled(true);
                        break;
                    default:
                        System.out.println("Controller: Command " + command + 
                            " not recognised.");
                        break;
                }
            }
            else {
                switch(command) {
                    case "changeDefaultValues":
                        defValWindView = new DVWView(model, figuresPainterView);        
                        defValWindView.addWindowListener(new FiguresPainterWindowListener());
                        defValWindView.setActionListener(new FiguresPainterActionListener());
                        defValWindView.setChangeListener(new FiguresPainterChangeListener());
                        figuresPainterView.setEnabled(false);
                        break;
                    case "setCurrentValuesToDefault":
                        model.setCurrentToDefault();
                        figuresPainterView.updateChosenValuesToDefault(model.getCurrentThickness(),
                                model.getCurrentFigureOutlineColor(), model.getCurrentFigureBackgroundColor());
                        break;
                    case "saveImage":
                        SaveImage imageSaver = new SaveImage();
                        model.saveImage(imageSaver.getFile(figuresPainterView));
                        break;
                    case "exit":
                        System.exit(0);
                        break;
                    case "showAuthors":
                        JOptionPane.showMessageDialog(figuresPainterView, "Authors: Marcel Kawski", "Authors", 
                                JOptionPane.PLAIN_MESSAGE);
                        break;
                    case "exitDVW":
                        model.clearUnconfirmedValues();
                        defValWindView.dispatchEvent(new WindowEvent(defValWindView, WindowEvent.WINDOW_CLOSING));
                        figuresPainterView.setEnabled(true);
                        break;
                    default:
                        System.out.println("Controller: Command " + command + 
                            " not recognised.");
                        break;
                }
            }
        }
    }
    
    private class FiguresPainterChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent ce) {
            JSlider slider = (JSlider)ce.getSource();
            String sliderName = slider.getName();
            int newThickness = slider.getValue();
            switch(sliderName) {
                case "currentThicknessSlider":
                    model.setCurrentThickness(newThickness);
                    figuresPainterView.updateCurrentThicknessValueLabel(model.getCurrentThickness());
                    break;
                case "defaultThicknessSlider":
                    model.setUnconfirmedDefaultThickness(newThickness);
                    defValWindView.updateDefaultThicknessValueLabel(model.getUnconfirmedDefaultThickness());
                    break;
                default:
                    System.out.println("Controller: There is no " + sliderName + 
                        " slider.");
                    break;
            }
        }
    }
    
    private class FiguresPainterMouseListener extends MouseAdapter {
        
        private int rectangleStartingX, rectangleStartingY;
        private int circleStartingX, circleStartingY;
        private ArrayList<Integer> triangleXpoints = new ArrayList<>();
        private ArrayList<Integer> triangleYpoints = new ArrayList<>();
        private FiguresPainterModel.DrawingMode mode;

        @Override
        public void mousePressed(MouseEvent me) {
            mode = model.getDrawingMode();
            if (mode != null) {
                switch(mode) {
                    case DRAWING_RECTANGLES:
                        if(me.getButton() == MouseEvent.BUTTON1) {
                            rectangleStartingX = me.getX();
                            rectangleStartingY = me.getY();
                        }
                        break;
                    case DRAWING_CIRCLES:
                        if(me.getButton() == MouseEvent.BUTTON1) {
                            circleStartingX = me.getX();
                            circleStartingY = me.getY();
                        }
                        break;
                }
            }
        }
        
        @Override
        public void mouseReleased(MouseEvent me) {
            if (mode != null) {
                switch(mode) {
                    case DRAWING_RECTANGLES:
                        if(me.getButton() == MouseEvent.BUTTON1) {
                            int mouseX = me.getX();
                            int mouseY = me.getY();
                            if(mouseX != rectangleStartingX && mouseY != rectangleStartingY) {
                                model.drawRectangle(rectangleStartingX, rectangleStartingY, mouseX, mouseY, 
                                    model.getCurrentFigureOutlineColor(), model.getCurrentFigureBackgroundColor(), 
                                    model.getCurrentThickness());
                                figuresPainterView.getPaintingPanel().repaint();
                                model.incrementDrawnFiguresNumber();
                                figuresPainterView.updateDrawnFiguresCounterValueLabel(model.getDrawnFiguresNumber());
                            }
                        }
                        break;
                    case DRAWING_CIRCLES:
                        if(me.getButton() == MouseEvent.BUTTON1) {
                            int currentThickness = model.getCurrentThickness();
                            double r = Math.sqrt( Math.pow(me.getX()-circleStartingX, 2) + Math.pow(me.getY()-circleStartingY, 2) );
                            int radius = (int)Math.round(r);
                            if (r > currentThickness) {
                                model.drawCircle(circleStartingX, circleStartingY, radius, model.getCurrentFigureOutlineColor(), 
                                        model.getCurrentFigureBackgroundColor(), model.getCurrentThickness());
                                figuresPainterView.getPaintingPanel().repaint();
                                model.incrementDrawnFiguresNumber();
                                figuresPainterView.updateDrawnFiguresCounterValueLabel(model.getDrawnFiguresNumber());
                            }
                        }
                        break;
                }
            }
        }
       
        @Override
        public void mouseClicked(MouseEvent me) {
            mode = model.getDrawingMode();
            if (mode == FiguresPainterModel.DrawingMode.DRAWING_TRIANGLES && me.getButton() == MouseEvent.BUTTON1) {
                if (triangleXpoints.size() < 3) {
                    triangleXpoints.add(me.getX());
                    triangleYpoints.add(me.getY());
                }
                if (triangleXpoints.size() == 3) {
                    int x0 = triangleXpoints.get(0);
                    int x1 = triangleXpoints.get(1);
                    int x2 = triangleXpoints.get(2);
                    int y0 = triangleYpoints.get(0);
                    int y1 = triangleYpoints.get(1);
                    int y2 = triangleYpoints.get(2);
                    // the triangle cannot have two or three points which are the same
                    if ( !(x0 == x1 && y0 == y1) && !(x1 == x2 && y1 == y2) && !(x0 == x2 && y0 == y2) ) {
                        model.drawTriangle(x0, y0, x1, y1, x2, y2, 
                                model.getCurrentFigureOutlineColor(), model.getCurrentFigureBackgroundColor(), 
                                model.getCurrentThickness());
                        figuresPainterView.getPaintingPanel().repaint();
                        model.incrementDrawnFiguresNumber();
                        figuresPainterView.updateDrawnFiguresCounterValueLabel(model.getDrawnFiguresNumber());
                    }
                    triangleXpoints = new ArrayList<>();
                    triangleYpoints = new ArrayList<>();
                }
            }
            else if(me.getButton() == MouseEvent.BUTTON3) {
                int confirm = JOptionPane.showConfirmDialog(figuresPainterView, "Do you want to delete all the drawn figures?", "Select the option", 
                    JOptionPane.YES_NO_OPTION);
                if(confirm == 0) {
                    model.clearImage();
                    figuresPainterView.getPaintingPanel().repaint();
                    figuresPainterView.updateDrawnFiguresCounterValueLabel(model.getDrawnFiguresNumber());
                }
            }
        }
    }
    
    private class FiguresPainterMouseMotionListener extends MouseMotionAdapter {
        
        private FiguresPainterModel.DrawingMode mode;
        
        @Override
        public void mouseDragged(MouseEvent me) {
            mode = model.getDrawingMode();
            if(mode == FiguresPainterModel.DrawingMode.ERASER && SwingUtilities.isLeftMouseButton(me)) { 
                model.erase(me.getX(), me.getY(), model.getEraserSize()/2, model.getBackgroundColor());
                figuresPainterView.getPaintingPanel().repaint();
            }
        } 
    }
    
    private class FiguresPainterWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            JFrame closedJFrame;
            JDialog closedJDialog = null;
            String closedWindowName = null;
            if (e.getSource() instanceof JFrame) {
                closedJFrame = (JFrame)e.getSource();
                closedWindowName = closedJFrame.getName();
            }
            else if (e.getSource() instanceof JDialog) {
                closedJDialog = (JDialog)e.getSource();
                closedWindowName = closedJDialog.getName();
            }
            if(closedWindowName != null) {
                switch(closedWindowName) {
                    case "figuresPainterWindow":
                        System.exit(0);
                        break;
                    case "defaultValuesWindow":
                        if(closedJDialog != null) {
                            model.clearUnconfirmedValues();
                            closedJDialog.dispose();
                            figuresPainterView.setEnabled(true);
                        }
                        break;   
                }
            }
        }
    }  
}
