package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT_Test extends BaseClass {

	@Test(dataProvider="logindata",dataProviderClass=DataProviders.class)
	public void test_login_ddt(String email,String pwd,String exp)
	{
		try
		{
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.SetEmail(email);
		lp.SetPassword(pwd);
		lp.ClickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageexists();
		
		if(exp.equals("valid"))
		{
			if(targetpage==true)
			{
				macc.ClickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("invalid"))
		{
			if(targetpage==true)
			{
				macc.ClickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	
}
