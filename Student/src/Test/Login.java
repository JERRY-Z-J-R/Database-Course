package Test;

import java.util.Scanner;
import java.sql.*;

public class Login {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		System.out.print("���ݿ������ɹ���");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test_zjr", "root", "245424");
		// ����ѧ������
		System.out.println("���¼");
		System.out.println("-----------------------------");
		System.out.print("ѧ�ţ�");
		String xh = sc.next();
		System.out.print("���룺");
		String mm = sc.next();
		System.out.println("-----------------------------");
		// ���ݿ��ѯѧ�������Ƿ���ȷ
		String sql = "SELECT * FROM student WHERE Sno=? and Spassword=?;";
		// ֱ����PrepareStatement��䣬sql������д������
		PreparedStatement sta = conn.prepareStatement(sql);
		sta.setString(1, xh); // ��һ��?������
		sta.setString(2, mm); // �ڶ���?������
		ResultSet rs = sta.executeQuery();
		// ���
		if (rs.next()) {
			System.out.println("��¼�ɹ�����ӭ��");
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
					+ " " + rs.getString(5));
		} else {
			System.out.println("ѧ�Ż��������벻��ȷ��");
		}
		conn.close();
	}
}
