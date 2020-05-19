package es.uv.eu.mvc.controller;

import es.uv.eu.mvc.model.PaintModel;
import es.uv.eu.mvc.view.default_values_window.DVWView;
import es.uv.eu.mvc.view.paint_window.PaintView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
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
        defValWindView.addWindowListener(new PaintWindowListener());
        defValWindView.setActionListener(new PaintActionListener());
        defValWindView.setChangeListener(new PaintChangeListener());
    }
    
    private class PaintActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            JButton button = (JButton) ae.getSource();
            switch (command) {
                case "changeDefaultOutlineColor":
                    model.setDefaultOutlineColor(defValWindView.getDefaultOutlineColorByButton(button));
                    defValWindView.updateDefaultOutlineColorLabel(model.getDefaultOutlineColor());
                    break;
                case "changeDefaultBackgroundColor":
                    model.setDefaultBackgroundColor(defValWindView.getDefualtBackgroundColorByButton(button));
                    defValWindView.updateDefaultBackgroundColorLabel(model.getDefaultBackgroundColor());
                    break;
                case "confirmDefaultValues":
                    defValWindView.dispatchEvent(new WindowEvent(defValWindView, WindowEvent.WINDOW_CLOSING));
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
            int currentThickness = ((JSlider)ce.getSource()).getValue();
            model.setDefaultThickness(currentThickness);
            defValWindView.updateDefaultThicknessValueLabel(model.getDefaultThickness());
        }
    }
    
    private class PaintWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }  
}
