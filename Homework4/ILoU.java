//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import javalib.worldimages.WorldImage;

public interface ILoU {

    // Moves all the UFOs in the list downward
    public ILoU moveUFOs();

    // counts the number of collisions in the list
    public int countCollided(ILoB bull);

    public ILoU removeCollided(ILoB bull);

    public boolean hasCollided(Bullet b);

    public int countHitGround();

    public ILoU createRandomUFO(int width);

    public WorldImage drawImage();
}
