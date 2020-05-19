package es.uv.eu.mvc.view.default_values_window;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;

public class DVWThicknessPanel extends JPanel {
    
    private DVWView defValWindView;
    private JLabel sliderTitle;
    private JSlider thicknessSlider;
    
    public DVWThicknessPanel(DVWView defValWindView) {
        this.setLayout(new BorderLayout());
        this.defValWindView = defValWindView;
        this.sliderTitle = new JLabel("Thickness:");
        this.thicknessSlider = new JSlider(0, 100);
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        sliderTitle.setFont(new Font("Dialog", Font.BOLD, 13));
        sliderTitle.setBorder(BorderFactory.createEmptyBorder(10, 8, 0, 0));
        
        thicknessSlider.setMajorTickSpacing(10);
        thicknessSlider.setMinorTickSpacing(1);
        thicknessSlider.setValue(defValWindView.getModel().getDefaultThickness());
        thicknessSlider.setPaintTicks(true);
        thicknessSlider.setPaintLabels(true);
        thicknessSlider.setFont(new Font("Symbol", Font.PLAIN, 15));   
        
        this.add(thicknessSlider, BorderLayout.CENTER);
        this.add(sliderTitle, BorderLayout.NORTH);
    }
    
    public void setChangeListener(ChangeListener cl) {
        thicknessSlider.addChangeListener(cl);
    } 
}
