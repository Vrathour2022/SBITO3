import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC - Java DATABASE connectivity
 * 
 * 					Database <-- HSQLDB
 * 						|
 * 					  Driver <-- hsqldb.jar file
 * 						|	C:\Users\PC-2\Downloads\hsqldb-2.6.1\hsqldb\lib
 * 						|
 * 					DriverManager
 * 						|	1. registerDriver - ??? org.hsqldb.jdbc.JDBCDriver
 * 						|	2. acquire the connection to the DB ?? URL jdbc:hsqldb:hsql://localhost/xdb
 * 					Connection
 * 						|
 * 			---------------------------------
 * 			|			|			|
 * 		Statement PreparedStatement CallableStatement
 * 
 * 		SELECT	INSERT/UPDATE/DELETE   PROCEDURE/FUNCTION
 * 1. load the driver
 * 2. acquire the connection
 * 3. make a desired statement
 * 4. execute the statement
 * 5. process the result if any
 * 6. close the result, close the statement, close the db
 */
public class SelectTest {

	public static void main(String[] args) {
		try
		{
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded.../registered....");
		
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Connected to the db....");
			
			Statement st = conn.createStatement();
			System.out.println("statement is created..."+st);
			
			ResultSet rs = st.executeQuery("SELECT * FROM BANK_APPLICANT");
			System.out.println("query fired...got the results....");
			
			while(rs.next()) {
				System.out.println("APPLICANT ID     : "+rs.getInt(1));
				System.out.println("APPLICANT NAME   : "+rs.getString(2));
				System.out.println("APPLICANT EMAIL  : "+rs.getString(3));
				System.out.println("APPLICANT ADDRESS: "+rs.getString(4));
				System.out.println("APPLICANT Mobile : "+rs.getString(5));
				System.out.println("APPLICANT DOB    : "+rs.getDate(6));
				System.out.println("-----------------------------");
			}
			
			rs.close();
			st.close();
			conn.close();
			System.out.println("DisConnected from the db....");
			
		}
		catch(SQLException e) {
			System.out.println("Some problem : "+e);
		}
		
	}

}






interface Account {
	Vehicle withdraw(Movie m);
}
class Savings implements Account {
	public Vehicle withdraw(Movie m) {
		Vehicle  v= new Car();
		return v;
	}
}
interface Vehicle {
	void drive() ;
}
class Car implements Vehicle {
	public void drive() {
		
	}
}
interface Movie {
	void watch();
}
class HindiMovie implements Movie {
	public void watch() {
		
	}
}
class Test {
	void testing() {
		Vehicle v       = VehicleFactory.getVehicle();
	//	Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
		
	}
}
















class VehicleFactory
{
	static Vehicle getVehicle() {
		Account a = new Savings();
		Movie m = new HindiMovie();
		Vehicle v = a.withdraw(m);
		return v;
	}
}









