//assignment 3
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import javalib.colors.Blue;
import javalib.colors.Green;
import javalib.colors.Red;
import tester.Tester;

public class ExamplesMobiles {
    public ExamplesMobiles() {
    };

    IMobile right1 = new Simple(3, 40, new Green());
    IMobile left2 = new Simple(1, 10, new Red());
    IMobile right2 = new Simple(2, 10, new Blue());
    IMobile left1 = new Complex(1, 6, 7, left2, right2);
    IMobile example1 = new Simple(2, 10, new Blue());
    IMobile calder = new Complex(3, 12, 5, left1, right1);

    // My Example
    IMobile left3 = new Simple(100, 10, new Red());
    IMobile right3 = new Simple(2, 10, new Blue());
    IMobile example3 = new Complex(3, 5, 5, left3, right3);
    IMobile example4 = new Complex(3, 5, 10, left1, right1);
    IMobile example5 = new Complex(3, 10, 5, right1, left1);

    public void testtotalWeight(Tester t) {
        // totalWeight
        t.checkExpect(this.example1.totalWeight(), 10);
        t.checkExpect(this.calder.totalWeight(), 60);
        t.checkExpect(this.example3.totalWeight(), 20);

        // totalWeight
        t.checkExpect(this.example1.totalHeight(), 2);
        t.checkExpect(this.calder.totalHeight(), 6);
        t.checkExpect(this.example3.totalHeight(), 103);

        // isBalanced
        t.checkExpect(this.calder.isBalanced(), false);
        t.checkExpect(this.example3.isBalanced(), true);

        // buildMobile
        t.checkExpect(this.left1.buildMobile(right1, 3, 15), example4);
        t.checkExpect(this.right1.buildMobile(left1, 3, 15), example5);

        // maxWidth
        t.checkExpect(this.example1.maxWidth(2), true);
        t.checkExpect(this.example1.maxWidth(1), false);
        t.checkExpect(this.calder.maxWidth(20), false);
        t.checkExpect(this.calder.maxWidth(21), true);


    }

}
