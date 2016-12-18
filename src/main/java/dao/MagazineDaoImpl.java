package dao;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connection.JDBCUtils;
import user.Magazine;

public class MagazineDaoImpl implements MagazineDao {
	private static final String FIND_MAGAZINE_BY_NAME = "select * from MAGAZINE where M_NAME=? ";
	private Connection conn;
	public MagazineDaoImpl(){
		conn=JDBCUtils.getConnection1();
	}

	@Override
	public Magazine getMagazineByName(String name) {
		ResultSet rs = null;
		Magazine mag = null;
		PreparedStatement stm=null;
		conn=JDBCUtils.getConnection1();
		try{
			 stm=conn.prepareStatement(FIND_MAGAZINE_BY_NAME);
			 stm.setString(1, name);
			  rs=stm.executeQuery();
			  if(rs!=null){
				mag=new Magazine();
			while(rs.next()){
				mag.setName(rs.getString("M_NAME"));
				mag.setSupId(rs.getInt("SUP_ID"));
				mag.setCity(rs.getString("M_CITY"));
				mag.setPrice(rs.getDouble("M_PRICE"));
				mag.setSales(rs.getInt("M_SALES"));
				mag.setDescription(rs.getClob("M_DESCRIPTION"));
				mag.setImage(rs.getBlob("M_IMAGE"));
			}
			  }
			} catch (SQLException e) {
			e.printStackTrace();
			}
		return mag;
	}

	@Override
	public List<Magazine> getAllMagazines(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMagazine(Magazine m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSuplier(Integer supId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePrice(String name, Double price) {
		// TODO Auto-generated method stub

	}

	@Override
	public Double getPrice(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDescription(String name, Clob desc) {
		// TODO Auto-generated method stub

	}

	@Override
	public Clob getDescription(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
