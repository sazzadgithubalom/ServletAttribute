package com.alom.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alom.model.Employee;

public class EmployeeDao {
	Connection conn;
	PreparedStatement pst ;
	ResultSet rs;
	public EmployeeDao() throws ClassNotFoundException, IOException, SQLException {
		conn = MyConnection.getConnection();
	}
	
	public int addRecord(Employee employee) throws SQLException {
		pst = conn.prepareStatement("insert into user1 values(?,?)");
		pst.setString(1, employee.getUserName());
		pst.setString(2, employee.getUserPassword());
		return pst.executeUpdate();
	}
	
	public Employee findRecord(Employee emp) throws SQLException {
		pst = conn.prepareStatement("select * from user1 where userName=?");
		pst.setString(1, emp.getUserName());
		rs = pst.executeQuery();
		Employee employee =new Employee();
		while(rs.next()) {
			employee.setUserName(rs.getString(1));  
			employee.setUserPassword(rs.getString(2));
			
		}
		return employee;
	}
	public List findAllRecord() throws SQLException {
		pst = conn.prepareStatement("select * from user1");
		rs = pst.executeQuery();
		List< Employee> list = new ArrayList<Employee>();
		while(rs.next()) {
			Employee emp =new Employee();
			emp.setUserName(rs.getString(1));  
			emp.setUserPassword(rs.getString(2));
			list.add(emp);
			
		}
		return list;
	}
	
	
	
	
}
