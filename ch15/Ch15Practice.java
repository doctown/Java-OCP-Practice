/**
 * Introduction to database principles. Implementing a database using JDBC.
 */
package ch15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ch15Practice {
	public static void main(String[] args) {
		Connection conn = null;
		
		

		try {
			conn =
			   DriverManager.getConnection("jdbc:mysql://db.iac.gatech.edu/" +
										   "user=SampleDB@localhost&password=nPaguVSr");
	java.sql.Connection conn2 = java.sql.DriverManager.getConnection(
        "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};" + 
        "DBQ=C:\\temp\\access.mdb;DriverID=22;READONLY=true", "", ""
    );
			// Do something with the Connection		   
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}	
}