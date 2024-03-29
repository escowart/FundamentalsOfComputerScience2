import tester.*;

// runs tests for the buddies problem
public class ExamplesBuddies {
    public ExamplesBuddies() {
    };

    Person ann = new Person("Ann");
    Person bob = new Person("Bob");
    Person cole = new Person("Cole");
    Person dan = new Person("Dan");
    Person ed = new Person("Ed");
    Person fay = new Person("Fay");
    Person gabi = new Person("Gabi");
    Person hank = new Person("Hank");
    Person jan = new Person("Jan");
    Person kim = new Person("Kim");
    Person len = new Person("Len");

    public void initBuddies() {
        this.ann.addBuddy(this.bob);
        this.ann.addBuddy(this.cole);

        this.bob.addBuddy(this.ann);
        this.bob.addBuddy(this.ed);
        this.bob.addBuddy(this.hank);

        this.cole.addBuddy(this.dan);

        this.dan.addBuddy(this.cole);

        this.ed.addBuddy(this.fay);

        this.fay.addBuddy(this.ed);
        this.fay.addBuddy(this.gabi);

        this.gabi.addBuddy(this.ed);
        this.gabi.addBuddy(this.fay);

        this.jan.addBuddy(this.kim);
        this.jan.addBuddy(this.len);

        this.kim.addBuddy(this.jan);
        this.kim.addBuddy(this.len);

        this.len.addBuddy(this.jan);
        this.len.addBuddy(this.kim);
    }

    
    public void testAll(Tester t) {
        this.initBuddies();
        t.checkExpect(!this.hank.hasDirectBuddy(this.ann));
        t.checkExpect(this.len.hasDirectBuddy(this.kim));
        t.checkExpect(!this.hank.hasDistantBuddy(this.len));
        t.checkExpect(this.ann.hasDistantBuddy(this.len));
    }
}