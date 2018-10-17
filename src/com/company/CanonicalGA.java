package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CanonicalGA {

    List<Chromosome> generation;
    List<Chromosome> newGeneration;
    double PC = 0.7;
    double PM = 0.001;
    double knapsacksize;
    int itemsNo;
    double cumFitness;

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
            for(int j = 0; j < popNum/2; ++j){
                Parent parents = selectChromosomes();
                doCrossOver(parents);
            }
            doAllMutation();
            generation = newGeneration;
            newGeneration = new ArrayList<>();
        }
        return getOptimalChromosome();
    }

    private void initRandGeneration(int popNum){
        Random rand = new Random();
        for(int i = 0 ; i < popNum; ++i){
            generation.add(new Chromosome());
            for(int j = 0; j < itemsNo; ++j) {
                generation.get(i).genes[j].isActive = rand.nextBoolean();
            }
        }
    }

    private void evalAllFitness(){
        double cumFitness = 0;
        for (Chromosome chromosome : generation) {
            cumFitness += chromosome.evaluateFitness(knapsacksize);
            chromosome.cumFitness = cumFitness;
        }
        this.cumFitness = cumFitness;
    }

    private Parent selectChromosomes(){
        Random rand = new Random();
        Parent parent = new Parent();
        for (int i = 0; i < 2; i++) {
            double randChrom = rand.nextDouble()*cumFitness;
            double initCum = 0;
            for (Chromosome chromosome : generation) {
                double cumVal = chromosome.cumFitness;
                if (randChrom >= initCum && randChrom <= cumVal) {
                    parent.setParent(chromosome);
                    break;
                }
                initCum = cumVal;
            }
        }
        return parent;
    }

    private void doCrossOver(Parent parents){
        Random rand = new Random();
        double r = rand.nextDouble();

        int L = rand.nextInt(itemsNo-1)+1;
        Chromosome offspring1;
        Chromosome offspring2;

        if(r <= PC) {
            offspring1 = new Chromosome();
            offspring2 = new Chromosome();
            for (int i = 0; i < L; ++i) {
                offspring1.genes[i] = new Gene(parents.getC1().genes[i]);
                offspring2.genes[i] = new Gene(parents.getC2().genes[i]);
            }
//            System.out.println(L);
            for (int i = L; i < itemsNo; ++i) {
                offspring1.genes[i] = new Gene(parents.getC2().genes[i]);
                offspring2.genes[i] = new Gene(parents.getC1().genes[i]);
            }
        }else{
            offspring1 = new Chromosome(parents.getC1());
            offspring2 = new Chromosome(parents.getC2());
        }
        newGeneration.add(offspring1);
        newGeneration.add(offspring2);

    }

    private void doAllMutation(){
        Random rand = new Random();
        for (Chromosome chromosome : newGeneration) {
            for (int j = 0; j < itemsNo; ++j) {
                if (rand.nextDouble() <= PM) {
                    chromosome.genes[j].isActive = !chromosome.genes[j].isActive;
                }
            }
        }
    }

    private Chromosome getOptimalChromosome() {
        double maxFitness = 0;
        Chromosome optimalChromosome = null;
        for (Chromosome chromosome : generation) {
            if (chromosome.evaluateFitness(knapsacksize) > maxFitness) {
                maxFitness = chromosome.fitness;
                optimalChromosome = chromosome;
            }
        }
        return optimalChromosome;
    }
}
