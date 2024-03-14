package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test
	public void test_login()
	{
		try
		{
		logger.info("Starting TC_002_LoginTest");
		
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.SetEmail(rb.getString("email"));
		lp.SetPassword(rb.getString("password"));
		lp.ClickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageexists();
		Assert.assertEquals(targetpage, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished TC_002_LoginTest..");
	}

}
