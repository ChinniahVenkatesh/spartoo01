package Object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeObject {
	
	public ChromeDriver driver;
	
	public HomeObject(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[@id='callNumber']")
	WebElement customerId;
	
	public WebElement customerId()
	{
		return customerId;
	}
	
	@FindBy(xpath = "//div[@class='cookies_info']/div/div[3]/button[1]")
	WebElement cookies;
	
	public WebElement cookie()
	{
		return cookies;
	}
	
	public WebElement searchBox()
	{
		By searchBox = By.xpath("//form[@class='search headerSearch']/input");
		return driver.findElement(searchBox);
		
	}
	
	@FindBy(xpath="//div[@id='completeDiv']/div/span")
	List<WebElement> searchBoxOptions;
	
	public List<WebElement> searchBoxOptions()
	{
		return searchBoxOptions;
	}
	
	public List<WebElement> navOptions()
	{
		By navOptions = By.xpath("//nav[@id='nav']/ul/li/a");
		return driver.findElements(navOptions);
	}
	
	
}
