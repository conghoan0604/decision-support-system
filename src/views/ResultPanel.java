package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ResultPanel extends JDialog {
	
	private String name = "Kết quả";

	private JPanel contentPane;
	
	private JLabel lblCasename, lblSolutionname, lblResult;
	
	private String[] caseArr = {"Ra quyết định theo không chắc chắn", "Ra quyết định với rủi ro", "Ra quyết định theo chắc chắn"};
	private String[][] solutionArr = {{"Chỉ tiêu Laplace", "Tốt trong xấu", "Chỉ tiêu Savage", "Hạng cực tiểu"}, {"Giống tương lai nhất", "Đầu ra kỳ vọng", "Cây quyết định", "Mất kỳ vọng thấp nhất"}, {"Giá trị kỳ vọng khi có đủ thông tin"}};
	private int[] N_PRODUCT = {11, 12, 13, 14};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultPanel frame = new ResultPanel();
					frame.setResult(1, 2, new int[] {1, 2, 3});
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResultPanel() {
		setTitle(name);
		setBounds(100, 100, 450, 200);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		Border title = BorderFactory.createTitledBorder("Kết quả bài toán");
		Border margin = new EmptyBorder(5, 5, 5, 5);
		panel.setBorder(new CompoundBorder(title, margin));
		contentPane.add(panel, BorderLayout.CENTER);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{392, 0};
		gbl_panel.rowHeights = new int[]{21, 21, 21, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblCasename = new JLabel("Trường hợp");
		GridBagConstraints gbc_lblCasename = new GridBagConstraints();
		gbc_lblCasename.fill = GridBagConstraints.BOTH;
		gbc_lblCasename.insets = new Insets(0, 0, 5, 0);
		gbc_lblCasename.gridx = 0;
		gbc_lblCasename.gridy = 0;
		panel.add(lblCasename, gbc_lblCasename);
		
		lblSolutionname = new JLabel("Cách giải quyết");
		GridBagConstraints gbc_lblSolutionname = new GridBagConstraints();
		gbc_lblSolutionname.fill = GridBagConstraints.BOTH;
		gbc_lblSolutionname.insets = new Insets(0, 0, 5, 0);
		gbc_lblSolutionname.gridx = 0;
		gbc_lblSolutionname.gridy = 1;
		panel.add(lblSolutionname, gbc_lblSolutionname);
		
		lblResult = new JLabel("Kết quả");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.fill = GridBagConstraints.BOTH;
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 3;
		panel.add(lblResult, gbc_lblResult);
	}
	
	public void setResult(int caseNum, int solutionNum, int[] result) {
		try {
			lblCasename.setText("Trường hợp: " + caseArr[caseNum-1]);
			lblSolutionname.setText("Cách giải quyết: " + solutionArr[caseNum-1][solutionNum-1]);
			int varSize = result.length;
			if (varSize == 0) {
				throw new Exception();
			}
			String resultText = N_PRODUCT[result[0]] + "";
			if (varSize > 1) {
				for (int i = 1; i < varSize - 1; i++) {
					resultText += ", " + N_PRODUCT[result[i]];
				}
				resultText += " hoặc " + N_PRODUCT[result[varSize-1]];
			}
			lblResult.setText("Người bán hàng sẽ mua về " + resultText + " bánh mì");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cleanResult() {
		lblCasename.setText("Trường hợp");
		lblSolutionname.setText("Cách giải quyết");
		lblResult.setText("Kết quả");
	}

}
