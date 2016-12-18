package user;

import java.sql.Blob;
import java.sql.Clob;

public class Magazine {
	String name;
	Integer supId;
	String city;
	Double price;
	Integer sales;
	Clob description;
	Blob image;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSupId() {
		return supId;
	}
	public void setSupId(Integer supId) {
		this.supId = supId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Clob getDescription() {
		return description;
	}
	public void setDescription(Clob description) {
		this.description = description;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
	public Magazine(String name,Double price){
		this.name=name;
		this.price=price;
	}
	public Magazine() {
		super();
	}
	

}
//create table MAGAZINE
//(M_NAME varchar(255) NOT NULL,
//SUP_ID integer  NULL,
//M_CITY varchar(255) NOT NUll,
//M_PRICE numeric(10,2) NOT NULL,
//M_SALES integer,
//M_DESCRIPTION longtext,
//M_IMAGE longblob NULL,
//PRIMARY KEY (M_NAME),
//FOREIGN KEY (SUP_ID) REFERENCES SUPPLIERS (SUP_ID)ON DELETE CASCADE);
