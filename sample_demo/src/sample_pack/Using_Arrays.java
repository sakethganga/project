package sample_pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Using_Arrays {
	   static WebDriver wd=null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//local var, global var and instance var
		
		String[] pageurl = {"https://www.seleniumhq.org/","https://www.seleniumhq.org/download/","https://www.seleniumhq.org/support/"};
	    for(int i=0;i<=4;i++)
	    {
	    	System.setProperty("webdriver.chrome.driver","E:\\selenium tools\\chrome driver\\chromedriver.exe");
	    	wd = new ChromeDriver();
			wd.get(pageurl[i]);
			Thread.sleep(5000);
			if(pageurl.equals(pageurl))
			{
				System.out.println("verified");
				
			}
			else
			{
				System.out.println("not verified");
			}
			
	    }
		}
}
