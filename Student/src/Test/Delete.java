package Test;

import java.util.Scanner;
import java.sql.*;

public class Delete {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库启动成功");
		} catch (ClassNotFoundException ce) {
			System.out.println("SQLException:" + ce.getMessage());
		}
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_zjr", "root",
					"245424");
			Statement stmt = con.createStatement();
			System.out.println("----------------------------------");
			System.out.printf("请输入要删除学生的学号：");
			String sno = sc.next();
			System.out.println("----------------------------------");
			String sql = "DELETE FROM student where Sno=" + "'" + sno + "'";
			stmt.executeUpdate(sql);
			System.out.println(sno + " 删除成功");
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		}

	}
}
