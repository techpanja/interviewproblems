package arrays.findarray;

/*
* Implementation class for FindArray
* */
public class FindArrayImpl implements FindArray {

    @Override
    public int findArray(int[] array, int[] subArray) {
        if (array.length < 1 || subArray.length < 1) {
            return -1;
        }
        if (subArray.length > array.length) {
            return -1;
        }
        int subArrayFirstElement = subArray[0];
        int startIndex = -1;
        int i = 0;
        while (i < array.length) {
            if (array[i] == subArrayFirstElement) {
                if (subArray.length == 1) {
                    startIndex = i;
                    return startIndex;
                }
                int j = i + 1;
                int k = 1;  // k is to keep track of sub-array index.
                while (j < array.length && k < subArray.length) {
                    if (array[j] != subArray[k]) {
                        i = j;
                        break;
                    }
                    if (k == subArray.length - 1) {
                        startIndex = i;
                        return startIndex;
                    }
                    j++;
                    k++;
                }
            } else {
                i++;
            }
        }
        return startIndex;
    }

    public static void main(String[] args) {
        FindArray findArray = new FindArrayImpl();

        System.out.println(findArray.findArray(new int[]{7, 8, 9, 11, 8, 9, 1, 10}, new int[]{8, 9, 10}));
        System.out.println(findArray.findArray(new int[]{7, 8, 9, 11, 8, 9, 10}, new int[]{8, 9, 10}));
        System.out.println(findArray.findArray(new int[]{7, 8, 9, 11, 8, 9, 8, 9, 10}, new int[]{8, 9, 10}));
    }
}
