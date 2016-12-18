package app;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.NamingException;


import connection.JDBCUtils;
import dao.UserDao;
import dao.UserDaoImpl;
import user.User;

public class App {
public static void main(String []ar) throws SQLException, NamingException, IOException{
//	JDBCUtils conn=new JDBCUtils("root","oleg");
//	DataSource d=conn.lookUpConnection("jdbc/magazine");
//	Connection c=d.getConnection("oleg","oleg");
//     PreparedStatement pstmt;
//     try {
//         c.setAutoCommit(false);
//         pstmt =c.prepareStatement(sql);
//         pstmt.executeUpdate();
//         c.commit();
//         pstmt.close();
//
//     } finally {
//         if (c != null) c.close();
//     }

	
	
	UserDao dao= new UserDaoImpl();
	//dao.addDescriptionFromFile("o@gmail.com","src\\main\\resources\\desc.txt");
	//dao.addPersonImage("o@gmail.com","src\\main\\resources\\cat.jpg");
	//dao.getIMage("o@gmail.com", "cat2.jpg");
	//String s=dao.writeDescriptionToFile("o@gmail.com", "desc1.txt");
	//System.out.println(s);
	List list=dao.getAllusers();
	System.out.println(list.get(0).toString());
//	JDBCUtils util=new JDBCUtils();
//	Connection conn=util.getConnection1();	
//	Statement  stm=conn.createStatement();
//	stm.addBatch(sql);
//	stm.addBatch(sql1);
//	stm.addBatch(sql2);
//	stm.executeBatch();
//	
	
	
	
	
 }
	
	
	

static String sql=
"create table SUPPLIERS"
+"(SUP_ID integer NOT NULL  AUTO_INCREMENT,"
+"SUP_NAME varchar(255) NOT NULL,"
+"CITY varchar(20) NOT NULL,"
+ "DESCRIPTION longtext,"
+ "IMAGE longblob NULL,"
+"PRIMARY KEY (SUP_ID));";

static String sql1="create table MAGAZINE"
+"(M_NAME varchar(255) NOT NULL,"
+"SUP_ID integer NOT NULL,"
+"PRICE numeric(10,2) NOT NULL,"
+"SALES integer NOT NULL,"
+ "DESCRIPTION longtext,"
+ "IMAGE longblob NULL,"
+"PRIMARY KEY (M_NAME),"
+"FOREIGN KEY (SUP_ID) REFERENCES SUPPLIERS (SUP_ID));";



static String sql2="create table CLIENTS"
+"(C_ID integer NOT NULL AUTO_INCREMENT,"
+"C_NAME varchar(40) NOT NULL,"
+"C_CITY varchar(20) NOT NULL,"
+"C_EMAIL varchar(255) NOT NULL,"
+"C_PASS VARCHAR(255) NOT NULL,"
+"C_MAGAZINE varchar(255),"
+"INVOICE numeric(10,2),"
+ "DESCRIPTION longtext,"
+ "IMAGE longblob NULL,"
+"PRIMARY KEY (C_ID),"
+"FOREIGN KEY (C_MAGAZINE) REFERENCES MAGAZINE (M_NAME));";







}
