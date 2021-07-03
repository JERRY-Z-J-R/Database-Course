package Test;

import java.sql.*;

public class Select {

	// MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// MySQL 数据库端口及数据库名
	static final String DB_URL = "jdbc:mysql://localhost:3306/test_zjr";

	// 数据库的用户名与密码
	static final String USER = "root";
	static final String PASS = "245424";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 注册 JDBC 驱动
			Class.forName(JDBC_DRIVER);
			System.out.println("数据库启动成功");
			// 打开链接
			// 连接数据库...
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
			// 实例化Statement对象...
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT Sno, Sname, Ssex, Sage, Smajor FROM student";
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			System.out.println("----------------------------------------------------------------");
			System.out.println("学号" + "\t\t" + "姓名" + "\t" + "性别" + "\t" + "年龄" + "\t" + "专业");
			System.out.println("----------------------------------------------------------------");
			while (rs.next()) {
				// 通过字段检索
				String sno = rs.getString("Sno");
				String sname = rs.getString("Sname");
				String ssex = rs.getString("Ssex");
				String sage = rs.getString("Sage");
				String smajor = rs.getString("Smajor");

				// 输出数据
				System.out.println(sno + "\t" + sname + "\t" + ssex + "\t" + sage + "\t" + smajor);

				System.out.print("\n");
			}

			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
