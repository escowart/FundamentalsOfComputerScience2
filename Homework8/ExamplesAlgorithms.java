import java.util.ArrayList;
import java.util.Comparator;

import tester.Tester;

public class ExamplesAlgorithms {

    Algorithms al = new Algorithms();
    ArrayList<String> als1 = new ArrayList<String>();
    ArrayList<String> als2 = new ArrayList<String>();

    ArrayList<Integer> ilist = new ArrayList<Integer>();
    ArrayList<Integer> ali2 = new ArrayList<Integer>();
    
    IntegerComparator intComp = new IntegerComparator();

    void initData() {
        this.als1.add("a");
        this.als1.add("b");
        this.als1.add("c");

        this.als2.add("v");
        this.als2.add("w");
        this.als2.add("x");
        this.als2.add("y");
        this.als2.add("z");

        this.ilist.add(1);
        this.ilist.add(2);
        this.ilist.add(3);
        this.ilist.add(4);

        this.ali2.add(-1);
        this.ali2.add(0);
        this.ali2.add(1);
    }

    Algorithms algo = new Algorithms();

    // Binary on the given list for the given element
    public <T> int binSearch(T item, ArrayList<T> alist, Comparator<T> comp) {

        return this.algo.binarySearch(0, alist.size() - 1, alist, comp, item);

    }

    void testAll(Tester t) {
        initData();
        t.checkExpect(this.binSearch("c", als1, new StringComparator()), 2);
        t.checkExpect(this.al.binarySearch(0, als1.size() - 1, this.als1,
                new StringComparator(), "c"), 2);
        t.checkExpect(this.al.binarySearch(0, als2.size() - 1, this.als2,
                new StringComparator(), "v"), 0);
        t.checkExpect(this.al.binarySearch(0, als2.size() - 1, this.als2,
                new StringComparator(), "a"), -1);
        t.checkExpect(this.al.binarySearch(0, ilist.size() - 1, this.ilist,
                new IntegerComparator(), 3), 2);
        t.checkExpect(this.al.binarySearch(0, ali2.size() - 1, this.ali2,
                new IntegerComparator(), -1), 0);
    }

}
