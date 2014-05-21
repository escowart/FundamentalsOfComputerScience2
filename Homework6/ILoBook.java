//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is an interface representing List of Books
public interface ILoBook {
    
    /* Template:
     * Fields: none
     * 
     * Methods:
     * this.isEmpty() ... boolean
     * this.buildTree(ABST tree) ... ABST
     * 
     * Methods for Fields: none
     */
    
    // Is the List of Books empty
    public boolean isEmpty();

    // Build a tree with this list and given tree
    public ABST buildTree(ABST tree);
}
