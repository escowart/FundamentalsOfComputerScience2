//assignment 3
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import tester.*;

public class ExamplesWP {
    public ExamplesWP() {
    }

    // my example
    ILoI empty = new MtLoI();
    WP emptyPage = new WP("empty.gov", "This Page is Empty", empty);

    Item crossGoogle = new Image("crossgoogle", 60, "gif");
    ILoI notGoogleList = new ConsLoI(crossGoogle, empty);
    WP notGoogle = new WP("notgoogle.com", "Not Google", notGoogleList);

    Item google = new Link("google", notGoogle);
    Item windowsText = new Text("THIS WEB SITE SELLS ONLY WINDOWS!"
            + " Go to Google to look for windows");
    Item windowsImage = new Image("door", 372, "jpeg");
    ILoI windowsItems = new ConsLoI(windowsImage, new ConsLoI(windowsText,
            new ConsLoI(google, empty)));
    WP windows = new WP("windows.com", "Windows", windowsItems);

    Item doorsLink = new Link("here", windows);
    Item doorsText = new Text(
            "THIS WEB SITE SELLS ONLY DOORS! Click here for doors.");
    Item doorsImage = new Image("window", 372, "jpeg");
    ILoI doorsItems = new ConsLoI(doorsImage, new ConsLoI(doorsText,
            new ConsLoI(doorsLink, empty)));
    WP doors = new WP("doors.com", "Doors", doorsItems);

    // myPets example

    Item gerbilPic = new Image("cutie", 500, "png");
    Item text3 = new Text("My gerbil");
    ILoI bobsList = new ConsLoI(text3, new ConsLoI(gerbilPic, empty));
    WP bobsPage = new WP("bob-pets.org", "Bob's Pets", bobsList);

    Item text2 = new Text("This is my cat");
    Item catPic = new Image("kitty", 400, "png");
    Item text1 = new Text("This is my dog");
    Item dogPic = new Image("doggie", 230, "jpeg");
    Item link = new Link("Here are Bob's pets", bobsPage);

    ILoI petsList1 = new ConsLoI(text1, new ConsLoI(dogPic, new ConsLoI(link,
            empty)));
    ILoI petsList = new ConsLoI(text2, new ConsLoI(catPic, petsList1));
    WP myPetsWP = new WP("mypets.org", "My Pets", petsList);

    public void testAll(Tester t) {
        // totalImageSize
        t.checkExpect(text1.totalImageSize(), 0);
        t.checkExpect(dogPic.totalImageSize(), 230);
        t.checkExpect(link.totalImageSize(), 500);
        t.checkExpect(empty.totalImageSize(), 0);
        t.checkExpect(petsList.totalImageSize(), 1130);

        t.checkExpect(emptyPage.totalImageSize(), 0);
        t.checkExpect(bobsPage.totalImageSize(), 500);
        t.checkExpect(doors.totalImageSize(), 804);
        t.checkExpect(myPetsWP.totalImageSize(), 1130);

        // textLength()
        t.checkExpect(text1.textLength(), 14);
        t.checkExpect(dogPic.textLength(), 10);
        t.checkExpect(link.textLength(), 46);
        t.checkExpect(empty.textLength(), 0);
        t.checkExpect(petsList.textLength(), 92);

        t.checkExpect(emptyPage.textLength(), 18);
        t.checkExpect(bobsPage.textLength(), 27);
        t.checkExpect(doors.textLength(), 183);
        t.checkExpect(myPetsWP.textLength(), 99);

        // images()
        t.checkExpect(text1.images(), "");
        t.checkExpect(dogPic.images(), "doggie.jpeg");
        t.checkExpect(link.images(), "cutie.png");
        t.checkExpect(empty.images(), "");
        t.checkExpect(petsList.images(), "kitty.png, doggie.jpeg, cutie.png");

        t.checkExpect(emptyPage.images(), "");
        t.checkExpect(bobsPage.images(), "cutie.png");
        t.checkExpect(doors.images(), "window.jpeg, "
                + "door.jpeg, crossgoogle.gif");
        t.checkExpect(myPetsWP.images(), "kitty.png, doggie.jpeg, cutie.png");

    }
}
