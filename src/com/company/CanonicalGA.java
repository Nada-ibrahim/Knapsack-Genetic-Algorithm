package com.company;

import javafx.util.Pair;

public class CanonicalGA {

    Chromosome[] generation;
    Chromosome[] newGeneration;
    double knapsacksize;
    int itemsNo;

    CanonicalGA(Item[] items, double knapsacksize){
        Chromosome.allItems = items;
        itemsNo = items.length;
        this.knapsacksize = knapsacksize;
    }
    public Chromosome applyAlgorithm(int maxGen, int popNum){
        initRandGeneration(popNum);
        for(int i = 0; i < maxGen; ++i){
            evalAllFitness();
            for(int j = 0; j < itemsNo/2; ++j){
                Pair<Chromosome, Chromosome> parents = selectChromosomes();
                doCrossOver(parents);
            }
            doAllMutation();
            generation = newGeneration;
            newGeneration = new Chromosome[popNum];
        }
        return getOptimalChromosome();
    }

    private void initRandGeneration(int popNum){

    }

    private void evalAllFitness(){

    }

    private Pair<Chromosome, Chromosome> selectChromosomes(){

        return null;
    }

    private void doCrossOver(Pair<Chromosome, Chromosome> parents){

    }

    private void doAllMutation(){

    }

    private Chromosome getOptimalChromosome() {
        return null;
    }
}
