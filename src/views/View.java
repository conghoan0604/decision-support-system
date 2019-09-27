package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame {

	private String name = "Bài toán DSS sử dụng xác suất";

	JMenuBar menuBar;
	public JMenu mnFile;
	public JMenuItem mnfNew, mnfLoad, mnfSave, mnfExit;
	JPopupMenu.Separator line1, line2;

	private JPanel null_panel;

	private JPanel main;
	private JLabel label_margin_1, label_margin_2, label_margin_3, label_margin_4;
	private JButton btnThngTinNhm, btnCase_1, btnCase_2, btnCase_3;

	private JPanel footer;
	private JPanel form;
	private JPanel label, text;
	private JLabel lblGiMua, lblGiBn, lblMtMtKhch;
	private JTextField txtGiMua, txtGiBn, txtMtMtKhch;
	private JButton btnExit;
	private JLabel lblEmpty;

	private KeyAdapter numberInput = new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
				getToolkit().beep();
				e.consume();
			}
		}
	};

	/**
	 * Create the frame.
	 */
	public View() {
		this.setTitle(name);
		this.setSize(500, 260);
		this.setLocationRelativeTo(null); // can giua man hinh
		this.setResizable(false);
		getContentPane().setLayout(new BorderLayout());

		// <MenuBar
		menuBar = new JMenuBar();
		// -----------------------------------------------------
		mnFile = new JMenu("File");

		mnfNew = new JMenuItem("New");
		line1 = new JPopupMenu.Separator();
		mnfLoad = new JMenuItem("Load...");
		mnfSave = new JMenuItem("Save");
		mnfSave.setEnabled(false);
		line2 = new JPopupMenu.Separator();
		mnfExit = new JMenuItem("Exit");

		mnFile.add(mnfNew);
		mnFile.add(line1);
		mnFile.add(mnfLoad);
		mnFile.add(mnfSave);
		mnFile.add(line2);
		mnFile.add(mnfExit);

		menuBar.add(mnFile);

		null_panel = new JPanel();
		// -----------------------------------------------------
		// getContentPane().add(menuBar, BorderLayout.PAGE_START);
		getContentPane().add(null_panel, BorderLayout.NORTH);
		// End MenuBar>

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
		btnThngTinNhm = new JButton("Thông tin nhóm");
		GridBagConstraints gbc_btnThngTinNhm = new GridBagConstraints();
		gbc_btnThngTinNhm.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnThngTinNhm.insets = new Insets(0, 0, 5, 5);
		gbc_btnThngTinNhm.gridx = 1;
		gbc_btnThngTinNhm.gridy = 0;
		main.add(btnThngTinNhm, gbc_btnThngTinNhm);
		// -----------------------------------------------------
		label_margin_2 = new JLabel(">");
		GridBagConstraints gbc_label_margin_2 = new GridBagConstraints();
		gbc_label_margin_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_margin_2.gridx = 0;
		gbc_label_margin_2.gridy = 1;
		main.add(label_margin_2, gbc_label_margin_2);
		btnCase_1 = new JButton("Trường hợp 1");
		GridBagConstraints gbc_btnCase_1 = new GridBagConstraints();
		gbc_btnCase_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnCase_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase_1.gridx = 1;
		gbc_btnCase_1.gridy = 1;
		main.add(btnCase_1, gbc_btnCase_1);
		// -----------------------------------------------------
		label_margin_3 = new JLabel(">");
		GridBagConstraints gbc_label_margin_3 = new GridBagConstraints();
		gbc_label_margin_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_margin_3.gridx = 0;
		gbc_label_margin_3.gridy = 2;
		main.add(label_margin_3, gbc_label_margin_3);
		btnCase_2 = new JButton("Trường hợp 2");
		GridBagConstraints gbc_btnCase_2 = new GridBagConstraints();
		gbc_btnCase_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnCase_2.gridx = 1;
		gbc_btnCase_2.gridy = 2;
		main.add(btnCase_2, gbc_btnCase_2);
		// -----------------------------------------------------
		label_margin_4 = new JLabel(">");
		GridBagConstraints gbc_label_margin_4 = new GridBagConstraints();
		gbc_label_margin_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_margin_4.gridx = 0;
		gbc_label_margin_4.gridy = 3;
		main.add(label_margin_4, gbc_label_margin_4);
		btnCase_3 = new JButton("Trường hợp 3");
		GridBagConstraints gbc_btnCase_3 = new GridBagConstraints();
		gbc_btnCase_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCase_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnCase_3.gridx = 1;
		gbc_btnCase_3.gridy = 3;
		main.add(btnCase_3, gbc_btnCase_3);
		// -----------------------------------------------------
		getContentPane().add(main, BorderLayout.CENTER);
		// End case>

		footer = new JPanel();
		getContentPane().add(footer, BorderLayout.SOUTH);
		GridBagLayout gbl_footer = new GridBagLayout();
		gbl_footer.columnWidths = new int[] { 0, 0 };
		gbl_footer.rowHeights = new int[] { 0, 0, 0 };
		gbl_footer.columnWeights = new double[] { 1.0, 1.0 };
		gbl_footer.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		footer.setLayout(gbl_footer);

		form = new JPanel();
		form.setBorder(BorderFactory.createTitledBorder("Dữ liệu bài toán"));
		form.setLayout(new BorderLayout(5, 0));
		GridBagConstraints gbc_form = new GridBagConstraints();
		gbc_form.insets = new Insets(0, 0, 5, 5);
		gbc_form.fill = GridBagConstraints.BOTH;
		gbc_form.gridx = 0;
		gbc_form.gridy = 0;
		footer.add(form, gbc_form);

		label = new JPanel();
		form.add(label, BorderLayout.WEST);
		label.setLayout(new GridLayout(3, 1));
		lblGiMua = new JLabel("Giá mua");
		label.add(lblGiMua);
		lblGiBn = new JLabel("Giá bán");
		label.add(lblGiBn);
		lblMtMtKhch = new JLabel("Mất một khách hàng");
		label.add(lblMtMtKhch);

		text = new JPanel();
		form.add(text, BorderLayout.CENTER);
		text.setLayout(new GridLayout(3, 1));
		txtGiMua = new JTextField();
		txtGiMua.setColumns(10);
		txtGiMua.addKeyListener(numberInput);
		text.add(txtGiMua);
		txtGiBn = new JTextField();
		txtGiBn.setColumns(10);
		txtGiBn.addKeyListener(numberInput);
		text.add(txtGiBn);
		txtMtMtKhch = new JTextField();
		txtMtMtKhch.setColumns(10);
		txtMtMtKhch.addKeyListener(numberInput);
		text.add(txtMtMtKhch);

		btnExit = new JButton("Exit");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnExit.insets = new Insets(0, 0, 5, 0);
		gbc_btnExit.gridx = 1;
		gbc_btnExit.gridy = 0;
		footer.add(btnExit, gbc_btnExit);

		lblEmpty = new JLabel("");
		GridBagConstraints gbc_lblEmpty = new GridBagConstraints();
		gbc_lblEmpty.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmpty.gridx = 2;
		gbc_lblEmpty.gridy = 0;
		footer.add(lblEmpty, gbc_lblEmpty);
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
	
	public void addListenerMainApp(ActionListener e) {
		btnThngTinNhm.addActionListener(e);
		
		btnCase_1.addActionListener(e);
		btnCase_2.addActionListener(e);
		btnCase_3.addActionListener(e);
		
		btnExit.addActionListener(e);
	}

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
}
