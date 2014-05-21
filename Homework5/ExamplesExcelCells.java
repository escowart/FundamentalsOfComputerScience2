//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import tester.Tester;

public class ExamplesExcelCells {

    IData emptydata = new EmptyData();
    ExcelCells a1 = new ExcelCells("A", 1, new Number(8));
    ExcelCells b1 = new ExcelCells("B", 1, new Number(3));
    ExcelCells c1 = new ExcelCells("C", 1, new Number(4));
    ExcelCells d1 = new ExcelCells("D", 1, new Number(6));
    ExcelCells e1 = new ExcelCells("E", 1, new Number(2));

    IOp max = new Max();
    IOp mult = new Mult();
    IOp add = new Add();

    ExcelCells c2 = new ExcelCells("C", 2, emptydata);
    ExcelCells d2 = new ExcelCells("D", 2, emptydata);
    Formula fe2 = new Formula(this.mult, this.b2, this.d1);
    ExcelCells e2 = new ExcelCells("E", 2, this.fe2);

    ExcelCells c3 = new ExcelCells("C", 3, emptydata);
    ExcelCells d3 = new ExcelCells("D", 3, emptydata);

    ExcelCells a4 = new ExcelCells("A", 4, emptydata);
    ExcelCells c4 = new ExcelCells("C", 4, emptydata);
    ExcelCells d4 = new ExcelCells("D", 4, emptydata);

    ExcelCells a5 = new ExcelCells("A", 5, emptydata);
    ExcelCells c5 = new ExcelCells("C", 5, emptydata);
    ExcelCells d5 = new ExcelCells("D", 5, emptydata);

    Formula fa2 = new Formula(this.max, this.b1, this.e1);
    ExcelCells a2 = new ExcelCells("A", 2, this.fa2);
    Formula fa3 = new Formula(this.mult, this.a1, this.a2);
    ExcelCells a3 = new ExcelCells("A", 3, this.fa3);
    Formula fb2 = new Formula(this.add, this.a3, this.c1);
    ExcelCells b2 = new ExcelCells("B", 2, this.fb2);
    Formula fb3 = new Formula(this.add, this.b2, this.e1);
    ExcelCells b3 = new ExcelCells("B", 3, this.fb3);
    Formula fe3 = new Formula(this.max, this.b3, this.d1);
    ExcelCells e3 = new ExcelCells("E", 3, this.fe3);
    Formula fb4 = new Formula(this.add, this.b3, this.b2);
    ExcelCells b4 = new ExcelCells("B", 4, this.fb4);
    Formula fb5 = new Formula(this.add, this.b4, this.b3);
    ExcelCells b5 = new ExcelCells("B", 5, this.fb5);
    Formula fe4 = new Formula(this.max, this.b4, this.e3);
    ExcelCells e4 = new ExcelCells("E", 4, this.fe4);
    Formula fe5 = new Formula(this.mult, this.b5, this.e4);
    ExcelCells e5 = new ExcelCells("E", 5, this.fe5);

    ExcelCells testCell = new ExcelCells("T", 5, new Formula(this.add, this.a1,
            this.a1));

    ILoC empty = new MtLoC();
    ILoC b2faa = new ConsLoC(this.a1, new ConsLoC(this.b1, new ConsLoC(this.e1,
            new ConsLoC(this.c1, empty))));
    ILoC a2faa = new ConsLoC(this.b1, new ConsLoC(this.e1, empty));
    ILoC elist = new ConsLoC(e1, new ConsLoC(e2, new ConsLoC(e3, new ConsLoC(
            e4, new ConsLoC(e5, empty)))));
    ILoC dlist = new ConsLoC(d1, new ConsLoC(d2, new ConsLoC(d3, new ConsLoC(
            d4, new ConsLoC(d5, elist)))));
    ILoC clist = new ConsLoC(c1, new ConsLoC(c2, new ConsLoC(c3, new ConsLoC(
            c4, new ConsLoC(c5, dlist)))));
    ILoC blist = new ConsLoC(b1, new ConsLoC(b2, new ConsLoC(b3, new ConsLoC(
            b4, new ConsLoC(b5, clist)))));
    ILoC alllist = new ConsLoC(a1, new ConsLoC(a2, new ConsLoC(a3, new ConsLoC(
            a4, new ConsLoC(a5, blist)))));

    Number n0 = new Number(0);

    public void testAll(Tester t) {
        // value
        t.checkExpect(this.emptydata.value(), 0);
        t.checkExpect(this.emptydata.value(), 0);
        t.checkExpect(new Number(8).value(), 8);
        t.checkExpect(new Number(8).value(), 8);
        t.checkExpect(this.a1.value(), 8);
        t.checkExpect(this.a2.value(), 3);
        t.checkExpect(this.a2.value(), 3);
        t.checkExpect(this.b2.value(), 28);
        t.checkExpect(this.e5.value(), 5104);

        // same
        t.checkExpect(this.a1.same(this.a1), true);
        t.checkExpect(this.a1.same(this.a2), false);
        t.checkExpect(this.a1.same(this.c2), false);

        t.checkExpect(this.emptydata.same(this.emptydata), true);
        t.checkExpect(this.emptydata.same(this.fa2), false);
        t.checkExpect(this.emptydata.sameEmptyData(), true);
        t.checkExpect(this.emptydata.sameFormula(this.fa2), false);
        t.checkExpect(this.emptydata.sameNumber(this.n0), false);

        t.checkExpect(this.fa2.same(this.emptydata), false);
        t.checkExpect(this.fa2.same(this.fa2), true);
        t.checkExpect(this.fa2.sameEmptyData(), false);
        t.checkExpect(this.fa2.sameFormula(this.fa2), true);
        t.checkExpect(this.fa2.sameFormula(this.fa3), false);
        t.checkExpect(this.fa2.sameNumber(this.n0), false);

        t.checkExpect(this.n0.same(this.n0), true);
        t.checkExpect(this.n0.same(this.fa2), false);
        t.checkExpect(this.n0.sameEmptyData(), false);
        t.checkExpect(this.n0.sameFormula(this.fa2), false);
        t.checkExpect(this.n0.sameFormula(this.fa3), false);
        t.checkExpect(this.n0.sameNumber(this.n0), true);
        t.checkExpect(this.n0.sameNumber(new Number(1)), false);

        // findAllArgs
        t.checkExpect(this.a1.findAllArgs(), new MtLoC());
        t.checkExpect(this.a2.findAllArgs(), this.a2faa);
        t.checkExpect(this.d2.findAllArgs(), new MtLoC());
        t.checkExpect(this.b2.findAllArgs(), this.b2faa);

        // countArgs
        t.checkExpect(this.a1.countArgs(), 0);
        t.checkExpect(this.a2.countArgs(), 2);
        t.checkExpect(this.d2.countArgs(), 0);
        t.checkExpect(this.b2.countArgs(), 4);
        t.checkExpect(this.testCell.countArgs(), 1);
        t.checkExpect(this.a1.countArgs(), 0);
        t.checkExpect(this.e5.countArgs(), 5);

        // operate
        t.checkExpect(this.max.operate(1, 1), 1);
        t.checkExpect(this.add.operate(1, 1), 2);
        t.checkExpect(this.mult.operate(1, 1), 1);

        // contains
        t.checkExpect(this.alllist.contains(this.a1), true);
        t.checkExpect(this.alllist.contains(this.e5), true);
        t.checkExpect(this.empty.contains(this.e5), false);
        t.checkExpect(this.alllist.contains(this.testCell), false);

        // filterRepeats
        t.checkExpect(new ConsLoC(a1, new ConsLoC(a1, new ConsLoC(a1, empty)))
                .filterRepeats(), new ConsLoC(a1, empty));
        t.checkExpect(empty.filterRepeats(), empty);

        // append
        t.checkExpect(this.empty.append(this.empty), this.empty);
        t.checkExpect(this.empty.append(this.elist), this.elist);
        t.checkExpect(this.elist.append(this.empty), this.elist);
        t.checkExpect(new ConsLoC(a1, empty).append(new ConsLoC(a1, empty)),
                new ConsLoC(a1, new ConsLoC(a1, empty)));

        // length
        t.checkExpect(this.empty.length(), 0);
        t.checkExpect(this.alllist.length(), 25);
        
        // isNumber
        t.checkExpect(this.emptydata.isNumber(), false);
    }
}
