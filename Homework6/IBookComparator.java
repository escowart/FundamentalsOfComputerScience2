//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is an interface representing Book Comparator
public interface IBookComparator {

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
    // returns -1 if the two books are in order
    // returns  0 if the two books are equal in the way 
    //    they are being tested
    // returns  1 if the two books are not in order
    public int compare(Book b1, Book b2);
    
    // Is the given Comparator the same as this one
    public boolean sameOrder(IBookComparator that);
    
    // Is the given Comparator the same as this book by author
    public boolean sameBooksByAuthor(BooksByAuthor that);
    
    // Is the given Comparator the same as this book by price
    public boolean sameBooksByPrice(BooksByPrice that);
    
    // Is the given Comparator the same as this book by title
    public boolean sameBooksByTitle(BooksByTitle that);
}
