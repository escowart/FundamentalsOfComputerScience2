import javalib.worldimages.WorldImage;

//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

public class ConsLoB implements ILoB {

    Bullet first;
    ILoB rest;

    public ConsLoB(Bullet first, ILoB rest) {
        this.first = first;
        this.rest = rest;
    }

    /*
     * Template Fields:
     * 
     * this.first ... Bullet this.rest ... ILoB
     * 
     * Methods:
     * 
     * this.moveBullets() ... ILoB 
     * this.countCollided(UFO ufo) ... int
     * this.hasCollided(UFO ufo) ... boolean 
     * this.removeCollided(ILoU ufos)) ... ILoB 
     * createNewBullet(int xloc, int bot) ... ILoB 
     * this.drawImage() ...  WorldImage
     */

    // Moves the first bullet upward and the rest of the list too
    public ILoB moveBullets() {
        return new ConsLoB(this.first.move(), this.rest.moveBullets());
    }

    // Counts the number of times the list collides with the given ufo
    public int countCollided(UFO ufo) {
        return this.first.countCollided(ufo) + this.rest.countCollided(ufo);
    }

    // Has the list of bullets collided with the given ufo
    public boolean hasCollided(UFO ufo) {
        return this.first.hasCollided(ufo) || this.rest.hasCollided(ufo);
    }

    // Remove all bullets in the list that have collided
    public ILoB removeCollided(ILoU ufos) {
        if (this.first.hasCollided(ufos) || this.first.isOffScreen())
            return this.rest.removeCollided(ufos);
        return new ConsLoB(this.first, this.rest.removeCollided(ufos));
    }

    // Creates a new bullet at the front of the list
    public ILoB createNewBullet(int xloc, int bot) {
        return new ConsLoB(new Bullet(xloc, bot), this);
    }

    // Draws the list of bullets as a World Image
    public WorldImage drawImage() {
        return this.first.drawImage().overlayImages(this.rest.drawImage());
    }
}
