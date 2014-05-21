package other;

import javalib.colors.Black;

public class CarLane extends Lane<Car> {

    public CarLane(int width, int height, int y) {
        super(width, height, y, new Black());
    }

    /** Add a new Car to the Lane */
    public void addNew() {
        this.alist.add(new Car(this.start(), this.y, this.vel));
    }

    /** Return the CarLane Class a String */
    public String toString() {
        return "new CarLane(" + this.width + ", " + this.height + ", " + ", "
                + this.y + this.vel + ", " + this.alist.toString() + ")";
    }

}
