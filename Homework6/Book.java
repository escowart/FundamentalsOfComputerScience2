//assignment 6
//pair 121
//Cowart, Edwsin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing a Book
public class Book {
    String title;
    String author;
    int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    /* Template:
     * Fields:
     * this.title ... String
     * this.author ... String
     * this.price ... int
     * 
     * Methods:
     * this.sameBook(Book that) ... boolean
     * 
     * Methods for Fields: none
     * 
     */

    // Is the given book the same as this one?
    public boolean sameBook(Book that) {
        return this.title.equals(that.title) && this.author.equals(that.author)
                && (this.price == that.price);
    }
}
