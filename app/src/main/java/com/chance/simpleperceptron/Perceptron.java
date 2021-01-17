package com.chance.simpleperceptron;

import android.util.Log;

public class Perceptron {

    public static final int NUM_VALUE = 10;
    public static final double THRESHOLD_VALUE = 0.6;

    double[] enters;
    //double[] hidden;
    double[] outer;
    //double[][] wEH;
    //double[] wHO;
    double[][] weights;

    double[] outer_max;

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

    /*
            {1,1,1,1,0,0,0,1,0,0,0,1,1,1,1}, // 5
            {1,1,1,1,0,0,0,1,1,0,0,1,1,1,1}, // 5
            {1,1,0,1,0,0,1,1,1,0,0,1,1,1,1}, // 5
            {1,1,0,1,0,0,1,1,1,0,0,1,0,1,1}, // 5
            {1,1,1,1,0,0,1,0,1,0,0,1,1,1,1}, // 5
     */

    double[][] patterns = {
            {1,1,1,1,0,1,1,0,1,1,0,1,1,1,1}, // 0
            {0,0,1,0,0,1,0,0,1,0,0,1,0,0,1}, // 1
            {1,1,1,0,0,1,1,1,1,1,0,0,1,1,1}, // 2
            {1,1,1,0,0,1,1,1,1,0,0,1,1,1,1}, // 3
            {1,0,1,1,0,1,1,1,1,0,0,1,0,0,1}, // 4
            {1,1,1,1,0,0,1,1,1,0,0,1,1,1,1}, // 5
            {1,1,1,1,0,0,1,1,1,1,0,1,1,1,1}, // 6
            {1,1,1,0,0,1,0,0,1,0,0,1,0,0,1}, // 7
            {1,1,1,1,0,1,1,1,1,1,0,1,1,1,1}, // 8
            {1,1,1,1,0,1,1,1,1,0,0,1,1,1,1}, // 9

            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  // Not found

            //{0,1,0, 0,1,0, 0,1,0, 0,1,0, 0,1,0}, // 1
            //{1,1,0, 0,0,1, 1,1,1, 1,0,0, 1,1,0}, // 2
            //{1,1,1, 0,1,0, 1,0,0, 1,0,0, 1,0,0}, // 7

    };

    //double[] answers = {0,1,2,3,4,5,6,7,8,9};
    double[][] answers = {
            {1,0,0,0,0,0,0,0,0,0, 0},// 0,0}, // 0
            {0,1,0,0,0,0,0,0,0,0, 0},// 1,0}, // 1
            {0,0,1,0,0,0,0,0,0,0, 0},// 0,1}, // 2
            {0,0,0,1,0,0,0,0,0,0, 0},// 0,0}, // 3
            {0,0,0,0,1,0,0,0,0,0, 0},// 0,0}, // 4
            {0,0,0,0,0,1,0,0,0,0, 0},// 0,0}, // 5
            {0,0,0,0,0,0,1,0,0,0, 0},// 0,0}, // 6
            {0,0,0,0,0,0,0,1,0,0, 0},// 0,0}, // 7
            {0,0,0,0,0,0,0,0,1,0, 0},// 0,0}, // 8
            {0,0,0,0,0,0,0,0,0,1, 0},// 0,0}, // 9
    };

    public Perceptron() {
        enters = new double[patterns[0].length];
        weights = new double[NUM_VALUE][enters.length];
        for(int num = 0; num <NUM_VALUE;num++) {
            for (int i = 0; i < enters.length; i++) {
                weights[num][i] = Math.random() * 0.02 + 0.01;
                enters[i] = 0;
            }
        }
        //weights[i] = 0;
        outer = new double[NUM_VALUE];
        outer_max = new double[NUM_VALUE];
    }

    void countOuter(){
        for(int num=0;num<NUM_VALUE;num++) {
            outer[num] = 0;
            for (int i = 0; i < enters.length; i++) {
                outer[num] += enters[i] * weights[num][i];
            }
            if (outer[num]>=THRESHOLD_VALUE) {
                outer_max[num] = outer[num];
                outer[num] = 1;
            }
            else{
                outer_max[num] = outer[num];
                outer[num] = 0;
            }
        }
    }

    int study(){
        int iterations = 0;
        double gError;
        for(int num=0;num<NUM_VALUE;num++) {
            do {
                iterations++;
                gError = 0;
                for (int p = 0; p < (patterns.length); p++) {
                    for (int i = 0; i < enters.length; i++) {
                        enters[i] = patterns[p][i];
                    }
                    countOuter();
                    //iterations++;
                    double error = answers[num][p] - outer[num];
                    gError += Math.abs(error);
                    for (int i = 0; i < enters.length; i++) {
                        weights[num][i] += 0.1 * error * enters[i];
                    }
                    Log.d(tag, "eror = " + error);
                    Log.d(tag, "gEror = " + gError);
                }
            } while (gError != 0);
        }
        return (iterations);
    }

    void studyWrong(int num){
        Integer Num = num;
        if(Num == -1) return;
        for(int i=0;i<enters.length;i++){
            if (enters[i]==1) weights[Num][i] -= 0.01;
        }
        countOuter();
    }

    void studyWright(int num){
        Integer Num = num;
        if(Num == -1) return;
        for(int i=0;i<enters.length;i++){
            if (enters[i]==1) weights[Num][i] += 0.01;
        }
        countOuter();
    }

}
