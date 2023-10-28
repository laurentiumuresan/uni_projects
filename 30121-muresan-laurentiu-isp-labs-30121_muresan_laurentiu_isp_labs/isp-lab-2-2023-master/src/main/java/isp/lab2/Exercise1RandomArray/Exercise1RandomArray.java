
package isp.lab2.Exercise1RandomArray;
import java.util.Random;
import java.util.Scanner;

public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers( int arraySize) {
        Scanner scanner=new Scanner(System.in);
        int[] array = new int[arraySize];
        System.out.println("Enter " + arraySize + " integers:");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[] findMaxAndMin(int[] array, int arraySize) {

        int max = array[0];
        int min = array[0];
        for (int i = 1; i <arraySize; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter m: ");
        int m = scanner.nextInt();
        Random random = new Random();
        int arraySize = random.nextInt(m - n + 1) + n;
        int[] a = getArrayOfRandomNumbers( arraySize);
        int[] mm = findMaxAndMin(a, arraySize);
//        System.out.println("Min is:"+mm[0]+" Max is:"+mm[1] );
    }
}
