package isp.lab2.Exercise4StringSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise4StringSearch {
    /**
     * This method should return an array of strings that contain the substring.
     * @param input
     * @param substring what to search for
     * @return
     */
    public static String[] searchSubstrings(String input, String substring) {
        String[] strings=input.split(",");
        ArrayList<String> matches= new ArrayList<String>();
        for(String string : strings)
        {
            if(string.contains(substring)){
                matches.add(string);
            }
        }
        return matches.toArray(new String[0]);
    }

    public static String readFromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter line: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String input = readFromConsoleInt();
        String substring = readFromConsoleInt();
        System.out.println("All the strings in the list that contain the specified substring are: ");
        String[] result = searchSubstrings(input, substring);
        for (String string : result) {
            System.out.println(string);
 }
    }
}