//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing an Comparator 
// that compares two Books by their title
public class BooksByTitle implements IBookComparator {

    /* Template:
     * Fields: none
     * 
     * Methods:
     * this.compare(Book b1, Book b2) ... int
     * this.sameOrder(IBookComparator that) ... boolean
     * this.sameBooksByAuthor(BooksByAuthor that) ... boolean
     * this.sameBooksByPrice(BooksByPrice that) ... boolean
     * this.sameBooksByTitle(BooksByTitle that) ... boolean
     * 
     * Methods for Fields: none
     * 
     */
    
    // Compare two books.
    // returns -1 if the two books are in order by their name
    // returns 0 if the two books have the same name
    // returns 1 if the two books are not in order by their name
    public int compare(Book b1, Book b2) {
        return b1.title.compareTo(b2.title);
    }

    // Is the given Comparator the same as this one
    public boolean sameOrder(IBookComparator that) {
        return that.sameBooksByTitle(this);
    }

    // Is the given book by author Comparator the same as this Comparator
    public boolean sameBooksByAuthor(BooksByAuthor that) {
        return false;
    }

    // Is the given book by price Comparator the same as this Comparator
    public boolean sameBooksByPrice(BooksByPrice that) {
        return false;
    }

    // Is the given book by title Comparator the same as this Comparator
    public boolean sameBooksByTitle(BooksByTitle that) {
        return true;
    }
}
