package se.skltp.anslutningslagetApi.service.impl;

public class Pair<P, T> {
    private P first;
    private T second;

    public Pair(P first, T second) {
        this.first = first;
        this.second = second;
    }

    public P getFirst() {
        return first;
    }

    public void setFirst(P first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
