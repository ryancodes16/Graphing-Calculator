/**
 * Interpreter.java
 *
 * Class to generate ExprNode trees based on a given
 * input.
 *
 * @author Ryan Regier
 * CSCI 235, Wheaton College, Fall 2019
 * Project 7
 * Date 12/2/2019
 */

public class Interpreter {
    /**
     * Turn a string into an ExprNode tree.
     *
     * @param input The string to parse
     * @return The root of the ExprNode tree
     */
    public static ExprNode parse(String input) {
        String nodes[] = ExprStringSlicer.slice(input);

        ExprNode out = null;

        // write the body

        if(nodes.length == 1) {  //base case
            if(nodes[0].charAt(0) == 'x'){
                out = new Variable();
            } else {
                out = new Number(nodes[0]);
            }
        } else { //recursive case           
            ExprNode left = parse(nodes[0]);
            ExprNode right = parse(nodes[2]);
            out = new Operation(nodes[1].charAt(0), left, right);			
        }
        return out;
    }

    /**
     * For testing project 7 (Part A).
     */
    public static void main(String[] args) {
        ExprNode tree = parse(args[0]);
        System.out.println(tree.evaluate(Double.parseDouble(args[1])));
    }

}
