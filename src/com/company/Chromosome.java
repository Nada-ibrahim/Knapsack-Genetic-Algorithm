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

    Chromosome(Chromosome copy){
        fitness = copy.fitness;
        cumFitness = copy.cumFitness;
        genes = new Gene[allItems.length];
        for(int i = 0; i < copy.genes.length; ++i){
            genes[i] = new Gene(copy.genes[i]);
        }
    }
    public double evaluateFitness(double knapsacksize){
        fitness = 0;
        double weight = 0;
        for (int i = 0; i < genes.length; ++i) {
            if (genes[i].isActive) {
                weight += genes[i].item.weight;
                fitness += genes[i].item.value;
            }
        }
        if (weight > knapsacksize)
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
