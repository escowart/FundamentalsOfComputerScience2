//assignment 9
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17
import java.util.ArrayList;

// This call represents the Eliza AI that responds to questions
public class Eliza {
    ArrayList<Reply> replies;

    public Eliza() {
        this.replies = new ArrayList<Reply>();
        this.initReplies();
    }
    
    /* Template:
     * Fields:
     * this.replies
     * 
     * Methods:
     * this.initReplies() ... void
     * 
     * Methods for Fields:
     * this.replies.randomAnswer(String str) ... String
     */

    // Initialize the Reply list
    public void initReplies() {
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Because");
        temp.add("'Cause");
        temp.add("Because Its time");
        this.replies.add(new Reply("why", temp));
        temp = new ArrayList<String>();
        temp.add("Me");
        temp.add("You");
        temp.add("Yo");
        temp.add("Tu");
        this.replies.add(new Reply("who", temp));
        temp = new ArrayList<String>();
        temp.add("It happens");
        temp.add("The Big Bang");
        temp.add("With a lunch box");
        temp.add("How sould I know");
        this.replies.add(new Reply("how", temp));
        temp = new ArrayList<String>();
        temp.add("Here");
        temp.add("There");
        temp.add("Earth");
        temp.add("Everywhere");
        this.replies.add(new Reply("where", temp));
        temp = new ArrayList<String>();
        temp.add("Then");
        temp.add("Now");
        temp.add("In 1 entinity");
        temp.add("In 2 entinitis");
        this.replies.add(new Reply("when", temp));
        temp = new ArrayList<String>();
        temp.add("That");
        temp.add("Everything");
        temp.add("Infinity");
        temp.add("Nothing");
        this.replies.add(new Reply("what", temp));
    }

    public String firstWord(String question) {
        for (int x = 0; x < this.replies.size(); x++) {
            if (question.toLowerCase().startsWith(this.replies.get(x).keyword))
                return this.replies.get(x).randomAnswer(question);
        }
        return "I do not know or Why do you want to know?";
    }
}
