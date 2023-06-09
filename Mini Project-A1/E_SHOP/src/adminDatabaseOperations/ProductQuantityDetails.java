package adminDatabaseOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import userDatabaseOperations.CommonConnection;

public class ProductQuantityDetails {
	
	public static void getAllProductQuantity() {
		for(int i=1;i<=10;i++) {
			getProductQuantity(i);
		}
	}
	public static void getSingleProductQuantity(int id) {
		getProductQuantity(id);
	}
	
	private static void getProductQuantity(int id) {
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from products where id=?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int Id=resultSet.getInt(1);
				String description=resultSet.getString(2);
				String name=resultSet.getString(3);
				int quantity=resultSet.getInt(4);
				int price=resultSet.getInt(5);
				
				System.out.println(Id+"] "+name+"  :  "+"["+quantity+"]");
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
