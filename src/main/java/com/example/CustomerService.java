package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

//	String url = "jdbc:mysql://localhost:3306/banking_app";
//	String user = "root";
//	String pswd = "Ramu@9988";
	
	@Autowired
	CustomerRepository repo;
	


	
	public String saveCustomer(Customer c) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "insert into customer values (?,?,?)";
//			PreparedStatement st = con.prepareStatement(query);
//			st.setInt(1, c.getId());
//			st.setString(2, c.getName());
//			st.setDouble(3, c.getAge());
//			st.executeUpdate();
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		repo.save(c);
		return "accont saved "+c.getId()+ " "+c.getName()+" "+c.getAge(); 
		
	}
	
	public List<Customer> getCustomer() {
//		List<Customer> li = new ArrayList<>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "select * from customer";
//			PreparedStatement st = con.prepareStatement(query);
//			ResultSet rs = st.executeQuery();
//			while(rs.next()) {
//				//System.out.println(rs.getInt(1)+" -> "+rs.getString(2)+" -> "+rs.getString(3));
//				Customer p = new Customer();
//				p.setId(rs.getInt(1));
//				p.setName(rs.getString(2));
//				p.setAge(rs.getInt(3));
//				
//				li.add(p);
//			}
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		return li;
		
		return repo.findAll();
	}
	
	public String updateCustomer(Integer id, Customer c) {
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "update customer set name=?, age=? where id=?";
//			PreparedStatement st = con.prepareStatement(query);
//			
//			st.setString(1, c.getName());
//			st.setInt(2, c.getAge());
//			st.setInt(3, c.getId());
//			st.executeUpdate();
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Customer c1 = repo.findById(id).orElseThrow();
		c.setId(id);
		if(c.getName().equals(null)) {
			c.setName(c1.getName());
		}
		if(c.getAge()==0) {
			c.setAge(c1.getAge());
		}
		repo.save(c);
			
		return "updated successfully "+c.getName()+" -> "+c.getAge();
	
	}
	
	public String deleteCustomer(int id) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "delete from customer where id = ?";
//			PreparedStatement st = con.prepareStatement(query);
//			st.setInt(1,id);
//			
//			
//			st.executeUpdate();
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		repo.deleteById(id);
		return "deleted successfully";
	}
}
