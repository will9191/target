package org.example.challenges;

import java.util.Scanner;

public class Number2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");

        if (!scanner.hasNextInt()){
            System.out.print("Value entered is not an integer.");
            scanner.close();
            return;
        }

        int num = scanner.nextInt();
        scanner.close();

        if (isFibonacci(num)) {
            System.out.println(num + " belongs to the Fibonacci sequence.");
        } else {
            System.out.println(num + " does not belong to the Fibonacci sequence.");
        }
    }

    private static boolean isFibonacci(int num){
        int a = 0, b = 1, next;

        while (a <= num){
            if (a == num){
                return true;
            }
            next = a + b;
            a = b;
            b = next;
        }
        return false;
    }
}
