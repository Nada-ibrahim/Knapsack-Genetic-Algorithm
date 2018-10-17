package com.company;

public class Parent {
    Chromosome c1;
    Chromosome c2;

    public Parent() {
        c1 = null;
        c2 = null;
    }
    public Chromosome getC1() {
        return c1;
    }

    public void setC1(Chromosome c1) {
        this.c1 = c1;
    }

    public Chromosome getC2() {
        return c2;
    }

    public void setC2(Chromosome c2) {
        this.c2 = c2;
    }

    public void setParent(Chromosome parent) {
        if (c1 == null)
            c1 = parent;
        else
            c2 = parent;
    }
}
