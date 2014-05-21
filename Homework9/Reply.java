//assignment 9
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17
import java.util.ArrayList;
import java.util.Random;


public class Reply {
    String keyword;
    ArrayList<String> answers;
    
    public Reply(String keyword, ArrayList<String> answers) {
        this.keyword = keyword;
        this.answers = answers;
    }
    
    /* Template:
     * Fields:
     * this.keyword
     * this.answers
     * 
     * Methods:
     * this.randomAnswer(String str) ... String
     * 
     * Methods for Fields: none
     */
    
    // Return a random answer.
    public String randomAnswer(String str) {
        Random rand = new Random();
        int intrad = rand.nextInt(this.answers.size());
        return this.answers.get(intrad);
    }
}
