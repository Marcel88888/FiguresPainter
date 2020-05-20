package es.uv.eu.mvc.view.paint_window;

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
import javax.swing.border.TitledBorder;

public class StatusPanel extends JPanel {
    
    private PaintView paintView;
    private JLabel currentThicknessTextLabel;
    private JLabel currentThicknessValueLabel;
    private JLabel currentOutlineColorTextLabel;
    private JLabel currentOutlineColorLabel;
    private JLabel currentBackgroundColorTextLabel;
    private JLabel currentBackgroundColorLabel;
    private JLabel drawnFiguresCounterTextLabel;
    private JLabel drawnFiguresCounterValueLabel;
    
    public StatusPanel(PaintView paintView) {
    
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        Border titledEmptyBorder = BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), 
                "Chosen current values", TitledBorder.LEFT, TitledBorder.TOP);
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border border = BorderFactory.createCompoundBorder(titledEmptyBorder, emptyBorder);
        this.setBorder(border);
        this.paintView= paintView;
        this.currentThicknessTextLabel = new JLabel("Thickness");
        this.currentThicknessValueLabel = new JLabel(String.valueOf(paintView.getModel().getCurrentThickness()), SwingConstants.RIGHT);
        this.currentOutlineColorTextLabel = new JLabel("Outline color");
        this.currentOutlineColorLabel = new JLabel();
        this.currentBackgroundColorTextLabel = new JLabel("Background color");
        this.currentBackgroundColorLabel = new JLabel();
        this.drawnFiguresCounterTextLabel = new JLabel("Nº drawn figures");
        this.drawnFiguresCounterValueLabel = new JLabel(String.valueOf(paintView.getModel().getDrawnFigures()), SwingConstants.RIGHT);
        
        currentThicknessValueLabel.setPreferredSize(new Dimension(30, 20));
        currentThicknessValueLabel.setMinimumSize(currentThicknessValueLabel.getPreferredSize());
        currentThicknessValueLabel.setMaximumSize(currentThicknessValueLabel.getPreferredSize());
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 0, 0, 1);
        Border border2 = BorderFactory.createCompoundBorder(etchedBorder, emptyBorder2);
        currentThicknessValueLabel.setBorder(border2);
        
        drawnFiguresCounterValueLabel.setPreferredSize(new Dimension(60, 20));
        drawnFiguresCounterValueLabel.setMinimumSize(currentThicknessValueLabel.getPreferredSize());
        drawnFiguresCounterValueLabel.setMaximumSize(currentThicknessValueLabel.getPreferredSize());
        drawnFiguresCounterValueLabel.setBorder(border2);
        
        Dimension colorDimension = new Dimension(80, 25);
        currentOutlineColorLabel.setPreferredSize(colorDimension);
        currentOutlineColorLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        currentOutlineColorLabel.setMinimumSize(currentOutlineColorLabel.getPreferredSize());
        currentOutlineColorLabel.setMaximumSize(currentOutlineColorLabel.getPreferredSize());
        currentOutlineColorLabel.setOpaque(true);
        currentOutlineColorLabel.setBackground(paintView.getModel().getCurrentOutlineColor());
        
        currentBackgroundColorLabel.setPreferredSize(colorDimension);
        currentBackgroundColorLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        currentBackgroundColorLabel.setMinimumSize(currentBackgroundColorLabel.getPreferredSize());
        currentBackgroundColorLabel.setMaximumSize(currentBackgroundColorLabel.getPreferredSize());
        currentBackgroundColorLabel.setOpaque(true);
        currentBackgroundColorLabel.setBackground(paintView.getModel().getCurrentBackgroundColor());
        
        Dimension smallGap = new Dimension(10, 0);
        Dimension bigGap = new Dimension(200, 0);
        
        this.add(Box.createRigidArea(bigGap));
        this.add(currentThicknessTextLabel);
        this.add(Box.createRigidArea(smallGap));
        this.add(currentThicknessValueLabel);
        this.add(Box.createHorizontalGlue());
        this.add(currentOutlineColorTextLabel);
        this.add(Box.createRigidArea(smallGap));
        this.add(currentOutlineColorLabel);
        this.add(Box.createHorizontalGlue());
        this.add(currentBackgroundColorTextLabel);
        this.add(Box.createRigidArea(smallGap));
        this.add(currentBackgroundColorLabel);
        this.add(Box.createHorizontalGlue());
        this.add(drawnFiguresCounterTextLabel);
        this.add(Box.createRigidArea(smallGap));
        this.add(drawnFiguresCounterValueLabel);
        this.add(Box.createRigidArea(bigGap));
    }
    
    public void updateCurrentThicknessValueLabel(int newThickness) {
        currentThicknessValueLabel.setText(String.valueOf(newThickness));
    }
    
    public void updateCurrentOutlineColorLabel(Color newCurrentOutlineColor) {
        currentOutlineColorLabel.setBackground(newCurrentOutlineColor);
    }
    
    public void updateCurrentBackgroundColorLabel(Color newCurrentBackgroundColor) {
        currentBackgroundColorLabel.setBackground(newCurrentBackgroundColor);
    }
}
