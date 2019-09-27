package models;

import java.lang.IllegalArgumentException;

public class Model implements ModelInterface {
    public static final int MIN_PRODUCT = 11;
    public static final int MAX_PRODUCT = 14;
    public static final int[] N_PRODUCT = {11, 12, 13, 14};
    static final int SIZE = 4;

    private int originalPrice, lossPrice, sellPrice;
    private int[][] interestMatrix = new int[SIZE][SIZE];
    private int[][] regretMatrix = new int[SIZE][SIZE];
    private double[] probabilities = new double[SIZE];

    public Model(){
        // null statement
    }

    // get
    @Override
    public int getOriginalPrice(){
        return originalPrice;
    }

    @Override
    public int getLossPrice(){
        return lossPrice;
    }

    @Override
    public int getSellPrice(){
        return sellPrice;
    }

    // set
    @Override
    public void setOriginalPrice(int number){
        if (number <= 0){
            throw new IllegalArgumentException("Gia don vi hang phai lon hon 0");
        }

        originalPrice = number;
    }

    @Override
    public void setLossPrice(int number){
        if (number <= 0){
            throw new IllegalArgumentException("Gia mat khach phai lon hon 0");
        }

        lossPrice = number;
    }

    @Override
    public void setSellPrice(int number){
        if (number <= 0){
            throw new IllegalArgumentException("Gia ban phai lon hon 0");
        }

        sellPrice = number;
    }

    // common
    @Override
    public void loadInput(){
        generateInterestMatrix();
        generateRegretMatrix();
    }

    @Override
    public void loadProbabilities(double[] array){
        probabilities = array;
    }

    private void generateInterestMatrix(){
        int[][] matrix = new int[SIZE][SIZE];
        int interest;
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                int orderProduct = MIN_PRODUCT + i;
                int sellProduct = MIN_PRODUCT + j;
                
                
                if (orderProduct >= sellProduct){
                    interest = sellProduct * sellPrice - orderProduct * originalPrice;
                } else {
                    interest = orderProduct * (sellPrice - originalPrice)
                            - (sellProduct - orderProduct) * lossPrice;
                }

                matrix[i][j] = interest;
            }
        }

        interestMatrix = matrix;
    }

    private void generateRegretMatrix(){
        int n;
        int[][] matrix = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++){
            n = interestMatrix[i][i];
            for (int j = 0; j < SIZE; j++){
                matrix[i][j] = interestMatrix[i][j] - n;
            }
        }

        regretMatrix = matrix;
    }

    // uncertain
    @Override
    public int laplaceCriteriaPredict(){
        double probability = 1 / SIZE;
        double[] expect_interest = new double[SIZE];

        for (int i = 0; i < SIZE; i++){
            expect_interest[i] = probability * interestMatrix[i][0];
            for (int j = 1; j < SIZE; j++){
                expect_interest[i] += probability * interestMatrix[i][j]; 
            }
        }

        int maxExpect = getMaxValueIndexInDoubleArray(expect_interest);
        return maxExpect;
    }

    @Override
    public int bestChoiceInBadCasesPredict(){
        int minInterest;
        int[] worstCases = new int[SIZE];

        for (int i = 0; i < SIZE; i++){
            minInterest = interestMatrix[i][0];
            for (int j = 1; j < SIZE; j++) {
                if (interestMatrix[i][j] < minInterest) {
                    minInterest = interestMatrix[i][j];
                }
            }
            worstCases[i] = minInterest;
        }
        
        int bestOutcome = getMaxValueIndexInIntegerArray(worstCases);
        return bestOutcome;
    }

    @Override
    public int savageCriteriaPredict(){
        int[] worstCase = new int[SIZE];
        int maxRegret;

        for (int i = 0; i < SIZE; i++){
            maxRegret = regretMatrix[i][i];
            for (int j = 0; j < SIZE; j++){
                if (regretMatrix[i][j] > maxRegret){
                    maxRegret = regretMatrix[i][j];
                }
            }
            worstCase[i] = maxRegret;
        }

        int bestOutcome = getMinValueIndexInIntegerArray(worstCase);
        return bestOutcome;   
    }

    @Override
    public int minimumRankPredict(){
        int min, max, rank, val;
        int[] rankArray = new int[SIZE];

        for (int i = 0; i < SIZE; i++){
            min = interestMatrix[i][0];
            max = interestMatrix[i][0];

            for (int j = 1; j < SIZE; j++){
                val = interestMatrix[i][j];
                if (val > max){
                    max = val;
                } else {
                    min = val;
                }
            }

            rank = max - min;
            rankArray[i] = rank;
        }

        int minRank = getMinValueIndexInIntegerArray(rankArray);
        return minRank;
    }

    // Risk management
    @Override
    public int nearFutureRiskPredict(){
        int highestProbability = getMaxValueIndexInDoubleArray(probabilities);
        return highestProbability;
    }

    @Override
    public int maximumExpectedProfitRiskPredict(){
        double[] expectInterests = new double[SIZE];
        double expectInterest;

        for (int i = 0; i < SIZE; i++){
            expectInterest = 0;
            for (int j = 0; j < SIZE; j++){
                expectInterest += probabilities[j] * interestMatrix[i][j]; 
            }
            expectInterests[i] = expectInterest;
        }
        
        int bestOutcome = getMaxValueIndexInDoubleArray(expectInterests);
        return bestOutcome;
    }

    @Override
    public int minimumExpectedRegretRiskPredict(){
        double[] expectRegrets = new double[SIZE];
        double expectRegret;

        for (int i = 0; i < SIZE; i++){
            expectRegret = 0;
            for (int j = 0; j < SIZE; j++){
                expectRegret += probabilities[j] * regretMatrix[i][j]; 
            }
            expectRegrets[i] = expectRegret;
        }
        
        int bestOutcome = getMinValueIndexInDoubleArray(expectRegrets);
        return bestOutcome;
    }

    // Certainty theory
    public int maximumExpectedProfitPredict(){
        // ???
        return 0;
    }

    private int getMaxValueIndexInDoubleArray(double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("Do dai mang phai lon hon 0");
        }

        int index = 0;
        double maxValue = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > maxValue){
                maxValue = array[i];
                index = i;
            }
        }

        return index;
    }

    private int getMinValueIndexInDoubleArray(double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("Do dai mang phai lon hon 0");
        }

        int index = 0;
        double minValue = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] < minValue){
                minValue = array[i];
                index = i;
            }
        }

        return index;
    }


    private int getMaxValueIndexInIntegerArray(int[] array){
        int maxVal = array[0];
        int index = 0;

        for (int i = 1; i < array.length; i++){
            if (array[i] > maxVal){
                maxVal = array[i];
                index = i;
            }
        }

        return index;
    }

    private int getMinValueIndexInIntegerArray(int[] array){
        int minVal = array[0];
        int index = 0;

        for (int i = 1; i < array.length; i++){
            if (array[i] < minVal){
                minVal = array[i];
                index = i;
            }
        }

        return index;
    }

    private void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void printInterestMatrix(){
        System.out.println("Interest Matrix = ");
        printMatrix(interestMatrix);
    }

    public void printRegretMatrix(){
        System.out.println("Regret Matrix = ");
        printMatrix(regretMatrix);
    }



}