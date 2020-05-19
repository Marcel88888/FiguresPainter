package es.uv.eu.mvc.view.default_values_window;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class DVWStatusPanel extends JPanel {
    
    private DVWView defValWindView;
    private JLabel defaultThicknessTextLabel;
    private JLabel defaultThicknessValueLabel;
    private JLabel defaultOutlineColorTextLabel;
    private JLabel defaultOutlineColorLabel;
    private JLabel defaultBackgroundColorTextLabel;
    private JLabel defaultBackgroundColorLabel;
    
    public DVWStatusPanel(DVWView defValWindView) {
    
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(600, 50));
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.defValWindView= defValWindView;
        this.defaultThicknessTextLabel = new JLabel("Thickness:");
        this.defaultThicknessValueLabel = new JLabel(String.valueOf(defValWindView.getModel().getDefaultThickness()), SwingConstants.RIGHT);
        this.defaultOutlineColorTextLabel = new JLabel("Outline:");
        this.defaultOutlineColorLabel = new JLabel();
        this.defaultBackgroundColorTextLabel = new JLabel("Background:");
        this.defaultBackgroundColorLabel = new JLabel();
        
        defaultThicknessValueLabel.setPreferredSize(new Dimension(30, 20));
        defaultThicknessValueLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        defaultThicknessValueLabel.setMinimumSize(defaultThicknessValueLabel.getPreferredSize());
        defaultThicknessValueLabel.setMaximumSize(defaultThicknessValueLabel.getPreferredSize());
        
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 1);
        Border border = BorderFactory.createCompoundBorder(etchedBorder, emptyBorder);
        defaultThicknessValueLabel.setBorder(border);
        
        Dimension colorDimension = new Dimension(80, 25);
        defaultOutlineColorLabel.setPreferredSize(colorDimension);
        defaultOutlineColorLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        defaultOutlineColorLabel.setMinimumSize(defaultOutlineColorLabel.getPreferredSize());
        defaultOutlineColorLabel.setMaximumSize(defaultOutlineColorLabel.getPreferredSize());
        defaultOutlineColorLabel.setOpaque(true);
        defaultOutlineColorLabel.setBackground(defValWindView.getModel().getDefaultOutlineColor());
        
        defaultBackgroundColorLabel.setPreferredSize(colorDimension);
        defaultBackgroundColorLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        defaultBackgroundColorLabel.setMinimumSize(defaultBackgroundColorLabel.getPreferredSize());
        defaultBackgroundColorLabel.setMaximumSize(defaultBackgroundColorLabel.getPreferredSize());
        defaultBackgroundColorLabel.setOpaque(true);
        defaultBackgroundColorLabel.setBackground(defValWindView.getModel().getDefaultBackgroundColor());
        
        Dimension smallGap = new Dimension(5, 0);
        
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(defaultThicknessTextLabel);
        this.add(Box.createRigidArea(smallGap));
        this.add(defaultThicknessValueLabel);
        this.add(Box.createHorizontalGlue());
        this.add(defaultOutlineColorTextLabel);
        this.add(Box.createRigidArea(smallGap));
        this.add(defaultOutlineColorLabel);
        this.add(Box.createHorizontalGlue());
        this.add(defaultBackgroundColorTextLabel);
        this.add(Box.createRigidArea(smallGap));
        this.add(defaultBackgroundColorLabel);
        this.add(Box.createHorizontalGlue());
    }
    
    public void updateDefaultThicknessValueLabel(int newThickness) {
        defaultThicknessValueLabel.setText(String.valueOf(newThickness));
    }
    
    public void updateDefaultOutlineColorLabel(Color newDefaultOutlineColor) {
        defaultOutlineColorLabel.setBackground(newDefaultOutlineColor);
    }
    
    public void updateDefaultBackgroundColorLabel(Color newDefaultBackgroundColor) {
        defaultBackgroundColorLabel.setBackground(newDefaultBackgroundColor);
    }
}
