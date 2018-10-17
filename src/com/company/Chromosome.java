package com.company;

public class Chromosome {
    public static Item[] allItems;
    public Gene[] genes;
    public double fitness;
    public double cumFitness;

    public Chromosome(){
        genes = new Gene[allItems.length];
        for(int i = 0; i < allItems.length; ++i){
            genes[i] = new Gene();
            genes[i].item = allItems[i];
        }
        fitness = 0;
        cumFitness = 0;
    }

    public double evaluateFitness(double knapsacksize){
        for (int i = 0; i < genes.length; ++i)
            if (genes[i].isActive)
                fitness += genes[i].item.weight;

        if (fitness > knapsacksize)
            fitness = 1/fitness;
        return fitness;
    }

    public int evaluateVal() {
        int val = 0;
        for (int i = 0; i < genes.length; ++i)
            if (genes[i].isActive)
                val += genes[i].item.value;
        return val;
    }
}
