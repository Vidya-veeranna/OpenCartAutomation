package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
Properties pro;

	public ConfigDataProvider(){
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream file = new FileInputStream(src);
			pro = new Properties();
			pro.load(file);
		}catch(Exception e){
			System.out.println("Cannot load a file" + e.getMessage());
		}	
	}
	
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	
	public String getURL() {
		return pro.getProperty("testurl");
	}
	

}
