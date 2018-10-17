package com.company;

public class Gene {
    Item item;
    boolean isActive;

    Gene(){}
    Gene(Gene copy){
        item = copy.item;
        isActive = copy.isActive;
    }
}
