package sample_pack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class New_Test {
	
	public static WebDriver wd = null;
  @Test(priority=1)
  public void f() {
	  
	  wd.findElement(By.xpath("//*[@name=\"txtUsername\"]")).sendKeys("Admin");
	  wd.findElement(By.xpath("//*[@name=\"txtPassword\"]")).sendKeys("admin123");
	  wd.findElement(By.xpath("//*[@id = \"btnLogin\"]")).click();
	  
  }
  @BeforeTest
  public void beforeTest() {
  
	  System.setProperty("webdriver.chrome.driver","E:\\selenium tools\\chrome driver\\chromedriver.exe");
	  wd = new ChromeDriver();
	  wd.get("https://opensource-demo.orangehrmlive.com/");
	  wd.manage().window().maximize();
	  try {
		  Thread.sleep(2000);
	  }
	  catch (InterruptedException e) {
		  e.printStackTrace();
	  }
  }
  

  @AfterTest
  public void afterTest() {
	  wd.close();
  }

}

