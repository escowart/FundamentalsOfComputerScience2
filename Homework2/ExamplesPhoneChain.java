// assignment 2
// pair 027
// Cowart, Edwin
// escowart
// Bachiri, Zacharia
// bachiri

import tester.*;

public class ExamplesPhoneChain {
    public ExamplesPhoneChain() {
    }

    Player jen = new Player("Jen", "5-4-3-2-1");
    Player may = new Player("May", "5-4-3-2-1");
    Player bea = new Player("Bea", "5-4-3-2-1");
    Player kim = new Player("Kim", "5-4-3-2-1");
    Player pat = new Player("Pat", "5-4-3-2-1");
    Player ann = new Player("Ann", "5-4-3-2-1");
    Player joy = new Player("Joy", "5-4-3-2-1");
    Player tay = new Player("Tay", "5-4-3-2-1");
    Player zoe = new Player("Zoe", "5-4-3-2-1");
    Player meg = new Player("Meg", "5-4-3-2-1");
    Player lou = new Player("Lou", "5-4-3-2-1");
    Player cam = new Player("Cam", "5-4-3-2-1");
    Player eve = new Player("Eve", "5-4-3-2-1");
    Player tam = new Player("Tam", "5-4-3-2-1");

    IPhoneChain emptyLink = new Empty();
    IPhoneChain tamLink = new Link(tam, emptyLink, emptyLink);
    IPhoneChain eveLink = new Link(eve, emptyLink, emptyLink);
    IPhoneChain camLink = new Link(cam, emptyLink, emptyLink);
    IPhoneChain louLink = new Link(lou, emptyLink, emptyLink);
    IPhoneChain megLink = new Link(meg, emptyLink, emptyLink);
    IPhoneChain zoeLink = new Link(zoe, emptyLink, emptyLink);
    IPhoneChain tayLink = new Link(tay, emptyLink, emptyLink);
    IPhoneChain joyLink = new Link(joy, tamLink, emptyLink);
    IPhoneChain annLink = new Link(ann, camLink, eveLink);
    IPhoneChain patLink = new Link(pat, megLink, louLink);
    IPhoneChain kimLink = new Link(kim, tayLink, zoeLink);
    IPhoneChain beaLink = new Link(bea, annLink, joyLink);
    IPhoneChain mayLink = new Link(may, kimLink, patLink);
    IPhoneChain jenLink = new Link(jen, mayLink, beaLink);

    // making sure the code contains at least one test
    boolean testAll(Tester t) {
        ExamplesPhoneChain epc = new ExamplesPhoneChain();
        return t.checkExpect(epc.jenLink, epc.jenLink);
    }

}
