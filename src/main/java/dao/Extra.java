package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.JDBCUtils;

public class Extra {
	private static final String READ_DESCRIPTION_FROM_CLIENT="select DESCRIPTION from CLIENTS where C_EMAIL=? ";
	private static final String ADD_DESCRIPTION_TO_PERSON="update CLIENTS set DESCRIPTION=? where C_EMAIL=? ";
	private static final String GET_IMAGE="select IMAGE from CLIENTS where C_EMAIL=?";
	private static final String ADD_IMAGE="update  CLIENTS set IMAGE=? where C_EMAIL=?";
	private Connection conn;
	public Extra(){
		conn=JDBCUtils.getConnection1();
	}
	public void addPersonImage(String email,String file){
		
		try{
		PreparedStatement stm=conn.prepareStatement(ADD_IMAGE);
		InputStream input=new FileInputStream(file);
		stm.setBinaryStream(1, input);
		stm.setString(2, email);
		stm.executeUpdate();
		}catch(SQLException | FileNotFoundException e){
			e.getStackTrace();
		}
}
	public String writeDescriptionToFile(String email,String file){
		StringBuilder str=new StringBuilder();
		try{
		PreparedStatement stm=conn.prepareStatement(READ_DESCRIPTION_FROM_CLIENT);
		stm.setString(1, email);
		ResultSet rs=stm.executeQuery();
		File thefile=new File(file);
		FileWriter out=new FileWriter(thefile);
		while(rs.next()){
			Clob clob=rs.getClob("DESCRIPTION");
			Reader rd=clob.getCharacterStream();
			int thechar;
			while((thechar=rd.read())>0){
				out.write((char)thechar);
				str.append(thechar);
			}
		}
		}catch( SQLException | IOException e){
			e.getStackTrace();
		}
		return str.toString();
	}
	
	public void addDescriptionFromFile(String email,String file){
		try{
		PreparedStatement stm=conn.prepareStatement(ADD_DESCRIPTION_TO_PERSON);
		FileReader input=new FileReader(file);
		stm.setCharacterStream(1, input);
		stm.setString(2, email);
		stm.executeUpdate();
		}catch( SQLException | IOException e){
			e.getStackTrace();
		}
		
	}
	
	public Blob getIMage(String email,String file){
		Blob blob=null;
		try{
		PreparedStatement stm=conn.prepareStatement(GET_IMAGE);
		stm.setString(1, email);
		ResultSet rs=stm.executeQuery();
		OutputStream output=new FileOutputStream(new File(file));
		while(rs.next()){
			 blob=rs.getBlob("IMAGE");
			//output.write(rs.getBytes("IMAGE"));
			output.write(blob.getBytes(1, (int) blob.length()));
		}
		}catch(SQLException | IOException e){
			e.printStackTrace();
		}
		return blob;
		
	}

}
