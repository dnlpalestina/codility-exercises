package org.example;

import java.util.*;

public class calculatorCodeReview {

    public static void main(String[] args) throws Exception {

        System.out.println("calculatorCodeReview");

        //This method should return a result of the operation given as parameter
        System.out.println(new calculatorCodeReview().solution("+",2, 2));
    }

    public Double solution(String operation, Integer a, Integer b) throws Exception {
        if(operation=="+"){
            return (double) (a+b);
        } else if (operation=="-"){
            return (double) (a-b);
        } else if (operation=="*"){
            return (double) (a*b);
        } else if (operation=="/"){
            return (double) (a/b);
        } else if (operation=="%"){
            return (double) (a%b);
        } else {
            throw new Exception();
        }
    }

}