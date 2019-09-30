import models.*;
import views.*;
import controllers.*;

public class Main {
    public static void main(String[] args) {
        Model testModel = new Model();
        testModel.setOriginalPrice(6);
        testModel.setSellPrice(11);
        testModel.setLossPrice(2);

        testModel.loadInput();

        testModel.printInterestMatrix();

        double[] probabilities = {0.1, 0.3, 0.2, 0.4};
        testModel.loadProbabilities(probabilities);

        int choice = testModel.bestChoiceInBadCasesPredict();
        System.out.println(Model.N_PRODUCT[choice]);

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        view.setVisible(true);
    }
}
