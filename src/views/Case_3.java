package views;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Case_3 extends JDialog {

	private String name = "Ra quyết định theo chắc chắn";

	private JPanel null_panel;

	private JPanel main;
	private JLabel label_margin_1;
	private JButton btnCase3_solution1;
	private JPanel panel;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Case_3 frame = new Case_3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Case_3() {
		this.setTitle(name);
		setBounds(768, 100, 368, 150);
		this.setResizable(false);
		getContentPane().setLayout(new BorderLayout());

		null_panel = new JPanel();
		getContentPane().add(null_panel, BorderLayout.NORTH);

		// <Case
		main = new JPanel();
		GridBagLayout gbl_main = new GridBagLayout();
		gbl_main.columnWidths = new int[] { 0, 0, 0 };
		gbl_main.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_main.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_main.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		main.setLayout(gbl_main);
		// -----------------------------------------------------
		label_margin_1 = new JLabel(">");
		GridBagConstraints gbc_label_margin_1 = new GridBagConstraints();
		gbc_label_margin_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_margin_1.gridx = 0;
		gbc_label_margin_1.gridy = 0;
		main.add(label_margin_1, gbc_label_margin_1);
		btnCase3_solution1 = new JButton("Giá trị kỳ vọng khi có đủ thông tin");
		GridBagConstraints gbc_btnCase1_solution1 = new GridBagConstraints();
		gbc_btnCase1_solution1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase1_solution1.insets = new Insets(0, 0, 5, 5);
		gbc_btnCase1_solution1.gridx = 1;
		gbc_btnCase1_solution1.gridy = 0;
		main.add(btnCase3_solution1, gbc_btnCase1_solution1);
		// -----------------------------------------------------
		getContentPane().add(main, BorderLayout.CENTER);
		// End case>

		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 51, 5, 0 };
		gbl_panel.rowHeights = new int[] { 129, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnExit = new JButton("Exit");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.insets = new Insets(0, 0, 5, 0);
		gbc_btnExit.anchor = GridBagConstraints.SOUTH;
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.gridx = 0;
		gbc_btnExit.gridy = 0;
		panel.add(btnExit, gbc_btnExit);
	}
	
	public void addListenerCase3(ActionListener solution1Btn, ActionListener exitBtn) {		
		btnCase3_solution1.addActionListener(solution1Btn);
		
		btnExit.addActionListener(exitBtn);
	}

}
