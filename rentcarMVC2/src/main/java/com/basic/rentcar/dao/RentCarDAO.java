package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.util.DBUtil;

import combasic.rentcar.vo.Rentcar;

public class RentCarDAO {

	static private RentCarDAO instance = new RentCarDAO();

	static public RentCarDAO getInstance() {
		if (instance == null) {
			instance = new RentCarDAO();
		}
		return instance;
	}

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// car 전체 List
	public ArrayList<Rentcar> getCarList() {
		String sql = "select * from rentcar";
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int totalQty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");

				Rentcar car = new Rentcar(num, name, category, price, usepeople, totalQty, company, img, info);
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps, rs);
		}

		return list;
	}

	public ArrayList<Rentcar> carListCategroy(int categroy) {
		String sql = "";
		if(categroy == 4) {
			sql = "select * from rentcar order by no desc limit 3";
		}else {
			sql = "select * from rentcar where category=?";
		}
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			if(categroy != 4) {
				ps.setInt(1, categroy);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int totalQty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");

				Rentcar car = new Rentcar(num, name, category, price, usepeople, totalQty, company, img, info);
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps, rs);
		}

		return list;
	}

	// 한개의 차량 정보
	public Rentcar getCarInfo(int no) {
		String sql = "select * from rentcar where no=?";
		Rentcar car = null;

		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				int num = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int totalQty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");

				car = new Rentcar(num, name, category, price, usepeople, totalQty, company, img, info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return car;
	}

	public int carReservateCntDown(int qty, int no) {
		String sql = "update rentcar set total_qty = total_qty - ? where no=?";
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qty);
			ps.setInt(2, no);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}

	public Rentcar getCarUserList(int no) {
		String sql = "select * from rentcar where no=?";
		Rentcar car = null;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				int num = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int totalQty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");
				car = new Rentcar(num, name, category, price, usepeople, totalQty, company, img, info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return car;
	}
	// 유저의 예약한 카트가 삭제될때 차수량도 증가
	public int resDeleteCntUp(int no, int qty) {
		String sql = "update rentcar set total_qty = total_qty + ? where no = ?";
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,qty);
			ps.setInt(2, no);
			cnt = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
	// car 추가
	public int carInsert(Rentcar r) {
		String sql = "insert into rentcar values(null,?,?,?,?,?,?,?,?)";
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1,r.getName());
			ps.setInt(2,r.getCategory());
			ps.setInt(3,r.getPrice());
			ps.setInt(4,r.getUsepeople());
			ps.setInt(5,r.getTotalQty());
			ps.setString(6,r.getCompany());
			ps.setString(7, r.getImg());
			ps.setString(8, r.getInfo());
			cnt = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return cnt;
	}
}
