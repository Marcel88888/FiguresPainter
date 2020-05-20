package es.uv.eu.mvc.view.default_values_window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;


public class DVWBottomPanel extends JPanel {
    
    private DVWView defValWindView;
    private JSlider defaultThicknessSlider;
    private DVWStatusPanel statusPanel;
    private JButton confirmButton;
    
    public DVWBottomPanel(DVWView defValWindView) {
        this.setLayout(new BorderLayout(0, 5));
        
        this.defValWindView = defValWindView;
        this.defaultThicknessSlider = new JSlider(0, 100);
        this.statusPanel = new DVWStatusPanel(defValWindView);
        this.confirmButton = new JButton("OK");
        
        defaultThicknessSlider.setMajorTickSpacing(10);
        defaultThicknessSlider.setMinorTickSpacing(1);
        defaultThicknessSlider.setValue(defValWindView.getModel().getDefaultThickness());
        defaultThicknessSlider.setPaintTicks(true);
        defaultThicknessSlider.setPaintLabels(true);
        defaultThicknessSlider.setFont(new Font("Symbol", Font.PLAIN, 15)); 
        Border titledEtchedBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
                "Thickness", TitledBorder.LEFT, TitledBorder.TOP);
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border border = BorderFactory.createCompoundBorder(titledEtchedBorder, emptyBorder);
        defaultThicknessSlider.setBorder(border);
        defaultThicknessSlider.setName("defaultThicknessSlider");
        
        confirmButton.setPreferredSize(new Dimension(0, 40));
        confirmButton.setMinimumSize(confirmButton.getPreferredSize());
        confirmButton.setMaximumSize(confirmButton.getPreferredSize());
        confirmButton.setActionCommand("confirmDefaultValues");
        
        this.add(defaultThicknessSlider, BorderLayout.NORTH);
        this.add(statusPanel, BorderLayout.CENTER);
        this.add(confirmButton, BorderLayout.SOUTH);
    }
    
    public void setChangeListener(ChangeListener cl) {
        defaultThicknessSlider.addChangeListener(cl);
    } 
    
    public void setActionListener(ActionListener al) {
        confirmButton.addActionListener(al);
    }
    
    public void updateDefaultThicknessValueLabel(int newThickness) {
        statusPanel.updateDefaultThicknessValueLabel(newThickness);
    }
    
    public void updateDefaultOutlineColorLabel(Color newDefaultOutlineColor) {
        statusPanel.updateDefaultOutlineColorLabel(newDefaultOutlineColor);
    }
    
    public void updateDefaultBackgroundColorLabel(Color newDefaultBackgroundColor) {
        statusPanel.updateDefaultBackgroundColorLabel(newDefaultBackgroundColor);
    }
}
