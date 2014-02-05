package maps.sortofvaluesinmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A map that should be sorted on the basis of values and not keys.
 * Created by techpanja
 * Created on 2/5/14 2:33 PM.
 */
public class SortOnValuesInMap {

    private SortOnValuesInMap() {

    }

    public static Map<String, Integer> sortOnValuesInMap(Map<String, Integer> inputMap) {
        ValueComparator valueComparator = new ValueComparator(inputMap);
        Map<String, Integer> sortedMapOnValue = new TreeMap<>(valueComparator);
        sortedMapOnValue.putAll(inputMap);
        return sortedMapOnValue;
    }

    static class ValueComparator implements Comparator<String> {

        private Map<String, Integer> inputMap;

        public ValueComparator(Map<String, Integer> inputMap) {
            this.inputMap = inputMap;
        }

        @Override
        public int compare(String string1, String string2) {
            if (inputMap.get(string1) > inputMap.get(string2)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 2);
        map.put("B", 1);
        map.put("C", 3);
        map.put("D", 0);
        map.put("E", 8);
        Map<String, Integer> output = sortOnValuesInMap(map);
        for (String temp : output.keySet()) {
            System.out.println(temp);
        }
    }
}
