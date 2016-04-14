package com.goit.rectanglemethod;

import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
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
        ReadFunction readFunction = new ReadFunction();
        LowerUpperBorder lowerUpperBorder = new LowerUpperBorder();

        System.out.print(readFunction.calculateIntegral(expression, 2d));

        while (!correctValue) {
            System.out.print("Input lower borders: ");
            try {
                sc = new Scanner(System.in);
                lowerBorder = sc.nextDouble();
                correctValue = true;
                lowerUpperBorder.setLowerBorder(lowerBorder);
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
                lowerUpperBorder.setUpperBorder(upperBorder);
                correctValue = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: it must be a number.");
                correctValue = false;
            }
        }

        if (!lowerUpperBorder.correctBorderInput(lowerUpperBorder.getLowerBorder(), lowerUpperBorder.getUpperBorder())) {
            System.out.println("Upper border is smaller than lower border. The boundaries are reversed.");
            lowerUpperBorder.setLowerBorder(upperBorder);
            lowerUpperBorder.setUpperBorder(lowerBorder);
        }

        correctValue = false;
        while (!correctValue) {
            System.out.print("Input count of steps, please: ");
            try {
                sc = new Scanner(System.in);
                Integer countOfSteps = sc.nextInt();
                lowerUpperBorder.setCountOfSteps(countOfSteps);
                correctValue = true;
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
                case 1://метод левых прямоугольников
                    correctValue = true;
                    break;
                case 2: //метод центральных прямоугольников
                    correctValue = true;
                    break;
                case 3: //метод правых прямоугольников
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
