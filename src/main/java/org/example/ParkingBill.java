package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ParkingBill {

    public static void main(String[] args) {
        System.out.println("ParkingBill!");
        System.out.println(solution("10:00", "13:21"));
        System.out.println(solution("09:42", "11:42"));
        System.out.println(solution("17:59", "18:01"));
        System.out.println(solution("17:59", "02:01"));
    }

    private static int solution(String E, String L) {

        final int ENTRANCE_FEE = 2;
        final int FIRST_FEE = 3;
        final int SUCCESSIVE_FEE = 4;

        int parkingBill = 0;

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        try {
            Date date1 = format.parse(E);
            Date date2 = format.parse(L);

            long timeDifferenceInMillis;
            if (date2.after(date1)) {
                timeDifferenceInMillis = date2.getTime() - date1.getTime();
            } else {
                // If date2 is before date1, add a day to date2
                date2.setTime(date2.getTime() + 24 * 60 * 60 * 1000);
                timeDifferenceInMillis = date2.getTime() - date1.getTime();
            }

            // Converting milliseconds to hours and minutes
            long hours = timeDifferenceInMillis / (60 * 60 * 1000);
            long minutes = (timeDifferenceInMillis / (60 * 1000)) % 60;

            System.out.println("Time difference: " + hours + " hours " + minutes + " minutes");

            if (hours >= 1) {
                parkingBill += ENTRANCE_FEE + FIRST_FEE;
                hours--; // Deduct the first hour
            } else if (hours == 0 && minutes > 0){
                return ENTRANCE_FEE + FIRST_FEE; // Return only entrance fee and first hour fee
            }

            if (hours > 0) {
                parkingBill += SUCCESSIVE_FEE * hours;
            }

            if (minutes > 0) {
                parkingBill += SUCCESSIVE_FEE; // Additional fee for the partial hour
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parkingBill;
    }

}
