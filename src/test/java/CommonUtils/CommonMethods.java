package CommonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CommonMethods {
	
	public Properties p;
	FileInputStream fis;
	
	public String getProperty(String data) throws IOException
	{
		p = new Properties();
		String path = "C:\\Users\\chinn\\jan2023\\Spartoo\\src\\test\\java\\TestData\\HomePage.properties";
		fis = new FileInputStream(path);
		p.load(fis);
		return p.getProperty(data);
	}

	
	public List<String> searchData()
	{
		ArrayList<String> searchProducts = new ArrayList<String>();
		searchProducts.add("shoes");
		searchProducts.add("puma");
		return searchProducts;
			
	}
}
