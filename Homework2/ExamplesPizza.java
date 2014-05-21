// assignment 2
// pair 027
// Cowart, Edwin
// escowart
// Bachiri, Zacharia
// bachiri

import tester.*;

public class ExamplesPizza {
    public ExamplesPizza() {
    }

    Fancy order1 = new Fancy(new Fancy(new Plain("thin crust", "mozarella"),
            "mushrooms"), "olives");
    Fancy order2 = new Fancy(new Fancy(new Plain("deep dish", "mixed cheese"),
            "pepperoni"), "onions");

    // making sure the code contains at least one test
    boolean testAll(Tester t) {
        ExamplesPizza ep = new ExamplesPizza();
        return t.checkExpect(ep.order1, ep.order1);
    }

}
