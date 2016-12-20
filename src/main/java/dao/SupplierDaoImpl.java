package dao;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.JDBCUtils;
import user.Magazine;
import user.Supplier;
import user.User;

public class SupplierDaoImpl implements SupplierDao {
	private static final String ADD_MAGAZINE="insert into MAGAZINE (M_NAME,SUP_ID,M_CITY,M_PRICE,M_DESCRIPTION,M_IMAGE"
	+ ") value (?,?,?,?,?,?)";
	private static final String GET_SUPP="select * from SUPPLIERS where SUP_NAME=?";
	private Connection conn;
	public SupplierDaoImpl(){
		conn=JDBCUtils.getConnection1();
	}
	@Override
	public void addMagazine(Supplier sup, Magazine mag) {
		try {
			PreparedStatement stm=conn.prepareStatement(ADD_MAGAZINE);
			stm.setString(1,mag.getName());
			stm.setInt(2,sup.getId());

			stm.setString(3, sup.getCity());

			stm.setDouble(4, mag.getPrice());
			stm.setClob(5, mag.getDescription());
			stm.setBlob(6, sup.getBlob());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Supplier getSuplierByName(String name) {
		Supplier sup=null;
		try {
			PreparedStatement stm=conn.prepareStatement(GET_SUPP);
			stm.setString(1, name);
			ResultSet rs=stm.executeQuery();
			 sup=new Supplier();
			while(rs.next()){
				sup.setId(rs.getInt("SUP_ID"));
				sup.setName(rs.getString("SUP_NAME"));
				sup.setCity(rs.getString("SUP_CITY"));
				sup.setPrice(rs.getDouble("SUP_PRICE"));
				sup.setClob(rs.getClob("SUP_DESCRIPTION"));
				sup.setBlob(rs.getBlob("SUP_IMAGE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sup;
	}
	

	
//	 (M_NAME varchar(255) NOT NULL,
//			  SUP_ID integer  NULL,
//			  M_CITY varchar(255) NOT NUll,
//			  M_PRICE numeric(10,2) NOT NULL,
//			  M_SALES integer,
//			  M_DESCRIPTION longtext,
//			  M_IMAGE longblob NULL,
//			  PRIMARY KEY (M_NAME),
//			  FOREIGN KEY (SUP_ID) REFERENCES SUPPLIERS (SUP_ID)ON DELETE CASCADE);

	
	
	@Override
	public void setSupplierDescription(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Clob getSupplierDescription(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSupplierImage(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Blob getSupplierImage(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
