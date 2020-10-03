
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 

public class ConnectDB {

	public static ArrayList<Map<String, String>>  getValues ()
	{
		System.out.println("*********************CALL TO GET VALUES*******************************");
		ArrayList<Map<String, String>> rows = new ArrayList<Map<String, String>>();
		ResultSet resultSet = null;
		Connection connection =null;
		   Statement statement = null;
		try  {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "XXXXXXX");
				 
            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within 
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//          Class.forName("org.postgresql.Driver"); 
 
            System.out.println("Connected to PostgreSQL database!");
            statement = connection.createStatement();
           // System.out.println("Reading car records...");
           // System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
            //System.out.println( "\r\n");
            String db_query = "SELECT * FROM public.cars";
            System.out.println("==============================");
            System.out.println(db_query);
            //System.out.println("==============================");
            resultSet = statement.executeQuery(db_query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
			int column_Size = rsmd.getColumnCount();
            while (resultSet.next()) {
           //     System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("model"), resultSet.getString("price"));
               
                HashMap<String, String> row = new HashMap<String, String>();
				for (int i = 1; i <= column_Size; ++i)
				{
					
					String col_Name = rsmd.getColumnName(i).toUpperCase();
					//System.out.println(col_Name);
					String db_Val = resultSet.getString(col_Name);
					//System.out.println(db_Val);
					row.put(col_Name, db_Val);
					//Reporter.addStepLog(col_Name +" : "+ db_Val);	
				}
				rows.add(row);
			//	System.out.println("Row"+" : " + row);
				
            }
 
        } /*catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }*/ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }finally
		{
			try {
				statement.close();
				resultSet.close();
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(rows);
		System.out.println("**********************************************************************" + "\r\n");
		return rows;
		
	}
	
	public static int  getCount()
	{
		System.out.println("*********************CALL TO GET ROWCOUNTS*******************************");
		 Statement statement=null;
			Connection connection =null;
			ResultSet resultSet = null;
		int count = 0;
		//ArrayList<Map<String, String>> rows = new ArrayList<Map<String, String>>();
		try  {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "XXXXXXXX");
            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within 
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//          Class.forName("org.postgresql.Driver"); 
 
            System.out.println("Connected to PostgreSQL database!");
            statement = connection.createStatement();
           // System.out.println("Reading car records...");
           // System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
            //System.out.println( "\r\n");
            String db_query = "SELECT * FROM public.cars";
            System.out.println("==============================");
            System.out.println(db_query);
            //System.out.println("==============================");
            resultSet = statement.executeQuery(db_query);
            while (resultSet.next()) {
             count ++;    	
            }
 
        } /*catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }*/ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }finally
		{
			try {
				statement.close();
				resultSet.close();
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Number of RECORDS: "+ count );
		System.out.println("**********************************************************************"+"\r\n");
		return count;
		
	}	
}
