package com.company;

import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        for(int i = 0; i < c; ++i){
            int n = scan.nextInt();
            Item[] allItems = new Item[n];
            double s = scan.nextDouble();
            for(int j = 0; j < n; ++j){
                allItems[j] = new Item(scan.nextDouble(), scan.nextDouble());
            }
            CanonicalGA ga = new CanonicalGA(allItems, s);
            ga.applyAlgorithm(100, 100);
        }

    }


}
