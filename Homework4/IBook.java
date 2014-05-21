//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

public interface IBook {

    // Returns the number of days that the book is overdue
    public int daysOverdue(int today);

    // Is the book overdue?
    public boolean isOverdue(int today);

    // returns the price of the fine for an overdue book in cents
    public int computeFine(int today);

}
