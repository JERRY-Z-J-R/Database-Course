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

	private JLabel userNameLabel = new JLabel("学号：");
	private JTextField userNameField = new JTextField();
	private JLabel passwordLabel = new JLabel("密码：");
	private JPasswordField passwordField = new JPasswordField();
	private JLabel tipsLabel = new JLabel();
	private JButton okBtn = new JButton("登录");
	private JButton resetBtn = new JButton("重置");
	private String sno;
	private String spass;

	public LoginFrame() {
		setTitle("学生登录验证系统 - 周吉瑞");
		Font textFont = new Font("宋体", Font.BOLD, 18);
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
		// 直接用PrepareStatement语句，sql语句可以写在里面
		PreparedStatement sta = conn.prepareStatement(sql);
		sta.setString(1, sno); // 第一个?的内容
		sta.setString(2, spass); // 第二个?的内容
		ResultSet rs = sta.executeQuery();
		// 输出
		if (rs.next()) {
			tipsLabel.setText(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " "
					+ rs.getString(5));
		} else {
			tipsLabel.setText("学号或密码输入不正确！");
		}
		conn.close();
	}
}
