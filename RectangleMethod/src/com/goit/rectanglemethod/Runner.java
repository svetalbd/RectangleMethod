package com.goit.rectanglemethod;

import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

/**
 * Created by Сергей on 12.04.2016.
 */
public class Runner {
    public static void main (String[] args){
        System.out.println("Input your integral. Variable must be named \"y\":");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        ReadFunction readFunction = new ReadFunction();
        LowerUpperBorder lowerUpperBorder = new LowerUpperBorder();

        System.out.print(readFunction.calculateIntegral(expression, 2d));

        System.out.print("Input lower borders: ");
        /*Можно сделать класс для границ, чтобы вы все к нему обращались.*/
        try {
            Double lowerBorder = sc.nextDouble();
            lowerUpperBorder.setLowerBorder(lowerBorder);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: it must be a number.");
        }


        System.out.print("Input upper borders: ");
        /*смотрите комментарий выше*/
        try {
            Double upperBorder = sc.nextDouble();
            lowerUpperBorder.setUpperBorder(upperBorder);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: it must be a number.");
        }


        System.out.print("Input count of steps, please: ");
        /*смотрите комментарий выше*/
        try {
        Integer countOfSteps = sc.nextInt();
        lowerUpperBorder.setCountOfSteps(countOfSteps);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: it must be an integer number.");
        }

        System.out.println("1 - The method of LEFT corner rectangles\n " +
                "2 - The method of CENTER corner rectangles\n " +
                "3 - The method of RIGHT corner rectangles\n");
        Integer choice = sc.nextInt();
        switch (choice){
            case 1://метод левых прямоугольников
                break;
            case 2: //метод центральных прямоугольников
                break;
            case 3: //метод правых прямоугольников
                break;
            default:
                System.out.println("Make good choice");
                break;
        }

    }
}
