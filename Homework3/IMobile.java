//assignment 3
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import javalib.colors.Black;
import javalib.colors.IColor;
import javalib.worldimages.LineImage;
import javalib.worldimages.Posn;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldImage;

public interface IMobile {

    // determines the total weight of an IMobile
    public int totalWeight();

    // What is the height of the mobile
    public int totalHeight();

    // Is the mobile balance;
    public boolean isBalanced();

    // builds a new balanced mobile out of two
    public IMobile buildMobile(IMobile that, int string, int strut);

    // Does the Mobile fit in a given space?
    public boolean maxWidth(int radius);

    // Finds the largest radius of the mobile
    public int longestRad();

    // Draws the Mobile at the given position
    //public WorldImage drawAt(int x, int y);
}

class Simple implements IMobile {

    int length;
    int weight;
    IColor color;

    /*
     * Template 
     * this.length 
     * this.weight 
     * this.color
     */

    public Simple(int length, int weight, IColor color) {
        this.length = length;
        this.weight = weight;
        this.color = color;
    }

    // determines the total weight of an IMobile
    public int totalWeight() {
        return this.weight;
    }

    // What is the height of the mobile given the length
    public int totalHeight() {
        return this.length;
    }

    // Is the mobile balance?
    public boolean isBalanced() {
        return true;
    }

    // Build a new Complex out of a Simple and another IMobile
    public IMobile buildMobile(IMobile that, int string, int strut) {
        int lefthalf = strut * this.totalWeight()
                / (that.totalWeight() + this.totalWeight());
        int righthalf = strut * that.totalWeight()
                / (that.totalWeight() + this.totalWeight());
        return new Complex(string, lefthalf, righthalf, this, that);
    }

    // Does the Simple Mobile fit in a given space?
    public boolean maxWidth(int radius) {
        return this.longestRad() < radius;
    }

    // Finds the largest radius of the simple mobile can rotate at.
    public int longestRad() {
        return this.weight / 10;
    }

    // Draws the Simple Mobile at the given point
    /*
    public WorldImage drawAt(int x, int y) {
        int s = 5;
        int bot = (y + s * this.length);
        LineImage line = new LineImage(new Posn(x, y), new Posn(x, bot),
                new Black());
        TextImage weightText = new TextImage(new Posn(x, bot + 10), ""
                + this.weight, 10, 1, this.color);
        return line.overlayImages(weightText);
    }
    */
}

class Complex implements IMobile {

    int length;
    int leftside;
    int rightside;
    IMobile left;
    IMobile right;

    public Complex(int length, int leftside, int rightside, IMobile left,
            IMobile right) {
        this.length = length;
        this.leftside = leftside;
        this.rightside = rightside;
        this.left = left;
        this.right = right;
    }

    /*
     * Template 
     * this.length 
     * this.leftside
     * this.rightside
     * this.left 
     * this.right
     */

    // Determines the total weight of an IMobile
    public int totalWeight() {
        return this.left.totalWeight() + this.right.totalWeight();
    }

    // What is the total height of the mobile given its length
    public int totalHeight() {
        return this.length
                + Math.max(this.left.totalHeight(), this.right.totalHeight());
    }

    // Is the mobile balance?
    public boolean isBalanced() {
        return ((this.leftside * this.left.totalWeight()) == 
                (this.rightside * this.right.totalWeight()))
                && this.right.isBalanced()
                && this.left.isBalanced();
    }

    // Builds a new Complex out of the a Complex and a given inputs
    public IMobile buildMobile(IMobile that, int string, int strut) {
        int lefthalf = strut * this.totalWeight()
                / (that.totalWeight() + this.totalWeight());
        int righthalf = strut * that.totalWeight()
                / (that.totalWeight() + this.totalWeight());
        return new Complex(string, lefthalf, righthalf, this, that);
    }

    // Does the Complex Mobile fit in a given space?
    public boolean maxWidth(int radius) {
        return this.longestRad() < radius;
    }

    // Finds the largest radius of the Complex Mobile will spin at
    public int longestRad() {
        return Math.max(this.leftside + this.left.longestRad(), this.rightside
                + this.left.longestRad());
    }

    // Draws the Complex Mobile starting at the given point
    /*
    public WorldImage drawAt(int x, int y) {
        int s = 5;
        int bot = (y + s * this.length);
        int rightend = (x + (s * this.rightside));
        int leftend = (x - (s * this.leftside));
        LineImage verticle = new LineImage(new Posn(x, y), new Posn(x, bot),
                new Black());
        LineImage horriz = new LineImage(new Posn(leftend, bot), new Posn(
                rightend, bot), new Black());
        return verticle.overlayImages(horriz, left.drawAt(leftend, bot),
                right.drawAt(rightend, bot));
    }
    */
}
