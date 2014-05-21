//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import tester.*;

public class ExamplesBook {

    public ExamplesBook() {

    }

    IBook audiobook1 = new AudioBook("Book", "Author", 15);
    IBook book1 = new Book("book2", "Author2", 13);
    IBook refbook1 = new RefBook("book3", 4);

    public void testAll(Tester t) {
        t.checkExpect(this.audiobook1.daysOverdue(29), 0);
        t.checkExpect(this.book1.daysOverdue(13), -14);
        t.checkExpect(this.refbook1.daysOverdue(7), 1);

        t.checkExpect(this.audiobook1.isOverdue(29), false);
        t.checkExpect(this.book1.isOverdue(13), false);
        t.checkExpect(this.refbook1.isOverdue(7), true);

        t.checkExpect(this.audiobook1.computeFine(7), 0);
        t.checkExpect(this.book1.computeFine(7), 0);
        t.checkExpect(this.refbook1.computeFine(7), 10);
        t.checkExpect(this.audiobook1.computeFine(30), 20);

    }

}
