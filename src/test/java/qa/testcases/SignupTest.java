package qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import qa.base.Base;
import qa.pages.SignupPage;
import qa.utils.Utilities;

public class SignupTest extends Base {
	
	SignupPage signupPage;
	
	
	public SignupTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));	
		signupPage = new SignupPage(driver);
		signupPage.goSignUpField();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	@Test(priority=1)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() throws InterruptedException {
		signupPage.EmptyCredintialsFields();
		Thread.sleep(2000);
		Assert.assertTrue((signupPage.displayStatusOfWarningMessages(dataProp.getProperty("namesWarning"),dataProp.getProperty("emailWarning"),dataProp.getProperty("countryWarning"),
				dataProp.getProperty("accountTypeWarning"), dataProp.getProperty("passwordWarning"), dataProp.getProperty("cofirmPasswordWarning"), dataProp.getProperty("termsWarning"))));
				
	}
	@Test(priority=2)
	public void verifyRegisteringAccountWithALlField() throws InterruptedException {
		signupPage.signUpUsingValidInfo(dataProp.getProperty("firstName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("password"), dataProp.getProperty("confirmPassword"));
		Thread.sleep(2000);
		Assert.assertEquals(signupPage.retrieveAccountSuccessHeading(),dataProp.getProperty("accountSuccesHeading"),"Account Success page is not displayed");
	}
	@Test(priority=3)
	public void verifyRegisteringAccountWithALlFieldForStudent() throws InterruptedException {
		signupPage.signUpUsingValidInfoForStudent(dataProp.getProperty("firstName"), Utilities.generateEmailWithTimeStamp(),dataProp.getProperty("institutionName"), dataProp.getProperty("password"), dataProp.getProperty("confirmPassword"));
		Thread.sleep(2000);
		Assert.assertEquals(signupPage.retrieveAccountSuccessHeading(),dataProp.getProperty("accountSuccesHeading"),"Account Success page is not displayed");
	}
	@Test(priority=4)
	public void verifyRegisteringAccountWithALlFieldForEmploy() throws InterruptedException {
		signupPage.signUpUsingValidInfoForStudent(dataProp.getProperty("firstName"), Utilities.generateEmailWithTimeStamp(),dataProp.getProperty("organizationName"), dataProp.getProperty("password"), dataProp.getProperty("confirmPassword"));
		Thread.sleep(2000);
		Assert.assertEquals(signupPage.retrieveAccountSuccessHeading(),dataProp.getProperty("accountSuccesHeading"),"Account Success page is not displayed");
	}
	@Test(priority=5)
	public void verifyRegisteringAccountWithoutTryDifferentPassword() throws InterruptedException {
		signupPage.signUpUsingDifferentPassword(dataProp.getProperty("firstName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("password"), dataProp.getProperty("invalidconfirmPassword"));
		Thread.sleep(2000);
		Assert.assertEquals(signupPage.retrieveDifferentPasswordHeading(),dataProp.getProperty("differentPasswordWarningHeading"),"Email Warrning is not displayed");
	}
	@Test(priority=5)
	public void verifyRegisteringAccountWithoutTryDifferentPasswordFailCase() throws InterruptedException {
		signupPage.signUpUsingDifferentPassword(dataProp.getProperty("firstName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("password"), dataProp.getProperty("invalidconfirmPassword"));
		Thread.sleep(2000);
		Assert.assertEquals(signupPage.retrieveDifferentPasswordHeading(),dataProp.getProperty("differentPasswordWarningHeading1"),"Email Warrning is not displayed");
	}
	
	

}
	
