package org.example;

import java.util.Arrays;

public class FrogJmp {

    public static void main(String[] args) {
        int x=10;
        int y=85;
        int d=30;
        System.out.println("min = " + new FrogJmp().solution(x, y, d));
    }

    public int solution(int X, int Y, int D){
        int distance = Y-X;
        int numJumps = distance / D;
        if(distance%D != 0){
            numJumps++;
        }
        return numJumps;
    }
}