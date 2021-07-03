package Test;

import java.sql.*;

public class Select {

	// MySQL 8.0 ���°汾 - JDBC �����������ݿ� URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// MySQL ���ݿ�˿ڼ����ݿ���
	static final String DB_URL = "jdbc:mysql://localhost:3306/test_zjr";

	// ���ݿ���û���������
	static final String USER = "root";
	static final String PASS = "245424";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// ע�� JDBC ����
			Class.forName(JDBC_DRIVER);
			System.out.println("���ݿ������ɹ�");
			// ������
			// �������ݿ�...
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// ִ�в�ѯ
			// ʵ����Statement����...
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT Sno, Sname, Ssex, Sage, Smajor FROM student";
			ResultSet rs = stmt.executeQuery(sql);

			// չ����������ݿ�
			System.out.println("----------------------------------------------------------------");
			System.out.println("ѧ��" + "\t\t" + "����" + "\t" + "�Ա�" + "\t" + "����" + "\t" + "רҵ");
			System.out.println("----------------------------------------------------------------");
			while (rs.next()) {
				// ͨ���ֶμ���
				String sno = rs.getString("Sno");
				String sname = rs.getString("Sname");
				String ssex = rs.getString("Ssex");
				String sage = rs.getString("Sage");
				String smajor = rs.getString("Smajor");

				// �������
				System.out.println(sno + "\t" + sname + "\t" + ssex + "\t" + sage + "\t" + smajor);

				System.out.print("\n");
			}

			// ��ɺ�ر�
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// ���� JDBC ����
			se.printStackTrace();
		} catch (Exception e) {
			// ���� Class.forName ����
			e.printStackTrace();
		} finally {
			// �ر���Դ
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
