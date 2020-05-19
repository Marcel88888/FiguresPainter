package es.uv.eu.mvc.view.default_values_window;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DVWColorsPanel extends JPanel {
    
    private Color[] colors = {Color.BLACK, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY,
        Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN};
    private String[] colorsNames = {"Black", "Cyan", "Dark grey", "Grey", "Light grey", "Magenta", "Orange",
    "Pink", "Yellow", "White", "Red", "Blue", "Green"};
    private DVWColorChooser defaultOutlineColorChooser;
    private DVWColorChooser defaultBackgroundColorChooser;
    
    public DVWColorsPanel() {
        this.setLayout(new GridLayout(1, 2, 5, 5));
        this.defaultOutlineColorChooser= new DVWColorChooser("Outline", colors, colorsNames, "Outline:");
        this.defaultBackgroundColorChooser = new DVWColorChooser("Background", colors, colorsNames, "Background:");
        this.add(defaultOutlineColorChooser);
        this.add(defaultBackgroundColorChooser);
    }
    
    public void setActionListener (ActionListener al) {
        defaultOutlineColorChooser.setActionListener(al);
        defaultBackgroundColorChooser.setActionListener(al);
    }
    
    public Color getDefaultOutlineColorByButton(JButton button) {
        return colors[defaultOutlineColorChooser.getColorButtons().indexOf(button)];
    }
    
    public Color getDefaultBackgroundColorByButton(JButton button) {
        return colors[defaultBackgroundColorChooser.getColorButtons().indexOf(button)];
    }
}
