import models.*;

public class Test {
    public static void main(String[] args) {
        Model testModel = new Model();
        testModel.setOriginalPrice(6);
        testModel.setSellPrice(11);
        testModel.setLossPrice(2);

        testModel.loadInput();

        // testModel.printInterestMatrix();

        double[] probabilities = {0.1, 0.3, 0.2, 0.4};
        testModel.loadProbabilities(probabilities);

        int[] choices = testModel.minimumExpectedRegretRiskPredict();
        printResult(choices);

    }

    private static void printResult(int[] choices){
        int[] cases = Model.N_PRODUCT;

        System.out.print("De thu duoc loi nhuan, Toto quyet dinh mua ");

        System.out.printf("%d", cases[choices[0]]);
        for (int i = 1; i < choices.length; i++){
            System.out.printf(" hoac %d", cases[choices[i]]);
        }

        System.out.print(" banh mi");
    }
}
