package com.goit.rectanglemethod;

/**
 * Created by Сергей on 14.04.2016.
 */
public class LowerUpperLimits {
    private double lowerBorder;
    private double upperBorder;
    private Integer countOfSteps;

    public double getLowerBorder() {
        return lowerBorder;
    }

    public void setLowerBorder(double lowerBorder) {
        this.lowerBorder = lowerBorder;
    }

    public double getUpperBorder() {
        return upperBorder;
    }

    public void setUpperBorder(double upperBorder) {
        this.upperBorder = upperBorder;
    }

    public Integer getCountOfSteps() {
        return countOfSteps;
    }

    public void setCountOfSteps(Integer countOfSteps) {
        this.countOfSteps = countOfSteps;
    }

    public Boolean correctBorderInput (Double lowerBorder, double upperBorder){
        if ((upperBorder - lowerBorder) <= 0) {
            return false;
        } else {
            return true;
        }
    }


}
