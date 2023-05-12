package pt.ipp.isep.dei.examples.tdd.basic.domain;

/**
 * Calculator class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class Calculator {

    /**
     * Sums one operand to the other, returning the result.
     *
     * @param firstOperand  First operand to sum.
     * @param secondOperand Second Operand to sum.
     * @return The sum of firstOperand with secondOperand.
     */
    public int sum(int firstOperand, int secondOperand) {
        if ((long)firstOperand + (long)secondOperand < Integer.MIN_VALUE){
            throw new IllegalArgumentException("Result lower than Integer Minimum Value!");
        }
        if ((long)firstOperand + (long)secondOperand > Integer.MAX_VALUE){
            throw new IllegalArgumentException("Result higher than Integer Maximum Value!");
        }
        return firstOperand + secondOperand;
    }

    public int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    public int divide(int dividend, int divisor) {
        if(divisor==0){
            throw new ArithmeticException("Division with 0 not allowed");
        }
        else {
            return (dividend / divisor);
        }
    }

    public int multiply(int firstOperand, int secondOperand) {
        int result;
        if(firstOperand == 0 || secondOperand == 0){
            result = 0;
        } else {
            result = firstOperand * secondOperand;
        }
        return result;
    }

    public int factorial(int firstOperand) {
        if(firstOperand < 0){
            throw new ArithmeticException("Negative Factorial is not defined!");
        }
        int result = 1;
        for (int i = 1; i <= firstOperand; i++) {
            result = result * i;
        }
        return result;
    }


}
