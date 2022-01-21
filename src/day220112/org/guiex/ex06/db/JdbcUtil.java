package day220112.org.guiex.ex06.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtil {
	public static Connection getConnection() {
		// url : "jdbc:mariadb" >> 프로토콜
		String protocol = "jdbc:mariadb://";
		String ip = "127.0.0.1"; // db ip
		String port = "3306"; // db 포트
		String db = "user"; // db 이름  기본값 : test
		String url = String.format("%s%s:%s/%s",protocol,ip,port,db);
		String user = "root"; // userID  기본값 : root
		String password = "1234"; // password  기본값 : 1234
		
		try {
			// 클래스파일 확장자 빼야됨.
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found...");
		} catch (SQLException e) {
			System.out.println("SQL exeption ...");
		}
		return null;
	}
	
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // end of close
}
