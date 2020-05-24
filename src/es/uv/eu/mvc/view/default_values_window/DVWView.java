package es.uv.eu.mvc.view.default_values_window;

import es.uv.eu.mvc.model.PaintModel;
import es.uv.eu.mvc.view.paint_window.PaintView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.event.ChangeListener;

public class DVWView extends JDialog {
    
    private PaintModel model;
    private DVWColorsPanel colorsPanel;
    private DVWBottomPanel bottomPanel;
    private DVWMenuBar dVWMenuBar;
    
    public DVWView(PaintModel model, PaintView paintView) {
        
        super(paintView);
        this.setTitle("Default values window");
        this.setName("defaultValuesWindow");
        this.setLayout(new BorderLayout(17, 8));
        this.setSize(600, 520);
        
        this.model = model;
        this.colorsPanel = new DVWColorsPanel();
        this.bottomPanel = new DVWBottomPanel(this);
        this.dVWMenuBar = new DVWMenuBar();
        
        this.add(colorsPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.setJMenuBar(dVWMenuBar);
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, this.getBackground()));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public PaintModel getModel() {
        return model;
    }
    
    public Color getDefaultOutlineColorByButton(JButton button) {
        return colorsPanel.getDefaultOutlineColorByButton(button);
    }
    
    public Color getDefaultBackgroundColorByButton(JButton button) {
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
        dVWMenuBar.setActionListener(al);
    }
    
    public void setChangeListener(ChangeListener cl) {
        bottomPanel.setChangeListener(cl);
    } 
}
