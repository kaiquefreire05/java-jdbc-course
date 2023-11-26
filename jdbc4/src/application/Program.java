package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn  = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			// mudando os dados do campo 'SetSalary', adicionando um valor a mais se o 'DepartmentId = ao valor que eu escolher
			st = conn.prepareStatement("DELETE FROM department WHERE (Id = ?)");
			
			st.setInt(1, 12);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
			
		} finally { 
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
