package views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GroupInfoPanel extends JDialog {

	private String name = "Thông tin nhóm";

	private JPanel null_panel_1, panel, footer;
	
	private JPanel panel_1, panel_2, panel_3, panel_4;
	private JLabel lblname_1, lblname_2, lblname_3, lblname_4;
	
	private JLabel picDung, picHoan, picMinh, picQuang;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupInfoPanel frame = new GroupInfoPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static JLabel pictureLabel(String dir) {
		BufferedImage picture = null;
		try {
			picture = ImageIO.read(new File(dir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				picture = ImageIO.read(new File("images/noavatar.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JLabel picLabel = new JLabel(new ImageIcon(picture));
		return picLabel;
	}

	/**
	 * Create the frame.
	 */
	public GroupInfoPanel() {
		this.setTitle(name);
		this.setSize(520, 690);
		this.setLocationRelativeTo(null); // can giua man hinh
		this.setResizable(false);
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(5);
		getContentPane().setLayout(borderLayout);
		
		null_panel_1 = new JPanel();
		getContentPane().add(null_panel_1, BorderLayout.NORTH);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 10, 10));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 5));
		picQuang = pictureLabel("images/quang.jpg");
		panel_1.add(picQuang, BorderLayout.CENTER);
		lblname_1 = new JLabel("Đặng Nhật Quang");
		lblname_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblname_1, BorderLayout.SOUTH);
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 5));
		picDung = pictureLabel("images/dung.jpg");
		panel_2.add(picDung, BorderLayout.CENTER);
		lblname_2 = new JLabel("Huỳnh Minh Dũng");
		lblname_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblname_2, BorderLayout.SOUTH);
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 5));
		picHoan = pictureLabel("images/hoan.jpg");
		panel_3.add(picHoan, BorderLayout.CENTER);
		lblname_3 = new JLabel("Ngô Công Hoan");
		lblname_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblname_3, BorderLayout.SOUTH);
		
		panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 5));
		picMinh = pictureLabel("images/minh.jpg");
		panel_4.add(picMinh, BorderLayout.CENTER);
		lblname_4 = new JLabel("Nguyễn Thọ Công Minh");
		lblname_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblname_4, BorderLayout.SOUTH);
		
		footer = new JPanel();
		footer.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BorderLayout());
		btnExit = new JButton("Exit");
		footer.add(btnExit, BorderLayout.EAST);
	}
	
	public void addListenerInfo(ActionListener exitBtn) {
		btnExit.addActionListener(exitBtn);
	}

}
