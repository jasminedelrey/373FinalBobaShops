import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.sql.Date;    

import org.hibernate.query.criteria.internal.expression.function.LengthFunction;

public class ConnectingJDBC {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/bobaShops";
	
	static final String USER = "root";
	static final String PASSWORD = "iAmSTRIPESbitxh418!"; //REPLACE WITH YOUR PASSWORD
	
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

	public static void createTables(Connection conn) throws SQLException {
		// create the menu and order table in jdbc_example
		
		System.out.println("Creating boba table...");

		Statement statement = conn.createStatement();
		// construct the sql statement in a string
		String createEmployeeSql = "CREATE TABLE if not exists Employee(\n"
				+ "\n"
				+ "	emp_id int not null,\n"
				+ "	address varchar(100) not null,\n"
				+ "	email varchar(100) not null,\n"
				+ "	home_store_id varchar(100) not null,\n"
				+ "	name varchar(100) not null,\n"
				+ "	phone varchar(100) not null,\n"
				+ "	primary key(emp_id),\n"
				+ "Foreign Key(home_store_id) references Store(store_id));\n";
		String createBobaSql = "CREATE TABLE if not exists Boba(\n"
				+ "\n"
				+ "	boba_id varchar(100) not null,\n"
				+ "	name varchar(100) not null,\n"
				+ "	price decimal(3, 1) not null,\n"
				+ "	review decimal(3, 1) not null,\n"
				+ "	primary key(boba_id));\n";

		String createInventorySql = "CREATE TABLE if not exists Inventory(\n"
				+ "\n"
				+ "	store_id varchar(100) not null,\n"
				+ "	ingredient_id int not null,\n"
				+ "	quantity int,\n"
				+ "	primary key(ingredient_id),\n"
				+ "	foreign key(store_id) references store(store_id),\n"
				+ "	foreign key(ingredient_id) references recipe(ingredent_id));\n";
		String createMemberSql = "CREATE TABLE if not exists Member(\n"
				+ "\n"
				+ "	member_id varchar(100) not null,\n"
				+ "	name varchar(100) NOT NULL,\n"
				+ "	phone varchar(100) NOT NULL,\n"
				+ "	email varchar(100) NOT NULL,\n"
				+ "	address varchar(100) NOT NULL,\n"
				+ "	year_init int not null,\n"
				+ "	month_init int not null,\n"
				+ "	day_init int not null,\n"
				+ "	primary key(member_id));\n";
		String createPurchaseSql = "CREATE TABLE if not exists Purchase(\n"
				+ "\n"
				+ "	purchase_id varchar(100) not null,\n"
				+ "	year int not null,\n"
				+ "	month int not null,\n"
				+ "	day int not null,\n"
				+ "	boba_id int not null,\n"
				+ "	quantity int not null,\n"
				+ "	price decimal(5,2) not null,\n"
				+ "	isMember boolean not null,\n"
				+ "	member_id int,\n"
				+ "	store_id varchar(100) not null,\n"
				+ "	primary key(purchase_id),\n"
				+ "	foreign key(member_id) references member(member_id));\n";
		String createRecipeSql = "CREATE TABLE if not exists Recipe(\n"
				+ "\n"
				+ "	store_id varchar(100) not null,\n"
				+ "	ingredient_id int not null,\n"
				+ "	boba_id int not null,\n"
				+ "	primary key(boba_id),\n"
				+ "	foreign key(boba_id) references boba(boba_id),\n"
				+ "	foreign key(store_id) references store(store_id));\n";
		String createStoreSql = "CREATE TABLE if not exists Store(\n"
				+ "\n"
				+ "	store_id varchar(100) not null,\n"
				+ "	name varchar(100) not null,\n"
				+ "	rating decimal(3,1) not null,\n"
				+ "	address varchar(100) not null,\n"
				+ "	city varchar(100) not null,\n"
				+ "	primary key(store_id));\n";
		String createShipmentSql = "CREATE TABLE if not exists Shipment(\n"
				+ "\n"
				+ "	order_id varchar(100) not null,\n"
				+ "	request_id int not null,\n"
				+ "	shipment_number int not null,\n"
				+ "	ingredient_id int not null,\n"
				+ "	quantity int not null,\n"
				+ "	store_id varchar(100) not null,\n"
				+ " price decimal(8,2) not null,\n"
				+ "	date_arrival DATE not null,\n"
				+ "	date_request DATE not null,\n"
				+ "	primary key(order_id),\n"
				+ "	foreign key(ingredient_id) references inventory(ingredient_id),\n"
				+ "	foreign key(store_id) references store(store_id));\n";
				
		statement.execute(createEmployeeSql);
		// statement.execute(createBobaSql);
		// statement.execute(createInventorySql);
		// statement.execute(createMemberSql);
		// statement.execute(createPurchaseSql);
		// statement.execute(createRecipeSql);
		// statement.execute(createStoreSql);
		// statement.execute(createShipmentSql);
		
	}
	
	
	public static void insertEmployee(Connection conn, String filename) {

		PreparedStatement statement = null;
		String insertSql = " INSERT into employee (emp_id, address, email, home_store_id, name, phone) values (?, ?, ?, ?, ?, ?)";
		// Reading from the csv file
		List<List<String>> employeeRecords = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("Employee.csv"));) {
		    while (scanner.hasNextLine()) {
				List<String> currentRecord = getRecordFromLine(scanner.nextLine());
		    	employeeRecords.add(currentRecord);
				System.out.println(currentRecord.get(1));

				try {
					statement = conn.prepareStatement(insertSql);
					// setXXX() methods to set the values of these ?
					statement.setInt(1, Integer.parseInt(currentRecord.get(0)));
					statement.setString(2, currentRecord.get(1));
					statement.setString(3,currentRecord.get(2));
					statement.setString(4, currentRecord.get(3));
					statement.setString(5, currentRecord.get(4));
					statement.setString(6, currentRecord.get(5));
					System.out.println(statement);
					statement.executeUpdate();
					// to execute the statememt,
					// executeQuery() -> return a ResultSet
					// executeUpdate() -> to update the database without returning a ResultSet
									// instead, it returns an integer that tells us how many records in the 
									// database were affected
					
				}catch (SQLException ex) {
					ex.printStackTrace();
				}

		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static void insertBoba(Connection conn, String filename) {

		PreparedStatement statement = null;
		String insertSql = " INSERT into boba (boba_id, name, price, review) values (?, ?, ?, ?)";
		// Reading from the csv file
		List<List<String>> bobaRecords = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("Boba.csv"));) {
		    while (scanner.hasNextLine()) {
				List<String> currentRecord = getRecordFromLine(scanner.nextLine());
		    	bobaRecords.add(currentRecord);
				System.out.println(currentRecord.get(1));

				try {
					statement = conn.prepareStatement(insertSql);
					// setXXX() methods to set the values of these ?
					statement.setString(1, currentRecord.get(0));
					statement.setString(2, currentRecord.get(1));
					statement.setFloat(3, Float.parseFloat(currentRecord.get(2)));
					statement.setFloat(4, Float.parseFloat(currentRecord.get(3)));
					System.out.println(statement);
					statement.executeUpdate();
					// to execute the statememt,
					// executeQuery() -> return a ResultSet
					// executeUpdate() -> to update the database without returning a ResultSet
									// instead, it returns an integer that tells us how many records in the 
									// database were affected
					
				}catch (SQLException ex) {
					ex.printStackTrace();
				}

		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static void insertInventory(Connection conn, String filename) {

		PreparedStatement statement = null;
		String insertSql = " INSERT into inventory (store_id, ingredient_id, quantity) values (?, ?, ?)";
		// Reading from the csv file
		List<List<String>> inventoryRecords = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("Inventory.csv"));) {
		    while (scanner.hasNextLine()) {
				List<String> currentRecord = getRecordFromLine(scanner.nextLine());
		    	inventoryRecords.add(currentRecord);
				System.out.println(currentRecord.get(1));

				try {
					statement = conn.prepareStatement(insertSql);
					// setXXX() methods to set the values of these ?
					statement.setString(1, currentRecord.get(0));
					statement.setInt(2, Integer.parseInt(currentRecord.get(1)));
					statement.setInt(3, Integer.parseInt(currentRecord.get(2)));
					System.out.println(statement);
					statement.executeUpdate();
					// to execute the statememt,
					// executeQuery() -> return a ResultSet
					// executeUpdate() -> to update the database without returning a ResultSet
									// instead, it returns an integer that tells us how many records in the 
									// database were affected
					
				}catch (SQLException ex) {
					ex.printStackTrace();
				}

		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static void insertMember(Connection conn, String filename) {

		PreparedStatement statement = null;
		String insertSql = " INSERT into member (member_id, name, phone, email, address, year_init, month_init, day_init) values (?, ?, ?, ?, ?, ?, ?, ?)";
		// Reading from the csv file
		List<List<String>> memberRecords = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("Member.csv"));) {
		    while (scanner.hasNextLine()) {
				List<String> currentRecord = getRecordFromLine(scanner.nextLine());
		    	memberRecords.add(currentRecord);
				System.out.println(currentRecord);

				try {
					statement = conn.prepareStatement(insertSql);
					// setXXX() methods to set the values of these ?
					statement.setString(1, currentRecord.get(0));
					statement.setString(2, currentRecord.get(1));
					statement.setString(3, currentRecord.get(2));
					statement.setString(4, currentRecord.get(3));
					statement.setString(5, currentRecord.get(4));
					statement.setInt(6, Integer.parseInt(currentRecord.get(5)));
					statement.setInt(7, Integer.parseInt(currentRecord.get(6)));
					statement.setInt(8, Integer.parseInt(currentRecord.get(7)));
					System.out.println(statement);
					statement.executeUpdate();
					// to execute the statememt,
					// executeQuery() -> return a ResultSet
					// executeUpdate() -> to update the database without returning a ResultSet
									// instead, it returns an integer that tells us how many records in the 
									// database were affected
					
				}catch (SQLException ex) {
					ex.printStackTrace();
				}

		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static void insertPurchase(Connection conn, String filename) {

		PreparedStatement statement = null;
		String insertSql = " INSERT into purchase (purchase_id, year, month, day, boba_id, quantity, price, isMember, store_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// Reading from the csv file
		List<List<String>> purchaseRecords = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("Purchase.csv"));) {
		    while (scanner.hasNextLine()) {
				List<String> currentRecord = getRecordFromLine(scanner.nextLine());
		    	purchaseRecords.add(currentRecord);
				System.out.println(currentRecord);

				try {
					statement = conn.prepareStatement(insertSql);
					// setXXX() methods to set the values of these ?
					statement.setString(1, currentRecord.get(0));
					statement.setInt(2, Integer.parseInt(currentRecord.get(1)));
					statement.setInt(3, Integer.parseInt(currentRecord.get(2)));
					statement.setInt(4, Integer.parseInt(currentRecord.get(3)));
					statement.setInt(5, Integer.parseInt(currentRecord.get(4)));
					statement.setInt(6, Integer.parseInt(currentRecord.get(5)));
					statement.setFloat(7, Float.parseFloat(currentRecord.get(6)));
					statement.setBoolean(8, Boolean.parseBoolean(currentRecord.get(7)));
					statement.setString(9, currentRecord.get(8));
					System.out.println(statement);
					statement.executeUpdate();
					// to execute the statememt,
					// executeQuery() -> return a ResultSet
					// executeUpdate() -> to update the database without returning a ResultSet
									// instead, it returns an integer that tells us how many records in the 
									// database were affected
					
				}catch (SQLException ex) {
					ex.printStackTrace();
				}

		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static void insertRecipe(Connection conn, String filename) {

		PreparedStatement statement = null;
		String insertSql = " INSERT into recipe (store_id, ingredient_id, boba_id) values (?, ?, ?)";
		// Reading from the csv file
		List<List<String>> recipeRecords = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("Recipe.csv"));) {
		    while (scanner.hasNextLine()) {
				List<String> currentRecord = getRecordFromLine(scanner.nextLine());
		    	recipeRecords.add(currentRecord);
				System.out.println(currentRecord);

				try {
					statement = conn.prepareStatement(insertSql);
					// setXXX() methods to set the values of these ?
					statement.setString(1, currentRecord.get(0));
					statement.setInt(2, Integer.parseInt(currentRecord.get(1)));
					statement.setInt(3, Integer.parseInt(currentRecord.get(2)));
					System.out.println(statement);
					statement.executeUpdate();
					// to execute the statememt,
					// executeQuery() -> return a ResultSet
					// executeUpdate() -> to update the database without returning a ResultSet
									// instead, it returns an integer that tells us how many records in the 
									// database were affected
					
				}catch (SQLException ex) {
					ex.printStackTrace();
				}

		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static void insertStore(Connection conn, String filename) {

		PreparedStatement statement = null;
		String insertSql = " INSERT into store (store_id, name, rating, address, city) values (?, ?, ?, ?, ?)";
		// Reading from the csv file
		List<List<String>> storeRecords = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("Store.csv"));) {
		    while (scanner.hasNextLine()) {
				List<String> currentRecord = getRecordFromLine(scanner.nextLine());
		    	storeRecords.add(currentRecord);
				System.out.println(currentRecord);

				try {
					statement = conn.prepareStatement(insertSql);
					// setXXX() methods to set the values of these ?
					statement.setString(1, currentRecord.get(0));
					statement.setString(2, currentRecord.get(1));
					statement.setFloat(3, Float.parseFloat(currentRecord.get(2)));
					statement.setString(4, currentRecord.get(3));
					statement.setString(5, currentRecord.get(4));
					System.out.println(statement);
					statement.executeUpdate();
					// to execute the statememt,
					// executeQuery() -> return a ResultSet
					// executeUpdate() -> to update the database without returning a ResultSet
									// instead, it returns an integer that tells us how many records in the 
									// database were affected
					
				}catch (SQLException ex) {
					ex.printStackTrace();
				}

		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static void insertShipment(Connection conn, String filename) {

		PreparedStatement statement = null;
		String insertSql = " INSERT into shipment (order_id, request_id, shipment_number, ingredient_id, quantity, store_id, price, date_arrival, date_request) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// Reading from the csv file
		List<List<String>> shipmentRecords = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("Shipment.csv"));) {
		    while (scanner.hasNextLine()) {
				List<String> currentRecord = getRecordFromLine(scanner.nextLine());
		    	shipmentRecords.add(currentRecord);
				System.out.println(currentRecord);

				try {
					statement = conn.prepareStatement(insertSql);
					// setXXX() methods to set the values of these ?
					Date date1 = Date.valueOf(currentRecord.get(7)); 
					Date date2 = Date.valueOf(currentRecord.get(8)); 

					statement.setString(1, currentRecord.get(0));
					statement.setInt(2, Integer.parseInt(currentRecord.get(1)));
					statement.setInt(3, Integer.parseInt(currentRecord.get(2)));
					statement.setInt(4, Integer.parseInt(currentRecord.get(3)));
					statement.setInt(5, Integer.parseInt(currentRecord.get(4)));
					statement.setString(6, currentRecord.get(5));
					statement.setFloat(7, Float.parseFloat(currentRecord.get(6)));
					statement.setDate(8, date1);
					statement.setDate(9, date2);
					System.out.println(statement);
					statement.executeUpdate();
					// to execute the statememt,
					// executeQuery() -> return a ResultSet
					// executeUpdate() -> to update the database without returning a ResultSet
									// instead, it returns an integer that tells us how many records in the 
									// database were affected
					
				}catch (SQLException ex) {
					ex.printStackTrace();
				}

		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		// open a connection
		// execute a query -> constructed with String concatenation
		try {
			System.out.println("Connecting to database ...");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			createTables(conn);
			insertEmployee(conn, "Employee.csv");
			// insertBoba(conn, "Boba.csv");
			// insertInventory(conn, "Inventory.csv");
			// insertMember(conn, "Member.csv");
			// insertPurchase(conn, "Purchase.csv");
			// insertRecipe(conn, "Recipe.csv");
			// insertStore(conn, "Store.csv");
			// insertShipment(conn, "Shipment.csv");
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}

}
