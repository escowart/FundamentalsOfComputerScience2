//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing an Empty List of Books
public class MtLoBook implements ILoBook {

    /* Template:
     * Fields: none
     * 
     * Methods:
     * this.isEmpty() ... boolean
     * this.buildTree(ABST tree) ... ABST
     * 
     * Methods for Fields: none
     */
    
    // Is the empty list a empty list?
    public boolean isEmpty() {
        return true;
    }

    // Build the tree with this empty list and the given tree
    public ABST buildTree(ABST tree) {
        return tree;
    }
}
