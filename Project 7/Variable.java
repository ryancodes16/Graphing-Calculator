/**
 * Variable.java
 * Variable class implements ExprNode
 *
 * @author Ryan Regier
 * @date 12/2/2019
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 */
public class Variable implements ExprNode
{
    /*
     * Empty Constructor
     */
    public Variable(){

    }

    /*
     * @param x, the double to be used here
     * @return double x
     */
    public double evaluate(double x){
        return x;
    }
}
