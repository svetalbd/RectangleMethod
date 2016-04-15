package com.goit.rectanglemethod;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Сергей on 12.04.2016.
 */
public class Runner {

    public static void main (String[] args){
        boolean correctValue = false;
        Double upperBorder = null;
        Double lowerBorder = null;


        System.out.println("Input your integral. Use operators like /, *, -, + ,. ,sin. cos. tg, arctan, (, )." +
                " Variable must be named \"x\", \"y\" or \"z\":");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        ConvertFunctionToRPN convertFunctionToRPN = new ConvertFunctionToRPN();
        convertFunctionToRPN.setExpression(expression);

        LowerUpperLimits lowerUpperLimits = new LowerUpperLimits();


        while (!correctValue) {
            System.out.print("Input lower borders: ");
            try {
                sc = new Scanner(System.in);
                lowerBorder = sc.nextDouble();
                correctValue = true;
                lowerUpperLimits.setLowerBorder(lowerBorder);
            } catch (InputMismatchException e) {
                System.out.println("ERROR: it must be a number.");
                correctValue = false;
            }
        }


        correctValue = false;
        while (!correctValue) {
            System.out.print("Input upper borders: ");
            try {
                sc = new Scanner(System.in);
                upperBorder = sc.nextDouble();
                lowerUpperLimits.setUpperBorder(upperBorder);
                correctValue = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: it must be a number.");
                correctValue = false;
            }
        }

        if (!lowerUpperLimits.correctBorderInput(lowerUpperLimits.getLowerBorder(), lowerUpperLimits.getUpperBorder())) {
            System.out.println("Upper border is smaller than lower border. The boundaries are reversed.");
            lowerUpperLimits.setLowerBorder(upperBorder);
            lowerUpperLimits.setUpperBorder(lowerBorder);
        }

        correctValue = false;
        while (!correctValue) {
            System.out.print("Input count of steps, please: ");
            try {
                sc = new Scanner(System.in);
                Integer countOfSteps = sc.nextInt();
                if (countOfSteps > 0) {
                    lowerUpperLimits.setCountOfSteps(countOfSteps);
                    correctValue = true;
                } else {
                    System.out.println("ERROR: Count of steps must be more than 0.");
                    correctValue = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR: it must be an integer number.");
                correctValue = false;
            }
        }




        correctValue = false;
        boolean isInteger = false;
        Integer choice = null;
        while (!correctValue) {
            while (!isInteger) {
                System.out.println("1 - The method of LEFT corner rectangles\n " +
                        "2 - The method of CENTER corner rectangles\n " +
                        "3 - The method of RIGHT corner rectangles\n");
                try {
                    sc = new Scanner(System.in);
                    choice = sc.nextInt();
                    isInteger = true;
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Input a number, please.");
                    isInteger = false;
                }
            }
            switch (choice) {
                case 1:
                    LeftRectangleMethod leftRectangleMethod = new LeftRectangleMethod();
                    leftRectangleMethod.setExpression(expression);
                    Double area = leftRectangleMethod.leftCornerRM(lowerUpperLimits.getLowerBorder(),
                            lowerUpperLimits.getUpperBorder(), lowerUpperLimits.getCountOfSteps());
                    System.out.printf("Area of integral is %5.5f" , area);
                    correctValue = true;
                    break;
                case 2: //метод центральных прямоугольников
                    CenterRectangleMethod centerCornerRectangleMethod = new CenterRectangleMethod();
                    centerCornerRectangleMethod.setExpression(expression);
                    Double areaCC = centerCornerRectangleMethod.centerCornerRM(lowerUpperLimits.getLowerBorder(),
                            lowerUpperLimits.getUpperBorder(), lowerUpperLimits.getCountOfSteps());
                    System.out.printf("Area of integral is %5.5f" , areaCC);
                    correctValue = true;
                case 3: //метод правых прямоугольников
                    RightRectangleMethod rightRectangleMethod = new RightRectangleMethod();
                    rightRectangleMethod.setExpression(expression);
                    Double areaRC = rightRectangleMethod.rightCornerRM(lowerUpperLimits.getLowerBorder(),
                            lowerUpperLimits.getUpperBorder(), lowerUpperLimits.getCountOfSteps());
                    System.out.printf("Area of integral is %5.5f" , areaRC);
                    correctValue = true;
                    break;
                default:
                    isInteger = false;
                    System.out.println("Make good choice");
                    correctValue = false;
                    break;
            }
        }

    }
}
