package com.goit.rectanglemethod;

import java.util.Scanner;

/**
 * Created by Сергей on 12.04.2016.
 */
public class Runner {
    public static void main (String[] args){
        System.out.print("Input your formula:");
        Scanner sc = new Scanner(System.in);

        String phrase = sc.next();
        String delims = "[+*/^()-]+";
        String[] tokens = phrase.split(delims);

        for (String each: tokens) {
            System.out.println(each);
        }
    }
}
