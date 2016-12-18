package app;

import dao.SupplierDao;
import dao.SupplierDaoImpl;
import user.Magazine;

public class App1 {

	public static void main(String[] args) {
		SupplierDao dao=new SupplierDaoImpl();
		dao.addMagazine(dao.getSuplierByName("A"), new Magazine("ABBA",150.50));
	}

}
