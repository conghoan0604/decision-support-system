package models;

import java.lang.IllegalArgumentException;

public class Model implements ModelInterface {
    public static final int MIN_PRODUCT = 11;
    public static final int MAX_PRODUCT = 14;
    static final int SIZE = 4;

    private int originalPrice, lossPrice, sellPrice;
    private int[][] interestMatrix = new int[SIZE][SIZE];

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
    public void generateInterestMatrix(){
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

    // uncertain
    @Override
    public int laplaceCriteriaPredict(){
        return 0;
    }

    @Override
    public int bestChoiceInBadCasesPredict(){
        return 0;
    }

    @Override
    public int savageCriteriaPredict(){
        return 0;   
    }

    @Override
    public int minimumRankPredict(){
        return 0;
    }

    // Risk management
    @Override
    public int nearFutureRiskPredict(){
        return 0;
    }

    @Override
    public int maximumExpectedProfitRiskPredict(){
        return 0;
    }

    @Override
    public int minimumExpectedRegretRiskPredict(){
        return 0;
    }

    // Certainty theory
    public int maximumExpectedProfitPredict(){
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

    public void printInterestMatrix(){
        System.out.println("Interest Matrix = ");
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                System.out.printf("%5d", interestMatrix[i][j]);
            }
            System.out.println();
        }
    }



}