package other;

import javalib.colors.Blue;

public class LogLane extends Lane<Log> {

    public LogLane(int width, int height, int y) {
        super(width, height, y, new Blue());
    }

    /** Add a new Log to the Lane */
    public void addNew() {
        this.alist.add(new Log(this.start(), this.y, this.vel));
    }

    /** Return the LogLane Class a String */
    public String toString() {
        return "new LogLane(" + this.width + ", " + this.height + ", " + ", "
                + this.y + this.vel + ", " + this.alist.toString() + ")";
    }
}
