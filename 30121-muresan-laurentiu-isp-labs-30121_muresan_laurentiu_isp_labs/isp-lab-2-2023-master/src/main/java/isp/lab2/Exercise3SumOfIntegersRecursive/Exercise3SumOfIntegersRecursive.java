package isp.lab2.Exercise3SumOfIntegersRecursive;
import java.util.Scanner;
public class Exercise3SumOfIntegersRecursive {
    /**
     * This method will return the sum of the first n integers
     * @param n
     * @return
     */
    public static int sumOfIntegers(int n) {
        if(n==1)
            return 1;
        else
            return n+sumOfIntegers(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        sc.close();
        System.out.println("The sum of all positive integers from 1 to " + n + " is " +sumOfIntegers(n));

    }
}
