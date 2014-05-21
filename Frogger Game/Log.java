package other;

import javalib.colors.Black;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

public class Log extends NPC {

    public Log(int x, int y, int vel) {
        super(x, y, vel);
    }

    /** Move the Log by its Velocity */
    public void onTick() {
        this.move();
    }

    /** Return an Image of the Log */
    public WorldImage makeImage() {
        return new RectangleImage(new Posn(this.x, this.y), 120, 40,
                new Black());
    }

    /** Return the Log Class a String */
    public String toString() {
        return "new Log(" + this.x + ", " + this.y + ", " + this.vel + ")";
    }
}
