//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import java.util.Random;

import javalib.colors.White;
import javalib.worldimages.CircleImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

public class MtLoU implements ILoU {

    public MtLoU() {

    }

    /*
     * Template Fields:
     * 
     * Methods:
     * 
     * this.moveUFOs() ... ILoU this.countCollided(ILoB bull) ... int
     * this.removeCollided(ILoB bull)) ... ILoU this.hasCollided(Bullet b) ...
     * boolean this.countHitGround() ... int this.createRandomUFO(int width) ...
     * ILoU this.drawImage() ... WorldImage
     */

    // Returns itself (empty case)
    public ILoU moveUFOs() {
        return this;
    }

    // Returns zero (empty case)
    public int countCollided(ILoB bull) {
        return 0;
    }

    // Returns itself (empty case)
    public ILoU removeCollided(ILoB bull) {
        return this;
    }

    // Returns false (empty case)
    public boolean hasCollided(Bullet b) {
        return false;
    }

    // Returns 0 (empty case)
    public int countHitGround() {
        return 0;
    }

    // Returns either itself (empty case) or adds a random UFO to the front of
    // itself
    public ILoU createRandomUFO(int width) {
        Random randomGen = new Random();
        int randomInt = randomGen.nextInt(5);
        if (randomInt == 0)
            return new ConsLoU(new UFO(width), this);
        return this;
    }

    // Draws the an empty image
    public WorldImage drawImage() {
        return new CircleImage(new Posn(0, 0), 0, new White());
    }
}
