//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import javalib.colors.Black;
import javalib.colors.White;
import javalib.funworld.World;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;

public class UFOGame extends World {

    int score;
    ILoU ufos;
    ILoB bullets;
    AntiUFO base;
    int hp;
    int time;

    // Constants
    int width = 400;
    int height = 400;

    WorldImage background = new RectangleImage(new Posn(width / 2, height / 2),
            width, height, new White());

    public UFOGame(int score, ILoU ufos, ILoB bullets, AntiUFO base, int hp,
            int time) {
        this.score = score;
        this.ufos = ufos;
        this.bullets = bullets;
        this.base = base;
        this.hp = hp;
        this.time = time;
    }

    public UFOGame() {
        this.score = 0;
        this.ufos = new MtLoU();
        this.bullets = new MtLoB();
        this.base = new AntiUFO(this.width / 2);
        this.hp = 5;
        this.time = 0;
    }

    /*
     * Template Fields:
     * 
     * this.score ... int 
     * this.ufos ... ILoU 
     * this.bullets ... ILoB 
     * this.base ... AntiUFO 
     * this.hp ... int 
     * this.time ... int
     * 
     * Methods:
     * 
     * this.moveUFOs() ... ILoU 
     * this.moveBullets() ... ILoB 
     * this.countCollided() ... int 
     * this.makeImage() ... WorldImage 
     * this.createNewBullet() ... ILoB
     * this.moveAURight() ... ILoU 
     * this.moveAULeft() ... ILoU 
     * this.onTick() ... UFOGame 
     * this.onKeyEvent(String ke) ... UFOGame 
     * this.lastImage() ... WorldImage 
     * this.worldEnds() ... WorldEnd 
     * this.initWorld() ... UFOGame
     */

    // Moves all the UFOs downward
    public ILoU moveUFOs() {
        return this.ufos.moveUFOs();
    }

    // Moves all the Bullets upward
    public ILoB moveBullets() {
        return this.bullets.moveBullets();
    }

    // Counts the number of collisions between the UFOs and Bullets
    public int countCollided() {
        return this.ufos.countCollided(this.bullets);
    }

    // Returns the World Image of the Whole world
    public WorldImage makeImage() {
        return background.overlayImages(this.ufos.drawImage(),
                this.bullets.drawImage(), this.base.drawImage());
    }

    // Creates a New Bullet at the front of the list
    public UFOGame createNewBullet() {
        if (this.time > 5)
            return new UFOGame(this.score, this.ufos,
                    this.bullets.createNewBullet(this.base.xloc, height
                            - this.base.drawImage().getHeight()), this.base,
                    this.hp, 0);
        return this;
    }

    // Moves all UFO right
    public UFOGame moveAURight() {
        return new UFOGame(this.score, this.ufos, this.bullets,
                this.base.moveRight(), this.hp, this.time);
    }

    // Moves all UFO left
    public UFOGame moveAULeft() {
        return new UFOGame(this.score, this.ufos, this.bullets,
                this.base.moveLeft(), this.hp, this.time);
    }

    // Does everything that has to run constantly
    public UFOGame onTick() {
        return new UFOGame(this.score + this.ufos.countCollided(this.bullets),
                this.ufos.removeCollided(this.bullets).createRandomUFO(width)
                        .moveUFOs(), this.bullets.removeCollided(this.ufos)
                        .moveBullets(), this.base, this.hp
                        - this.ufos.countHitGround(), this.time + 1);
    }

    // Does everything for key press
    // Shoots on up
    // Moves the anti UFO left or right
    public UFOGame onKeyEvent(String ke) {
        if (ke.equals("up"))
            return this.createNewBullet();
        else if (ke.equals("left"))
            return this.moveAULeft();
        else if (ke.equals("right"))
            return this.moveAURight();
        return this;
    }

    // Returns the final image of the game
    public WorldImage lastImage() {
        return background.overlayImages(new TextImage(new Posn(width / 2,
                height / 2 + 100), "Game Over", 50, 1, new Black()),
                new TextImage(new Posn(width / 2, height / 2 - 100), "Score :"
                        + this.score, 50, 1, new Black()));
    }

    // End Game method
    public WorldEnd worldEnds() {
        if (this.hp == 0)
            return new WorldEnd(true, lastImage());
        return new WorldEnd(false, this.makeImage());
    }

    // Creates the initial world.
    public UFOGame initWorld() {
        return new UFOGame();
    }
}
