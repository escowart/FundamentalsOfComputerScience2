//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing an Leaf which is a Binary Search Tree
public class Leaf extends ABST {

    /* Template:
     * Fields:
     * this.order ... IBookComparator
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
     */
    
    public Leaf(IBookComparator order) {
        super(order);
    }

    // Insert a book as a new node replacing this one.
    public ABST insert(Book book) {
        return new Node(book, this, this);
    }

    // Find the first element in the Binary Search Tree
    public Book getFirst() {
        throw new RuntimeException("No first in an empty tree");
    }

    // Removes the first element from the Binary Search Tree
    public ABST getRest() {
        throw new RuntimeException("No rest of an empty tree");
    }

    // Is the Binary Search Tree a leaf
    public boolean isLeaf() {
        return true;
    }

    // Is the given tree the same as this Leaf?
    public boolean sameTree(ABST that) {
        return that.isLeaf() && this.order.sameOrder(that.order);
    }

    // Is the given Node the same as this Leaf?
    public boolean sameNode(Node that) {
        return false;
    }

    // Does the Leaf contain the given book?
    public boolean contains(Book book) {
        return false;
    }

    // Does the given tree contain data as this leaf?
    public boolean sameDataHelper(ABST that) {
        return true;
    }

    // Does the given tree contain data as this leaf?
    public boolean sameData(ABST that) {
        return that.isLeaf();
    }

    // Is the tree same as the given list
    public boolean sameAsList(ILoBook list) {
        return list.isEmpty();
    }

    // Build a list from this tree and the given list
    public ILoBook buildList(ILoBook list) {
        return list;
    }
}
