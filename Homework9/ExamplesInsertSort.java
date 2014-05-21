//assignment 9
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

import java.util.ArrayList;
import java.util.Comparator;

import tester.Tester;

public class ExamplesInsertSort {

    IntegerComparator icomp = new IntegerComparator();

    ArrayList<Integer> intlist;
    ArrayList<Integer> isortedlist;

    // Reset the two list
    public void reset() {
        this.intlist = new ArrayList<Integer>();
        this.isortedlist = new ArrayList<Integer>();
    }

    // Initialize the data.
    public void initData() {
        reset();

        this.isortedlist.add(-4);
        this.isortedlist.add(-3);
        this.isortedlist.add(-2);
        this.isortedlist.add(-1);
        this.isortedlist.add(0);
        this.isortedlist.add(1);
        this.isortedlist.add(2);
        this.isortedlist.add(3);
        this.isortedlist.add(4);

        this.intlist.add(1);
        this.intlist.add(0);
        this.intlist.add(-1);
        this.intlist.add(3);
        this.intlist.add(-3);
        this.intlist.add(2);
        this.intlist.add(-2);
        this.intlist.add(-4);
        this.intlist.add(4);
    }

    // Insert a T into a sorted Array List of Ts
    public <T> ArrayList<T> sortedInsert(T item, ArrayList<T> sortedlist,
            Comparator<T> comp) {
        int x;
        for (x = 0; x < sortedlist.size(); x++) {
            if (comp.compare(item, sortedlist.get(x)) <= 0) {
                sortedlist.add(x, item);
                return sortedlist;
            }
        }
        sortedlist.add(item);
        return sortedlist;
    }

    // Insert Sort the given list of T given the Comparator
    public <T> ArrayList<T> insertSort(ArrayList<T> list, Comparator<T> comp) {
        ArrayList<T> temp;
        for (temp = new ArrayList<T>(); list.size() > 0; list.remove(0)) {
            this.sortedInsert(list.get(0), temp, comp);
        }
        return temp;
    }

    // Is the given list order by the comparator
    public <T> boolean isOrdered(ArrayList<T> list, Comparator<T> comp) {
        for (int x = 0; x < list.size() - 1; x++) {
            if (comp.compare(list.get(x), list.get(x + 1)) >= 0)
                return false;
        }
        return true;
    }

    // Insert Sort the given list of T given the Comparator
    public <T> ArrayList<T> insertionSort(ArrayList<T> list, 
            Comparator<T> comp) {
        int x = 0;
        T temp1;
        T temp2;
        while (!this.isOrdered(list, comp)) {

            if (comp.compare(list.get(x), list.get(x + 1)) >= 0) {
                temp1 = list.get(x);
                temp2 = list.get(x + 1);
                list.set(x, temp2);
                list.set(x + 1, temp1);
            }

            if (x == list.size() - 2)
                x = 0;
            else
                x++;
        }
        return list;
    }

    // Test All
    public void testAll(Tester t) {
        initData();
        t.checkExpect(this.insertSort(this.intlist, this.icomp),
                this.isortedlist);
        t.checkExpect(this.isOrdered(this.isortedlist, this.icomp));
        initData();
        t.checkExpect(this.insertionSort(this.intlist, this.icomp),
                this.isortedlist);
    }
}
