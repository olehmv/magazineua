package user;

import java.sql.Blob;
import java.sql.Clob;

public class Supplier {
	Integer id;
	String name;
	String city;
	Double price;
	Clob clob;
	Blob blob;
	public Supplier() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Clob getClob() {
		return clob;
	}
	public void setClob(Clob clob) {
		this.clob = clob;
	}
	public Blob getBlob() {
		return blob;
	}
	public void setBlob(Blob blob) {
		this.blob = blob;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", city=" + city + ", price=" + price + ", clob=" + clob
				+ ", blob=" + blob + "]";
	}
	

}

