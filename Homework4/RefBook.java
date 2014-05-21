//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

public class RefBook extends ABook {

    public RefBook(String title, int dayTaken) {
        super(title, dayTaken);
    }

    /*
     * Template Fields:
     * 
     * this.title ... String 
     * this.dayTaken ... int
     * 
     * Methods:
     * 
     * this.daysOverdue(int today) ... int
     */

    // Returns the number of days that the reference book is overdue
    public int daysOverdue(int today) {
        return (today - dayTaken) - 2;
    }

}
