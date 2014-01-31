package stackqueues.customstackwithpushpopgetmin;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Stack with push(), pop() and getMin(). O(1) complexity.
 * Created by techpanja
 * Created on 1/30/14 2:26 PM.
 */
public class CustomStackImpl implements CustomStack {

    private final int maxSize;
    private List<Integer> stackList;
    private List<Integer> stackMinList;

    public CustomStackImpl(int maxSize) {
        this.maxSize = maxSize;
        this.stackList = new ArrayList<>(maxSize);
        this.stackMinList = new ArrayList<>();
    }

    @Override
    public boolean push(Integer integer) {
        if (integer == null || stackList.size() == maxSize) {
            return false;
        }
        stackList.add(integer);
        if (!stackMinList.isEmpty()) {
            if (stackMinList.get(stackMinList.size() - 1) >= integer) {
                stackMinList.add(integer);
            }
        } else {
            stackMinList.add(integer);
        }
        return true;
    }

    @Override
    public Integer pop() {
        if (stackList.isEmpty()) {
            return null;
        }
        Integer temp = stackList.remove(stackList.size() - 1);
        if (stackMinList.get(stackMinList.size() - 1).equals(temp)) {
            stackMinList.remove(stackMinList.size() - 1);
        }
        return temp;
    }

    @Override
    public Integer peek() {
        if (stackList.isEmpty()) {
            return null;
        }
        return stackList.get(stackList.size() - 1);
    }

    @Override
    public Integer getMinimum() {
        if (stackMinList.isEmpty()) {
            return null;
        }
        return stackMinList.get(stackMinList.size() - 1);
    }

    @Override
    public String toString() {
        String temp = "top-> ";
        for (int i = stackList.size() - 1; i >= 0; i --) {
            temp = temp + stackList.get(i) + " ";
        }
        return temp + " <-bottom";
    }
}
