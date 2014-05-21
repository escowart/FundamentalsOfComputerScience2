//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import javalib.colors.White;
import javalib.worldimages.CircleImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

public class MtLoB implements ILoB {

    public MtLoB() {

    }

    /*
     * Template Fields:
     * 
     * Methods:
     * 
     * this.moveBullets() ... ILoB this.countCollided(UFO ufo) ... int
     * this.hasCollided(UFO ufo) ... boolean this.removeCollided(ILoU ufos)) ...
     * ILoB createNewBullet(int xloc, int bot) ... ILoB this.drawImage() ...
     * WorldImage
     */

    // Returns itself (empty case)
    public ILoB moveBullets() {
        return this;
    }

    // Returns 0 (empty case)
    public int countCollided(UFO ufo) {
        return 0;
    }

    // Returns false (empty case)
    public boolean hasCollided(UFO ufo) {
        return false;
    }

    // Returns itself (empty case)
    public ILoB removeCollided(ILoU ufos) {
        return this;
    }

    // Adds a new bullet to the beginning of the empty list
    public ILoB createNewBullet(int xloc, int bot) {
        return new ConsLoB(new Bullet(xloc, bot), this);
    }

    // Returns a empty drawing (empty case)
    public WorldImage drawImage() {
        return new CircleImage(new Posn(0, 0), 0, new White());
    }
}
