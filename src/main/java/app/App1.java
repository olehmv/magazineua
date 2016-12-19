package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

import datasourcedao.SupplierDao;
import datasourcedao.SupplierDaoImpl;
import user.Supplier;

public class App1 {

	public static void main(String[] args) throws IOException, SQLException {
		
		SupplierDao dao=new SupplierDaoImpl();
		Supplier sup=dao.getSuplierByName("B");
		
		System.out.println(sup.getId());
		//dao.addMagazine(dao.getSuplierByName("B"), new Magazine("Box",180.50));
		System.out.println(sup);
		Clob clob=sup.getClob();
		Reader reader=clob.getCharacterStream();
		int i=reader.read();
		while(i>0){
			System.out.print(i);
		}
		reader.close();
	}
	

}
