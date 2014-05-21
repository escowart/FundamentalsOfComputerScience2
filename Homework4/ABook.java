//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

public abstract class ABook implements IBook {

    String title;
    int dayTaken;

    public ABook(String title, int dayTaken) {
        this.title = title;
        this.dayTaken = dayTaken;
    }

    /*
     * Template Fields:
     * 
     * this.title ... String 
     * this.daytaken ... int
     * 
     * Methods:
     * 
     * this.daysOverdue(int today) ... int 
     * this.isOverdue(int today) ... boolean
     * this.computeFine(int today) ... int
     */

    // Returns the number of days that the book is overdue
    // negative days is how many days until it is due
    // Used for AudioBooks and Books
    public int daysOverdue(int today) {
        return (today - dayTaken) - 14;
    }

    // Is the book overdue?
    public boolean isOverdue(int today) {
        return this.daysOverdue(today) > 0;
    }

    // Returns the fine for the book being overdue
    // Used for AudioBooks and Books in cents
    public int computeFine(int today) {
        if (this.isOverdue(today))
            return this.daysOverdue(today) * 10;
        return 0;
    }

}
