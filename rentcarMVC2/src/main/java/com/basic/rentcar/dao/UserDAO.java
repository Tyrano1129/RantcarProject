package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.util.DBUtil;

import combasic.rentcar.vo.User;

public class UserDAO {
	static private UserDAO instance = new UserDAO();
	static public UserDAO getInstance() {
		if(instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	private Connection conn; // db객체
	private PreparedStatement ps; // 쿼리문 객체
	private ResultSet rs; // 
	// 로그인
	public int checkLogin(String id, String pw) {
		String sql = "select * from member where id=? and pw=?";
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("no");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
	// 아이디 중복체크
	public int checkId(String id) {
		String sql = "select * from member where id=?";
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("no");
				System.out.println(cnt);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
	//비번 체크
	public int checkPw(String pw) {
		String sql = "select * from member where id=?";
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("no");
				System.out.println(cnt);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
	
	public int joinMember(String id, String pw,String email, int age,String job,String tel,String hobby,String info) {
		String sql = "insert into member values(null,?,?,?,?,?,?,?,?)";
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, email);
			ps.setString(4, tel);
			ps.setString(5, hobby);
			ps.setString(6, job);
			ps.setInt(7, age);
			ps.setString(8, info);
			cnt = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
	// 내정보 가지고오기
	public User userOneInfo(String id) {
		String sql = "select * from member where id=?";
		
		User user = null;
		
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			rs = ps.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String ids = rs.getString("id");
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String hobby = rs.getString("hobby");
				String job = rs.getString("job");
				int age = rs.getInt("age");
				String info = rs.getString("info");
				user = new User(no,ids,pw,email,tel,hobby,job,age,info);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return user;
	}
	//유저 탈퇴
	public int userOneDelete(String id) {
		String sql = "delete from member where id=?";
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			cnt = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return cnt;
	}
	// 유저 업데이트
	public int userOneUpdate(String id,String job,String tel,String email,String info,String hobby) {
		String sql = "update member set job=?,tel=?,email=?,info=?,hobby=? where id=?";
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, job);
			ps.setString(2, tel);
			ps.setString(3, email);
			ps.setString(4, info);
			ps.setString(5, hobby);
			ps.setString(6, id);
			cnt = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return cnt;
	}
}
