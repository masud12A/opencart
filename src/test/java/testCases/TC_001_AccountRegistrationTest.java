package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void test_account_Registration()
	{
		try
		{
			
		HomePage hp=new HomePage(driver);
		logger.info("Starting TC_001_AccountRegistrationTest...");
		hp.ClickMyAccount();
		logger.info("Clicked on Myaccout...");
		hp.ClickRegister();
		logger.info("Clicked on Register..");

		AccountRegistration reg=new AccountRegistration(driver);
		logger.info("Providing customer details..");
		reg.SetFirstName(randomString());
		reg.SetLastName(randomString());
		reg.SetEmail(randomString()+"@gmail.com");
		reg.SetPassword(randomAlphaNumeric());
		reg.SetPrivacyPolicy();
		reg.ClickContinue();
		
		String Confmsg=reg.getConfirmationmsg();
		Assert.assertEquals(Confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished TC_001_AccountRegistrationTest...");
	}

}
