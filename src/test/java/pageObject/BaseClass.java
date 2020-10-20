package pageObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseClass {

	public WebDriver driver;
	public GooglePage gp;
	public HomePage hp;
	public CustDetailsPage cdp;
	public static Logger logger;
	
	public void tkscrnsht() throws IOException
	{
		   String pth = "./src/test/resources/Scrnsht/image"+timer()+".png";
		   TakesScreenshot tss = ((TakesScreenshot)driver);
		   File src =  tss.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(src, new File(pth));
	}
	
	public String timer()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date curr = new Date();
		return sdf.format(curr);
	}

}
