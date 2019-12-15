package com.AutomationPractice;


	import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

	import javax.xml.xpath.XPath;

	import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

import junit.framework.Assert;

	public class EndToEndFlow {

	WebDriver driver;
	@BeforeTest
    public void setUp() {
	System.setProperty("webdriver.chrome.driver","D:\\Eclipse\\Workspace\\AutomationPractice\\DriverExecutables\\chromedriver.exe");	
	driver=new ChromeDriver();		
	//driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://automationpractice.com/index.php");
	}

	//This function is to perform login function.
	@Test(priority = 1)
	public void signIn() throws InterruptedException{
	driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("email")).sendKeys("ashirbad@gmail.com");
	Thread.sleep(1500);
	driver.findElement(By.id("passwd")).sendKeys("ashirbad@gmail.com");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
	Thread.sleep(1500);
	}

	//Click on T-Shirt, add the t-shirt to cart and verify the "product successfully added to shopping cart message".
	@Test(priority = 2)
	public void workflow() throws InterruptedException{
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]")).click();
	Thread.sleep(2000);
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"))).click().build().perform();
	Thread.sleep(3000);
	driver.switchTo().frame(0);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
	String text = driver.findElement(By.xpath("//*[@id='layer_cart']/div/div/h2")).getText();
	System.out.println(text);
	Assert.assertEquals("Product successfully added to your shopping cart", text);
	System.out.println("product addition successful");
	//After addition of the item to the cart we can Proceed to checkout.
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();

	}

	@AfterTest
	public void afterTest() throws InterruptedException{

	Thread.sleep(3000);
	//driver.close();
	}



}
