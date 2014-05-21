//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import java.util.Random;

import javalib.worldimages.WorldImage;

public class ConsLoU implements ILoU {

    UFO first;
    ILoU rest;

    public ConsLoU(UFO first, ILoU rest) {
        this.first = first;
        this.rest = rest;
    }

    /*
     * Template Fields:
     * 
     * this.first ... UFO this.rest ... ILoU
     * 
     * Methods:
     * 
     * this.moveUFOs() ... ILoU 
     * this.countCollided(ILoB bull) ... int
     * this.removeCollided(ILoB bull)) ... ILoU 
     * this.hasCollided(Bullet b) ... boolean 
     * this.countHitGround() ... int 
     * this.createRandomUFO(int width) ... ILoU 
     * this.drawImage() ... WorldImage
     */

    // Moves the first UFO and recurse on the rest
    public ILoU moveUFOs() {
        return new ConsLoU(first.move(), rest.moveUFOs());
    }

    // Counts the number of collisions the list has with the given list of
    // bullets
    public int countCollided(ILoB bull) {
        return this.first.countCollided(bull) + this.rest.countCollided(bull);
    }

    // Remove all UFOs from the list that have collided with the given list of
    // bullets
    public ILoU removeCollided(ILoB bull) {
        if (this.first.hasCollided(bull) || this.first.hitGround())
            return this.rest.removeCollided(bull);
        return new ConsLoU(this.first, this.rest.removeCollided(bull));
    }

    // Has the list of UFOs collided with the given bullet
    public boolean hasCollided(Bullet b) {
        return this.first.hasCollided(b) || this.rest.hasCollided(b);
    }

    // Count the number of the UFOs in the list that have hit the ground.
    public int countHitGround() {
        if (this.first.hitGround())
            return 1 + this.rest.countHitGround();
        return this.rest.countHitGround();
    }

    // Has a 1/20 chance of creating a UFO randomly at the top of the screen
    // Passes down the width of the world
    public ILoU createRandomUFO(int width) {
        Random randomGen = new Random();
        int randomInt = randomGen.nextInt(20);
        if (randomInt == 0)
            return new ConsLoU(new UFO(width), this);
        return this;
    }

    public WorldImage drawImage() {
        return this.first.drawImage().overlayImages(this.rest.drawImage());
    }
}
