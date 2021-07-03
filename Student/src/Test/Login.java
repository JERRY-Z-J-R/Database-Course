package Test;

import java.util.Scanner;
import java.sql.*;

public class Login {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		System.out.print("数据库启动成功，");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test_zjr", "root", "245424");
		// 输入学号密码
		System.out.println("请登录");
		System.out.println("-----------------------------");
		System.out.print("学号：");
		String xh = sc.next();
		System.out.print("密码：");
		String mm = sc.next();
		System.out.println("-----------------------------");
		// 数据库查询学号密码是否正确
		String sql = "SELECT * FROM student WHERE Sno=? and Spassword=?;";
		// 直接用PrepareStatement语句，sql语句可以写在里面
		PreparedStatement sta = conn.prepareStatement(sql);
		sta.setString(1, xh); // 第一个?的内容
		sta.setString(2, mm); // 第二个?的内容
		ResultSet rs = sta.executeQuery();
		// 输出
		if (rs.next()) {
			System.out.println("登录成功，欢迎！");
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
					+ " " + rs.getString(5));
		} else {
			System.out.println("学号或密码输入不正确！");
		}
		conn.close();
	}
}
