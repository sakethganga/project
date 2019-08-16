package Appln_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;


public class Excel_Login {
	WebDriver wd=null;
	public static void main(String[] args) throws Throwable  {
				WebDriver driver;
				String url = "https://wiki.perficient.com/confluence/login.action?os_destination=%2Fhomepage.action";
				System.setProperty("webdriver.chrome.driver", "E:\\selenium tools\\chrome driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			
				String data = "C:\\\\Users\\\\ganga\\\\OneDrive\\\\Desktop\\\\mylogindata.xlsx";
				FileInputStream file = new FileInputStream(data);
				XSSFWorkbook wb = new XSSFWorkbook(file);
				XSSFSheet wc = wb.getSheet("Sheet1");
				
				//int rowscount = wc.getLastRowNum();
				
				
				driver.get(url);
				for(int row=0;row<=wc.getLastRowNum();row++){
					
					
					
				String username = wc.getRow(row).getCell(0).getStringCellValue();
				
				//driver.get(username);
				
				driver.findElement(By.name("os_username")).sendKeys(username);
				
				String password = wc.getRow(row).getCell(1).getStringCellValue();
				driver.findElement(By.name("os_password")).sendKeys(password);
				//Checkbox
				
				driver.findElement(By.name("login")).click();
				
				WebElement wel =  driver.findElement(By.xpath("//*[@id=\"login-container\"]/div/p/em"));
				if(wel.isDisplayed()){
					
					System.out.println(wel.getText());
					wc.getRow(row).createCell(2).setCellValue(wel.getText());
				}
				else
					System.out.println("user login failed");
				
				
				String msg = driver.findElement(By.cssSelector("#login-container > div > p > em")).getText();
				wc.getRow(row).createCell(2).setCellValue(msg);
				
				driver.navigate().refresh();
				Thread.sleep(3000);
				driver.findElement(By.name("os_username")).clear();
				driver.findElement(By.name("os_password")).clear();
				
				//System.out.println(msg);
				}
				FileOutputStream fo = new FileOutputStream("C:\\Users\\ganga\\OneDrive\\Desktop\\mylogindata.xlsx");
				wb.write(fo);
				wb.close();
				driver.quit();
			}
	
	
		}
