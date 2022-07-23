package com.tns.client;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import com.tns.util.DBUtil;

	public class Client {
	public static void main(String[] args) throws SQLException{
			
			Connection connection =DBUtil.getconnection();
			
			//checking the connection establishment
			if(connection !=null) {
				System.out.println("JDBC: Connection is established");
			}
			
		
			addworker();
			Getworker();
		}
			//Create Operation
			private static void addworker() throws SQLException 
			{
				Connection connection =DBUtil.getconnection();
				Statement stmt = connection.createStatement();
				String sqlinsert = "insert into aish.emp2(id,name,salary,bonus)" + "values(5,'kavya',45000,900)";
				int executeupdate = stmt.executeUpdate(sqlinsert);
				if(executeupdate==1) {
					System.out.println("Entry is added");
				}
			}
			//Update Operation
			private static void Updateworker() throws SQLException 
			{
				Connection connection =DBUtil.getconnection();
				Statement stmt = connection.createStatement();
				String sqlupdate = "update worker set bonus =100.00 where emp2 id=4";
				int executeupdate = stmt.executeUpdate(sqlupdate);
				if(executeupdate==1) {
					System.out.println("Update is successfull");
				}
			}
			//Delete Operation
			private static void Deleteworker() throws SQLException 
			{
				Connection connection =DBUtil.getconnection();
				Statement stmt = connection.createStatement();
				String sqldelete = "delete from emp2 where  id =4";
				int executeupdate = stmt.executeUpdate(sqldelete);
				if(executeupdate==1) {
					System.out.println("Delete is successfull");
				}
			}
			
			//Retrieve Operation
			private static void Getworker() throws SQLException {
				Connection connection =DBUtil.getconnection();
				Statement stmt = connection.createStatement();
				String sqlretrieve="Select * from worker";
				ResultSet rs = stmt.executeQuery(sqlretrieve);
				while(rs.next()) {
					int id = rs.getInt("id");
					String name= rs.getString("name");
					Double salary = rs.getDouble("salary");
					Double bonus = rs.getDouble("bonus");
					System.out.println(id+" "+ name + " " + salary + " " + bonus);
				}
				
			}
			//RetrieveById Operation
			private static void RetrieveByIdworker() throws SQLException {
			Connection connection = DBUtil.getconnection();
			Statement stmt = connection.createStatement();
			String sqlretrieve = "select * from worker where id =3";
			ResultSet rs = stmt.executeQuery(sqlretrieve);
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Double salary = rs.getDouble("Salary");
				Double bonus = rs.getDouble("bonus");
				System.out.println(id + " " + name + " "+ salary +" "+ bonus);
			}
			else {
				System.out.println("worker is not available with the mentioned ID...");
			}
			}


	}

