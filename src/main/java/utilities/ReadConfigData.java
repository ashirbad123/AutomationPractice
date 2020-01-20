package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData {

	Properties prop;
	File file;
	FileInputStream fis;
	
	public ReadConfigData() {
		file=new File("./Configuration\\config.properties");
		try {
			fis= new FileInputStream(file);
			prop= new Properties();
			prop.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("IO Exception is resulted");
		}
		
	}
	
	public String getApplicationURL() {
		////This is to read the data from the properties file
		//return prop.getProperty("url");
		
		//To read the application url from the jenkins
		System.out.println("Application value read from jenkins is:-"+System.getProperty("url"));
		return System.getProperty("url");
	}
	
	

	public String getUsername() {
		//This is to read the data from the properties file
		//return prop.getProperty("username");
		
		//To read data from the jenkins
		System.out.println("Username value read from jenkins is:-"+System.getProperty("username"));
		return System.getProperty("username");
	}


	public String getPassword() {
		//This is to read the data from the properties file
		//return prop.getProperty("password");
		//To read the data from jenkins
		System.out.println("Password value read from jenkins is:-"+System.getProperty("password"));
		return System.getProperty("password");
	}


	public String getChromeDriverPath() {
		return prop.getProperty("chromepath");
	}


	public String getFirefoxPath() {
		return prop.getProperty("firefoxpath");
	}


	public String getIEPath() {
		return prop.getProperty("iepath");
	}

	
}
