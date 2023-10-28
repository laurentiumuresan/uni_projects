package isp.lab2.Exercise2PrimeProduct;

import java.util.Scanner;

public class Exercise2PrimeProduct {

    /**
     * This method should return the product of the first n prime numbers
     * @return
     */
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static long getPrimeProduct(int n, int m) {
        long product = 1;
        System.out.print("Primes between " + n + " and " + m + " are ");
        for (int i = n; i <= m; i++) {
            if (isPrime(i)) {
                product *= i;
                System.out.print(i + " ");
            }
        }
        return product;
    }

    /**
     * This method should read from the console a number
     * @return the number read from the console
     */
   /* public static int readfromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        return number;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter m: ");
        int m = sc.nextInt();
        sc.close();
       System.out.println("\nProduct of primes between " + n + " and " + m + " is " + getPrimeProduct(n, m));
        //System.out.println("The product of prime numbers between m and n: " + getPrimeProduct(readfromConsoleInt(), readfromConsoleInt()));
    }

}
