package strings.segmentstringfindalldictwords;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Find all dictionary words in a given string.
 * User: rpanjrath
 * Date: 10/1/13
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringSegmentation {

    public Set segmentString(String inputString, Set inputDictionary) {
        Set<String> segmentedStrings = new HashSet<String>();
        if (inputString.isEmpty()) {
            throw new  IllegalArgumentException("String cannot be empty");
        }
        inputString = inputString.replaceAll(" ", "");
        for (int i = 0; i < inputString.length(); i++)
            for (int j = i + 1; j <= inputString.length(); j++) {
                if (inputDictionary.contains(inputString.substring(i, j))) {
                    segmentedStrings.add(inputString.substring(i, j));
                }
            }
        return segmentedStrings;
    }

    public static void main(String[] args) {
        StringSegmentation stringSegmentation = new StringSegmentation();
        Set dictionary = new HashSet();
        dictionary.add("apple");
        dictionary.add("pie");
        dictionary.add("eip");
        dictionary.add("pi");
        dictionary.add("a");
        dictionary.add("e");
        Set set = stringSegmentation.segmentString("apple  pie", dictionary);
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }
//        System.out.print(stringSegmentation.segmentString("applepie", dictionary));
    }
}
