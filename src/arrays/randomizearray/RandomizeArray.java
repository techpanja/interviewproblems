package arrays.randomizearray;

import java.util.Random;

/**
 * Given an array, write a program to generate a random permutation of array elements.
 * This question is also asked as “shuffle a deck of cards” or “randomize a given array”.
 * Created by techpanja
 * Created on 1/27/14 9:22 PM.
 */
public class RandomizeArray {

    private RandomizeArray() {

    }

    /*
    * Fisher–Yates shuffle Algorithm
    * start from the last element, swap it with a randomly selected element from the whole array (including last).
    * Now consider the array from 0 to n-2 (size reduced by 1), and repeat the process till we hit the first element.
    * O(N) time.
    * */
    public static int[] randomizeArray(int[] inputArray) {
        Random random = new Random();
        for (int i = inputArray.length - 1; i > 0; i--) {
            int randomInt = random.nextInt(i + 1);
            System.out.println(randomInt);
            swap(inputArray, i, randomInt);
        }
        return inputArray;
    }

    private static void swap(int[] inputArray, int i, int randomInt) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[randomInt];
        inputArray[randomInt] = temp;
    }

    public static void main(String[] args) {
        int[] output = randomizeArray(new int[] {1, 2, 3, 4});
        for (int i : output) {
            System.out.print(i + " ");
        }
    }
}
