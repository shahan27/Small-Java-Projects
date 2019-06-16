//Shahan Rahman CSC 221 Assignment 3
//Spring 2019


import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Compare implements Comparator, Serializable {

    private List comparatorChain = null;

    private BitSet orderingBits = null;

    private boolean locked = false;

    public Compare() {
        this(new ArrayList(),new BitSet());
    }

    public Compare(List list, BitSet bits) {
        comparatorChain = list;
        orderingBits = bits;
    }

    public void addComparator(Comparator comparator) {
        addComparator(comparator,false);
    }

    @SuppressWarnings("unchecked")
    public void addComparator(Comparator comparator, boolean reverse) {
        checkLock();

        comparatorChain.add(comparator);
        if (reverse == true) {
            orderingBits.set(comparatorChain.size() - 1);
        }
    }

    // throw an exception if the ComparatorChain is locked
    private void checkLock() {
        if (locked == true) {
            throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
        }
    }

    private void checkChain() {
        if (comparatorChain.size() == 0) {
            throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
        }
    }

    @SuppressWarnings("unchecked")
    public int compare(Object o1, Object o2) throws UnsupportedOperationException {
        if (locked == false) {
            checkChain();
            locked = true;
        }

        // iterate over all comparators in the chain
        Iterator comparators = comparatorChain.iterator();
        for (int comparatorIndex = 0; comparators.hasNext(); ++comparatorIndex) {

            Comparator comparator = (Comparator) comparators.next();
            int retval = comparator.compare(o1,o2);
            if (retval != 0) {
                // invert the order if it is a reverse sort
                if (orderingBits.get(comparatorIndex) == true) {
                    if(Integer.MIN_VALUE == retval) {
                        retval = Integer.MAX_VALUE;
                    } else {
                        retval *= -1;
                    }
                }

                return retval;
            }

        }

        // if comparators are exhausted, return 0
        return 0;
    }


}