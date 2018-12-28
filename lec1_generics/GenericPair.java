package lec1_generics;

public class GenericPair <A, B> {
    A first;
    B second;

    public GenericPair()
    {}

    public GenericPair(A first, B second)
    {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}
