package models;

import java.io.File;
import java.lang.IllegalArgumentException;

public class Model {
    private int minProduct, maxProduct;
    private int unitPrice, sellPrice, lossPrice;
    private int[][] interestMatrix;


    public Model(File file){
        // file input
    }

    public Model(){
        // null statement
    }

    public void readDatafromFile(File filePath){
        // processing

        // checking
        if (maxProduct < minProduct){
            throw new IllegalArgumentException("So luong hang hoa lon nhat phai lon hon so luong hang hoa nho nhat");
        }

        if (lossPrice <= 0){
            throw new IllegalArgumentException("Gia mat phai lon hon 0");
        }

        if (sellPrice <= 0){
            throw new IllegalArgumentException("Gia ban hang phai lon hon 0");
        }

        if (unitPrice <= 0){
            throw new IllegalArgumentException("Gia don vi hang phai lon hon 0");
        }

        if (sellPrice <= unitPrice ){
            throw new IllegalArgumentException("Gia ban phai lon hon gia mua hang");
        }

    }

    public void generateInterestMatrix(){
        int size = maxProduct - minProduct + 1;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                int supplyQuantity = minProduct + i;
                int demandQuantity = minProduct + j;
                int lossQuantity = demandQuantity - supplyQuantity;

                int interest = (sellPrice - unitPrice) * supplyQuantity - lossQuantity * lossPrice;
                matrix[i][j] = interest;
            }
        }

        // gan kich thuoc cho ma tran
        interestMatrix = new int[size][size];

        // gan ma tran
        interestMatrix = matrix;
    }


    public int laplacePredict(){
        int size = maxProduct - minProduct + 1;
        double probability = 1 / size;

        double[] expectInterest = new double[size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                expectInterest[i] += probability * interestMatrix[i][j];
            }
        }

        int index = getMaxValueIndexInArray(expectInterest);

        return index;
    }

    private int getMinValueIndexInArray(double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("Do dai mang phai lon hon 0");
        }
        int index = 0;
        double min = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
                index = i;
            }
        }

        return index;
    }

    private int getMaxValueIndexInArray(double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("Do dai mang phai lon hon 0");
        }
        int index = 0;
        double max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
                index = i;
            }
        }

        return index;
    }
}
