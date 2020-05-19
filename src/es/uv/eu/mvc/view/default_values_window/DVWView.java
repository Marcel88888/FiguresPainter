package es.uv.eu.mvc.view.default_values_window;

import es.uv.eu.mvc.model.PaintModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class DVWView extends JFrame {
    
    private PaintModel model;
    private DVWColorsPanel colorsPanel;
    private DVWBottomPanel bottomPanel;
    
    public DVWView(PaintModel model) {
        
        super("Default values window");
        this.setLayout(new BorderLayout(17, 8));
        this.setSize(600, 520);
        
        this.model = model;
        this.colorsPanel = new DVWColorsPanel();
        this.bottomPanel = new DVWBottomPanel(this);
        
        this.add(colorsPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, this.getBackground()));
        //this.setVisible(true);
    }

    public PaintModel getModel() {
        return model;
    }
    
    public Color getDefaultOutlineColorByButton(JButton button) {
        return colorsPanel.getDefaultOutlineColorByButton(button);
    }
    
    public Color getDefualtBackgroundColorByButton(JButton button) {
        return colorsPanel.getDefaultBackgroundColorByButton(button);
    }
    
    public void updateDefaultThicknessValueLabel(int newThickness) {
        bottomPanel.updateDefaultThicknessValueLabel(newThickness);
    }
    
    public void updateDefaultOutlineColorLabel(Color newDefaultOutlineColor) {
        bottomPanel.updateDefaultOutlineColorLabel(newDefaultOutlineColor);
    }
    
    public void updateDefaultBackgroundColorLabel(Color newDefaultBackgroundColor) {
        bottomPanel.updateDefaultBackgroundColorLabel(newDefaultBackgroundColor);
    }
    
    public void setActionListener(ActionListener al) {
        colorsPanel.setActionListener(al);
        bottomPanel.setActionListener(al);
    }
    
    public void setChangeListener(ChangeListener cl) {
        bottomPanel.setChangeListener(cl);
    } 
}
