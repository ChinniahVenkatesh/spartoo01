package TestScript;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import CommonUtils.CommonMethods;
import Object.HomeObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class HomePage {
	
	
	public ChromeDriver driver;
	public Logger log = LogManager.getLogger(HomePage.class);

	
	
	@Test(priority=0)
	public void cookies() throws IOException
	{
		driver = new ChromeDriver();
		CommonMethods cm = new CommonMethods();
		driver.get(cm.getProperty("Homeurl"));
		driver.manage().window().maximize();
		HomeObject ho = new HomeObject(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		ho.cookie().click();
		String title = driver.getTitle();
		Assert.assertEquals(title,"SPARTOO| Shoes, bags and clothes | Free Delivery");
	}
	@Test(priority=1)
	public void Header() throws IOException, InterruptedException
	{
		HomeObject ho = new HomeObject(driver);
		CommonMethods cm = new CommonMethods();
		String customerId [] = ho.customerId().getAttribute("href").split(":");
		Assert.assertEquals(customerId[1],cm.getProperty("customernumber") );
		List<String> searchBox = cm.searchData();
		System.out.println(searchBox.size());
		for(String searchText:searchBox)
		{
			System.out.println(searchText);
			ho.searchBox().sendKeys(searchText);
			Thread.sleep(10000);
			List<WebElement> options = ho.searchBoxOptions();
			for(WebElement option : options)
			{
				System.out.println(option.getText());
			}	
			
			ho.searchBox().clear();
		}
		
	}
	
	@Test(priority = 2)
	public  void navOptions()
	{
		HomeObject ho = new HomeObject(driver);
		List<WebElement> Navoptions = ho.navOptions();
		for(WebElement navOption : Navoptions)
		{
			System.out.println(navOption.getText());
		}
	}
	
	@Test(priority = 3)
	public void carousel() throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scroll(0,3000)");
		List<WebElement> carousel =  driver.findElements(By.xpath("//div[@class='home_op_bg']/div[2]/div[@id='carousel_8']/div"));
		int size = carousel.size();
		 
		 for(int i = 1 ; i < size ; i++)
		 {
			List<WebElement> productName = driver.findElements(By.xpath("//div[@class='home_op_bg']/div[2]/div[@id='carousel_8']/div["+i+"]/a[2]"));
			 for(WebElement name : productName)
			 {
				 System.out.println(name.getText());
				 List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='home_op_bg']/div[2]/div[@id='carousel_8']/div[1]/a[4]"));
				 for(WebElement price : productPrice)
				 {
					 System.out.println(price.getText());
				 }
				 
				// productPrice.stream().map(s -> s.getText()).forEach(s -> System.out.println(s));
			 }
			 if(i == 6 || i == 9 || i == 12)
			 {
				 int step = 0;
					while(step < 2)
					{
					driver.findElement(By.cssSelector("div[class='home_carousel 8'] i[class='icon-flecheDroite suiv']")).click(); 
					step++;
					}
					Thread.sleep(10000);
			 }
		 }
	 
	}
}
