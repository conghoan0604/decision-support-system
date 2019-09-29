package controllers;

import models.Model;
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

    public int getViewOriginalPrice() {
        return view.getOriginalPrice();
    }

    public int getViewSellPrice() {
        return view.getSellPrice();
    }

    public int getViewLossPrice() {
        return view.getLossPrice();
    }



//    public void initView() {
//
//    }
//
//        public class btnExitAL implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            System.exit(0);
//        }
//    }
//
//    public class btnSetDataAL implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    }
}
