package es.uv.eu.mvc.view.default_values_window;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class DVWColorChooser extends JPanel {
    
    private String colorType;
    private ArrayList<JButton> colorButtons = new ArrayList<>();
    private Color[] colors;
    
    public DVWColorChooser (String colorType, Color[] colors, String[] colorsNames, String label) {
        
        this.setLayout(new GridLayout(7, 2, 10, 10));
        Border titledEtchedBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
                colorType + " color", TitledBorder.LEFT, TitledBorder.TOP);
        Border emptyBorder = BorderFactory.createEmptyBorder(8, 8, 8, 8);
        Border border = BorderFactory.createCompoundBorder(titledEtchedBorder, emptyBorder);
        this.setBorder(border);
        this.colorType = colorType;
        this.colors = colors;
        for (int i=0; i<colors.length; i++) {
            JButton newButton = new JButton(colorsNames[i]);
            newButton.setBackground(colors[i]);
            newButton.setActionCommand("changeDefault" + colorType + "Color");
            if (colors[i] == Color.BLACK || colors[i] == Color.DARK_GRAY || colors[i] == Color.BLUE)
                newButton.setForeground(Color.WHITE);
            colorButtons.add(newButton);
            this.add(newButton);
        }
    }
    
    public ArrayList<JButton> getColorButtons() {
        return colorButtons;
    }
    
    public void setActionListener (ActionListener al) {
        for (JButton colorButton: colorButtons) {
            colorButton.addActionListener(al);
        }
    }
}
