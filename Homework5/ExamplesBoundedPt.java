//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import tester.Tester;

public class ExamplesBoundedPt {

    public ExamplesBoundedPt() {

    }

    BoundedPt bptmin = new BoundedPt(0, 0);
    BoundedPt bptmax = new BoundedPt(600, 400);

    public void testAll(Tester t) {
        t.checkExpect(bptmin, new BoundedPt(0, 0));
        t.checkExpect(bptmax, new BoundedPt(600, 400));
        t.checkConstructorException(new RuntimeException(
                "The given x coordinate was 1 points beyond the right edge"),
                "BoundedPt", 601, 0);
        t.checkConstructorException(new RuntimeException(
                "The given x coordinate was 1 points beyond the left edge"),
                "BoundedPt", -1, 0);
        t.checkConstructorException(new RuntimeException(
                "The given y coordinate was 1 points beyond the top edge"),
                "BoundedPt", 0, 401);
        t.checkConstructorException(new RuntimeException(
                "The given y coordinate was 1 points beyond the bottom edge"),
                "BoundedPt", 0, -1);
    }
}
