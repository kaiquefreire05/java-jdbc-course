package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn  = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			// mudando os dados do campo 'SetSalary', adicionando um valor a mais se o 'DepartmentId = ao valor que eu escolher
			st = conn.prepareStatement("UPDATE seller SET BaseSalary = BaseSalary + ? WHERE (DepartmentId = ?)");
			
			st.setDouble(1, 200.0);
			st.setInt(2, 2); // vou mudar apenas o departamento que tem o código 2
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally { 
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
