package Test;

import java.util.Scanner;
import java.sql.*;

public class Insert {
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
			System.out.printf("请输入学生的学号：");
			String sno = sc.next();
			System.out.printf("请输入学生的姓名：");
			String sname = sc.next();
			System.out.printf("请输入学生的性别：");
			String ssex = sc.next();
			System.out.printf("请输入学生的年龄：");
			String sage = sc.next();
			System.out.printf("请输入学生的专业：");
			String smajor = sc.next();
			System.out.printf("请输入学生的密码：");
			String spass = sc.next();
			System.out.println("----------------------------------");
			String sqlstr = "insert into Student values(" + "'" + sno + "'" + "," + "'" + sname + "'" + "," + "'" + ssex
					+ "'" + "," + "'" + sage + "'" + "," + "'" + smajor + "'" + "," + "'" + spass + "'" + ")";
			stmt.executeUpdate(sqlstr);
			System.out.println("插入成功");
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		}
	}
}
