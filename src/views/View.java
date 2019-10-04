package views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {
	
	private String name = "Bài toán DSS sử dụng xác suất";

	private JPanel contentPane;
	
	private Case_1 frame_1 = new Case_1();
	private Case_2 frame_2 = new Case_2();
	private Case_3 frame_3 = new Case_3();
	private GroupInfoPanel info_frame = new GroupInfoPanel();
	private ResultPanel result_frame = new ResultPanel();
	
	private JPanel infoPane, formPane, casePane;
	
	private JButton btnInfoGroup;
	
	private JPanel form;
	private JPanel required, optional;
	
	private JPanel labelArea;
	private JLabel lblGiMua, lblGiBn, lblMtMtKhch;
	
	private JPanel textArea;
	private JTextField txtGiMua, txtGiBn, txtMtMtKhch;
	
	private JTextField textProbability1, textProbability2, textProbability3, textProbability4;
	
	private JPanel button;
	private JButton btnReset, btnSubmit;
	
	private JButton btnCase1, btnCase2, btnCase3;

	private KeyAdapter numberInput = new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			String textField = ((JTextField) e.getSource()).getText();
			if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
				// getToolkit().beep();
				e.consume();
			}
			if (textField.length() == 0) {
				((JTextField) e.getSource()).setText("0");
			} else {
				((JTextField) e.getSource()).setText(textField.replaceAll("^[0]+", ""));
			}
		}
	};
	private KeyAdapter doubleInput = new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			String textField = ((JTextField) e.getSource()).getText();
			if (textField.length() > 0) {
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == '.')) || (textField.matches("^[1]"))) {
					// getToolkit().beep();
					e.consume();
				} else {
					if (c == '.') {
						if (textField.contains(".")) {
							e.consume();
						}
					} else if (!((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
						if (!textField.contains(".")) {
							textField = textField.replaceAll("^[0]+", "") + c;
							textField = textField.replaceAll("^[1-9]+", "1");
						} else {
							textField += c;
						}
						((JTextField) e.getSource()).setText(textField);
						e.consume();
					}
				}
			}
			if (((JTextField) e.getSource()).getText().length() == 0) {
				((JTextField) e.getSource()).setText("0");
			}
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		setTitle(name);
		setSize(550, 330);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 15));
		setContentPane(contentPane);
		
		infoPane = new JPanel();
		contentPane.add(infoPane, BorderLayout.NORTH);
		btnInfoGroup = new JButton("Thông tin nhóm");
		infoPane.add(btnInfoGroup);
		
		formPane = new JPanel();
		formPane.setBorder(BorderFactory.createTitledBorder("Dữ liệu bài toán"));
		contentPane.add(formPane, BorderLayout.CENTER);
		formPane.setLayout(new BorderLayout(0, 0));
		
		form = new JPanel();
		formPane.add(form, BorderLayout.CENTER);
		form.setLayout(new BorderLayout(0, 0));
		// ---------------------------------------------------------------------------------
		required = new JPanel();
		form.add(required, BorderLayout.CENTER);
		required.setLayout(new BorderLayout(10, 0));
		
		labelArea = new JPanel();
		required.add(labelArea, BorderLayout.WEST);
		labelArea.setLayout(new GridLayout(3, 0, 0, 5));
		lblGiMua = new JLabel("Giá mua");
		labelArea.add(lblGiMua);
		lblGiBn = new JLabel("Giá bán");
		labelArea.add(lblGiBn);
		lblMtMtKhch = new JLabel("Mất một khách hàng");
		labelArea.add(lblMtMtKhch);
		
		textArea = new JPanel();
		required.add(textArea, BorderLayout.CENTER);
		textArea.setLayout(new GridLayout(3, 0, 0, 5));
		txtGiMua = new JTextField();
		txtGiMua.setText("0");
		textArea.add(txtGiMua);
		txtGiMua.setColumns(10);
		txtGiMua.addKeyListener(numberInput);
		txtGiBn = new JTextField();
		txtGiBn.setText("0");
		textArea.add(txtGiBn);
		txtGiBn.setColumns(10);
		txtGiBn.addKeyListener(numberInput);
		txtMtMtKhch = new JTextField();
		txtMtMtKhch.setText("0");
		textArea.add(txtMtMtKhch);
		txtMtMtKhch.setColumns(10);
		txtMtMtKhch.addKeyListener(numberInput);
		// ---------------------------------------------------------------------------------
		optional = new JPanel();
		form.add(optional, BorderLayout.SOUTH);
		optional.setBorder(BorderFactory.createTitledBorder("Dữ liệu thêm"));
		optional.setLayout(new GridLayout(1, 4, 10, 0));
		
		textProbability1 = new JTextField();
		textProbability1.setText("0");
		optional.add(textProbability1);
		textProbability1.setColumns(10);
		textProbability1.addKeyListener(doubleInput);
		
		textProbability2 = new JTextField();
		textProbability2.setText("0");
		optional.add(textProbability2);
		textProbability2.setColumns(10);
		textProbability2.addKeyListener(doubleInput);
		
		textProbability3 = new JTextField();
		textProbability3.setText("0");
		optional.add(textProbability3);
		textProbability3.setColumns(10);
		textProbability3.addKeyListener(doubleInput);
		
		textProbability4 = new JTextField();
		textProbability4.setText("0");
		optional.add(textProbability4);
		textProbability4.setColumns(10);
		textProbability4.addKeyListener(doubleInput);
		// ---------------------------------------------------------------------------------
		
		button = new JPanel();
		FlowLayout flowLayout = (FlowLayout) button.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		formPane.add(button, BorderLayout.SOUTH);
		btnReset = new JButton("Reset");
		button.add(btnReset);
		btnSubmit = new JButton("Submit");
		button.add(btnSubmit);
		
		casePane = new JPanel();
		contentPane.add(casePane, BorderLayout.SOUTH);
		//casePane.setLayout(new GridLayout(0, 3, 10, 0));
		casePane.setLayout(new GridLayout(0, 2, 10, 0));
		btnCase1 = new JButton("<html><center>"+"Ra quyết định"+"<br>"+"theo không chắc chắn"+"</center></html>");
		casePane.add(btnCase1);
		btnCase2 = new JButton("<html><center>"+"Ra quyết định"+"<br>"+"với rủi ro"+"</center></html>");
		casePane.add(btnCase2);
		btnCase3 = new JButton("<html><center>"+"Ra quyết định"+"<br>"+"theo chắc chắn"+"</center></html>");
		//casePane.add(btnCase3);
		setEnableCaseBtn(0, false);
	}
	
	public int getOriginalPrice() {
		return Integer.parseInt(txtGiMua.getText());
	}
	public int getSellPrice() {
		return Integer.parseInt(txtGiBn.getText());
	}
	public int getLossPrice() {
		return Integer.parseInt(txtMtMtKhch.getText());
	}
	public double[] getProbability() {
		double[] property = {Double.parseDouble(textProbability1.getText()), Double.parseDouble(textProbability2.getText()), Double.parseDouble(textProbability3.getText()), Double.parseDouble(textProbability4.getText())};
		return property;
	}

	public void showInfoGroupWindow() {
		info_frame.setVisible(true);
	}
	public void hideInfoGroupWindow() {
		info_frame.setVisible(false);
	}

	public void hideAllCaseWindow() {
		frame_1.setVisible(false);
		frame_2.setVisible(false);
		frame_3.setVisible(false);
	}
	
	public void showCase1Window(boolean unique) {
		if (unique) {
			hideAllCaseWindow();
		}
		frame_1.setVisible(true);
	}
	public void hideCase1Window() {
		frame_1.setVisible(false);
	}

	public void showCase2Window(boolean unique) {
		if (unique) {
			hideAllCaseWindow();
		}
		frame_2.setVisible(true);
	}
	public void hideCase2Window() {
		frame_2.setVisible(false);
	}

	public void showCase3Window(boolean unique) {
		if (unique) {
			hideAllCaseWindow();
		}
		frame_3.setVisible(true);
	}
	public void hideCase3Window() {
		frame_3.setVisible(false);
	}
	
	public void setResult(int caseNum, int solutionNum, int[] result) {
		result_frame.setResult(caseNum, solutionNum, result);
	}
	public void showResultWindow() {
		result_frame.setVisible(true);
	}
	public void closeResultWindow() {
		result_frame.cleanResult();
		result_frame.setVisible(false);
	}
	
	public void resetDefault() {
		txtGiMua.setText("0");
		txtGiBn.setText("0");
		txtMtMtKhch.setText("0");
		textProbability1.setText("0");
		textProbability2.setText("0");
		textProbability3.setText("0");
		textProbability4.setText("0");
	}
	
	public void setEnableCaseBtn(int caseNum, boolean status) {
		switch (caseNum) {
		case 1:
			btnCase1.setEnabled(status);
			break;
		case 2:
			btnCase2.setEnabled(status);
			break;
		case 3:
			btnCase3.setEnabled(status);
			break;
		default:
			btnCase1.setEnabled(status);
			btnCase2.setEnabled(status);
			btnCase3.setEnabled(status);
			break;
		}
	}
	
	public void addListenerMainApp(ActionListener groupInfoBtn, ActionListener case1Btn, ActionListener case2Btn, ActionListener case3Btn, ActionListener submitBtn, ActionListener resetBtn) {
		btnInfoGroup.addActionListener(groupInfoBtn);

		btnCase1.addActionListener(case1Btn);
		btnCase2.addActionListener(case2Btn);
		btnCase3.addActionListener(case3Btn);
		
		btnSubmit.addActionListener(submitBtn);

		btnReset.addActionListener(resetBtn);
	}
	
	public void addListenerGroupInfoPanel(ActionListener exitBtn) {
		info_frame.addListenerInfo(exitBtn);
	}
	
	public void addListenerCase1(ActionListener solution1Btn, ActionListener solution2Btn, ActionListener solution3Btn, ActionListener solution4Btn, ActionListener exitBtn) {
		frame_1.addListenerCase1(solution1Btn, solution2Btn, solution3Btn, solution4Btn, exitBtn);
	}
	
	public void addListenerCase2(ActionListener solution1Btn, ActionListener solution2Btn, ActionListener solution3Btn, ActionListener solution4Btn, ActionListener exitBtn) {
		frame_2.addListenerCase2(solution1Btn, solution2Btn, solution3Btn, solution4Btn, exitBtn);
	}
	
	public void addListenerCase3(ActionListener solution1Btn, ActionListener exitBtn) {
		frame_3.addListenerCase3(solution1Btn, exitBtn);
	}

}
