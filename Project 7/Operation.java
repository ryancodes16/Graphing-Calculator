/**
 * Operation.java
 * Operation class that implements ExprNode
 *
 * @author Ryan Regier
 * @date 12/2/2019
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 */
public class Operation implements ExprNode
{
    /*
     * A char that holds the operator
     */
    private char operator;
    /*
     * A left ExprNode
     */
    private ExprNode left;
    /*
     * A right ExprNode
     */
    private ExprNode right;
    /*
     * Constructor
     *@param char, ExprNode, ExprNode
     */
    public Operation(char operator, ExprNode left, ExprNode right){
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    /*
     * Returns the value of left and right with the operator
     * @return double
     */
    public double evaluate(double x){
        switch(operator){
            case '+': return (left.evaluate(x) + right.evaluate(x)); 
            case '-': return (left.evaluate(x) - right.evaluate(x)); 
            case '*': return (left.evaluate(x) * right.evaluate(x)); 
            case '/': return (left.evaluate(x) / right.evaluate(x));
            case '^': return(Math.pow(left.evaluate(x), right.evaluate(x)));
            default: return(0);
        }
    }
}
