package Java_Test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Appln_Testing {
	

	public static WebDriver wd;
	private static XSSFWorkbook wb;

	    public static void main(String[] args) throws IOException {


	        //Data Driven Testing
	        //Data Parameterizations

	        File file = new File("C:\\Users\\ganga\\OneDrive\\Desktop\\mylogindata.xlsx");
	        FileInputStream myfile = new FileInputStream(file);
	        wb = new XSSFWorkbook(myfile);
	        XSSFSheet ws = wb.getSheetAt(0);



	        //XSSFSheet ws1 = wb.createSheet("TrainerSheet");


	        int rowcount = ws.getLastRowNum();
	        System.out.println("Total Rows are.."+rowcount);


	        for(int i=0;i<rowcount;i++){


	            System.setProperty("webdriver.chrome.driver", "E:\\selenium tools\\chrome driver\\chromedriver.exe");



	           String mypath =  ws.getRow(i).getCell(0).getStringCellValue();
	           System.out.println(mypath);


	            String username = ws.getRow(i).getCell(1).getStringCellValue();
	            System.out.println(username);

	            String password = ws.getRow(i).getCell(2).getStringCellValue();
	            System.out.println(password);

	            wd=new ChromeDriver();
	            String url = "https://www.amazon.in/";
	            String pagetitle = "Amazon";
	            wd.manage().window().maximize();
	            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            wd.navigate().to(url);

	            String myurl = wd.getCurrentUrl();
	            if(mypath.equalsIgnoreCase(myurl)){
	                //System.out.println("Verified path");
	             ws.getRow(i).createCell(4).setCellValue("pass");
	            }
	            else
	            {
	                System.out.println("not verified");
	            }



	           WebElement un =  wd.findElement(By.name("txtUsername"));
	            if(un.isDisplayed()){
	                un.sendKeys(username);
	                ws.getRow(i).createCell(5).setCellValue("username success");
	            }


	            wd.findElement(By.name("txtPassword")).sendKeys(password);




	        }
	        FileOutputStream fo = new FileOutputStream(file);
	        wb.write(fo);




	    }
	    
}




