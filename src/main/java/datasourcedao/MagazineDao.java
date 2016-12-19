package datasourcedao;

import java.sql.Clob;
import java.util.List;

import user.Magazine;

public interface MagazineDao {
	
	Magazine getMagazineByName(String name);
	List<Magazine> getAllMagazines(String email);
	void addMagazine(Magazine m);
	void setSuplier(Integer supId);
	void updatePrice(String name,Double price);
	Double getPrice(String name);
	void updateDescription(String name,Clob desc);
	Clob getDescription(String name);
//	void updateImage(String name);
//	Blob getImage(String name);
	
}
