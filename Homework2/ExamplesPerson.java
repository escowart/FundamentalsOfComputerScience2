// assignment 2
// pair 027
// Cowart, Edwin
// escowart
// Bachiri, Zacharia
// bachiri

import tester.*;

public class ExamplesPerson {
    Person tim = new Person("Tim", 20, "M", new Address("Concord", "NH"));
    Person ann = new Person("Ann", 19, "F", new Address("Concord", "MA"));
    Person pat = new Person("Pat", 19, "F", new Address("Boston", "MA"));
    Person kim = new Person("Kim", 17, "F", new Address("Boston", "MA"));
    Person dan = new Person("Dan", 22, "M", new Address("Nashua", "NH"));

    public void testPerson(Tester t) {
        // sameCity tests
        t.checkExpect(kim.sameCity(kim), true);
        t.checkExpect(kim.sameCity(pat), true);
        t.checkExpect(kim.sameCity(tim), false);
        t.checkExpect(kim.sameCity(ann), false);

        // sameStateOnly tests
        t.checkExpect(pat.sameStateOnly(dan), false);
        t.checkExpect(pat.sameStateOnly(pat), false);
        t.checkExpect(pat.sameStateOnly(kim), false);
        t.checkExpect(pat.sameStateOnly(ann), true);

    }
}
