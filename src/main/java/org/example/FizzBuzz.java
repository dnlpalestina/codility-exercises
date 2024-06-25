package org.example;

public class FizzBuzz {
    public static void fizzBuzz(int n){
        String string = "";
        for (int i = 1; i < n; i++) {
            System.out.println("i = " + i);
            if(i%3==0)
                string+="Fizz";
            if(i%5==0)
                string+="Buzz";
            if(i%7==0)
                string+="Seven";
            if(i%8==0)
                string+="AWE!";
            System.out.println(string);
            string="";
        }
    }

    public static void main(String[] args){
        fizzBuzz(165);
    }
}
