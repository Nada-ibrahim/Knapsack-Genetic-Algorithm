package com.company;

public class Chromosome {
    public static Item[] allItems;
    public Gene[] genes;
    public double fitness;
    public double cumFitness;

    public Chromosome(){
        genes = new Gene[allItems.length];
        for(int i = 0; i < allItems.length; ++i){
            genes[i].item = allItems[i];
        }
    }

    public void evaluateFitness(){

    }
}
