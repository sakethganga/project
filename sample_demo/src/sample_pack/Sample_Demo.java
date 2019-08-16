package sample_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample_Demo {

	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub

	//Launching Browser and closing
		
		WebDriver wd=null;
		String pageurl = "https://opensource-demo.orangehrmlive.com/";
		String pagetitle = "OrangeHRM";
	
		System.setProperty("webdriver.chrome.driver","E:\\selenium tools\\chrome driver\\chromedriver.exe");
		
		wd = new ChromeDriver();
		wd.get(pageurl);
		Thread.sleep(5000);
		 
			
		String purl = wd.getCurrentUrl();
		
		if(pageurl.equalsIgnoreCase(purl)){
			System.out.println("URL path is verified");
		}
		else
		{
			System.out.println("Does not verified");
		}
		
		
		String ptitle = wd.getTitle();
		if(ptitle.equalsIgnoreCase(pagetitle)){
			System.out.println("Title verified");
		}
		else
		{
			System.out.println("Does not verified");
		}
		
		
		wd.findElement(By.name("txtUsername")).sendKeys("Admin");
		wd.findElement(By.name("txtPassword")).sendKeys("admin123");
		wd.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(5000);
		
		
		WebElement wel =  wd.findElement(By.id("welcome"));
		if(wel.isDisplayed()){
			wel.click();
			System.out.println("Page login success");
		}
		else
			System.out.println("user login failed");
		
		
		
		Thread.sleep(3000);
		wd.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[3]/a")).click();
		Thread.sleep(3000);
		wd.close();
		
	
	}

}
