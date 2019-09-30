package controllers;

import models.Model;
import views.GroupInfoPanel;
import views.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.JButton;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public int getModelOriginalPrice() {
        return model.getOriginalPrice();
    }

    public int getModelSellPrice() {
        return model.getSellPrice();
    }

    public int getModelLossPrice() {
        return model.getLossPrice();
    }

    public void setModelOriginalPrice() {
        model.setOriginalPrice(view.getOriginalPrice());
    }

    public void setModelSellPrice() {
        model.setSellPrice(view.getSellPrice());
    }

    public void setModelLossPrice() {
        model.setLossPrice(view.getLossPrice());
    }

//    public void setModelProbabilities() {
//        model.loadProbabilities(new double[]{view.getProbability1(), view.getProbability2(), view.getProbability3(), view.getProbability4()});
//    }

    public int getViewOriginalPrice() {
        return view.getOriginalPrice();
    }

    public int getViewSellPrice() {
        return view.getSellPrice();
    }

    public int getViewLossPrice() {
        return view.getLossPrice();
    }

//    public int getViewProbability1() {
//        return view.getProbability1();
//    }
//
//    public int getViewProbability2() {
//        return view.getProbability2();
//    }
//
//    public int getViewProbability3() {
//        return view.getProbability3();
//    }
//
//    public int getViewProbability4() {
//        return view.getProbability4();
//    }

    public class btnInfoAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showInfoGroupWindow();
        }
    }

    public class btnCase1AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showCase1Window(true);
        }
    }

    public class btnCase2AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showCase2Window(true);
        }
    }

    public class btnCase3AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showCase3Window(true);
        }
    }

    public class btnSubmitAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setModelLossPrice();
            setModelOriginalPrice();
            setModelSellPrice();
        }
    }

    public class btnCase1Solution1AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(1, 1, model.laplaceCriteriaPredict());
            view.showResultWindow();
        }
    }

    public class btnCase1Solution2AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(1, 2, model.bestChoiceInBadCasesPredict());
            view.showResultWindow();
        }
    }

    public class btnCase1Solution3AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(1,3, model.savageCriteriaPredict());
            view.showResultWindow();
        }
    }

    public class btnCase12Solution4AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(1, 4, model.minimumRankPredict());
            view.showResultWindow();
        }
    }

    public class btnCase2Solution1AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(2, 1, model.nearFutureRiskPredict());
            view.showResultWindow();
        }
    }

    public class btnCase2Solution2AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(2, 2, model.maximumExpectedProfitRiskPredict());
            view.showResultWindow();
        }
    }

    public class btnCase2Solution3AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(2, 3, model.minimumExpectedRegretRiskPredict());
            view.showResultWindow();
        }
    }

    public class btnCase3Solution1AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(3, 1, model.maximumExpectedProfitPredict());
            view.showResultWindow();
        }
    }

}
