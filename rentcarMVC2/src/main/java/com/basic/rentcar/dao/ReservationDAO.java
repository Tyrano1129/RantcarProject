package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.util.DBUtil;

import combasic.rentcar.vo.Resevation;

public class ReservationDAO {
	
	private static ReservationDAO instance = new ReservationDAO();
	public static ReservationDAO getinstance() {
		if(instance == null) {
			instance = new ReservationDAO();
		}
		return instance;
	}
	
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public int carReservate(int no,String id,int qty,int dday,String rday,int usein,int usewifi,int usenavi,int useseat) {
		String sql = "insert into carreserve values(null,?,?,?,?,?,?,?,?,?)";
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,no);
			ps.setString(2,id);
			ps.setInt(3,qty);
			ps.setInt(4,dday);
			ps.setString(5,rday);
			ps.setInt(6,usein);
			ps.setInt(7,usewifi);
			ps.setInt(8,usenavi);
			ps.setInt(9,useseat);
			cnt = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
	
	public ArrayList<Resevation> getUserReserveList(String id) {
		String sql = "select * from carreserve where id=?";
		ArrayList<Resevation> list = new ArrayList<Resevation>();
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int reseveSeq = rs.getInt("reserve_seq");
				int no = rs.getInt("no");
				String ids = rs.getString("id");
				int qty = rs.getInt("qty");
				int dday = rs.getInt("dday");
				String rday = rs.getString("rday");
				int usein = rs.getInt("usein");
				int usewifi = rs.getInt("usewifi");
				int usenavi = rs.getInt("usenavi");
				int useseat = rs.getInt("useseat");
				
				Resevation rese = new Resevation(reseveSeq, no, ids, qty, dday, rday, usein, usewifi, usenavi, useseat);
				list.add(rese);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return list;
	}
	// 유저가 예약한 랜트 삭제
	public int deleteRes(int reserveSeq, String id) {
		String sql = "delete from carreserve where reserve_seq=? and id=?";
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,reserveSeq);
			ps.setString(2, id);
			cnt = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
}
