package strings.findduplicates;

import java.util.*;

/**
 * Find duplicate strings in list
 * User: rpanjrath
 * Date: 9/18/13
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindDuplicates {

    public List<String> findDuplicatesUsingSetAdd(List<String> inputStringList) {
        List<String> duplicateList = new ArrayList<String>();
        Set<String> tempSet = new HashSet<String>();
        for (String str : inputStringList) {
            if (!tempSet.add(str) && !duplicateList.contains(str)) {
                duplicateList.add(str);
            }
        }
        return duplicateList;
    }

    public List<String> findDuplicatesOrCountUsingFrequency(List<String> inputStringList) {
        Set<String> tempSet = new HashSet<String>();
        List<String> outList = new ArrayList<String>();
        tempSet.addAll(inputStringList);
        for (String str : tempSet) {
             outList.add(str + ": " + Collections.frequency(inputStringList, str));
        }
        return outList;
    }
}
