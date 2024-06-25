package org.example;

import java.util.Scanner;

public class EvenOrOdd {
    public static boolean isEven(int n) {
        // todo: implement functionality
        return n%2==0;
    }

    public static void main(String[] args) {
        int userNum = 67;
        System.out.println("Is the number: "+userNum+" even? " + isEven(userNum));
    }
}
