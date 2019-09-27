package view;

import java.awt.*;
import javax.swing.*;

public class Case_2 extends JFrame {

	private String name = "Ra quyết định với rủi ro";

	private JPanel null_panel;

	private JPanel main;
	private JLabel label_margin_1, label_margin_2, label_margin_3;
	private JButton btnCase_1, btnCase_2, btnCase_3;
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
		setBounds(100, 100, 368, 135);
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
		btnCase_1 = new JButton("Giống tương lai nhất");
		GridBagConstraints gbc_btnThngTinNhm = new GridBagConstraints();
		gbc_btnThngTinNhm.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnThngTinNhm.insets = new Insets(0, 0, 5, 5);
		gbc_btnThngTinNhm.gridx = 1;
		gbc_btnThngTinNhm.gridy = 0;
		main.add(btnCase_1, gbc_btnThngTinNhm);
		// -----------------------------------------------------
		label_margin_2 = new JLabel(">");
		GridBagConstraints gbc_label_margin_2 = new GridBagConstraints();
		gbc_label_margin_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_margin_2.gridx = 0;
		gbc_label_margin_2.gridy = 1;
		main.add(label_margin_2, gbc_label_margin_2);
		btnCase_2 = new JButton("Đầu ra kỳ vọng");
		GridBagConstraints gbc_btnCase_1 = new GridBagConstraints();
		gbc_btnCase_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnCase_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase_1.gridx = 1;
		gbc_btnCase_1.gridy = 1;
		main.add(btnCase_2, gbc_btnCase_1);
		// -----------------------------------------------------
		label_margin_3 = new JLabel(">");
		GridBagConstraints gbc_label_margin_3 = new GridBagConstraints();
		gbc_label_margin_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_margin_3.gridx = 0;
		gbc_label_margin_3.gridy = 2;
		main.add(label_margin_3, gbc_label_margin_3);
		btnCase_3 = new JButton("Cây quyết định");
		GridBagConstraints gbc_btnCase_2 = new GridBagConstraints();
		gbc_btnCase_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnCase_2.gridx = 1;
		gbc_btnCase_2.gridy = 2;
		main.add(btnCase_3, gbc_btnCase_2);
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

}
