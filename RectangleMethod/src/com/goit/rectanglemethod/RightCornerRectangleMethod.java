package com.goit.rectanglemethod;

/**
 * Created by Сергей on 12.04.2016.
 */
public class RightCornerRectangleMethod {
    private static   String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public static double rightCornerRM (Double lowerBorder, Double upperBorder, Integer countOfSteps) {
        ReadFunction readFunction = new ReadFunction();
        Double result;
        Double deltaX = (upperBorder - lowerBorder) / countOfSteps;
        Double[] array = new Double[countOfSteps];
        array[0] = lowerBorder+deltaX;
        result = deltaX * readFunction.calculateIntegral(expression, array[0]);
        for (int i = 1; i<=countOfSteps-1; i++){
            array[i] = array[i-1]+ deltaX;
            result = result + deltaX * readFunction.calculateIntegral(expression, array[i]);

        }
        return result;
    }
}
