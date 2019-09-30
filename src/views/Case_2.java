package views;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Case_2 extends JDialog {

	private String name = "Ra quyết định với rủi ro";

	private JPanel null_panel;

	private JPanel main;
	private JLabel label_margin_1, label_margin_2, label_margin_3, label_margin_4;
	private JButton btnCase2_solution1, btnCase2_solution2, btnCase2_solution3, btnCase2_solution4;
	private JPanel panel;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Case_2 frame = new Case_2();
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
	public Case_2() {
		this.setTitle(name);
		setBounds(468, 100, 368, 168);
		this.setResizable(false);
		getContentPane().setLayout(new BorderLayout());

		null_panel = new JPanel();
		getContentPane().add(null_panel, BorderLayout.NORTH);

		// <Case
		main = new JPanel();
		GridBagLayout gbl_main = new GridBagLayout();
		gbl_main.columnWidths = new int[] { 0, 0, 0 };
		gbl_main.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_main.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_main.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		main.setLayout(gbl_main);
		// -----------------------------------------------------
		label_margin_1 = new JLabel(">");
		GridBagConstraints gbc_label_margin_1 = new GridBagConstraints();
		gbc_label_margin_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_margin_1.gridx = 0;
		gbc_label_margin_1.gridy = 0;
		main.add(label_margin_1, gbc_label_margin_1);
		btnCase2_solution1 = new JButton("Giống tương lai nhất");
		GridBagConstraints gbc_btnCase2_solution1 = new GridBagConstraints();
		gbc_btnCase2_solution1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase2_solution1.insets = new Insets(0, 0, 5, 5);
		gbc_btnCase2_solution1.gridx = 1;
		gbc_btnCase2_solution1.gridy = 0;
		main.add(btnCase2_solution1, gbc_btnCase2_solution1);
		// -----------------------------------------------------
		label_margin_2 = new JLabel(">");
		GridBagConstraints gbc_label_margin_2 = new GridBagConstraints();
		gbc_label_margin_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_margin_2.gridx = 0;
		gbc_label_margin_2.gridy = 1;
		main.add(label_margin_2, gbc_label_margin_2);
		btnCase2_solution2 = new JButton("Đầu ra kỳ vọng");
		GridBagConstraints gbc_btnCase2_solution2 = new GridBagConstraints();
		gbc_btnCase2_solution2.insets = new Insets(0, 0, 5, 5);
		gbc_btnCase2_solution2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase2_solution2.gridx = 1;
		gbc_btnCase2_solution2.gridy = 1;
		main.add(btnCase2_solution2, gbc_btnCase2_solution2);
		// -----------------------------------------------------
		label_margin_3 = new JLabel(">");
		GridBagConstraints gbc_label_margin_3 = new GridBagConstraints();
		gbc_label_margin_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_margin_3.gridx = 0;
		gbc_label_margin_3.gridy = 2;
		main.add(label_margin_3, gbc_label_margin_3);
		btnCase2_solution3 = new JButton("Cây quyết định");
		GridBagConstraints gbc_btnCase2_solution3 = new GridBagConstraints();
		gbc_btnCase2_solution3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase2_solution3.insets = new Insets(0, 0, 5, 5);
		gbc_btnCase2_solution3.gridx = 1;
		gbc_btnCase2_solution3.gridy = 2;
		main.add(btnCase2_solution3, gbc_btnCase2_solution3);
		// -----------------------------------------------------
		label_margin_4 = new JLabel(">");
		GridBagConstraints gbc_label_margin_4 = new GridBagConstraints();
		gbc_label_margin_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_margin_4.gridx = 0;
		gbc_label_margin_4.gridy = 3;
		main.add(label_margin_4, gbc_label_margin_4);
		btnCase2_solution4 = new JButton("Mất kỳ vọng thấp nhất");
		GridBagConstraints gbc_btnCase2_solution4 = new GridBagConstraints();
		gbc_btnCase2_solution4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase2_solution4.insets = new Insets(0, 0, 5, 5);
		gbc_btnCase2_solution4.gridx = 1;
		gbc_btnCase2_solution4.gridy = 3;
		main.add(btnCase2_solution4, gbc_btnCase2_solution4);
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
	
	public void addListenerCase2(ActionListener solution1Btn, ActionListener solution2Btn, ActionListener solution3Btn, ActionListener solution4Btn, ActionListener exitBtn) {		
		btnCase2_solution1.addActionListener(solution1Btn);
		btnCase2_solution2.addActionListener(solution2Btn);
		btnCase2_solution3.addActionListener(solution3Btn);
		btnCase2_solution4.addActionListener(solution4Btn);
		
		btnExit.addActionListener(exitBtn);
	}

}
