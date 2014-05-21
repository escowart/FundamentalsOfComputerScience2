//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing an Abstract Binary Search Tree
public abstract class ABST {

    IBookComparator order;

    public ABST(IBookComparator order) {
        this.order = order;
    }
    
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

    // Insert a book into the Binary Search Tree
    public abstract ABST insert(Book book);

    // Find the first element in the Binary Search Tree
    public abstract Book getFirst();

    // Removes the first element from the Binary Search Tree
    public abstract ABST getRest();

    // Is the Binary Search Tree a leaf
    public abstract boolean isLeaf();

    // Is the given tree the same as this one?
    public abstract boolean sameTree(ABST that);

    // Is the given node the same as this one?
    public abstract boolean sameNode(Node that);

    // Does the Tree contain the given book?
    public abstract boolean contains(Book book);

    // Does the Tree contain the same data as the Tree?
    public abstract boolean sameDataHelper(ABST that);

    // Does the Tree contain the same data as the given tree?
    public abstract boolean sameData(ABST that);

    // Is the given list the same as the tree;
    public abstract boolean sameAsList(ILoBook list);

    // Create a list from this Tree and this given list
    public abstract ILoBook buildList(ILoBook list);
}
