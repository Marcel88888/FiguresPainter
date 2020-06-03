package es.uv.eu.mvc.view.paint_window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ToolsPanel extends JPanel {
    
    private PaintView paintView;
    private JButton rectangleButton;
    private JButton triangleButton;
    private JButton circleButton;
    private JButton eraserButton;
    
    public ToolsPanel(PaintView paintView) {
        
        this.setLayout( new FlowLayout(FlowLayout.CENTER));
        this.setPreferredSize(new Dimension(250, 84));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        Border titledEtchedBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
                "Tools", TitledBorder.CENTER, TitledBorder.TOP);
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 5, 5, 5);
        Border border = BorderFactory.createCompoundBorder(titledEtchedBorder, emptyBorder);
        this.setBorder(border);
        this.paintView = paintView;
        
        Image image;
        Image scaledImage;
        
        ImageIcon rectangleIcon = new ImageIcon("icons/rectangle.png");
        image = rectangleIcon.getImage(); 
        scaledImage = image.getScaledInstance(32, 32,  java.awt.Image.SCALE_SMOOTH); 
        rectangleIcon = new ImageIcon(scaledImage);
        
        ImageIcon triangleIcon = new ImageIcon("icons/triangle.png");
        image = triangleIcon.getImage(); 
        scaledImage = image.getScaledInstance(32, 32,  java.awt.Image.SCALE_SMOOTH); 
        triangleIcon = new ImageIcon(scaledImage);
        
        ImageIcon circleIcon = new ImageIcon("icons/circle.png");
        image = circleIcon.getImage(); 
        scaledImage = image.getScaledInstance(32, 32,  java.awt.Image.SCALE_SMOOTH); 
        circleIcon = new ImageIcon(scaledImage);
        
        ImageIcon eraserIcon = new ImageIcon("icons/eraser.png");
        image = eraserIcon.getImage(); 
        scaledImage = image.getScaledInstance(32, 32,  java.awt.Image.SCALE_SMOOTH); 
        eraserIcon = new ImageIcon(scaledImage);
        
        this.rectangleButton = new JButton(rectangleIcon);
        this.triangleButton = new JButton(triangleIcon);
        this.circleButton = new JButton(circleIcon);
        this.eraserButton = new JButton(eraserIcon);
        
        rectangleButton.setBackground(Color.WHITE);
        triangleButton.setBackground(Color.WHITE);
        circleButton.setBackground(Color.WHITE);
        eraserButton.setBackground(Color.WHITE);
        eraserButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        Dimension buttonDimension = new Dimension(40, 32);
        
        rectangleButton.setPreferredSize(buttonDimension);
        triangleButton.setPreferredSize(buttonDimension);
        circleButton.setPreferredSize(buttonDimension);
        eraserButton.setPreferredSize(buttonDimension);
        
        rectangleButton.setActionCommand("setDrawingRectanglesMode");
        triangleButton.setActionCommand("setDrawingTrianglesMode");
        circleButton.setActionCommand("setDrawingCirclesMode");
        eraserButton.setActionCommand("setEraserMode");
        
        Dimension gap = new Dimension(5, 0);
        
        this.add(rectangleButton);
        this.add(Box.createRigidArea(gap));
        this.add(triangleButton);
        this.add(Box.createRigidArea(gap));
        this.add(circleButton);
        this.add(Box.createRigidArea(gap));
        this.add(eraserButton);
        this.add(Box.createRigidArea(gap));
    }
    
    public void displayButtonAsChosen(JButton chosenButton) {
        chosenButton.setBackground(Color.LIGHT_GRAY);
    }
    
    public void displayOtherButtonsAsUnchosen(JButton chosenButton) {
        if (chosenButton != rectangleButton)
            rectangleButton.setBackground(Color.WHITE);
        if (chosenButton != triangleButton)
            triangleButton.setBackground(Color.WHITE);
        if (chosenButton != circleButton)
            circleButton.setBackground(Color.WHITE);
        if (chosenButton != eraserButton)
            eraserButton.setBackground(Color.WHITE);
    }
    
    public void setActionListener(ActionListener al) {
        rectangleButton.addActionListener(al);
        triangleButton.addActionListener(al);
        circleButton.addActionListener(al);
        eraserButton.addActionListener(al);
    }
}
