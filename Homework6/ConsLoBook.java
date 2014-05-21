//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing a Cons List of Books
public class ConsLoBook implements ILoBook {

    Book first;
    ILoBook rest;

    public ConsLoBook(Book first, ILoBook rest) {
        this.first = first;
        this.rest = rest;
    }

    /* Template:
     * Fields:
     * this.first ... Book
     * this.rest ... ILoBook
     * 
     * Methods:
     * this.isEmpty() ... boolean
     * this.buildTree(ABST tree) ... ABST
     * 
     * Methods for Fields:
     * this.first.sameBook(Book that) ... boolean
     * this.rest.isEmpty() ... boolean
     * this.rest.buildTree(ABST tree) ... ABST
     */
    
    // Is the list empty?
    public boolean isEmpty() {
        return false;
    }

    // Build a tree with this cons list and a given tree
    public ABST buildTree(ABST tree) {
        return rest.buildTree(tree.insert(this.first));
    }
}
