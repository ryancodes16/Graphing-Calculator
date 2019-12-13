/**
 * GraphCalc.java
 *
 * Graphing calculator program (class with main method)
 *
 * @author Ryan Regier
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 * Date 12/3/2019
 */

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;

public class GraphCalc {
    /*
     * Constructor
     * @param none
     * @return none
     * Creates JFrame window, makes textfields for reading input, creates GUI layout for graphing calculator
     */
    public GraphCalc() {
        JFrame window = new JFrame("Graphing calculator");
        window.setLayout(new FlowLayout());
        window.setSize(350, 600);

        PaintPanel graphPanel = new PaintPanel(350, 350);

        JTextField funcField = new JTextField(25);
        JTextField xminField = new JTextField(5);
        JTextField yminField = new JTextField(5);
        JTextField xmaxField = new JTextField(5);
        JTextField ymaxField = new JTextField(5);

        JLabel funcLabel = new JLabel("f(x) = ");
        JLabel xminLabel = new JLabel("x min:");
        JLabel xmaxLabel = new JLabel("x max:");
        JLabel yminLabel = new JLabel("y min:");
        JLabel ymaxLabel = new JLabel("y max:");

        funcField.setText("((x ^ 3) - 5)");
        xminField.setText("-10");
        yminField.setText("-10");
        xmaxField.setText("10");
        ymaxField.setText("10");

        JButton go = new JButton("Go");        
        ActionListener MyListener = new MyListener(graphPanel, xminField, xmaxField, yminField,ymaxField, funcField);   //creates MyListener object    
        go.addActionListener(MyListener); //attach ActionListener

        window.add(graphPanel);
        JPanel panel2 = new JPanel(); //for x
        JPanel panel3 = new JPanel(); //for y
        JPanel panel4 = new JPanel(); //for function
        JPanel panel5 = new JPanel(); //for go button

        panel2.setLayout(new GridLayout(2,1));
        panel3.setLayout(new GridLayout(2,1));
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel5.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel2.add(xminLabel);
        panel2.add(xminField);
        panel2.add(xmaxLabel);
        panel2.add(xmaxField);
        panel3.add(yminLabel);
        panel3.add(yminField);
        panel3.add(ymaxLabel);
        panel3.add(ymaxField);
        panel4.add(funcLabel);
        panel4.add(funcField);
        panel5.add(go);

        window.add(panel4);
        window.add(panel2);
        window.add(panel3);        
        window.add(panel5);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    /*
     * Main method
     * Creates new GraphCalc object to run GUI
     * @param String[] args
     */
    public static void main(String[] args){
        GraphCalc theWindow = new GraphCalc();
    }
}
