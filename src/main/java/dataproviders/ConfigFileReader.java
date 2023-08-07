package dataproviders;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ConfigFileReader {
	public static Properties properties;
	public static String propertyFilePath= (System.getProperty("user.dir")+"/Configs/Configuration.properties");
	static ConfigFileReader config;


	public ConfigFileReader() throws IOException{
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}	
		finally {
			if (reader!=null) {

				reader.close();
			}

		}

	}



	public static  String userName() throws IOException {
		config = new ConfigFileReader();
		String username = properties.getProperty("USERNAME");
		if(username != null) 
			return username;
		else throw new RuntimeException("username not specified in the Configuration.properties file.");
	}
	public static String userPassword() throws IOException {
		config = new ConfigFileReader();
		String password = properties.getProperty("PASSWORD");
		if(password != null) return password;
		else throw new RuntimeException("PASSWORD not specified in the Configuration.properties file.");
	}
	public static String sellNowQty() throws IOException {
		config = new ConfigFileReader();
		String sellQty = properties.getProperty("SELLNOW_QTY");
		if(sellQty != null) return sellQty;
		else throw new RuntimeException("SellNowQunatity not specified in the Configuration.properties file.");
	}
	public static String sellLaterQty() throws IOException {
		config = new ConfigFileReader();
		String sellLaterQty = properties.getProperty("SELLLATER_QTY");
		if(sellLaterQty != null) return sellLaterQty;
		else throw new RuntimeException("SellLaterQuantity not specified in the Configuration.properties file.");
	}
	public static String remarks() throws IOException {
		config = new ConfigFileReader();
		String remarks = properties.getProperty("REMARKS");
		if(remarks != null) return remarks;
		else throw new RuntimeException("REMARKS not specified in the Configuration.properties file.");
	}



}



