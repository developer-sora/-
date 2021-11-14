package com.mz.like;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB ���õ� �Ÿ� �Ź� �����ڵ带 �� ���Ŀ� �۾� �ؿ�

// AOP
public class DBManager {

	// DB �۾��ÿ� ��¶�� �����ؾߵ�
	
	public static Connection connect() throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		return DriverManager.getConnection(url,"psa","psa");
		
	}

	// ������ ������ �� �� �ݱ�
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) {
			rs.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
