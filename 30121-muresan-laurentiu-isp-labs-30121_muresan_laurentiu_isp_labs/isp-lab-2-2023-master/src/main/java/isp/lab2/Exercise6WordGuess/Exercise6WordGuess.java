package isp.lab2.Exercise6WordGuess;
import java.util.Scanner;
public class Exercise6WordGuess {

    /**
     * This method will return the number of occurrences of a character in a word
     */

    public static char readFromConsoleChar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a character: ");
        return scanner.nextLine().charAt(0);
    }

    public static String readFromConsoleString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word: ");
        return scanner.nextLine();
    }
    public static int countOccurence(char c, char[] word) {

        int count = 0;
        for (char ch : word) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String word = readFromConsoleString();
        char c = readFromConsoleChar();
        int count = countOccurence(c, word.toCharArray());
        System.out.println("The character " + c + " appears " + count + " times in the word " + word);


    }

}
