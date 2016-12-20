package dao;

import java.sql.Blob;
import java.sql.Clob;

import user.Magazine;
import user.Supplier;
import user.User;

public interface SupplierDao {
	Supplier getSuplierByName(String name);
	void setSupplierDescription(String name);
	Clob getSupplierDescription(String name);
	void setSupplierImage(String name);
	Blob getSupplierImage(String name);
	void addMagazine(Supplier supName,Magazine mag);

	
	
	

}
//create table SUPPLIERS
//(SUP_ID integer NOT NULL  AUTO_INCREMENT,
//SUP_NAME varchar(255) NOT NULL,
//SUP_CITY varchar(20) NOT NULL,
//SUP_DESCRIPTION longtext NUll,
//SUP_IMAGE longblob NULL,
//PRIMARY KEY (SUP_ID));