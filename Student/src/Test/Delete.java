package Test;

import java.util.Scanner;
import java.sql.*;

public class Delete {
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
			System.out.printf("������Ҫɾ��ѧ����ѧ�ţ�");
			String sno = sc.next();
			System.out.println("----------------------------------");
			String sql = "DELETE FROM student where Sno=" + "'" + sno + "'";
			stmt.executeUpdate(sql);
			System.out.println(sno + " ɾ���ɹ�");
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		}

	}
}
