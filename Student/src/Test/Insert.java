package Test;

import java.util.Scanner;
import java.sql.*;

public class Insert {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���ݿ������ɹ�");
		} catch (ClassNotFoundException ce) {
			System.out.println("SQLException:" + ce.getMessage());
		}
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_zjr", "root",
					"245424");
			Statement stmt = con.createStatement();
			System.out.println("----------------------------------");
			System.out.printf("������ѧ����ѧ�ţ�");
			String sno = sc.next();
			System.out.printf("������ѧ����������");
			String sname = sc.next();
			System.out.printf("������ѧ�����Ա�");
			String ssex = sc.next();
			System.out.printf("������ѧ�������䣺");
			String sage = sc.next();
			System.out.printf("������ѧ����רҵ��");
			String smajor = sc.next();
			System.out.printf("������ѧ�������룺");
			String spass = sc.next();
			System.out.println("----------------------------------");
			String sqlstr = "insert into Student values(" + "'" + sno + "'" + "," + "'" + sname + "'" + "," + "'" + ssex
					+ "'" + "," + "'" + sage + "'" + "," + "'" + smajor + "'" + "," + "'" + spass + "'" + ")";
			stmt.executeUpdate(sqlstr);
			System.out.println("����ɹ�");
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		}
	}
}
