//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing an Node which is a Binary Search Tree
public class Node extends ABST {

    Book data;
    ABST left;
    ABST right;

    protected Node(Book data, ABST left, ABST right) {
        super(left.order);
        if (!left.order.sameOrder(right.order))

        this.left = left;
        this.right = right;
    }

    /* Template:
     * Fields:
     * this.order ... IBookComparator
     * this.data ... Book
     * this.left ... ABST
     * this.right ... ABST
     * 
     * Methods:
     * this.insert(Book book) ... ABST
     * this.getFirst() ... Book
     * this.getRest() ... ABST
     * this.isLeaf() ... boolean
     * this.sameTree(ABST that) ... boolean
     * this.sameNode(Node that) ... boolean
     * this.contains(Book book) ... boolean
     * this.sameDataHelper(ABST that) ... boolean
     * this.sameData(ABST that) ... boolean
     * this.sameAsList(ILoBook list) ... boolean
     * this.buildList(ILoBook list) ... ILoBook
     * 
     * Methods for Fields:
     * this.order.compare(Book b1, Book b2) ... int
     * this.order.sameOrder(IBookComparator that) ... boolean
     * this.order.sameBooksByAuthor(BooksByAuthor that) ... boolean
     * this.order.sameBooksByPrice(BooksByPrice that) ... boolean
     * this.order.sameBooksByTitle(BooksByTitle that) ... boolean
     * this.data.sameBook(Book that) ... boolean
     * this.left.insert(Book book) ... ABST
     * this.left.getFirst() ... Book
     * this.left.getRest() ... ABST
     * this.left.isLeaf() ... boolean
     * this.left.sameTree(ABST that) ... boolean
     * this.left.sameNode(Node that) ... boolean
     * this.left.contains(Book book) ... boolean
     * this.left.sameDataHelper(ABST that) ... boolean
     * this.left.sameData(ABST that) ... boolean
     * this.left.sameAsList(ILoBook list) ... boolean
     * this.left.buildList(ILoBook list) ... ILoBook
     * this.right.insert(Book book) ... ABST
     * this.right.getFirst() ... Book
     * this.right.getRest() ... ABST
     * this.right.isLeaf() ... boolean
     * this.right.sameTree(ABST that) ... boolean
     * this.right.sameNode(Node that) ... boolean
     * this.right.contains(Book book) ... boolean
     * this.right.sameDataHelper(ABST that) ... boolean
     * this.right.sameData(ABST that) ... boolean
     * this.right.sameAsList(ILoBook list) ... boolean
     * this.right.buildList(ILoBook list) ... ILoBook
     */
    
    // Insert a book in the correct area
    public ABST insert(Book book) {
        if ((this.order.compare(book, this.data)) < 0)
            return new Node(this.data, this.left.insert(book), this.right);
        else if ((this.order.compare(book, this.data)) == 0)
            return new Node(this.data, new Node(book, this.left, new Leaf(
                    this.order)), this.right);
        return new Node(this.data, this.left, this.right.insert(book));
    }

    // Find the first element in the Binary Search Tree
    public Book getFirst() {
        if (this.left.isLeaf())
            return this.data;
        return this.left.getFirst();
    }

    // Removes the first element from the Binary Search Tree
    public ABST getRest() {
        if (this.left.isLeaf())
            return this.right;
        return new Node(this.data, this.left.getRest(), this.right);
    }

    // Is the Node a Leaf?
    public boolean isLeaf() {
        return false;
    }

    // Is the given tree the same as this Node?
    public boolean sameTree(ABST that) {
        return this.order.sameOrder(that.order) && that.sameNode(this);
    }

    // Is the given node the same as this Node?
    public boolean sameNode(Node that) {
        return this.data.sameBook(that.data) && this.left.sameTree(that.left)
                && this.right.sameTree(that.right);
    }

    // Does the node contain the data?
    public boolean contains(Book book) {
        return this.data.sameBook(book) || this.left.contains(book)
                || this.right.contains(book);
    }

    // Do the Node have the same data as the given tree?
    public boolean sameDataHelper(ABST that) {
        return that.contains(this.data) && this.left.sameDataHelper(that)
                && this.right.sameDataHelper(that);
    }

    // Do the Node have the same data as the given tree?
    public boolean sameData(ABST that) {
        return that.sameDataHelper(this) && this.sameDataHelper(that);
    }

    // Is the Node the same as the given list?
    public boolean sameAsList(ILoBook list) {
        if (list.isEmpty())
            return false;
        ConsLoBook conslist = (ConsLoBook) list;
        return conslist.first.sameBook(this.getFirst())
                && this.getRest().sameAsList(conslist.rest);
    }

    // Build a Node with this node and the given list
    public ILoBook buildList(ILoBook list) {
        return new ConsLoBook(this.getFirst(), this.getRest().buildList(list));
    }
}
