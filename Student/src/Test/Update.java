package Test;

import java.util.Scanner;
import java.sql.*;

public class Update {
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
			System.out.printf("������Ҫ�޸�ѧ����ѧ�ţ�");
			String sno = sc.next();
			System.out.println("----------------------------------");
			System.out.printf("�������µ�������");
			String sname = sc.next();
			System.out.printf("�������µ����䣺");
			String sage = sc.next();
			System.out.printf("�������µ�רҵ��");
			String smajor = sc.next();
			System.out.printf("�������µ����룺");
			String spass = sc.next();
			System.out.println("----------------------------------");
			String sql = "update student set Sname=" + "'" + sname + "'" + ",Sage=" + "'" + sage + "'" + ",Smajor="
					+ "'" + smajor + "'" + ",Spassword=" + "'" + spass + "'" + " WHERE Sno=" + "'" + sno + "'";
			stmt.executeUpdate(sql);
			System.out.println(sno + " �޸ĳɹ�");
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		}

	}
}
