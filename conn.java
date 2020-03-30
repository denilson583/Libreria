/**
 * conn
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class conn {

    public static void main(String[] args){

        System.out.println("hola java");
        try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:db2.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connected to the database");
				conn.close();
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

    }
    public void Connect() {
        
    }
}