package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CanonicalGA {

    List<Chromosome> generation;
    List<Chromosome> newGeneration;
    double PC = 0.6;
    double PM = 0.01;
    double knapsacksize;
    int itemsNo;

    CanonicalGA(Item[] items, double knapsacksize){
        Chromosome.allItems = items;
        newGeneration = new ArrayList<>();
        generation = new ArrayList<>();
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
            newGeneration = new ArrayList<>();
        }
        return getOptimalChromosome();
    }

    private void initRandGeneration(int popNum){
        Random rand = new Random(799);
        for(int i = 0 ; i < popNum; ++i){
            generation.add(new Chromosome());
            for(int j = 0; j < itemsNo; ++j) {
                generation.get(i).genes[j].isActive = rand.nextBoolean();
            }
        }
    }

    private void evalAllFitness(){

    }

    private Pair<Chromosome, Chromosome> selectChromosomes(){

        return null;
    }

    private void doCrossOver(Pair<Chromosome, Chromosome> parents){
        Random rand = new Random(799);
        double r = rand.nextDouble();

        int L = rand.nextInt(itemsNo-1);
        Chromosome offspring1 = new Chromosome();
        Chromosome offspring2 = new Chromosome();

        if(r <= PC) {
            for (int i = 0; i < L; ++i) {
                offspring1.genes[i] = parents.getKey().genes[i];
                offspring2.genes[i] = parents.getValue().genes[i];
            }
            for (int i = L - 1; i < itemsNo; ++i) {
                offspring1.genes[i] = parents.getValue().genes[i];
                offspring2.genes[i] = parents.getKey().genes[i];
            }
        }else{
            offspring1 = parents.getKey();
            offspring2 = parents.getValue();
        }
        newGeneration.add(offspring1);
        newGeneration.add(offspring2);

    }

    private void doAllMutation(){
        Random rand = new Random(799);
        for (Chromosome chromosome : newGeneration) {
            for (int j = 0; j < itemsNo; ++j) {
                if (rand.nextDouble() <= PM) {
                    chromosome.genes[j].isActive = !chromosome.genes[j].isActive;
                }
            }
        }
    }

    private Chromosome getOptimalChromosome() {
        return null;
    }
}
