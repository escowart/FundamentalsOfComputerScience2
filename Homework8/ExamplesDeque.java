import tester.Tester;

public class ExamplesDeque {

    public ExamplesDeque() {
        reset();
    }

    Sentinel testSentinel;
    Deque testDeque;
    Node abcnode;
    Node bcdnode;
    Node cdenode;
    Node defnode;
    Sentinel emptySentinel;
    Deque emptyDeque;
    Sentinel testSentinel2;
    Deque testDeque2;
    Node newnode;
    Node abcnode2;
    Node bcdnode2;
    Node cdenode2;
    Node defnode2;
    Sentinel emptySentinel2;
    Deque emptyDeque2;
    Node newnode2;
    Deque emptyDeque3;

    // Reset the data
    void reset() {
        testSentinel = new Sentinel();
        testDeque = new Deque(this.testSentinel);
        abcnode = new Node("abc");
        bcdnode = new Node("bcd");
        cdenode = new Node("cde");
        defnode = new Node("def");
        emptySentinel = new Sentinel();
        emptyDeque = new Deque(this.emptySentinel);

        testSentinel2 = new Sentinel();
        testDeque2 = new Deque(this.testSentinel2);
        newnode = new Node("string");
        abcnode2 = new Node("abc");
        bcdnode2 = new Node("bcd");
        cdenode2 = new Node("cde");
        defnode2 = new Node("def");
        emptySentinel2 = new Sentinel();
        emptyDeque2 = new Deque(this.emptySentinel2);
        newnode2 = new Node("string");
        emptyDeque3 = new Deque();
    }

    // Initialize the first half of the data
    void initData() {
        this.emptySentinel.addNext(this.emptySentinel);
        this.emptySentinel.addPrev(this.emptySentinel);

        this.testSentinel.addNext(this.abcnode);
        this.testSentinel.addPrev(this.defnode);

        this.abcnode.addNext(this.bcdnode);
        this.abcnode.addPrev(this.testSentinel);

        this.bcdnode.addNext(this.cdenode);
        this.bcdnode.addPrev(this.abcnode);

        this.cdenode.addNext(this.defnode);
        this.cdenode.addPrev(this.bcdnode);

        this.defnode.addNext(this.testSentinel);
        this.defnode.addPrev(this.cdenode);

    }

    // Initialize the second half of the data
    void initData2() {
        this.emptySentinel2.addNext(this.emptySentinel2);
        this.emptySentinel2.addPrev(this.emptySentinel2);

        this.testSentinel2.addNext(this.abcnode2);
        this.testSentinel2.addPrev(this.defnode2);

        this.abcnode2.addNext(this.bcdnode2);
        this.abcnode2.addPrev(this.testSentinel2);

        this.bcdnode2.addNext(this.cdenode2);
        this.bcdnode2.addPrev(this.abcnode2);

        this.cdenode2.addNext(this.defnode2);
        this.cdenode2.addPrev(this.bcdnode2);

        this.defnode2.addNext(this.testSentinel2);
        this.defnode2.addPrev(this.cdenode2);

    }

    // The addAtHead function results
    void runaddAtHeadResults() {
        this.testSentinel2.addNext(this.newnode);
        this.testSentinel2.addPrev(this.defnode2);

        this.newnode.addNext(this.abcnode2);
        this.newnode.addPrev(this.testSentinel2);

        this.abcnode2.addNext(this.bcdnode2);
        this.abcnode2.addPrev(this.newnode);

        this.bcdnode2.addNext(this.cdenode2);
        this.bcdnode2.addPrev(this.abcnode2);

        this.cdenode2.addNext(this.defnode2);
        this.cdenode2.addPrev(this.bcdnode2);

        this.defnode2.addNext(this.testSentinel2);
        this.defnode2.addPrev(this.cdenode2);

        this.emptySentinel2.addNext(this.newnode2);
        this.emptySentinel2.addPrev(this.newnode2);

        this.newnode2.addNext(this.emptySentinel2);
        this.newnode2.addPrev(this.emptySentinel2);
    }

    // Run addAtTail
    void runaddAtTail() {
        this.testDeque.addAtTail("string");
        this.emptyDeque.addAtTail("string");
    }

    // Produces the addAtTail Results
    void runaddAtTailResults() {
        this.testSentinel2.addNext(this.abcnode2);
        this.testSentinel2.addPrev(this.newnode);

        this.newnode.addNext(this.testSentinel2);
        this.newnode.addPrev(this.defnode2);

        this.abcnode2.addNext(this.bcdnode2);
        this.abcnode2.addPrev(this.testSentinel2);

        this.bcdnode2.addNext(this.cdenode2);
        this.bcdnode2.addPrev(this.abcnode2);

        this.cdenode2.addNext(this.defnode2);
        this.cdenode2.addPrev(this.bcdnode2);

        this.defnode2.addNext(this.newnode);
        this.defnode2.addPrev(this.cdenode2);

        this.emptySentinel2.addNext(this.newnode2);
        this.emptySentinel2.addPrev(this.newnode2);

        this.newnode2.addNext(this.emptySentinel2);
        this.newnode2.addPrev(this.emptySentinel2);
    }

    // Runs addAtHead
    void runaddAtHead() {
        this.testDeque.addAtHead("string");
        this.emptyDeque.addAtHead("string");
    }

    // Runs removeFromHead
    void runremoveFromHead() {
        this.testDeque2.removeFromHead();
        this.emptyDeque2.removeFromHead();
    }

    // Runs removeFromTail
    void runremoveFromTail() {
        this.testDeque2.removeFromTail();
        this.emptyDeque2.removeFromTail();
    }

    // Runs insertSorted and put the element at the front
    void runinsertSortedHead() {
        this.testDeque2.removeFromHead();
        this.testDeque2.insertSorted("abc");
    }

    // Runs insertSorted and put the element at the front
    void runinsertSortedTail() {
        this.testDeque2.removeFromTail();
        this.testDeque2.insertSorted("def");
    }

    // Runs insertSorted on an empty list
    void runinsertSortedAll() {
        this.emptyDeque.insertSorted("bcd");
        this.emptyDeque.insertSorted("def");
        this.emptyDeque.insertSorted("abc");
        this.emptyDeque.insertSorted("cde");
    }

    // Runs removeSorted
    void runremoveSorted() {
        this.testDeque2.removeSorted("string");
        this.emptyDeque2.removeSorted("string");
    }

    void testAll(Tester t) {
        initData();

        // size
        t.checkExpect(this.testDeque.size(), 4);
        t.checkExpect(this.emptyDeque.size(), 0);

        // addAtHead
        runaddAtHead();
        runaddAtHeadResults();
        t.checkExpect(this.testDeque, this.testDeque2);
        t.checkExpect(this.emptyDeque, this.emptyDeque2);

        // addAtTail
        reset();
        initData();
        runaddAtTail();
        runaddAtTailResults();
        t.checkExpect(this.testDeque, this.testDeque2);
        t.checkExpect(this.emptyDeque, this.emptyDeque2);

        // removeFromHead
        reset();
        initData();
        t.checkException(new RuntimeException(
                "Cannot remove an element from an empty list"),
                this.emptyDeque, "removeFromHead");
        runaddAtHeadResults();
        runremoveFromHead();
        t.checkExpect(this.testDeque, this.testDeque2);
        t.checkExpect(this.emptyDeque, this.emptyDeque2);

        // removeFromTail
        reset();
        initData();
        t.checkException(new RuntimeException(
                "Cannot remove an element from an empty list"),
                this.emptyDeque, "removeFromTail");
        runaddAtTailResults();
        runremoveFromTail();
        t.checkExpect(this.testDeque, this.testDeque2);
        t.checkExpect(this.emptyDeque, this.emptyDeque2);

        // getFirst
        reset();
        initData();
        t.checkExpect(this.testDeque.getFirst(), "abc");
        t.checkException(new RuntimeException(
                "Cannot get the first of an empty list"), this.emptyDeque,
                "getFirst");

        // getLast
        t.checkExpect(this.testDeque.getLast(), "def");
        t.checkException(new RuntimeException(
                "Cannot get the last of an empty list"), this.emptyDeque,
                "getLast");

        // insertSorted
        reset();
        initData();
        initData2();
        runinsertSortedHead();
        t.checkExpect(this.testDeque, this.testDeque2);

        reset();
        initData();
        initData2();
        runinsertSortedTail();
        t.checkExpect(this.testDeque, this.testDeque2);

        reset();
        initData();
        runinsertSortedAll();
        t.checkExpect(this.testDeque, this.emptyDeque);

        // removeSorted
        reset();
        initData();
        initData2();
        runaddAtTailResults();
        runremoveSorted();
        t.checkExpect(this.testDeque, this.testDeque2);
        t.checkExpect(this.emptyDeque, this.emptyDeque2);
        t.checkException(new RuntimeException(
                "There is no elements of to remove from the sentinel"),
                this.testDeque, "removeSorted", "zzz");
    }
}
