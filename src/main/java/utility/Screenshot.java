package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	public static void takeScreenShot(WebDriver driver, String name) throws IOException
	{
		
		TakesScreenshot sc = ((TakesScreenshot)driver);//upcast driver to TakesScreenshot
		File Source = sc.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\SachinPG\\eclipse-workspace\\kiteZerodha\\screenshot\\"+name+".jpg");

		FileHandler.copy(Source, destination);
				
		
	}
	
}


