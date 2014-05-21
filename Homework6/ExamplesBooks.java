//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class is for creating Abstract Binary Search Tree examples 
// and testing them
import tester.Tester;

public class ExamplesBooks {

    public ExamplesBooks() {

    }

    IBookComparator booksByAuthor = new BooksByAuthor();
    IBookComparator booksByTitle = new BooksByTitle();
    IBookComparator booksByPrice = new BooksByPrice();

    Book b1 = new Book("b1", "bb1", 50);
    Book b2 = new Book("b2", "bb1", 20);
    Book b3 = new Book("b3", "bb1", 10);
    Book b4 = new Book("b4", "bb1", 40);
    Book b5 = new Book("b5", "bb1", 30);

    Book book1 = new Book("A Game of Thrones", "George R. R. Martin", 50);
    Book book2 = new Book("A Storm of Swords", "George R. R. Martin", 75);
    Book book3 = new Book("The Lord of the Rings", "J. R. R. Tolkien", 25);
    Book book4 = new Book("Atlas Shrugged", "Ayn Rand", 5);
    Book book5 = new Book(
            "America Again: Re-becoming The Greatness We Never Weren't",
            "Stephen Colbert", 5000);
    Book b6 = new Book("The Art of War", "Sun Tzu", 20);
    Book b7 = new Book("The Republic", "Plato", 30);

    BooksByAuthor bba = new BooksByAuthor();
    BooksByPrice bbp = new BooksByPrice();
    BooksByTitle bbt = new BooksByTitle();

    Leaf leaf = new Leaf(this.bba);
    Node node1 = new Node(this.book1, this.leaf, this.leaf);
    Node node2 = new Node(this.book2, this.leaf, this.leaf);
    Node node3 = new Node(this.book3, this.leaf, this.leaf);
    Node node4 = new Node(this.book4, this.leaf, this.leaf);
    Node node5 = new Node(this.book5, this.leaf, this.leaf);
    Node node6 = new Node(this.b6, this.leaf, this.leaf);
    Node node7 = new Node(this.b7, this.leaf, this.leaf);

    Node authornode1 = new Node(this.book1, this.node1, this.leaf);
    Node authornode2 = new Node(this.book1, this.node1, this.node7);
    Node authornode3 = new Node(this.b7, this.leaf, this.node5);
    Node authornode4 = new Node(this.book1, this.node1, this.authornode3);
    Node authornode5 = new Node(this.book5, this.leaf, this.node6);
    Node authornode6 = new Node(this.b7, this.leaf, this.authornode5);
    Node authornode7 = new Node(this.book1, this.node1, this.authornode6);

    Leaf leafp = new Leaf(this.bbp);
    Node nodep1 = new Node(this.book1, this.leafp, this.leafp);
    Node nodep2 = new Node(this.book2, this.leafp, this.leafp);
    Node nodep4 = new Node(this.book4, this.leafp, this.leafp);

    Node pricenode1 = new Node(this.book1, this.leafp, this.nodep2);
    Node pricenode2 = new Node(this.book1, this.nodep1, this.leafp);
    Node pricenode3 = new Node(this.book1, this.nodep4, this.leafp);

    Leaf leaft = new Leaf(this.bbt);
    Node nodet1 = new Node(this.book1, this.leaft, this.leaft);
    Node nodet2 = new Node(this.book2, this.leaft, this.leaft);
    Node nodet3 = new Node(this.book3, this.leaft, this.leaft);

    Node titlenode1 = new Node(this.book2, this.leaft, this.nodet3);
    Node titlenode2 = new Node(this.book2, this.nodet2, this.leaft);
    Node titlenode3 = new Node(this.book2, this.nodet1, this.leaft);

    Node bstA1 = new Node(this.book2, this.node1, this.leaf);
    Node bstA = new Node(this.book3, this.bstA1, this.node4);

    Node bstbook1 = new Node(this.book2, this.node1, this.leaf);
    Node bstB = new Node(this.book3, this.bstbook1, this.node4);

    Node bstC1 = new Node(this.book4, this.node3, this.leaf);
    Node bstC = new Node(this.book2, this.node1, this.bstC1);

    Node bstD1 = new Node(this.book4, this.leaf, this.node5);
    Node bstD = new Node(this.book3, this.node1, this.bstD1);

    ILoBook empty = new MtLoBook();
    ILoBook list1 = new ConsLoBook(this.book1, this.empty);
    ILoBook bstAlist1 = new ConsLoBook(this.book3, new ConsLoBook(this.book4,
            this.empty));
    ILoBook bstAlist = new ConsLoBook(this.book1, new ConsLoBook(this.book2,
            bstAlist1));
    ILoBook alllist = new ConsLoBook(this.book1, new ConsLoBook(this.book2,
            new ConsLoBook(this.book3, new ConsLoBook(this.book4,
                    new ConsLoBook(this.book5, new ConsLoBook(this.b6,
                            new ConsLoBook(this.b7, this.empty)))))));
    Node allnode = new Node(this.book1, new Node(this.book2, this.node4,
            this.leaf), new Node(this.book3, this.leaf, new Node(this.book5,
            this.node7, this.node6)));

    ABST node8 = this.leaft.insert(this.b3).insert(this.b4).insert(this.b2)
            .insert(this.b1);

    public void testAll(Tester t) {
        // insert
        t.checkExpect(!this.node8.sameTree(this.node1));
        t.checkExpect(this.node8.sameTree(this.node8));
        t.checkExpect(this.leaf.insert(this.book1), this.node1);
        t.checkExpect(this.leaf.insert(this.book1), this.node1);
        t.checkExpect(this.leaf.insert(this.book1), this.node1);

        t.checkExpect(this.node1.insert(this.book1), this.authornode1);
        t.checkExpect(this.authornode1.insert(this.b7), this.authornode2);
        t.checkExpect(this.authornode2.insert(this.book5), this.authornode4);
        t.checkExpect(this.authornode4.insert(this.b6), this.authornode7);

        t.checkExpect(this.nodep1.insert(this.book1), this.pricenode2);
        t.checkExpect(this.nodep1.insert(this.book4), this.pricenode3);

        t.checkExpect(this.nodet2.insert(this.book3), this.titlenode1);
        t.checkExpect(this.nodet2.insert(this.book2), this.titlenode2);

        // getFirst
        t.checkExpect(this.node2.getFirst(), this.book2);
        t.checkExpect(this.pricenode3.getFirst(), this.book4);
        t.checkException(new RuntimeException("No first in an empty tree"),
                this.leaf, "getFirst");

        // getRest
        t.checkExpect(this.node2.getRest(), this.leaf);
        t.checkExpect(this.authornode1.getRest(), this.node1);
        t.checkException(new RuntimeException("No rest of an empty tree"),
                this.leaf, "getRest");

        // isLeaf
        t.checkExpect(this.leaf.isLeaf());
        t.checkExpect(!this.node1.isLeaf());

        // sameBook
        t.checkExpect(this.book1.sameBook(this.book1));
        t.checkExpect(!this.book1.sameBook(this.book2));

        // sameNode
        t.checkExpect(!this.leaf.sameNode(this.node1));
        t.checkExpect(this.node1.sameNode(this.node1));
        t.checkExpect(!this.node1.sameNode(this.node2));

        // sameTree
        t.checkExpect(this.leaf.sameTree(this.leaf));
        t.checkExpect(!this.leaf.sameTree(this.node1));
        t.checkExpect(!this.node1.sameTree(this.leaf));
        t.checkExpect(this.node1.sameTree(this.node1));
        t.checkExpect(!this.node2.sameTree(this.node1));
        t.checkExpect(!this.node1.sameTree(this.node2));

        // contains
        t.checkExpect(!this.leaf.contains(book1));
        t.checkExpect(this.node1.contains(book1));
        t.checkExpect(this.authornode7.contains(b7));

        // sameDataHelper
        t.checkExpect(this.leaf.sameDataHelper(this.leaf));
        t.checkExpect(this.leaf.sameDataHelper(this.node1));
        t.checkExpect(!this.node1.sameDataHelper(this.leaf));
        t.checkExpect(this.node1.sameDataHelper(this.node1));
        t.checkExpect(!this.node2.sameDataHelper(this.node1));
        t.checkExpect(!this.node1.sameDataHelper(this.node2));

        // sameData
        t.checkExpect(!this.bstA.sameData(this.leaf));
        t.checkExpect(!this.leaf.sameData(this.bstA));
        t.checkExpect(this.leaf.sameData(this.leaf));
        t.checkExpect(!this.bstA.sameData(new Node(this.b7, this.leaf,
                this.bstA)));

        t.checkExpect(this.bstA.sameData(this.bstA));
        t.checkExpect(this.bstA.sameData(this.bstB));
        t.checkExpect(this.bstA.sameData(this.bstC));
        t.checkExpect(!this.bstA.sameData(this.bstD));
        t.checkExpect(!this.bstA.sameData(this.authornode7));

        // isEmpty
        t.checkExpect(!this.bstAlist.isEmpty());
        t.checkExpect(!this.alllist.isEmpty());
        t.checkExpect(this.empty.isEmpty());

        // sameAsList
        t.checkExpect(this.leaf.sameAsList(this.empty));
        t.checkExpect(!this.leaf.sameAsList(this.bstAlist));
        t.checkExpect(!this.bstA.sameAsList(this.empty));
        t.checkExpect(this.node1.sameAsList(this.list1));
        t.checkExpect(this.bstA.sameAsList(this.bstAlist));

        // buildTree
        t.checkExpect(this.empty.buildTree(this.leaf), this.leaf);
        t.checkExpect(this.empty.buildTree(this.allnode), this.allnode);
        t.checkExpect(this.alllist.buildTree(this.leaf), this.allnode);
        t.checkExpect(this.list1.buildTree(this.node2), new Node(this.book2,
                this.node1, this.leaf));

        // buildTree
        t.checkExpect(this.leaf.buildList(this.empty), this.empty);
        t.checkExpect(this.leaf.buildList(this.alllist), this.alllist);
        t.checkExpect(this.node1.buildList(new ConsLoBook(this.book2,
                this.empty)), new ConsLoBook(this.book1, new ConsLoBook(
                this.book2, this.empty)));

        // sameNode
        t.checkExpect(this.node1.sameNode(this.node1));
        t.checkExpect(!this.node1.sameNode(this.node2));

        // sameOrder
        t.checkExpect(!this.bba.sameOrder(bbp));
        t.checkExpect(this.bba.sameBooksByAuthor(bba));
        t.checkExpect(!this.bba.sameBooksByPrice(bbp));
        t.checkExpect(!this.bba.sameBooksByTitle(bbt));

        t.checkExpect(this.bbp.sameOrder(bbp));
        t.checkExpect(!this.bbp.sameBooksByAuthor(bba));
        t.checkExpect(this.bbp.sameBooksByPrice(bbp));
        t.checkExpect(!this.bbp.sameBooksByTitle(bbt));

        t.checkExpect(!this.bbt.sameOrder(bbp));
        t.checkExpect(!this.bbt.sameBooksByAuthor(bba));
        t.checkExpect(!this.bbt.sameBooksByPrice(bbp));
        t.checkExpect(this.bbt.sameBooksByTitle(bbt));

        t.checkExpect(this.bbp.compare(this.book1, this.book2), -1);
        t.checkExpect(this.bbp.compare(this.book2, this.book2), 0);
        t.checkExpect(this.bbp.compare(this.book2, this.book1), 1);

        // Node constructor exception
        t.checkConstructorException(new RuntimeException(
                "Cannot Create a Node with Two Different Orders"), "Node",
                this.b1, this.leaf, this.leafp);
    }
}
