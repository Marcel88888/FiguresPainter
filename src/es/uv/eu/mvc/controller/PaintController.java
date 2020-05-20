package es.uv.eu.mvc.controller;

import es.uv.eu.mvc.model.PaintModel;
import es.uv.eu.mvc.view.default_values_window.DVWView;
import es.uv.eu.mvc.view.paint_window.PaintView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintController {
    
    private PaintModel model;
    private DVWView defValWindView;
    private PaintView paintView;
    
    public PaintController(PaintModel model, DVWView defValWindView, PaintView paintView) {
        this.model = model;
        this.defValWindView = defValWindView;
        this.paintView = paintView;
        
        PaintWindowListener paintWindowListener = new PaintWindowListener();
        
        defValWindView.addWindowListener(paintWindowListener);
        paintView.addWindowListener(paintWindowListener);
        
        PaintActionListener paintActionListener = new PaintActionListener();
        PaintChangeListener paintChangeListener = new PaintChangeListener();
        
        defValWindView.setActionListener(paintActionListener);
        defValWindView.setChangeListener(paintChangeListener);
        
        paintView.setActionListener(paintActionListener);
        paintView.setChangeListener(paintChangeListener);
    }
    
    private class PaintActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            JButton button = (JButton) ae.getSource();
            switch (command) {
                case "setDrawingRectanglesMode":
                    model.setDrawingMode(PaintModel.DrawingMode.DRAWING_RECTANGLES);
                    paintView.displayToolsPanelButtonAsChosen(button);
                    paintView.displayOtherToolsPanelButtonsAsUnchosen(button);
                    break;
                case "setDrawingTrianglesMode":
                    model.setDrawingMode(PaintModel.DrawingMode.DRAWING_TRIANGLES);
                    paintView.displayToolsPanelButtonAsChosen(button);
                    paintView.displayOtherToolsPanelButtonsAsUnchosen(button);
                    break;
                case "setDrawingCirclesMode":
                    model.setDrawingMode(PaintModel.DrawingMode.DRAWING_CIRCLES);
                    paintView.displayToolsPanelButtonAsChosen(button);
                    paintView.displayOtherToolsPanelButtonsAsUnchosen(button);
                    break;
                case "setEraserMode":
                    model.setDrawingMode(PaintModel.DrawingMode.ERASER);
                    paintView.displayToolsPanelButtonAsChosen(button);
                    paintView.displayOtherToolsPanelButtonsAsUnchosen(button);
                    break;
                case "changeCurrentOutlineColor":
                    model.setCurrentOutlineColor(paintView.getCurrentOutlineColorByButton(button));
                    paintView.updateCurrentOutlineColorLabel(model.getCurrentOutlineColor());
                    break;
                case "changeCurrentBackgroundColor":
                    model.setCurrentBackgroundColor(paintView.getCurrentBackgroundColorByButton(button));
                    paintView.updateCurrentBackgroundColorLabel(model.getCurrentBackgroundColor());
                    break;
                case "changeDefaultOutlineColor":
                    model.setDefaultOutlineColor(defValWindView.getDefaultOutlineColorByButton(button));
                    defValWindView.updateDefaultOutlineColorLabel(model.getDefaultOutlineColor());
                    break;
                case "changeDefaultBackgroundColor":
                    model.setDefaultBackgroundColor(defValWindView.getDefaultBackgroundColorByButton(button));
                    defValWindView.updateDefaultBackgroundColorLabel(model.getDefaultBackgroundColor());
                    break;
                case "confirmDefaultValues":
                    defValWindView.dispatchEvent(new WindowEvent(defValWindView, WindowEvent.WINDOW_CLOSING));
                    model.setCurrentToDefault();
                    paintView.updateChosenValuesAfterDefaultValuesChange(model.getCurrentThickness(),
                            model.getCurrentOutlineColor(), model.getCurrentBackgroundColor());
                    paintView.setEnabled(true);
                    break;
                default:
                    System.out.println("Controller: Command " + command + 
                        " not recognised.");
                    break;
            }
        }
    }
    
    private class PaintChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent ce) {
            JSlider slider = (JSlider)ce.getSource();
            String sliderName = slider.getName();
            int newThickness = slider.getValue();
            switch(sliderName) {
                case "currentThicknessSlider":
                    model.setCurrentThickness(newThickness);
                    paintView.updateCurrentThicknessValueLabel(model.getCurrentThickness());
                    break;
                case "defaultThicknessSlider":
                    model.setDefaultThickness(newThickness);
                    defValWindView.updateDefaultThicknessValueLabel(model.getDefaultThickness());
                    break;
                default:
                    System.out.println("Controller: There is no " + sliderName + 
                        " slider.");
                    break;
            }
        }
    }
    
    private class PaintWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            JFrame closedWindow = (JFrame)e.getSource();
            String windowName= closedWindow.getName();
            switch(windowName) {
                case "paintWindow":
                    System.exit(0);
                    break;
                case "defaultValuesWindow":
                    closedWindow.dispose();
                    break;
                default:
                    System.out.println("Controller: There is no " + windowName + 
                        " window.");
                    break;    
            }
        }
    }  
}
