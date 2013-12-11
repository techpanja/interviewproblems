package arrays.numberfrequency;

import java.util.ArrayList;
import java.util.List;

/**
 * For e.g. 111 22 4 555 ---> 13(1 occurs thrice) 22 41 53
 * User: rpanjrath
 * Date: 10/23/13
 * Time: 3:18 PM
 */
public class PrintNumbersWithFrequency {

    private PrintNumbersWithFrequency() {

    }

    public static void printNumberWithFrequency(int[] inputArray) {
        int counter = 1;
        if (inputArray.length == 0) {
            System.out.println("Minimum number of elements is 1.");
        }
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] == inputArray[i + 1]) {
                counter++;
            } else {
                System.out.println(inputArray[i] + ": " + counter);
                counter = 1;
            }
            if (i == inputArray.length - 2 && inputArray[i] != inputArray[i + 1]) {
                System.out.println(inputArray[i + 1] + ": " + "1");
            } else if (i == inputArray.length - 2 && counter != 1) {
                System.out.println(inputArray[i] + ": " + counter);
            }
        }
    }

    public static void printNumberWithFrequencyUsingList(int[] inputArray) {
        if (inputArray.length == 0) {
            System.out.println("Minimum number of elements is 1.");
        }
        int counter = -1;
        List tempList = new ArrayList();
        tempList.add(inputArray[0]);
        for (int i : inputArray) {
            counter++;
            if (tempList.contains(i)) {
                tempList.add(i);
            } else {
                System.out.println(tempList.get(0) + ": " + tempList.size());
                tempList = new ArrayList();
                tempList.add(i);
            }
            if (counter == inputArray.length - 1) {
                System.out.println(tempList.get(0) + ": " + tempList.size());
            }
        }
    }

    public static void printNumberWithFrequencyUsingTemp(int[] inputArray) {
        int counter = 1;
        Integer temp = null;
        for (int i : inputArray) {
            if (temp != null && i == temp) {
                counter++;
            } else {
                if (temp != null) {
                    System.out.println(temp + ": " + counter);
                }
                temp = i;
                counter = 1;
            }
        }
        System.out.println(temp + ": " + counter);
    }
}
