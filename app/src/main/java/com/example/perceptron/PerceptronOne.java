package com.example.perceptron;

import android.util.Log;

public class PerceptronOne{
    double[] enters;
    //double[] hidden;
    double outer;
    //double[][] wEH;
    //double[] wHO;
    double[] weights;

    String tag = "MyTag";

    /*double[] pattern_num_0 = {1,1,1,1,0,1,1,0,1,1,0,1,1,1,1};
    double[] pattern_num_1 = {0,0,1,0,0,1,0,0,1,0,0,1,0,0,1};
    double[] pattern_num_2 = {1,1,1,0,0,1,1,1,1,1,0,0,1,1,1};
    double[] pattern_num_3 = {1,1,1,0,0,1,1,1,1,0,0,1,1,1,1};
    double[] pattern_num_4 = {1,0,1,1,0,1,1,1,1,0,0,1,0,0,1};
    double[] pattern_num_5 = {1,1,1,1,0,0,1,1,1,0,0,1,1,1,1};
    double[] pattern_num_6 = {1,1,1,1,0,0,1,1,1,1,0,1,1,1,1};
    double[] pattern_num_7 = {1,1,1,0,0,1,0,0,1,0,0,1,0,0,1};
    double[] pattern_num_8 = {1,1,1,1,0,1,1,1,1,1,0,1,1,1,1};
    double[] pattern_num_9 = {1,1,1,1,0,1,1,1,1,0,0,1,1,1,1};*/

    double[][] patterns = {
            {1,1,1,1,0,1,1,0,1,1,0,1,1,1,1},
            {0,0,1,0,0,1,0,0,1,0,0,1,0,0,1},
            {1,1,1,0,0,1,1,1,1,1,0,0,1,1,1},
            {1,1,1,0,0,1,1,1,1,0,0,1,1,1,1},
            {1,0,1,1,0,1,1,1,1,0,0,1,0,0,1},
            {1,1,1,1,0,0,1,1,1,0,0,1,1,1,1},
            {1,1,1,1,0,0,1,1,1,1,0,1,1,1,1},
            {1,1,1,0,0,1,0,0,1,0,0,1,0,0,1},
            {1,1,1,1,0,1,1,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,1,0,0,1,1,1,1},

            {1,1,1,1,0,0,0,1,0,0,0,1,1,1,1},
            {1,1,1,1,0,0,0,1,1,0,0,1,1,1,1},
            {1,1,0,1,0,0,1,1,1,0,0,1,1,1,1},
            {1,1,0,1,0,0,1,1,1,0,0,1,0,1,1},
            {1,1,1,1,0,0,1,0,1,0,0,1,1,1,1},

            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    //double[] answers = {0,1,2,3,4,5,6,7,8,9};
    double[] answers = {0,0,0,0,0,1,0,0,0,0,  1,1,1,1,1, 0};

    public PerceptronOne() {
        enters = new double[patterns[0].length];
        weights = new double[enters.length];
        for(int i=0;i<enters.length;i++) {
            weights[i] = Math.random() * 0.02 + 0.01;
            enters[i]=0;
        }
        //weights[i] = 0;
    }

    void countOuter(){
        outer = 0;
        double delta = 0.5;
        for(int i=0;i<enters.length;i++){
            outer += enters[i]*weights[i];
        }
        if (outer>0.7) outer = 1;
        else outer = 0;
        /*if (outer<(0+delta)) outer = 0;
        if (outer<(1+delta) && (outer>(1-delta))) outer = 1;
        if (outer<(2+delta) && (outer>(2-delta))) outer = 2;
        if (outer<(3+delta) && (outer>(3-delta))) outer = 3;
        if (outer<(4+delta) && (outer>(4-delta))) outer = 4;
        if (outer<(5+delta) && (outer>(5-delta))) outer = 5;
        if (outer<(6+delta) && (outer>(6-delta))) outer = 6;
        if (outer<(7+delta) && (outer>(7-delta))) outer = 7;
        if (outer<(8+delta) && (outer>(8-delta))) outer = 8;
            //if (outer<10 && (outer>(9-delta))) outer = 9;
        else outer = 9;*/
    }

    int study(){
        int iterations = 0;
        double gError;
        do{
            iterations++;
            gError = 0;
            for(int p=0;p<(patterns.length);p++){
                for(int i=0;i<enters.length;i++){
                    enters[i] = patterns[p][i];
                }
                countOuter();
                double error = answers[p] - outer;
                gError += Math.abs(error);
                for(int i=0; i<enters.length;i++){
                    weights[i] += 0.1*error*enters[i];
                }
                Log.d(tag, "eror = " +error);
                Log.d(tag, "gEror = " +gError);
            }
        }while(gError != 0);
        return iterations;
    }

}
