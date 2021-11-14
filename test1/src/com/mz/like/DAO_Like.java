package com.mz.like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Like {

	public static String reg(Like l) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();
			String sql = "insert into menu_like values(?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, l.getName());
			pstmt.setString(2, l.getImg());

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
				return "성공";
			}
			System.out.println("등록 실패");
			return "실패";
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("에러");
			return "db 오류";
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}
	
	public static ArrayList<Like> showAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();
			String sql = "select * from menu_like";
			pstmt = con.prepareStatement(sql);
			Like l = null;

			rs = pstmt.executeQuery();
			ArrayList<Like> likes = new ArrayList<Like>();

			while (rs.next()) {
				String name = rs.getString("m_name");
				String img = rs.getString("m_img");

				l = new Like(name, img);
				likes.add(l);
			}

			return likes;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}
	
	public static String delete() {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();
			String sql = "delete from menu_like";
			pstmt = con.prepareStatement(sql);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 성공");
				return "성공";
			}
			System.out.println("삭제 실패");
			return "실패";
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("에러");
			return "db 오류";
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	
}
