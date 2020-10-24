package es.uv.eu.mvc.view.figures_painter_window;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ColorChooser extends JPanel {
    
    private String colorType;
    private ArrayList<JButton> colorButtons = new ArrayList<>();
    private Color[] colors;
    
    public ColorChooser (String colorType, Color[] colors, String label) {
        
        this.setLayout(new GridLayout(2, 7, 5, 5));
        Border titledEtchedBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
                colorType + " color", TitledBorder.CENTER, TitledBorder.TOP);
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border border = BorderFactory.createCompoundBorder(titledEtchedBorder, emptyBorder);
        this.setBorder(border);
        this.colorType = colorType;
        this.colors = colors;
        for (int i=0; i<colors.length; i++) {
            JButton newButton = new JButton();
            newButton.setBackground(colors[i]);
            newButton.setActionCommand("changeCurrent" + colorType + "Color");
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
