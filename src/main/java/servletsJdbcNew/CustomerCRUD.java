package servletsJdbcNew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerCRUD {
	
	public Connection getConnection() throws ClassNotFoundException, Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://locahost/servlet?user=root&password=root");
		
		
	}
	
	public int signUp(Customer customer) throws Exception {
	
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("Insert into customer(id,name,phone,email,password)values(?,?,?,?,?)");
		
		preparedStatement.setInt(1, customer.getId());
		preparedStatement.setString(2, customer.getName());
		preparedStatement.setLong(3, customer.getPhone());
		preparedStatement.setString(4, customer.getEmail());
		preparedStatement.setString(5, customer.getPassword());
	
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
		
	}

}
