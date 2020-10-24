package es.uv.eu.mvc.view.figures_painter_window;

import es.uv.eu.mvc.model.FiguresPainterModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class FiguresPainterView extends JFrame {
    
    private FiguresPainterModel model;
    private SettingsPanel settingsPanel;
    private PaintingPanel paintingPanel;
    private StatusPanel statusPanel;
    private FiguresPainterMenuBar menu;
    
    public FiguresPainterView(FiguresPainterModel model) {
        
        super("FiguresPainter");
        this.setName("figuresPainterWindow");
        this.setLayout(new BorderLayout());
        this.model = model;
        this.settingsPanel = new SettingsPanel(this);
        this.paintingPanel = new PaintingPanel(this);
        this.statusPanel = new StatusPanel(this);
        this.menu = new FiguresPainterMenuBar();
        
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

    public FiguresPainterModel getModel() {
        return model;
    }

    public PaintingPanel getPaintingPanel() {
        return paintingPanel;
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
    
    public void updateDrawnFiguresCounterValueLabel(int newDrawnFiguresNumber) {
        statusPanel.updateDrawnFiguresCounterValueLabel(newDrawnFiguresNumber);
    }
    
    public void updateChosenValuesToDefault(int newCurrentThicknessValue, 
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
    
    public void setMouseListener(MouseAdapter ma) {
        paintingPanel.addMouseListener(ma);
    }
    
    public void setMouseMotionListener(MouseMotionAdapter mma) {
        paintingPanel.addMouseMotionListener(mma);
    }
}
