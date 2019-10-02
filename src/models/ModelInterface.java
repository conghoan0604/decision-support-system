package models;

public interface ModelInterface {

    // Common
    void loadInput();
    void loadProbabilities(double[] array);

    // Uncertainty theory
    int[] laplaceCriteriaPredict();
    int[] bestChoiceInBadCasesPredict();
    int[] savageCriteriaPredict();
    int[] minimumRankPredict();

    // Risk management
    int[] nearFutureRiskPredict();
    int[] maximumExpectedProfitRiskPredict();
    int[] decisionTreePredict();
    int[] minimumExpectedRegretRiskPredict();

    // Certainty theory
    int[] maximumExpectedProfitPredict();

    // Get
    int getOriginalPrice();
    int getSellPrice();
    int getLossPrice();

    // Set
    void setOriginalPrice(int number);
    void setSellPrice(int number);
    void setLossPrice(int number);

}