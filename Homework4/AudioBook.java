//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

public class AudioBook extends ABook {
    String author;

    public AudioBook(String title, String author, int dayTaken) {
        super(title, dayTaken);
        this.author = author;
    }

    /*
     * Template Fields:
     * 
     * this.title ... String 
     * this.author ... String 
     * this.dayTaken ... int
     * 
     * Methods:
     * 
     * this.computeFine(int today) ... int
     */

    // Returns the fine for an overdue audio book in cents
    public int computeFine(int today) {
        if (this.isOverdue(today))
            return this.daysOverdue(today) * 20;
        return 0;
    }

}
