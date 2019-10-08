package views;

import java.awt.event.ActionListener;

public interface ViewInterface {
	
	// Show/Hide info group window
	void showInfoGroupWindow();
	void hideInfoGroupWindow();
	
	// Show/Hide case window
	void showCase1Window(boolean unique);
	void showCase2Window(boolean unique);
	void showCase3Window(boolean unique);
	void hideCase1Window();
	void hideCase2Window();
	void hideCase3Window();
	void hideAllCaseWindow();
	
	// Get data from view
	int getOriginalPrice();
	int getSellPrice();
	int getLossPrice();
	double[] getProbability();
	
	// Reset value
	void resetDefault();
	
	// Set result
	void setResult(int caseNum, int solutionNum, int result);
	
	// Show/Hide result window
	void showResultWindow();
	void closeResultWindow();
	
	// On/Off Case Button
	void setEnableCaseBtn(int caseNum, boolean status);
	
	// Add Action to main view
	void addListenerMainApp(ActionListener groupInfoBtn, ActionListener case1Btn, ActionListener case2Btn, ActionListener case3Btn, ActionListener submitBtn, ActionListener exitBtn);
	// Add Action to info group window
	void addListenerGroupInfoPanel(ActionListener exitBtn);
	// Add Action to case window
	void addListenerCase1(ActionListener solution1Btn, ActionListener solution2Btn, ActionListener solution3Btn, ActionListener solution4Btn, ActionListener exitBtn);
	void addListenerCase2(ActionListener solution1Btn, ActionListener solution2Btn, ActionListener solution3Btn, ActionListener solution4Btn, ActionListener exitBtn);
	void addListenerCase3(ActionListener solution1Btn, ActionListener exitBtn);
	
}
