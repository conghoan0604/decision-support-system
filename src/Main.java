import models.Model;

public class Main {
    public static void main(String[] args) {
        Model testModel = new Model();
        testModel.setOriginalPrice(6);
        testModel.setSellPrice(11);
        testModel.setLossPrice(2);

        testModel.generateInterestMatrix();

        testModel.printInterestMatrix();
    }
}
