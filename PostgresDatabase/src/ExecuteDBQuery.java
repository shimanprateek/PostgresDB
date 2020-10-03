import java.util.ArrayList;
import java.util.Map;

public class ExecuteDBQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			//System.out.println("Total Records : " + ConnectDB.getCount() + "\r\n");
		    ConnectDB.getCount();
			ArrayList<Map<String, String>> data_values = ConnectDB.getValues();
			
			//System.out.println("Model : "+ data_values.get(0).get("MODEL") + " ,Price : "+ data_values.get(0).get("PRICE"));
			//System.out.println("Model : "+ data_values.get(1).get("MODEL") + " ,Price : "+ data_values.get(1).get("PRICE"));
			
		}

}
