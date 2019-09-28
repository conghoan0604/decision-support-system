package controllers;

public interface ControllerInterface {
    // Get data from model
    int getModelOriginalPrice();
    int getModelSellPrice();
    int getModelLossPrice();

    // Set data to model
    void setModelOriginalPrice(int number);
    void setModelSellPrice(int number);
    void setModelLossPrice(int number);
}
