package es.uv.eu.mvc.view.paint_window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorsPanel extends JPanel {
    
    private Color[] colors = {Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.RED, 
        Color.ORANGE, Color.YELLOW, Color.WHITE, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK, 
        new Color(0, 200, 0), Color.GREEN};
    private ColorChooser currentOutlineColorChooser;
    private ColorChooser currentBackgroundColorChooser;
    
    public ColorsPanel() {
        
        this.setLayout(new GridLayout(1, 2, 30, 5));
        this.setPreferredSize(new Dimension(500, 100));
        this.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        this.currentOutlineColorChooser= new ColorChooser("Outline", colors, "Outline:");
        this.currentBackgroundColorChooser = new ColorChooser("Background", colors, "Background:");
        this.add(currentOutlineColorChooser);
        this.add(currentBackgroundColorChooser);
    }
    
    public void setActionListener (ActionListener al) {
        currentOutlineColorChooser.setActionListener(al);
        currentBackgroundColorChooser.setActionListener(al);
    }
    
    public Color getCurrentOutlineColorByButton(JButton button) {
        return colors[currentOutlineColorChooser.getColorButtons().indexOf(button)];
    }
    
    public Color getCurrentBackgroundColorByButton(JButton button) {
        return colors[currentBackgroundColorChooser.getColorButtons().indexOf(button)];
    }
}
