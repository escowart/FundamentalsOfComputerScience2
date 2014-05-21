//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import javalib.worldimages.WorldImage;

public interface ILoB {

    // Moves all the Bullets in the list upward
    public ILoB moveBullets();

    public int countCollided(UFO ufo);

    public boolean hasCollided(UFO ufo);

    public ILoB removeCollided(ILoU ufos);

    public ILoB createNewBullet(int xloc, int bot);

    public WorldImage drawImage();
}
