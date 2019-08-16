package Java_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

			//Launching Browser and closing
				
				WebDriver wd=null;
				String pageurl = "https://www.amazon.in/";
				String pagetitle = "OrangeHRM";
			
				System.setProperty("webdriver.chrome.driver","E:\\selenium tools\\chrome driver\\chromedriver.exe");
				
				wd = new ChromeDriver();
				wd.get(pageurl);
				WebDriver driver = null;
				driver.manage().window().maximize();
				Thread.sleep(3000);
				 
					
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
				
				
				
				wd.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]")).click();
				wd.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
				Thread.sleep(3000);
				wd.findElement(By.name("email")).sendKeys("gangasaketh97@gmail.com");
				Thread.sleep(3000);
				wd.findElement(By.id("continue")).click();
				Thread.sleep(3000);
				wd.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("saki3005");
				wd.findElement(By.id("signInSubmit")).click();
				Thread.sleep(3000);
				
				
				WebElement wel =  wd.findElement(By.id("welcome"));
				if(wel.isDisplayed()){
					wel.click();
					System.out.println("Page login success");
				}
				else
					System.out.println("user login failed");
				
				wd.close();
				
			
			}

}
