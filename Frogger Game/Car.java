package other;

import javalib.colors.Blue;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

public class Car extends NPC {

    public Car(int x, int y, int vel) {
        super(x, y, vel);
    }

    /** Move the Car On-Tick by its Velocity */
    public void onTick() {
        this.move();
    }

    /** Returns an Image of a Car */
    public WorldImage makeImage() {
        if (NPC.GEN.nextBoolean())
            return new RectangleImage(new Posn(this.x, this.y), 60, 40,
                    new Blue());
        return new RectangleImage(new Posn(this.x, this.y), 40, 40, new Blue());
    }

    /** Return the Car Class a String */
    public String toString() {
        return "new Car(" + this.x + ", " + this.y + ", " + this.vel + ")";
    }

}
