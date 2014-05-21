// A class representing a Deque List
public class Deque {
    Sentinel node;
    
    public Deque(Sentinel node) {
        this.node = node;
    }
    
    public Deque() {
        this.node = new Sentinel();
    }

    /*
     * Template: 
     * Field: 
     * this.node
     * 
     * Methods: 
     * this.size() ... int 
     * this.addAtHead(String str) ... void
     * this.addAtTail(String str) ... void 
     * this.removeFromHead() ... void
     * this.removeFromTail() ... void 
     * this.getFirst() ... String 
     * this.getLast() ... String 
     * this.insertSorted(String str) ... void
     * this.removeSorted(String str) ... void
     * 
     * Methods for Fields: 
     * this.node.addNext(Node next) ... void
     * this.node.addPrev(Node prev) ... void
     * this.node.size() ... int
     * this.node.sizeAux() ... int
     * this.node.addAtHead(String str) ... void
     * this.node.addAtTail(String str) ... void
     * this.node.isEmpty() ... boolean
     * this.node.isEmptyAux() ... boolean
     * this.node.removeFromHead() ... void
     * this.node.removeFromTail() ... void
     * this.node.getFirst() ... String
     * this.node.getName() ... String
     * this.node.getLast() ... String
     * this.node.insertSorted(String str) ... void
     * this.node.insertSortedAux(String str) ... void
     * this.node.removeSorted(String str) ... void
     * this.node.removeSortedAux(String str) ... void
     * 
     */

    // Compute the size of the Deque List
    public int size() {
        return this.node.size();
    }

    // Add the given string to the front of the Deque List
    public void addAtHead(String str) {
        this.node.addAtHead(str);
    }

    // Add the given string to the end of the Deque List
    public void addAtTail(String str) {
        this.node.addAtTail(str);
    }

    // Remove the first element from the Deque List
    public void removeFromHead() {
        this.node.removeFromHead();
    }

    // Remove the last element from the Deque List
    public void removeFromTail() {
        this.node.removeFromTail();
    }

    // Get the first element of the Deque List
    public String getFirst() {
        return this.node.getFirst();
    }

    // Get the last element of the Deque List
    public String getLast() {
        return this.node.getLast();
    }

    // Insert the given string into the sorted list
    public void insertSorted(String str) {
        this.node.insertSorted(str);
    }

    // Remove the given string from the sorted list
    public void removeSorted(String str) {
        this.node.removeSorted(str);
    }
}
