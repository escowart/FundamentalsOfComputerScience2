//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing an Comparator 
// that compares two Books by their authors
public class BooksByAuthor implements IBookComparator {

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
    // returns -1 if the two books are in order by author name
    // returns 0 if the two books have the same author
    // returns 1 if the two books are not in order by author name
    public int compare(Book b1, Book b2) {
        return b1.author.compareTo(b2.author);
    }

    // Is the given Comparator the same as this one
    public boolean sameOrder(IBookComparator that) {
        return that.sameBooksByAuthor(this);
    }

    // Is the given book by author Comparator the same as this Comparator
    public boolean sameBooksByAuthor(BooksByAuthor that) {
        return true;
    }

    // Is the given book by price Comparator the same as this Comparator
    public boolean sameBooksByPrice(BooksByPrice that) {
        return false;
    }

    // Is the given book by title Comparator the same as this Comparator
    public boolean sameBooksByTitle(BooksByTitle that) {
        return false;
    }

}
