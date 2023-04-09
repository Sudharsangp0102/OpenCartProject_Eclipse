package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test(groups={"Regression","Master"})
	public void test_account_Registration() throws InterruptedException
	{
		try
		{
		
		logger.debug("Debug mode...");
		logger.info("****TC_001_AccountRegistrationTest*****");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link");
		hp.clickRegister();
		logger.info("Clicked on Registered Link");
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providinng Customer data");
		
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		//regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("Clicked on Continue");
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validated expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");
		}
		catch(Exception e)
		{
		Assert.fail();
		}
		logger.info("Finished Log test");
	}
	
	
}
