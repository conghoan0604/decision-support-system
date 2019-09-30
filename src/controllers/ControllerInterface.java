package controllers;

public interface ControllerInterface {
    // Get data from model
    int getModelOriginalPrice();
    int getModelSellPrice();
    int getModelLossPrice();

    // Set data to model
    void setModelOriginalPrice();
    void setModelSellPrice();
    void setModelLossPrice();

    // Get data from view
    int getViewOriginalPrice();
    int getViewSellPrice();
    int getViewLossPrice();
    int getViewProbability1();
    int getViewProbability2();
    int getViewProbability3();
    int getViewProbability4();


    // Set data to view
    void setViewResult();
}
