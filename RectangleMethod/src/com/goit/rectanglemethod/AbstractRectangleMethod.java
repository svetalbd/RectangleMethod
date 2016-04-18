package com.goit.rectanglemethod;

/**
 * Created by amikhalnyuk on 18.04.2016.
 */
public abstract class AbstractRectangleMethod {

    protected ConvertFunctionToRPN convertFunctionToRPN;

    public AbstractRectangleMethod(String expression) {
        this.expression = expression;
        this.convertFunctionToRPN = new ConvertFunctionToRPN();
        this.convertFunctionToRPN.setExpression(expression);
    }

    protected String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

}
