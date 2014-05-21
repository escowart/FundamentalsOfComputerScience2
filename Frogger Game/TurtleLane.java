package other;

import javalib.colors.Blue;

public class TurtleLane extends Lane<Turtle> {

    public TurtleLane(int width, int height, int y) {
        super(width, height, y, new Blue());
    }

    /** Add a new Log to the Lane */
    public void addNew() {
        this.alist.add(new Turtle(this.start(), this.y, this.vel, true));
    }

    /** Return the CarLane Class a String */
    public String toString() {
        return "new TurtleLane(" + this.width + ", " + this.height + ", "
                + ", " + this.y + this.vel + ", " + this.alist.toString() + ")";
    }

}
