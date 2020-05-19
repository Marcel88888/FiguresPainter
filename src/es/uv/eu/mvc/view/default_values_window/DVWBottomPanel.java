package es.uv.eu.mvc.view.default_values_window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;


public class DVWBottomPanel extends JPanel {
    
    private DVWView defValWindView;
    private DVWThicknessPanel thicknessPanel;
    private DVWStatusPanel statusPanel;
    private JButton confirmButton;
    
    public DVWBottomPanel(DVWView defValWindView) {
        this.setLayout(new BorderLayout(0, 5));
        
        this.defValWindView = defValWindView;
        this.thicknessPanel = new DVWThicknessPanel(defValWindView);
        this.statusPanel = new DVWStatusPanel(defValWindView);
        this.confirmButton = new JButton("OK");
        
        confirmButton.setPreferredSize(new Dimension(0, 40));
        confirmButton.setMinimumSize(confirmButton.getPreferredSize());
        confirmButton.setMaximumSize(confirmButton.getPreferredSize());
        confirmButton.setActionCommand("confirmDefaultValues");
        
        this.add(thicknessPanel, BorderLayout.NORTH);
        this.add(statusPanel, BorderLayout.CENTER);
        this.add(confirmButton, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    public void setChangeListener(ChangeListener cl) {
        thicknessPanel.setChangeListener(cl);
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
