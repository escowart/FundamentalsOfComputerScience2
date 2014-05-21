// A class representing a Node of a Deque List
public class Node {
    String name;
    Node next;
    Node prev;

    public Node(String name) {
        this.name = name;
    }

    /*
     * Template: Field: 
     * this.name 
     * this.next 
     * this.prev
     * 
     * Methods: 
     * this.addNext(Node newnode) ... void 
     * this.addPrev(Node newnode) ... void 
     * this.sizeAux() ... int 
     * this.isEmptyAux() ... boolean 
     * this.getName()
     * ... String 
     * this.insertSortedAux(String str) ... void
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
     * this.prev.addNext(Node newnode) ... void 
     * this.prev.addPrev(Node newnode) ... void 
     * this.prev.sizeAux() ... int 
     * this.prev.isEmptyAux() ... boolean 
     * this.prev.getName() ... String
     * this.prev.insertSortedAux(String str) ... void
     * this.prev.removeSortedAux(String str) ... void
     */

    // Replace the next field
    public void addNext(Node newnode) {
        this.next = newnode;
    }

    // Replace the prev field
    public void addPrev(Node newnode) {
        this.prev = newnode;
    }

    // Find the size of the rest of the list and stop at the next Sentinel
    public int sizeAux() {
        return 1 + this.next.sizeAux();
    }

    // Is the Sentinel Empty Auxilary?
    public boolean isEmptyAux() {
        return false;
    }

 // Get the first element of the Deque List auxilary
    public String getFirstAux() {
        return this.name;
    }

    // Get the last element of the Deque List auxilary
    public String getLastAux() {
        return this.name;
    }
    

    // Insert the given string into the sorted list
    public void insertSortedAux(String str) {
        if (this.name.compareTo(str) >= 0) {
            Node newnode = new Node(str);
            newnode.addPrev(this.prev);
            newnode.addNext(this);
            this.prev.addNext(newnode);
            this.addPrev(newnode);
        } else {
            this.next.insertSortedAux(str);
        }
    }

    // Remove the given string from the sorted list auxilary function
    public void removeSortedAux(String str) {
        if (this.name.compareTo(str) == 0) {
            Node newnode = this.next;
            newnode.addPrev(this.prev);
            this.prev.addNext(newnode);
        } else {
            this.next.removeSortedAux(str);
        }
    }
}
