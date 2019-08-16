package sample_pack;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class New_TestE extends New_Test{
	public static WebDriver wd = null;
  @Test
  public void extends_method() {
	System.out.println("from extended class");
  }

}
