package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage{
	
	public AccountRegistration(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']")WebElement txtLastname;
	@FindBy(xpath="//input[@id='input-email']")WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-password']")WebElement txtPassword;
	@FindBy(xpath="//input[@name='agree']")WebElement chkPolicy;
	@FindBy(xpath="//button[normalize-space()='Continue']")WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgConfirmation;

	public void SetFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	public void SetLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	public void SetEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void SetPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void SetPrivacyPolicy()
	{
		chkPolicy.click();
	}
	public void ClickContinue()
	{
		btnContinue.click();
	}
	
	
	public String getConfirmationmsg()
	{
		try
		{
		return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
}
