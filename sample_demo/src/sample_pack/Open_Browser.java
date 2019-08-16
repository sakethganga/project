package sample_pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open_Browser {

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
    
    System.setProperty("webdriver.chrome.driver","E:\\selenium tools\\chrome driver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.seleniumhq.org/download/");
    driver.navigate().to("https://www.seleniumhq.org/download/");
    Thread.sleep(3000);
    
    System.out.println(driver.getCurrentUrl());
    System.out.println(driver.getTitle());
    
    driver.navigate().refresh();
    driver.navigate().back();
    driver.navigate().forward();
    Thread.sleep(3000);
    driver.close();
	}

}
