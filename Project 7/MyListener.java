/**
 * MyListener.java
 * ActionListener class for the Go button
 * Graphs the entered function with the specific range
 *
 * @author Ryan Regier
 * @date 12/8/2019
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 */
import java.awt.event.*;
import javax.swing.*;  
import java.awt.*;
import java.awt.Graphics;
import java.util.*;
public class MyListener implements ActionListener, Painter
{
    /*
     * JTextField instance variables for:
     * xMin, xMax, yMin, yMax, and function
     */
    private JTextField xMin, xMax, yMin, yMax, func;
    /*
     * PaintPanel instance variable to hold reference to PaintPanel in GraphCalc
     */
    private PaintPanel graphPanel;
    /*
     * ArrayList of Integer to store xValues with screen coordinate values to graph pixels
     */
    private ArrayList<Integer> xValues = new ArrayList<Integer>();
    /*
     * ArrayList of Integer to store yValues with screen coordinate values to graph pixels
     */
    private ArrayList<Integer> yValues = new ArrayList<Integer>();
    /*
     * double instance variables to hold the values pulled from JTextField instance variables
     */
    private double xMinimum = 0, xMaximum = 0, yMinimum = 0, yMaximum = 0;
    /*
     * Constructor
     * @param PaintPanel graphPanel
     * @param JTextField xMin
     * @param JTextField xMax
     * @param JTextField yMin
     * @param JTextField yMax
     * @param JTextField Func
     */
    public MyListener(PaintPanel graphPanel, JTextField xMin, JTextField xMax, JTextField yMin, JTextField yMax, JTextField func){
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.func = func;
        this.graphPanel = graphPanel;
    }

    /*
     * Method for when the button is clicked
     * Grabs values from JTextField instance variables
     * Parses function
     * Gets x and y values to plot
     * Calls repaint() to graph equation
     * @param e Unused
     */
    public void actionPerformed(ActionEvent e){
        Interpreter myInterpreter = new Interpreter();
        graphPanel.setPainter(this);        
        String function = "";
        try {
            xMinimum = Double.parseDouble(xMin.getText());
            xMaximum = Double.parseDouble(xMax.getText());
            yMinimum = Double.parseDouble(yMin.getText());
            yMaximum = Double.parseDouble(yMax.getText());
            function = func.getText();
            System.out.println("xMin: " + xMinimum);
            System.out.println("xMax: " + xMaximum);
            System.out.println("yMin: " + yMinimum);
            System.out.println("yMax: " + yMaximum);
            System.out.println("Function: " + function);

            ExprNode tree = myInterpreter.parse(function); //parse function
            System.out.println("xMin: " + tree.evaluate(xMinimum));
            System.out.println("xMax: " + tree.evaluate(xMaximum));
            /*
             * Loop through xMin - xMax and increment by 0.01 for precision
             * Check if yValue is in range
             * Add acceptable x and y values into their own arraylists
             */
            for(double i = xMinimum; i < xMaximum; i+= 0.01){//(Math.abs(xMaximum - xMinimum)/350)){
                double value = tree.evaluate(i);
                if(value >= yMinimum && value <= yMaximum){
                    xValues.add(xToCol(i));
                    yValues.add(yToCol(value));
                }
            }
            graphPanel.repaint(); //graph it
            System.out.println(xValues.size());
            System.out.println(yValues.size());
        } catch (Exception exc) {
            System.out.println("Error! Input mismatch!");
            System.out.println("Check to be sure all values in the text fields are entered correctly.");
        }
    }

    /*
     * Paint method to display graph on PaintPanel
     * @param Graphics g
     */
    public void paint(Graphics g) {
        g.setColor(Color.red); //sets color for all graphics with g
        int yaxis = yToCol(0);
        int xaxis = xToCol(0);
        /*
         * scales x and y axis based on the domain and range
         */
        if(xMinimum <= 0 && 0 <= xMaximum){
            g.drawLine(0,yaxis,350,yaxis); //x-axis
        }
        if(yMinimum <= 0 && 0 <= yMaximum){
            g.drawLine(xaxis,0,xaxis,350); //y-axis
        }
        for(int i = 0; i < xValues.size(); i++){
            g.fillRect(xValues.get(i), yValues.get(i), 1, 1); //fill pixels in
        }
        //clear arraylists
        xValues.clear(); 
        yValues.clear();
    }

    /*
     * Turns cartesian coordinates into screen coordinates for x values
     * @param double x (cartesian x value)
     * @return int (screen x value)
     */
    private int xToCol(double x){
        int newVal = 0;
        newVal = (int)(((x-xMinimum)/(xMaximum - xMinimum)) * 350);
        return(newVal);
    }

    /*
     * Turns cartesian coordinates into screen coordinates for y values
     * @param double y (cartesian y value)
     * @return int (screen y value)
     */
    private int yToCol(double y){
        int newVal = 0;
        newVal = (int)(350-(((y-yMinimum)/(yMaximum - yMinimum)) * 350));
        return(newVal);
    }
}
