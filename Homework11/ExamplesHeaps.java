

import java.util.ArrayList;

import tester.Tester;

// A class that test Priority Queue
public class ExamplesHeaps {

    public ExamplesHeaps() {
    }

    IntegerComparator comp = new IntegerComparator();
    PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>(this.comp);
    PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>(this.comp);
    PriorityQueue<Integer> heap3 = new PriorityQueue<Integer>(this.comp);
    PriorityQueue<Integer> heap4 = new PriorityQueue<Integer>(this.comp);
    PriorityQueue<Integer> heap5 = new PriorityQueue<Integer>(
            new ArrayList<Integer>(), this.comp);
    ArrayList<Integer> lh1 = new ArrayList<Integer>();
    ArrayList<Integer> lh2 = new ArrayList<Integer>();
    ArrayList<Integer> lh3 = new ArrayList<Integer>();
    ArrayList<Integer> lh4 = new ArrayList<Integer>();

    // Initialize the heap
    public void initHeap() {
        this.heap1.insert(60);
        this.heap1.insert(40);
        this.heap1.insert(50);
        this.heap1.insert(35);
        this.heap1.insert(70);

        this.heap2.insert(20);
        this.heap2.insert(80);
        this.heap2.insert(40);
        this.heap2.insert(45);
        this.heap2.insert(50);
        this.heap2.insert(30);

        this.heap3.insert(45);
        this.heap3.insert(40);
        this.heap3.insert(50);
        this.heap3.insert(30);
        this.heap3.insert(20);

        this.heap4.insert(20);
        this.heap4.insert(30);
        this.heap4.insert(40);
        this.heap4.insert(45);
        this.heap4.insert(50);
        this.heap4.insert(70);

        lh1.add(null);
        lh1.add(70);
        lh1.add(60);
        lh1.add(50);
        lh1.add(35);
        lh1.add(40);

        lh2.add(null);
        lh2.add(80);
        lh2.add(50);
        lh2.add(40);
        lh2.add(20);
        lh2.add(45);
        lh2.add(30);

        lh3.add(null);
        lh3.add(50);
        lh3.add(40);
        lh3.add(45);
        lh3.add(30);
        lh3.add(20);

        lh4.add(null);
        lh4.add(70);
        lh4.add(45);
        lh4.add(50);
        lh4.add(20);
        lh4.add(40);
        lh4.add(30);
    }

    // Initialize a remove from the heap
    public void remove() {
        this.heap1.remove();
        this.heap2.remove();
        this.heap3.remove();
        this.heap4.remove();

        lh1 = new ArrayList<Integer>();
        lh2 = new ArrayList<Integer>();
        lh3 = new ArrayList<Integer>();
        lh4 = new ArrayList<Integer>();

        lh1.add(null);
        lh1.add(60);
        lh1.add(40);
        lh1.add(50);
        lh1.add(35);

        lh2.add(null);
        lh2.add(50);
        lh2.add(45);
        lh2.add(40);
        lh2.add(20);
        lh2.add(30);

        lh3.add(null);
        lh3.add(45);
        lh3.add(40);
        lh3.add(20);
        lh3.add(30);

        lh4.add(null);
        lh4.add(50);
        lh4.add(45);
        lh4.add(30);
        lh4.add(20);
        lh4.add(40);
    }

    public void testAll(Tester t) {
        this.initHeap();
        t.checkExpect(this.heap1.list, this.lh1);
        t.checkExpect(this.heap2.list, this.lh2);
        t.checkExpect(this.heap3.list, this.lh3);
        t.checkExpect(this.heap4.list, this.lh4);

        this.remove();
        t.checkExpect(this.heap1.list, this.lh1);
        t.checkExpect(this.heap2.list, this.lh2);
        t.checkExpect(this.heap3.list, this.lh3);
        t.checkExpect(this.heap4.list, this.lh4);

        t.checkExpect(this.heap1.toString(),
                "new PriorityQueue<T>([null, 60, 40, 50, 35]," +
                " new IntegerComparator())");
        t.checkExpect(this.heap1.hashCode(), -235518638);
        t.checkExpect(this.comp.toString(), "new IntegerComparator()");
        t.checkExpect(this.comp.hashCode(), -265975274);
        t.checkExpect(!this.heap1.isLeaf(1));
        t.checkExpect(this.heap1.isLeaf(4));
        t.checkExpect(this.heap1.higherPriorityChild(1), 50);
        t.checkExpect(this.heap2.higherPriorityChild(1), 45);
        t.checkException(new RuntimeException(
                "The node 0 does not exist in the Heap"), this.heap1, "isLeaf",
                0);
        t.checkException(new RuntimeException(
                "The node 0 does not exist in the Heap"), this.heap1,
                "higherPriorityChild", 0);
        t.checkException(
                new RuntimeException(
                        "The given index corresponds to a Leaf and" +
                        " does not have children"),
                this.heap1, "higherPriorityChild", 4);
    }

    Heapsort sorter = new Heapsort();
    IntegerComparator icomp = new IntegerComparator();
    ArrayList<Integer> ilist = new ArrayList<Integer>();
    ArrayList<Integer> tlist = new ArrayList<Integer>();

    public void initList1() {
        ilist = new ArrayList<Integer>();
        tlist = new ArrayList<Integer>();
        ilist.add(1);
        ilist.add(2);
        ilist.add(3);
        ilist.add(0);
        ilist.add(8);
        ilist.add(18);
        ilist.add(12);
        ilist.add(5);
        ilist.add(6);
        ilist.add(9);
        ilist.add(11);

        tlist.add(18);
        tlist.add(11);
        tlist.add(12);
        tlist.add(5);
        tlist.add(9);
        tlist.add(2);
        tlist.add(8);
        tlist.add(0);
        tlist.add(3);
        tlist.add(1);
        tlist.add(6);
        
        this.sorter.init(tlist);
    }

    public void testAll2(Tester t) {
        initList1();
        t.checkExpect(this.sorter.heapsort(ilist, icomp), this.tlist);
        t.checkExpect(this.sorter.toString(), "new Heapsort()");
        t.checkExpect(this.sorter.hashCode(), -697631061);
        initList1();
        this.sorter.init(ilist);
        t.checkExpect(this.sorter.sort(icomp), this.tlist);
    }
}
