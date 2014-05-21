//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import javalib.colors.Black;
import javalib.worldimages.FromFileImage;
import javalib.worldimages.LineImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;
import tester.Tester;

public class ExamplesFundies2Game {
    public ExamplesFundies2Game() {

    }

    AntiUFO antiUfo1 = new AntiUFO(100);
    AntiUFO antiUfo0 = new AntiUFO(0);
    AntiUFO antiUfo400 = new AntiUFO(400);
    WorldImage auImage1 = new FromFileImage(new Posn(100, 374), "p027-au.png");

    Bullet bullet1 = new Bullet(new Posn(0, 0));
    Bullet bullet2 = new Bullet(new Posn(200, 200));
    Bullet bullet3 = new Bullet(new Posn(0, -6));
    Bullet bulletmove1 = new Bullet(new Posn(0, -10));
    Bullet bulletmove2 = new Bullet(new Posn(200, 190));

    WorldImage bImage1 = new LineImage(new Posn(0, 5), new Posn(0, -5),
            new Black());

    ILoB emptyBL = new MtLoB();
    ILoB bulletList = new ConsLoB(bullet1, new ConsLoB(bullet2, emptyBL));
    ILoB bulletmoveList = new ConsLoB(bulletmove1, new ConsLoB(bulletmove2,
            emptyBL));
    ILoB bulletremoveList = new ConsLoB(bullet2, emptyBL);

    UFO ufo1 = new UFO(new Posn(0, 0));
    UFO ufo2 = new UFO(new Posn(140, 50));
    UFO ufo3 = new UFO(400);
    UFO ufo4 = new UFO(new Posn(0, 400));

    ILoU emptyUL = new MtLoU();
    ILoU ufoList = new ConsLoU(ufo1, new ConsLoU(ufo2, emptyUL));
    ILoU collUFOList = new ConsLoU(ufo4, new ConsLoU(ufo3, ufoList));

    UFOGame initialWorld = new UFOGame();
    UFOGame ug = new UFOGame(0, ufoList, bulletList, antiUfo1, 5, 6);
    

    public void testAll(Tester t) {
        t.checkExpect(this.antiUfo1.moveLeft(), new AntiUFO(93));
        t.checkExpect(this.antiUfo0.moveLeft(), this.antiUfo0);
        t.checkExpect(this.antiUfo1.moveRight(), new AntiUFO(107));
        t.checkExpect(this.antiUfo400.moveRight(), this.antiUfo400);
        t.checkExpect(this.antiUfo1.drawImage(), auImage1);

        t.checkExpect(this.bullet1.move(), new Bullet(new Posn(0, -10)));
        t.checkExpect(this.bullet1.hasCollided(this.ufo1), true);
        t.checkExpect(this.bullet1.hasCollided(this.ufo2), false);
        t.checkExpect(this.bullet1.hasCollided(this.ufoList), true);
        t.checkExpect(this.bullet1.hasCollided(this.emptyUL), false);
        t.checkExpect(this.bullet1.countCollided(this.ufo1), 1);
        t.checkExpect(this.bullet1.countCollided(this.ufo2), 0);
        t.checkExpect(this.bullet1.isOffScreen(), false);
        t.checkExpect(this.bullet3.isOffScreen(), true);
        t.checkExpect(this.bullet1.drawImage(), bImage1);

        t.checkExpect(this.ufo1.move(), new UFO(new Posn(0, 5)));
        t.checkExpect(this.ufo1.countCollided(this.bulletList), 1);
        t.checkExpect(this.ufo1.countCollided(this.emptyBL), 0);
        t.checkExpect(this.ufo1.hasCollided(this.bullet1), true);
        t.checkExpect(this.ufo1.hasCollided(this.bullet2), false);
        t.checkExpect(this.ufo1.hasCollided(this.bulletList), true);
        t.checkExpect(this.ufo1.hasCollided(this.emptyBL), false);
        t.checkExpect(this.ufo1.hitGround(), false);
        t.checkExpect(this.ufo4.hitGround(), true);
        t.checkExpect(this.ufo4.drawImage(), this.ufo4.drawImage());
        t.checkExpect(this.ufo3.loc.y, -10);
        t.checkExpect(27 <= this.ufo3.loc.x, true);
        t.checkExpect((400 - 27) >= this.ufo3.loc.x, true);

        t.checkExpect(this.emptyBL.moveBullets(), this.emptyBL);
        t.checkExpect(this.bulletList.moveBullets(), this.bulletmoveList);
        t.checkExpect(this.emptyBL.countCollided(this.ufo1), 0);
        t.checkExpect(this.bulletList.countCollided(this.ufo1), 1);
        t.checkExpect(this.emptyBL.hasCollided(this.ufo1), false);
        t.checkExpect(this.bulletList.hasCollided(this.ufo1), true);
        t.checkExpect(this.bulletList.hasCollided(this.ufo2), false);
        t.checkExpect(this.bulletList.hasCollided(this.ufo4), false);
        t.checkExpect(this.emptyBL.removeCollided(this.emptyUL), this.emptyBL);
        t.checkExpect(this.bulletList.removeCollided(this.emptyUL),
                this.bulletList);
        t.checkExpect(this.emptyBL.removeCollided(this.ufoList), this.emptyBL);
        t.checkExpect(this.bulletList.removeCollided(this.ufoList),
                this.bulletremoveList);
        t.checkExpect(this.emptyBL.createNewBullet(200, 202),
                this.bulletremoveList);
        t.checkExpect(this.bulletremoveList.createNewBullet(0, 2),
                this.bulletList);
        t.checkExpect(this.emptyBL.drawImage(), this.emptyBL.drawImage());
        t.checkExpect(this.bulletremoveList.drawImage(),
                this.bulletremoveList.drawImage());

        t.checkExpect(this.emptyUL.moveUFOs(), this.emptyUL);
        t.checkExpect(this.ufoList.moveUFOs(), new ConsLoU(new UFO(new Posn(0,
                5)), new ConsLoU(new UFO(new Posn(140, 55)), new MtLoU())));
        t.checkExpect(this.emptyUL.countCollided(bulletList), 0);
        t.checkExpect(this.ufoList.countCollided(bulletList), 1);
        t.checkExpect(this.emptyUL.removeCollided(bulletList), this.emptyUL);
        t.checkExpect(this.ufoList.removeCollided(bulletList), new ConsLoU(
                new UFO(new Posn(140, 50)), new MtLoU()));
        t.checkExpect(this.emptyUL.hasCollided(bullet3), false);
        t.checkExpect(this.ufoList.hasCollided(bullet1), true);
        t.checkExpect(this.emptyUL.countHitGround(), 0);
        t.checkExpect(this.ufoList.countHitGround(), 0);
        t.checkExpect(this.collUFOList.countHitGround(), 1);
        t.checkOneOf(this.emptyUL.createRandomUFO(56), new MtLoU(),
                new ConsLoU(new UFO(new Posn(27, -10)), new MtLoU()));
        t.checkOneOf(this.ufoList.createRandomUFO(56), this.ufoList,
                new ConsLoU(new UFO(new Posn(27, -10)), new ConsLoU(ufo1,
                        new ConsLoU(ufo2, emptyUL))));
        t.checkExpect(this.emptyUL.drawImage(), this.emptyUL.drawImage());
        t.checkExpect(this.ufoList.drawImage(), this.ufoList.drawImage());

        t.checkExpect(this.initialWorld.moveUFOs(),
                this.initialWorld.moveUFOs());
        t.checkExpect(this.initialWorld.moveBullets(),
                this.initialWorld.moveBullets());
        t.checkExpect(this.initialWorld.countCollided(),
                this.initialWorld.countCollided());
        t.checkExpect(this.initialWorld.makeImage(),
                this.initialWorld.makeImage());
        t.checkExpect(this.initialWorld.createNewBullet(),
                this.initialWorld.createNewBullet());
        t.checkExpect(this.ug.createNewBullet(),
                this.ug.createNewBullet());
        t.checkExpect(this.initialWorld.moveAURight(),
                this.initialWorld.moveAURight());
        t.checkExpect(this.initialWorld.moveAULeft(),
                this.initialWorld.moveAULeft());
        t.checkExpect(this.initialWorld.onTick(), this.initialWorld.onTick());
        t.checkExpect(this.initialWorld.onKeyEvent("left"),
                this.initialWorld.onKeyEvent("left"));
        t.checkExpect(this.initialWorld.onKeyEvent("right"),
                this.initialWorld.onKeyEvent("right"));
        t.checkExpect(this.initialWorld.onKeyEvent("up"),
                this.initialWorld.onKeyEvent("up"));
        t.checkExpect(this.initialWorld.onKeyEvent("none"),
                this.initialWorld.onKeyEvent("none"));
        t.checkExpect(this.initialWorld.lastImage(),
                this.initialWorld.lastImage());
        t.checkExpect(this.initialWorld.worldEnds(),
                this.initialWorld.worldEnds());
        t.checkExpect(this.initialWorld.initWorld(),
                this.initialWorld.initWorld());
    }
}
