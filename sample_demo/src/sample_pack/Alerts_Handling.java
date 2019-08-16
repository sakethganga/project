package sample_pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts_Handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver wd = null;
		String myurl = "https://www.flipkart.com/?gclid=Cj0KCQjwkK_qBRD8ARIsAOteukC_5MEcnJZHiBNYJ4LFDhYt5KFM9z45f3NMD_SM0rgVuSxh5SWG87AaAsIUEALw_wcB&ef_id=Cj0KCQjwkK_qBRD8ARIsAOteukC_5MEcnJZHiBNYJ4LFDhYt5KFM9z45f3NMD_SM0rgVuSxh5SWG87AaAsIUEALw_wcB:G:s&s_kwcid=AL!739!3!376512959888!e!!g!!flipkart&semcmpid=sem_8024046704_brand_eta_goog";
	    System.setProperty("webdriver.chrome.driver","E:\\selenium tools\\chrome driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get(myurl);	
		
		wd.findElement(By.name("cusid")).sendKeys("345666");
		wd.findElement(By.name("submit")).click();
		
		
		Alert alert = wd.switchTo().alert();
		alert.accept();
		alert.dismiss();
	
		String myalert = wd.switchTo().alert().getText();
		System.out.println(myalert);
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	

}
