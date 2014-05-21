import tester.*;

// To represent a list of objects of the type T
interface ILo<T> {

    public <R, S> R accept(ILoVisitor<R, S, T> ilov, S source);
}

// To represent a list of objects of the type T
class MtLo<T> implements ILo<T> {
    MtLo() {
    }

    public <R, S> R accept(ILoVisitor<R, S, T> ilov, S source) {
        return ilov.forMt(source);
    }
}

// To represent a list of objects of the type T
class ConsLo<T> implements ILo<T> {
    T first;
    ILo<T> rest;

    ConsLo(T first, ILo<T> rest) {
        this.first = first;
        this.rest = rest;
    }

    public <R, S> R accept(ILoVisitor<R, S, T> ilov, S source) {
        return ilov.forCons(this.first, this.rest, source);
    }
}

// A visitor for the ILo<T> classes that consumes argument of the type S
// and produces the result of the type R
interface ILoVisitor<R, S, T> {
    // method for the empty list
    public R forMt(S source);

    // method for the nonempty list
    public R forCons(T first, ILo<T> rest, S source);
}

// A visitor for the ILo<T> classes that produces a list of Strings
// from the given list
class ToStringVisitor<T> implements ILoVisitor<ILo<String>, Integer, T> {
    // method for the empty list
    public ILo<String> forMt(Integer i) {
        return new MtLo<String>();
    }

    // method for the nonempty list
    public ILo<String> forCons(T first, ILo<T> rest, Integer i) {
        return new ConsLo<String>(first.toString(), rest.accept(this, i));
    }
}

// A visitor for the ILo<String> classes that determines whether all Strings
// in this list are longer than 3
class LongStringsVisitor implements ILoVisitor<Boolean, Boolean, String> {
    // method for the empty list
    public Boolean forMt(Boolean b) {
        return true;
    }

    // method for the nonempty list
    public Boolean forCons(String first, ILo<String> rest, Boolean b) {
        return first.length() > 3 && rest.accept(this, b);
    }
}

// a function from the type X and Y to Y
interface XYtoY<X, Y> {
    Y base();

    Y apply(X x, Y y);
}

