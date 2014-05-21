package other;

import javalib.colors.Red;
import javalib.colors.White;
import javalib.worldimages.CircleImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

public class Turtle extends NPC {

    boolean on;

    public Turtle(int x, int y, int vel, boolean on) {
        super(x, y, vel);
        this.on = on;
    }

    /** Move the Turtle across the Screen and Randomly turn it On or Off */
    public void onTick() {
        this.move();
        if (NPC.GEN.nextInt(10) == 0)
            this.on = !this.on;
    }

    /** Return the Image of the Turtle */
    public WorldImage makeImage() {
        if (this.on)
            return new CircleImage(new Posn(this.x, this.y), 25, new Red());
        return new CircleImage(new Posn(this.x, this.y), 0, new White());
    }

    /** Return the Turtle Class a String */
    public String toString() {
        return "new Car(" + this.x + ", " + this.y + ", " + this.vel + ", " + this.on + ")";
    }
    
}
