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
        for (int i = 0; i < array.length; i++) {
            if (array[i] == subArrayFirstElement) {
                if (subArray.length == 1) {
                    startIndex = i;
                    return startIndex;
                }
                int j = i + 1;
                int k = 1;
                while (j < array.length && k < subArray.length) {
                    if (array[j] != subArray[k]) {
                        break;
                    }
                    if (k == subArray.length - 1) {
                        startIndex = i;
                        return startIndex;
                    }
                    j++;
                    k++;
                }
            }
        }
        return startIndex;
    }

    public static void main(String[] args) {
        FindArray findArray = new FindArrayImpl();

        System.out.println(findArray.findArray(new int[]{7, 8, 9, 11, 8 , 9 , 1,10}, new int[]{8, 9, 10}));
    }
}
