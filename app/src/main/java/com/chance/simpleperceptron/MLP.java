package com.chance.simpleperceptron;

import android.util.Log;

public class MLP {

    public static final int NUM_VALUE = 10;
    public static final double THRESHOLD_VALUE = 0.6;
    public static final int HIDDEN = 30;

    public static final String TAG = "MyTag";

    double[] enters;
    double[] hidden;
    double[] outer;
    double[] outer_max;
    double[][] wEH;
    double[][] wHO;
    double[][] patterns = {
            {1,1,1, 1,0,1, 1,0,1, 1,0,1, 1,1,1}, // 0
            {0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1}, // 1
            {1,1,1, 0,0,1, 1,1,1, 1,0,0, 1,1,1}, // 2
            {1,1,1, 0,0,1, 1,1,1, 0,0,1, 1,1,1}, // 3
            {1,0,1, 1,0,1, 1,1,1, 0,0,1, 0,0,1}, // 4
            {1,1,1, 1,0,0, 1,1,1, 0,0,1, 1,1,1}, // 5
            {1,1,1, 1,0,0, 1,1,1, 1,0,1, 1,1,1}, // 6
            {1,1,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1}, // 7
            {1,1,1, 1,0,1, 1,1,1, 1,0,1, 1,1,1}, // 8
            {1,1,1, 1,0,1, 1,1,1, 0,0,1, 1,1,1}, // 9
            {0,0,0, 0,0,0, 0,0,0, 0,0,0, 0,0,0}, // Not found
    };
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

    public MLP() {
        enters = new double[patterns[0].length];
        hidden = new double[HIDDEN];
        wEH = new double[enters.length][hidden.length];
        wHO = new double[hidden.length][NUM_VALUE];

        outer = new double[NUM_VALUE];
        outer_max = new double[NUM_VALUE];
        
        init();
        Log.d(TAG,"init - ok");
        //study();
        //Log.d(TAG,"study - ok");
        
        for(int p=0;p<patterns.length;p++){
            for(int i=0;i<enters.length;i++)
                enters[i]=patterns[p][i];
            countOuter();
        }
    }
    
    public void init(){
        for(int i=0;i<enters.length;i++){
            for(int j=0;j<wEH[i].length;j++){
                wEH[i][j] = Math.random()*0.2 + 0.1;
            }
        }
        for(int i=0;i<wHO.length;i++){
            for(int j=0;j<NUM_VALUE;j++)
            wHO[i][j] = Math.random()*0.2+0.1;
        }
    }
    
    public void countOuter() {
        for(int num=0;num<NUM_VALUE;num++) {
            for (int i = 0; i < hidden.length; i++) {
                hidden[i] = 0;
                for (int j = 0; j < enters.length; j++) {
                    hidden[i] += enters[j] * wEH[j][i];
                }
                if (hidden[i] > THRESHOLD_VALUE ) hidden[i] = 1;
                else hidden[i] = 0;
            }
            outer[num] = 0;
            for (int i = 0; i < hidden.length; i++) {
                outer[num] += hidden[i] * wHO[i][num];
                outer_max[num] = outer[num];
            }
            if (outer[num] > THRESHOLD_VALUE ) {
                outer_max[num] = outer[num];
                outer[num] = 1;
            }
            else {
                outer_max[num] = outer[num];
                outer[num] = 0;
            }
        }
    }
    
    public int study() {
        int iterations = 0;

        double[] err = new double[hidden.length];
        double gError = 0;
        for(int num=0;num<NUM_VALUE;num++) {
            do {
                iterations++;
                gError = 0;
                for (int p = 0; p < patterns.length; p++) {
                    for (int i = 0; i < enters.length; i++)
                        enters[i] = patterns[p][i];
                    countOuter();
                    double lError = answers[num][p]-outer[num];
                    gError += Math.abs(lError);

                    for (int i = 0; i < hidden.length; i++)
                        err[i] = lError * wHO[i][num];

                    for (int i = 0; i < enters.length; i++) {
                        for (int j = 0; j < hidden.length; j++) {
                            wEH[i][j] += 0.1 * err[j] * enters[i];
                        }
                    }

                    for (int i = 0; i < hidden.length; i++) {
                        wHO[i][num] += 0.1 * lError * hidden[i];
                    }
                }
            } while (gError != 0);
        }
        Log.d(TAG,"study - ok");
        return iterations;
    }
    
    public static void main(String[] args) {
        MLP mlp = new MLP();
    }

    public void studyWrong(int num){

    }

    public void studyWright(int num){

    }
    
}
