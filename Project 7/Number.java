
/**
 * Number.java
 * Number class for implementing ExprNode
 *
 * @author Ryan Regier
 * @date 12/2/2019
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 */
public class Number implements ExprNode
{
    /*
     * double number is the number itself
     */
    private double number;
    /*
     * Constructor
     * @param String num is the string to be parsed into double for number
     */
    public Number(String num){
        this.number = Double.parseDouble(num);
    }

    /*
     * @param double x ; the number to be used with the variable method, carried along
     * @return double number
     */
    public double evaluate(double x){
        return(number);
    }
}
