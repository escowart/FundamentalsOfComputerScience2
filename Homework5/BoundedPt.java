//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

// This is a class representing a bounded point

import javalib.worldimages.Posn;

public class BoundedPt extends Posn {
    int width = 600; // the width of the canvas
    int height = 400; // the height of the canvas

    public BoundedPt(int x, int y) {
        super(x, y);
        if (x > this.width) {
            throw new RuntimeException("The given x coordinate was "
                    + (x - this.width) + " points beyond the right edge");
        } else if (x < 0) {
            throw new RuntimeException("The given x coordinate was " + (-x)
                    + " points beyond the left edge");
        } else if (y > this.height) {
            throw new RuntimeException("The given y coordinate was "
                    + (y - this.height) + " points beyond the top edge");
        } else if (y < 0) {
            throw new RuntimeException("The given y coordinate was " + (-y)
                    + " points beyond the bottom edge");
        }
    }

    /*
     * Template: 
     * Fields:
     * this.x ... int 
     * this.y ... int
     * 
     * Methods: none
     */

}
