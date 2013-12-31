package strings.findlatestversion;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * For e.g. 2.1 and 2.2 should return 2.2. e.g. 3.2 and 3.2.1 should return 3.2.1
 * User: rpanjrath
 * Date: 10/2/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindLatestVersion {

    public static String findLatest(String string1, String string2) {
        StringTokenizer stringTokenizer1 = new StringTokenizer(string1, ".");
        StringTokenizer stringTokenizer2 = new StringTokenizer(string2, ".");
        while (stringTokenizer1.hasMoreElements() || stringTokenizer2.hasMoreElements()) {
            long strVal1;
            long strVal2;
            try {
                strVal1 = Long.parseLong(stringTokenizer1.nextToken());
            } catch (NoSuchElementException ne) {
                strVal1 = 0l;
            }
            try {
                strVal2 = Long.parseLong(stringTokenizer2.nextToken());
            } catch (NoSuchElementException ne) {
                strVal2 = 0l;
            }
            if (strVal1 > strVal2) {
                return string1;
            } else if (strVal2 > strVal1){
                return string2;
            }
        }
        return string1;
    }
}
