import tester.Tester;

class Examples {
    Examples() {
    }

    ILo<Integer> nlist = new ConsLo<Integer>(5, new ConsLo<Integer>(3,
            new ConsLo<Integer>(4, new ConsLo<Integer>(1, new ConsLo<Integer>(
                    7, new MtLo<Integer>())))));

    ILo<String> nslist = new ConsLo<String>("5", new ConsLo<String>("3",
            new ConsLo<String>("4", new ConsLo<String>("1", new ConsLo<String>(
                    "7", new MtLo<String>())))));

    ILo<String> slist = new ConsLo<String>("hello", new ConsLo<String>("ciao",
            new ConsLo<String>("ahoy", new ConsLo<String>("sayonara",
                    new ConsLo<String>("goodbye", new MtLo<String>())))));

    ILoVisitor<ILo<String>, Integer, Integer> tsv = new ToStringVisitor<Integer>();
    ILoVisitor<Boolean, Boolean, String> lsv = new LongStringsVisitor();

    void testVisitors(Tester t) {
        t.checkExpect(nlist.accept(this.tsv, new Integer(1)), this.nslist);
        t.checkExpect(nslist.accept(this.lsv, new Boolean(false)), false);
        t.checkExpect(slist.accept(this.lsv, new Boolean(false)), true);
    }

}