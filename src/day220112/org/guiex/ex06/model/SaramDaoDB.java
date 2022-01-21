package day220112.org.guiex.ex06.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import day220112.org.guiex.ex06.db.JdbcUtil;

public class SaramDaoDB {

	public static final String SELECT_ALL = "SELECT * FROM USER";
	public static final String INSERT = "INSERT INTO USER (NAME, EMAIL, PHONE, GENDER) VALUES(?,?,?,?)";
	public static final String UPDATE = "UPDATE USER SET NAME =?, EMAIL =?, PHONE =?, GENDER =? WHERE ID = ?";
	public static final String DELETE = "DELETE FROM USER WHERE ID = ?";
	public static final String SELECT_ONE = "SELECT * FROM USER WHERE id = ?";
	public static final String SELECT_ByName = "SELECT * FROM USER WHERE NAME = ?";

	public static Connection conn = null;
	public static ResultSet rs = null;
	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;
	public static Vector<Vector> vector = null;

	public Vector<Vector> selectAll() {
		vector = new Vector<Vector>();
		conn = JdbcUtil.getConnection();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);

			while (rs.next()) {
				SaramDto saram = null;
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String gender = rs.getString(5);

				saram = new SaramDto(id, name, email, phone, gender);
				vector.add(saram.toVector());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					JdbcUtil.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vector;
	}
	// 이름으로 검색
	public Vector<Vector> search(SaramDto dto){
		vector = new Vector<Vector>();
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SELECT_ByName);
			pstmt.setString(1, dto.getName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String gender = rs.getString(5);
			
				SaramDto saram = new SaramDto(id, name, email, phone, gender);
				vector.add(saram.toVector());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					JdbcUtil.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vector;

	}
	// id로 검색
	public Vector selectOne(SaramDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SELECT_ONE);

			pstmt.setInt(1, dto.getIdx());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String gender = rs.getString(5);
				
				SaramDto saram = new SaramDto(id, name, email, phone, gender);
				return saram.toVector();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					JdbcUtil.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	public boolean insert(SaramDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getGender());
			int cnt = pstmt.executeUpdate();

			if (cnt == 0) {
				conn.rollback();
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					JdbcUtil.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

	public boolean delete(SaramDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, dto.getIdx());
			int cnt = pstmt.executeUpdate();

			if (cnt == 0) {
				conn.rollback();
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					JdbcUtil.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

	public boolean update(SaramDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getGender());
			pstmt.setInt(5, dto.getIdx());
			int cnt = pstmt.executeUpdate();

			if (cnt == 0) {
				conn.rollback();
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					JdbcUtil.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

}
