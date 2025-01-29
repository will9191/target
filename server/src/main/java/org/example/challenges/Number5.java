package org.example.challenges;

import java.util.Scanner;

public class Number5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to get inverted: ");
        String input = scanner.nextLine();
        String invertedString = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            invertedString += input.charAt(i);
        }

        System.out.println("Inverted string: " + invertedString);
    }
}
