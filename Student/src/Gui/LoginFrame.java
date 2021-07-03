package Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
	public static void main(String[] args) {
		new LoginFrame();
	}

	private JLabel userNameLabel = new JLabel("ѧ�ţ�");
	private JTextField userNameField = new JTextField();
	private JLabel passwordLabel = new JLabel("���룺");
	private JPasswordField passwordField = new JPasswordField();
	private JLabel tipsLabel = new JLabel();
	private JButton okBtn = new JButton("��¼");
	private JButton resetBtn = new JButton("����");
	private String sno;
	private String spass;

	public LoginFrame() {
		setTitle("ѧ����¼��֤ϵͳ - �ܼ���");
		Font textFont = new Font("����", Font.BOLD, 18);
		userNameLabel.setFont(textFont);
		passwordLabel.setFont(textFont);
		setBounds(100, 100, 360, 250);
		setLayout(null);
		userNameLabel.setBounds(50, 30, 200, 40);
		add(userNameLabel);
		userNameField.setBounds(100, 35, 200, 30);
		add(userNameField);
		passwordLabel.setBounds(50, 70, 200, 40);
		add(passwordLabel);
		passwordField.setBounds(100, 75, 200, 30);
		add(passwordField);
		okBtn.setBounds(50, 125, 100, 20);
		add(okBtn);
		okBtn.addActionListener(this);
		resetBtn.setBounds(200, 125, 100, 20);
		add(resetBtn);
		resetBtn.addActionListener(this);
		tipsLabel.setBounds(50, 170, 500, 20);
		add(tipsLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == okBtn) {
			sno = userNameField.getText();
			spass = new String(passwordField.getPassword());
			try {
				db();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == resetBtn) {
			userNameField.setText("");
			passwordField.setText("");
			tipsLabel.setText("");
		}
	}

	public void db() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test_zjr", "root", "245424");
		String sql = "SELECT * FROM student WHERE Sno=? and Spassword=?;";
		// ֱ����PrepareStatement��䣬sql������д������
		PreparedStatement sta = conn.prepareStatement(sql);
		sta.setString(1, sno); // ��һ��?������
		sta.setString(2, spass); // �ڶ���?������
		ResultSet rs = sta.executeQuery();
		// ���
		if (rs.next()) {
			tipsLabel.setText(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " "
					+ rs.getString(5));
		} else {
			tipsLabel.setText("ѧ�Ż��������벻��ȷ��");
		}
		conn.close();
	}
}
