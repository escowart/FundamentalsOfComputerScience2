// A class representing a Sentinel which encloses the elements of a Deque List
public class Sentinel extends Node {

    public Sentinel() {
        super("");
        this.addNext(this);
        this.addPrev(this);
    }

    /*
     * Template: Field: 
     * this.name
     * this.next 
     * this.prev
     * 
     * Methods: 
     * this.addNext(Node next) ... void 
     * this.addPrev(Node prev) ... void 
     * this.size() ... int 
     * this.sizeAux() ... int 
     * this.addAtHead(String str) ... void 
     * this.addAtTail(String str) ... void 
     * this.isEmpty() ... boolean 
     * this.isEmptyAux() ... boolean 
     * this.removeFromHead() ... void
     * this.removeFromTail() ... void 
     * this.getFirst() ... String 
     * this.getName() ... String 
     * this.getLast() ... String 
     * this.insertSorted(String str) ... void 
     * this.insertSortedAux(String str) ... void 
     * this.removeSorted(String str) ... void 
     * this.removeSortedAux(String str) ... void
     * 
     * Methods for Fields: 
     * this.next.addNext(Node newnode) ... void
     * this.next.addPrev(Node newnode) ... void 
     * this.next.sizeAux() ... int
     * this.next.isEmptyAux() ... boolean 
     * this.next.getName() ... String
     * this.next.insertSortedAux(String str) ... void
     * this.next.removeSortedAux(String str) ... void 
     * this.prev.addNext(Node  newnode) ... void 
     * this.prev.addPrev(Node newnode) ... void 
     * this.prev.sizeAux() ... int 
     * this.prev.isEmptyAux() ... boolean 
     * this.prev.getName() ... String
     * this.prev.insertSortedAux(String str) ... void
     * this.prev.removeSortedAux(String str) ... void
     */

    // Find the size of the list contained within the Sentinel
    public int size() {
        return this.next.sizeAux();
    }

    // The Termination case for sizeAux() for nodes
    public int sizeAux() {
        return 0;
    }

    // Add the given string to the front of the Sentinal's list
    public void addAtHead(String str) {
        Node first = new Node(str);
        first.addPrev(this);
        first.addNext(this.next);
        this.next.addPrev(first);
        this.addNext(first);
    }

    // Add the given string to the end of the Sentinal's list
    public void addAtTail(String str) {
        Node last = new Node(str);
        last.addPrev(this.prev);
        last.addNext(this);
        this.prev.addNext(last);
        this.addPrev(last);
    }

    // Is the Sentinel Empty?
    public boolean isEmpty() {
        return this.next.isEmptyAux() || this.prev.isEmptyAux();
    }

    // Is the Sentinel Empty Auxilary?
    public boolean isEmptyAux() {
        return true;
    }

    // Remove the first element from the Deque List
    public void removeFromHead() {
        if (this.isEmpty())
            throw new RuntimeException(
                    "Cannot remove an element from an empty list");
        Node newnode = this.next.next;
        newnode.addPrev(this);
        this.addNext(newnode);
    }

    // Remove the last element from the Deque List
    public void removeFromTail() {
        if (this.isEmpty())
            throw new RuntimeException(
                    "Cannot remove an element from an empty list");
        Node newnode = this.prev.prev;
        newnode.addNext(this);
        this.addPrev(newnode);
    }

    // Get the first element of the Deque List
    public String getFirst() {
        return this.next.getFirstAux();
    }

    // Get the first element of the Deque List auxilary
    public String getFirstAux() {
        throw new RuntimeException("Cannot get the first of an empty list");
    }

    // Get the last element of the Deque List
    public String getLast() {
        return this.prev.getLastAux();
    }

    // Get the last element of the Deque List auxilary
    public String getLastAux() {
        throw new RuntimeException("Cannot get the last of an empty list");
    }
    
    // Insert the given string into the sorted list
    public void insertSorted(String str) {
        this.next.insertSortedAux(str);
    }

    // Insert the given string into the sorted list auxilary function
    public void insertSortedAux(String str) {
        this.addAtTail(str);
    }

    // Remove the given string from the sorted list
    public void removeSorted(String str) {
        this.next.removeSortedAux(str);
    }

    // Remove the given string from the sorted list auxilary function
    public void removeSortedAux(String str) {
        throw new RuntimeException(
                "There is no elements of to remove from the sentinel");
    }
}
