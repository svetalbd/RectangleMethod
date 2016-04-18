package com.goit.rectanglemethod;

/**
 * Created by Сергей on 12.04.2016.
 */
public class CenterRectangleMethod extends AbstractRectangleMethod {

    public CenterRectangleMethod(String expression) {
        super(expression);
    }

    public double centerCornerRM (Double lowerBorder, Double upperBorder, Integer countOfSteps) {

        Double result;
        Double deltaX = (upperBorder - lowerBorder) / countOfSteps;
        Double[] array = new Double[countOfSteps];
        array[0] = lowerBorder+deltaX;
        result = deltaX * convertFunctionToRPN.calculateIntegral(expression, (array[0] - deltaX / 2));
        for (int i = 1; i<=countOfSteps-1; i++){
            array[i] = array[i-1]+ deltaX;
            result = result + deltaX * convertFunctionToRPN.calculateIntegral(expression, (array[i] - deltaX / 2));
        }
        return result;
    }
}

