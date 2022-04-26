import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectJDBC {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/bobaShops";
	
	static final String USER = "YOUR_ROOT_USER";
	static final String PASSWORD = "iAmSTRIPESbitxh418!";

	private static List<String> getRecordFromLine(String line) {
	    List<String> values = new ArrayList<String>();
	    try (Scanner rowScanner = new Scanner(line)) {
	        rowScanner.useDelimiter(",");
	        while (rowScanner.hasNext()) {
	            values.add(rowScanner.next());
	        }
	    }
	    return values;
	}
	
	public static void createTables(Connection conn) {
		
	}
	
	public static void insertEmployee(Connection conn, String filename) {
		
		// Reading from the csv file
		List<List<String>> employeeRecords = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("Employee.csv"));) {
		    while (scanner.hasNextLine()) {
		    	employeeRecords.add(getRecordFromLine(scanner.nextLine()));
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// public static void insertOrders(Connection conn, String filename) {
		
	// 	// Reading from the csv file

	// 	List<List<String>> orderRecords = new ArrayList<>();
	// 	try (Scanner scanner = new Scanner(new File("order.csv"));) {
	// 		while (scanner.hasNextLine()) {
	// 			orderRecords.add(getRecordFromLine(scanner.nextLine()));
	// 		}
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
