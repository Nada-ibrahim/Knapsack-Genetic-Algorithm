package com.company;

import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        int[] output = {58, 90, 130, 46, 197, 274, 236, 202, 3842,
                3203, 2601, 3253, 8205, 8190, 8065, 8398, 20019, 18445, 21959, 18811};
        int outputSum = 0;
        for (int i = 0; i < output.length; i++) {
            outputSum += output[i];
        }
        int predictedSum = 0;
        for(int i = 0; i < c; ++i){
            int n = scan.nextInt();
            Item[] allItems = new Item[n];
            double s = scan.nextDouble();
            for(int j = 0; j < n; ++j){
                allItems[j] = new Item(scan.nextDouble(), scan.nextDouble());
            }
            CanonicalGA ga = new CanonicalGA(allItems, s);
            Chromosome optimalChrom = ga.applyAlgorithm(1000, 500);
            System.out.println(optimalChrom.fitness);
            predictedSum += optimalChrom.fitness;
//            System.out.println(optimalChrom.evaluateVal());
        }
        System.out.println((predictedSum/(float)outputSum));

    }


}
