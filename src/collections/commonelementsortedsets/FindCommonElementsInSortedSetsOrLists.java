package collections.commonelementsortedsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * There are 2 sorted sets. Find the common elements of those sets/lists
 * e.g.
 * A={1,2,3,4,5,6}
 * B={5,6,7,8,9}
 * o/p C={5,6}
 * <p/>
 * Created by techpanja
 * Created on 1/20/14 7:46 PM.
 */
public class FindCommonElementsInSortedSetsOrLists {

    private FindCommonElementsInSortedSetsOrLists() {

    }

    /*
    * O(n^2) solution
    * */
    public static List<Integer> findCommonElementsDynamic(Set<Integer> integerSet1, Set<Integer> integerSet2) {
        List<Integer> commonElements = new ArrayList<>();
        for (int i : integerSet1) {
            for (int j : integerSet2) {
                if (i == j) {
                    commonElements.add(i);
                    break;
                }
            }
        }
        return commonElements;
    }

    /*
    *  O(m + n) time and space complexity.
    * */
    public static List<Integer> findCommonElementsUsingSet(Set<Integer> integerSet1, Set<Integer> integerSet2) {
        List<Integer> commonElements = new ArrayList<>();
        Set<Integer> tempSet = new HashSet<>();
        for (int i : integerSet1) {
            tempSet.add(i);
        }
        for (int j : integerSet2) {
            if (!tempSet.add(j)) {
                commonElements.add(j);
            }
        }
        return commonElements;
    }

    /*
    * O(size1 + size2) time complexity. O(1) space.
    * */
    public static List<Integer> findCommonElementsUsingWhile(List<Integer> integerList1, List<Integer> integerList2) {
        if (integerList1.isEmpty() || integerList2.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> commonElements = new ArrayList<>();
        int i = 0, j = 0;


        while (i < integerList1.size() && j < integerList2.size()) {
            if (integerList1.get(i) < integerList2.get(j)) {
                i++;
            } else if (integerList2.get(j) < integerList1.get(i)) {
                j++;
            } else {
                commonElements.add(integerList1.get(i));
                i++;
                j++;
            }
        }
        return commonElements;
    }

    public static void main(String[] args) {
        Set<Integer> integerSet1 = new HashSet<>();
        integerSet1.add(1);
        integerSet1.add(5);
        integerSet1.add(9);
        integerSet1.add(99);
        integerSet1.add(101);
        Set<Integer> integerSet2 = new HashSet<>();
        integerSet2.add(5);
        integerSet2.add(9);
        integerSet2.add(13);
        integerSet2.add(44);
        integerSet2.add(50);
        integerSet2.add(59);
        integerSet2.add(99);
        integerSet2.add(121);
        List<Integer> common1 = findCommonElementsDynamic(integerSet1, integerSet2);
        System.out.println("Using dynamic approach");
        for (int i : common1) {
            System.out.println(i);
        }
        List<Integer> common2 = findCommonElementsUsingSet(integerSet1, integerSet2);
        System.out.println("Using set");
        for (int i : common2) {
            System.out.println(i);
        }
        List<Integer> integerList1 = new ArrayList<>();
        List<Integer> integerList2 = new ArrayList<>();

        integerList1.add(1);
        integerList1.add(5);
        integerList1.add(9);
        integerList1.add(11);
        integerList1.add(36);

        integerList2.add(3);
        integerList2.add(5);
        integerList2.add(7);
        integerList2.add(9);
        integerList2.add(14);
        integerList2.add(36);
        System.out.println("Using while");
        List<Integer> common3 = findCommonElementsUsingWhile(integerList2, integerList1);
        for (int i : common3) {
            System.out.println(i);
        }

        List<Integer> integerListX = new ArrayList<>();
        List<Integer> integerListY = new ArrayList<>();
        integerListX.add(1);
        integerListX.add(2);
        integerListX.add(3);
        integerListY.add(3);
        integerListY.add(5);
        integerListY.add(6);
        System.out.println("Using while");
        List<Integer> common4 = findCommonElementsUsingWhile(integerListX, integerListY);
        for (int i : common4) {
            System.out.println(i);
        }
    }
}
