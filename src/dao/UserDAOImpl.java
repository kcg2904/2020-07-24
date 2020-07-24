package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import dto.UserDTO;

public class UserDAOImpl implements UserDAO {

	@Override
	public void insert(UserDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.condb();
			String sql = "INSERT INTO usertbl (username, mail,pw,mobile) VALUES(?, ?,?,?)";
			pstmt = conn.prepareStatement(sql);
			// 4. 데이터 binding
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getMail());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getMobile());
			
			int count = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.condb();
			String sql = "update usertbl set id=? WHERE mail = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getMail());
			// 4. 데이터 binding
			
			int count = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
