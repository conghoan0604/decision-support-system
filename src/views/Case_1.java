package views;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Case_1 extends JDialog {

	private JPanel contentPane;
	
	private String name = "Ra quyết định theo không chắc chắn";
	
	private JPanel theory, main;
	
	private JTextArea textArea;
	
	private JPanel solution, btnArea;
	private JButton btnExit;
	private JLabel lblMargin1, lblMargin2, lblMargin3, lblMargin4;
	private JButton btnCase1Solution1, btnCase1Solution2, btnCase1Solution3, btnCase1Solution4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Case_1 frame = new Case_1();
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
	public Case_1() {
		setTitle(name);
		setBounds(100, 100, 500, 285);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		theory = new JPanel();
		TitledBorder title = BorderFactory.createTitledBorder("Lý thuyết");
		EmptyBorder padding = new EmptyBorder(5, 10, 5, 10);
		theory.setBorder(new CompoundBorder(title, padding));
		GridBagConstraints gbc_theory = new GridBagConstraints();
		gbc_theory.insets = new Insets(0, 0, 10, 0);
		gbc_theory.fill = GridBagConstraints.BOTH;
		gbc_theory.gridx = 0;
		gbc_theory.gridy = 0;
		contentPane.add(theory, gbc_theory);
		theory.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setOpaque(false);
		textArea.setText("Càng biết ít về tương lai, càng cần nhiều chỉ tiêu để có hoàn cảnh ra quyết định. Thông thường các chỉ tiêu dựa trên các lưu ý đặc biệt, tức các chỉ tiêu có xu hướng bảo thủ.");
		textArea.setColumns(10);
		theory.add(textArea, BorderLayout.CENTER);
		
		main = new JPanel();
		GridBagConstraints gbc_main = new GridBagConstraints();
		gbc_main.insets = new Insets(10, 0, 0, 0);
		gbc_main.fill = GridBagConstraints.BOTH;
		gbc_main.gridx = 0;
		gbc_main.gridy = 1;
		contentPane.add(main, gbc_main);
		main.setLayout(new BorderLayout(0, 0));
		
		btnArea = new JPanel();
		main.add(btnArea, BorderLayout.EAST);
		GridBagLayout gbl_btnArea = new GridBagLayout();
		gbl_btnArea.columnWidths = new int[]{51, 0};
		gbl_btnArea.rowHeights = new int[]{23, 0};
		gbl_btnArea.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_btnArea.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		btnArea.setLayout(gbl_btnArea);
		
		btnExit = new JButton("Exit");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnExit.gridx = 0;
		gbc_btnExit.gridy = 0;
		btnArea.add(btnExit, gbc_btnExit);
		
		solution = new JPanel();
		main.add(solution, BorderLayout.CENTER);
		GridBagLayout gbl_solution = new GridBagLayout();
		gbl_solution.columnWidths = new int[]{0, 0, 0};
		gbl_solution.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_solution.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_solution.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		solution.setLayout(gbl_solution);
		
		lblMargin1 = new JLabel(">");
		GridBagConstraints gbc_lblMargin1 = new GridBagConstraints();
		gbc_lblMargin1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargin1.gridx = 0;
		gbc_lblMargin1.gridy = 0;
		solution.add(lblMargin1, gbc_lblMargin1);
		
		btnCase1Solution1 = new JButton("Chỉ tiêu Laplace");
		GridBagConstraints gbc_btnCase1Solution1 = new GridBagConstraints();
		gbc_btnCase1Solution1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase1Solution1.insets = new Insets(0, 0, 5, 0);
		gbc_btnCase1Solution1.gridx = 1;
		gbc_btnCase1Solution1.gridy = 0;
		solution.add(btnCase1Solution1, gbc_btnCase1Solution1);
		
		lblMargin2 = new JLabel(">");
		GridBagConstraints gbc_lblMargin2 = new GridBagConstraints();
		gbc_lblMargin2.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargin2.gridx = 0;
		gbc_lblMargin2.gridy = 1;
		solution.add(lblMargin2, gbc_lblMargin2);
		
		btnCase1Solution2 = new JButton("Tốt trong xấu");
		GridBagConstraints gbc_btnCase1Solution2 = new GridBagConstraints();
		gbc_btnCase1Solution2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase1Solution2.insets = new Insets(0, 0, 5, 0);
		gbc_btnCase1Solution2.gridx = 1;
		gbc_btnCase1Solution2.gridy = 1;
		solution.add(btnCase1Solution2, gbc_btnCase1Solution2);
		
		lblMargin3 = new JLabel(">");
		GridBagConstraints gbc_lblMargin3 = new GridBagConstraints();
		gbc_lblMargin3.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargin3.gridx = 0;
		gbc_lblMargin3.gridy = 2;
		solution.add(lblMargin3, gbc_lblMargin3);
		
		btnCase1Solution3 = new JButton("Chỉ tiêu Savage");
		GridBagConstraints gbc_btnCase1Solution3 = new GridBagConstraints();
		gbc_btnCase1Solution3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase1Solution3.insets = new Insets(0, 0, 5, 0);
		gbc_btnCase1Solution3.gridx = 1;
		gbc_btnCase1Solution3.gridy = 2;
		solution.add(btnCase1Solution3, gbc_btnCase1Solution3);
		
		lblMargin4 = new JLabel(">");
		GridBagConstraints gbc_lblMargin4 = new GridBagConstraints();
		gbc_lblMargin4.insets = new Insets(0, 0, 0, 5);
		gbc_lblMargin4.gridx = 0;
		gbc_lblMargin4.gridy = 3;
		solution.add(lblMargin4, gbc_lblMargin4);
		
		btnCase1Solution4 = new JButton("Hạng cực tiểu");
		GridBagConstraints gbc_btnCase1Solution4 = new GridBagConstraints();
		gbc_btnCase1Solution4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase1Solution4.gridx = 1;
		gbc_btnCase1Solution4.gridy = 3;
		solution.add(btnCase1Solution4, gbc_btnCase1Solution4);
		
	}
	
	public void addListenerCase1(ActionListener solution1Btn, ActionListener solution2Btn, ActionListener solution3Btn, ActionListener solution4Btn, ActionListener exitBtn) {
		btnCase1Solution1.addActionListener(solution1Btn);
		btnCase1Solution2.addActionListener(solution2Btn);
		btnCase1Solution3.addActionListener(solution3Btn);
		btnCase1Solution4.addActionListener(solution4Btn);
		
		btnExit.addActionListener(exitBtn);
	}

}
