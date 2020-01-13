package com.AutomationPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

	public class EndToEndFlow extends TestBase {

	//public WebDriver driver;
	/*@BeforeTest
    public void setUp() {
	System.setProperty("webdriver.chrome.driver","D:\\Eclipse\\Workspace\\AutomationPractice\\DriverExecutables\\chromedriver.exe");	
	driver=new ChromeDriver();		
	//driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://automationpractice.com/index.php");
	}*/

	//This function is to perform login function.
	@Test(priority = 1)
	public void signIn() throws InterruptedException{
	driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("email")).sendKeys(username);
	Thread.sleep(1500);
	driver.findElement(By.id("passwd")).sendKeys(password);
	Thread.sleep(1500);
	driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
	Thread.sleep(1500);
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

	



}
