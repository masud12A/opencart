package testBase;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	static public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br)
	{
		logger=LogManager.getLogger(this.getClass());
		rb=ResourceBundle.getBundle("Config");
		
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appurl"));
		driver.manage().window().maximize();
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
	public String randomNumber()
	{
		String generatedString2=RandomStringUtils.randomNumeric(10);
		return(generatedString2);
	}
	public String randomAlphaNumeric()
	{
		String st=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		
		return(st+"@"+num);
	}
	public String captureScreen(String tname) throws IOException
	{
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		String trg=System.getProperty("user.dir")+"\\screenshots\\"+timestamp+tname+"_"+".png";
		
		try
		{
		FileUtils.copyFile(src, new File(trg));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return trg;
		
	}

}
