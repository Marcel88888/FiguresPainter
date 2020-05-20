package es.uv.eu.mvc.view.paint_window;

import es.uv.eu.mvc.model.PaintModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class PaintView extends JFrame {
    
    private PaintModel model;
    private SettingsPanel settingsPanel;
    private PaintingPanel paintingPanel;
    private StatusPanel statusPanel;
    private PaintMenuBar menu;
    
    public PaintView(PaintModel model) {
        
        super("Paint");
        this.setName("paintWindow");
        this.setLayout(new BorderLayout());
        this.model = model;
        this.settingsPanel = new SettingsPanel(this);
        this.paintingPanel = new PaintingPanel();
        this.statusPanel = new StatusPanel(this);
        this.menu = new PaintMenuBar();
        
        this.add(settingsPanel, BorderLayout.NORTH);
        this.add(paintingPanel, BorderLayout.CENTER);
        this.add(statusPanel, BorderLayout.SOUTH);
        this.setJMenuBar(menu);
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 
                (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        this.setEnabled(false);
        this.setVisible(true);
    }

    public PaintModel getModel() {
        return model;
    }
    
    public Color getCurrentOutlineColorByButton(JButton button) {
        return settingsPanel.getCurrentOutlineColorByButton(button);
    }
    
    public Color getCurrentBackgroundColorByButton(JButton button) {
        return settingsPanel.getCurrentBackgroundColorByButton(button);
    }
    
    public void updateCurrentThicknessValueLabel(int newThickness) {
        statusPanel.updateCurrentThicknessValueLabel(newThickness);
    }
    
    public void updateCurrentOutlineColorLabel(Color newCurrentOutlineColor) {
        statusPanel.updateCurrentOutlineColorLabel(newCurrentOutlineColor);
    }
    
    public void updateCurrentBackgroundColorLabel(Color newCurrentBackgroundColor) {
        statusPanel.updateCurrentBackgroundColorLabel(newCurrentBackgroundColor);
    }
    
    public void updateChosenValuesAfterDefaultValuesChange(int newCurrentThicknessValue, 
            Color newCurrentOutlineColor, Color newCurrentBackgroundColor) {
        settingsPanel.updateCurrentThicknessSlider(newCurrentThicknessValue);
        statusPanel.updateCurrentThicknessValueLabel(newCurrentThicknessValue);
        statusPanel.updateCurrentOutlineColorLabel(newCurrentOutlineColor);
        statusPanel.updateCurrentBackgroundColorLabel(newCurrentBackgroundColor);
    }
    
    public void displayToolsPanelButtonAsChosen(JButton chosenButton) {
        settingsPanel.displayToolsPanelButtonAsChosen(chosenButton);
    }
    
    public void displayOtherToolsPanelButtonsAsUnchosen(JButton chosenButton) {
        settingsPanel.displayOtherToolsPanelButtonsAsUnchosen(chosenButton);
    }
    
    public void setActionListener(ActionListener al) {
        settingsPanel.setActionListener(al);
        menu.setActionListener(al);
    }
    
    public void setChangeListener(ChangeListener cl) {
        settingsPanel.setChangeListener(cl);
    }
}
