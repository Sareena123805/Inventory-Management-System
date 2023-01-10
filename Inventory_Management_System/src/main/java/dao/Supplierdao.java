package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DbConnection;
import model.Customer;
import model.Supplier;

public class Supplierdao {
DbConnection db = new DbConnection();

public int registerCustomerPreparedStatement(Supplier supplier) {
	try {
		String query = "insert into supplier(s_Name,s_Address," + 
				"s_Phone) values(?,?,?)";
					PreparedStatement st = db.con.prepareStatement(query);
					
					st.setString(1, supplier.getS_Name());
					st.setString(2, supplier.getS_Address());
					st.setString(3, supplier.getS_Phone());
		
		return db.manipulate(st);
		
		
	}catch(SQLException e) {
		e.printStackTrace();
		return 0;
	}
}




public List<Supplier> getAllSupplier() {
	String query;
	query = "select * from supplier";
	db = new DbConnection();
	ResultSet rs = db.retrieve(query);
	List<Supplier>lstSuppliers = new ArrayList<Supplier>();
	
	try {
		while(rs.next()) {
			Supplier supplier = new Supplier();
			supplier.setS_ID(rs.getInt("s_ID"));
			supplier.setS_Name(rs.getString("s_Name"));
			supplier.setS_Address(rs.getString("s_Address"));
			supplier.setS_Phone(rs.getString("s_Phone"));
			
			
			lstSuppliers.add(supplier);
		}
	}catch(Exception ex) {
		System.out.print("Error" + ex);
	}
	return lstSuppliers;
}
}
