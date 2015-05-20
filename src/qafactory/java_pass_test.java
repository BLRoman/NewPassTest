package qafactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class java_pass_test {

	WebDriver driver;
	
	String firstpass;
	String secondpass;
	String newpassone;
	String newpasstwo;
	String masterpass = "Roman123";
	String name = "Wazup321";
	
	
	
	
	@BeforeClass
	public void start_up()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Eclipse\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://angel.net/~nic/passwd.current.html");
		driver.manage().window().maximize();
		
	}
	@Test
	public void javaPassTest() throws InterruptedException
	{
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(masterpass);
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(1000);
		String firstpass = driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]/input")).getText();
		
		
		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(masterpass);
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(1000);
		String secondpass = driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]/input")).getText();
		
		Assert.assertEquals(firstpass, secondpass);
		
	}
	/*@Test			
		public void javaPassTestTwo() 
		{
		
		newpassone = firstpass.substring(14);
		newpasstwo = secondpass.substring(14);
		
		Assert.assertEquals(newpassone, newpasstwo);
	

                                             
	}
	
	*/
	
	@AfterClass
	public void shut_down()
	{
		 
		driver.quit();
	}
	
}
