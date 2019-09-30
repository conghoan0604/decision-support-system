package controllers;

import models.Model;
import views.GroupInfoPanel;
import views.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addListenerMainApp(new btnInfoAL(), new btnCase1AL(), new btnCase2AL(), new btnCase3AL(), new btnSubmitAL(), new btnExitAL());
        this.view.addListenerCase1(new btnCase1Solution1AL(), new btnCase1Solution2AL(), new btnCase1Solution3AL(), new btnCase1Solution4AL(), new btnCase1ExitAL());
        this.view.addListenerCase2(new btnCase2Solution1AL(), new btnCase2Solution2AL(), new btnCase2Solution3AL(), new btnCase2Solution4AL(), new btnCase2ExitAL());
        this.view.addListenerCase3(new btnCase3Solution1AL(), new btnCase3ExitAL());
        this.view.addListenerGroupInfoPanel(new btnInfoExitAL());
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

    public void setModelProbabilities() {
        model.loadProbabilities(view.getProbability());
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

    public class btnInfoAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showInfoGroupWindow();
        }
    }
    
    public class btnInfoExitAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.hideInfoGroupWindow();
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
        	view.closeResultWindow();
        	view.hideAllCaseWindow();
        	try {
        		setModelLossPrice();
            	setModelOriginalPrice();
            	setModelSellPrice();
            	setModelProbabilities();
            	model.loadInput();
            	view.setEnableCaseBtn(0, true);
        	} catch (Exception er) {
        		view.setEnableCaseBtn(0, false);
        		JOptionPane.showMessageDialog(null, er.getMessage(), "Error", 2);
        	}
        }
    }
    
    public class btnExitAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	System.exit(0);
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

    public class btnCase1Solution4AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(1, 4, model.minimumRankPredict());
            view.showResultWindow();
        }
    }
    
    public class btnCase1ExitAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.hideCase1Window();
            view.closeResultWindow();
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
            view.setResult(2, 3, model.maximumExpectedProfitRiskPredict());
            view.showResultWindow();
        }
    }
    
    public class btnCase2Solution4AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(2, 4, model.minimumExpectedRegretRiskPredict());
            view.showResultWindow();
        }
    }
    
    public class btnCase2ExitAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.hideCase2Window();
            view.closeResultWindow();
        }
    }

    public class btnCase3Solution1AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setResult(3, 1, model.maximumExpectedProfitPredict());
            view.showResultWindow();
        }
    }
    
    public class btnCase3ExitAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.hideCase3Window();
            view.closeResultWindow();
        }
    }

}
