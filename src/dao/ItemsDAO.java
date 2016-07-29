package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBHelper;

import java.sql.*;

import entity.Item;

//商品的业务逻辑类
public class ItemsDAO {
	//获取所有商品信息
	public ArrayList<Item> getAllItems(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Item> list = new ArrayList<Item>();
		
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				list.add(item);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally{
			if(rs!=null){
				try {
					rs.close();
					rs=null;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
					stmt=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	//根据商品编号获取商品资料
	public Item getItemById(int id){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()){
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				return item;
			}else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(rs!=null){
					rs.close();
					rs = null;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				if(stmt!=null){
					stmt.close();
					stmt = null;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
	//获取最近浏览的前五条商品信息
	public ArrayList<Item> getViewList(String list){
		System.out.println("list"+list);
		ArrayList<Item> itemList = new ArrayList<Item>();
		int iCount = 5;
		if(list!=null&&list.length()>0){
			String[] arr = list.split(",");
			System.out.println("arr.length="+arr.length);
			if(arr.length>=5){
				for(int i=arr.length-1;i>arr.length-iCount-1;i--){
					itemList.add(getItemById(Integer.parseInt(arr[i])));
				}
			}else {
				for(int i=arr.length-1;i>=0;i--){
					itemList.add(getItemById(Integer.parseInt(arr[i])));
				}
			}
			return itemList;
		}
		else {
			return null;
		}
	}
	
	
	
	
	
	
	
}
