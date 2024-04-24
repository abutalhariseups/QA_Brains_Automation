package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
	
	WebDriver driver;
	
	@FindBy(xpath="(//span[@class='after'])[1]")
	private WebElement signinBtn;
	
	@FindBy(xpath="//a[normalize-space()='Sign up']")
	private WebElement signupBtn;
	
	@FindBy(xpath="//small[normalize-space()='Name is a required field']")
	private WebElement namesWarning;
	
	@FindBy(xpath="//small[normalize-space()='Email is a required field']")
	private WebElement emailWarning;
	
	@FindBy(xpath="//small[normalize-space()='Country is a required field']")
	private WebElement countryWarning;
	
	@FindBy(xpath="//small[normalize-space()='Account type is a required field']")
	private WebElement accountTypeWarning;
	
	@FindBy(xpath="//small[normalize-space()='Password is a required field']")
	private WebElement passwordWarning;
	
	@FindBy(xpath="//small[normalize-space()='Confirm password is a required field']")
	private WebElement cofirmPasswordWarning;
	
	@FindBy(xpath="//small[normalize-space()='You must accept the terms and conditions']")
	private WebElement termsWarning;
	
	@FindBy(xpath="//span[@class='after']")
	private WebElement signUpMain;
	
	@FindBy(xpath="//label[contains(@for,'terms')]")
	private WebElement scroll1;
	
	///////////////////////////
	
	//SignupModule
	
	@FindBy(xpath="//input[@placeholder='eg. John Doe']")
	private WebElement signUpName;
	
	@FindBy(xpath="//input[@placeholder='eg. user@user.com']")
	private WebElement signUpEmail;
	
	@FindBy(xpath="//select[@name='country_id']")
	private WebElement signUpCountry;
	
	@FindBy(xpath="//select[@name='profession']")
	private WebElement signUpAccount;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement signUpPassword;
	
	
	@FindBy(xpath="(//*[name()='svg'][@stroke='currentColor'])[1]")
	private WebElement signUpPasswordEye;
	
	@FindBy(xpath="//input[@placeholder='Confirm password']")
	private WebElement signUpConfirmPassword;
	
	@FindBy(xpath="(//*[name()='svg'][@stroke='currentColor'])[2]")
	private WebElement signUpConfirmPasswordEye;


	@FindBy(xpath="//input[@id='terms']")
	private WebElement signUpPolicy;
	
	@FindBy(xpath="//input[@placeholder='Institution name ']")
	private WebElement institutionName;
	
	@FindBy(xpath="//input[@placeholder='Organization name ']")
	private WebElement organizationName;
	
	
	@FindBy(xpath="//small[normalize-space()='Password must match']")
	private WebElement differentPasswordWarningHeading;
	
	
	@FindBy(xpath="//h2[@class='title mb-0']")
	private WebElement accountSuccesHeading;
	
	
	public SignupPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void goSignUpField() throws InterruptedException {
		signinBtn.click();
		Thread.sleep(2000);
		signupBtn.click();
		Thread.sleep(2000);
	}
	
	public void signUpUsingValidInfo(String firstNameText, String emailText, String passwordText, String confirmPasswordText) throws InterruptedException {
		
		signUpName.sendKeys(firstNameText);
		Thread.sleep(2000);
		signUpEmail.sendKeys(emailText);
		Thread.sleep(2000);
		signUpCountry.click();
		Thread.sleep(2000);
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText("Afghanistan");
		Thread.sleep(2000);
		signUpAccount.click();
		Thread.sleep(2000);
		Select drpAccount = new Select(driver.findElement(By.name("profession")));
		drpAccount.selectByValue("1");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpPassword);
	    
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		signUpPassword.sendKeys(passwordText);
		Thread.sleep(2000);
		signUpPasswordEye.click();
		Thread.sleep(2000);
		signUpConfirmPassword.sendKeys(confirmPasswordText);
		Thread.sleep(2000);
		signUpConfirmPasswordEye.click();
		Thread.sleep(2000);
		signUpPolicy.click();
		Thread.sleep(2000);
		signUpMain.click();
		Thread.sleep(5000);
		
	}
	public void signUpUsingValidInfoForStudent(String firstNameText, String emailText,String institutionNameText, String passwordText, String confirmPasswordText) throws InterruptedException {
		
		signUpName.sendKeys(firstNameText);
		Thread.sleep(2000);
		signUpEmail.sendKeys(emailText);
		Thread.sleep(2000);
		signUpCountry.click();
		Thread.sleep(2000);
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText("Afghanistan");
		Thread.sleep(2000);
		signUpAccount.click();
		Thread.sleep(2000);
		Select drpAccount = new Select(driver.findElement(By.name("profession")));
		drpAccount.selectByValue("2");
		Thread.sleep(2000);
		institutionName.sendKeys(institutionNameText);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpPassword);
	    
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		signUpPassword.sendKeys(passwordText);
		Thread.sleep(2000);
		signUpPasswordEye.click();
		Thread.sleep(2000);
		signUpConfirmPassword.sendKeys(confirmPasswordText);
		Thread.sleep(2000);
		signUpConfirmPasswordEye.click();
		Thread.sleep(2000);
		signUpPolicy.click();
		Thread.sleep(2000);
		signUpMain.click();
		Thread.sleep(5000);
		
	}
	
	public void signUpUsingValidInfoForEmploy(String firstNameText, String emailText,String organizationNameText, String passwordText, String confirmPasswordText) throws InterruptedException {
		
		signUpName.sendKeys(firstNameText);
		Thread.sleep(2000);
		signUpEmail.sendKeys(emailText);
		Thread.sleep(2000);
		signUpCountry.click();
		Thread.sleep(2000);
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText("Afghanistan");
		Thread.sleep(2000);
		signUpAccount.click();
		Thread.sleep(2000);
		Select drpAccount = new Select(driver.findElement(By.name("profession")));
		drpAccount.selectByValue("2");
		Thread.sleep(2000);
		organizationName.sendKeys(organizationNameText);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpPassword);
	    
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		signUpPassword.sendKeys(passwordText);
		Thread.sleep(2000);
		signUpPasswordEye.click();
		Thread.sleep(2000);
		signUpConfirmPassword.sendKeys(confirmPasswordText);
		Thread.sleep(2000);
		signUpConfirmPasswordEye.click();
		Thread.sleep(2000);
		signUpPolicy.click();
		Thread.sleep(2000);
		signUpMain.click();
		Thread.sleep(5000);
		
	}
	public void signUpUsingDifferentPassword(String firstNameText, String emailText, String passwordText, String invalidconfirmPasswordText) throws InterruptedException {
		
		signUpName.sendKeys(firstNameText);
		Thread.sleep(2000);
		signUpEmail.sendKeys(emailText);
		Thread.sleep(2000);
		signUpCountry.click();
		Thread.sleep(2000);
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText("Afghanistan");
		Thread.sleep(2000);
		signUpAccount.click();
		Thread.sleep(2000);
		Select drpAccount = new Select(driver.findElement(By.name("profession")));
		drpAccount.selectByValue("1");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpPassword);
	    
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		signUpPassword.sendKeys(passwordText);
		Thread.sleep(2000);
		signUpPasswordEye.click();
		Thread.sleep(2000);
		signUpConfirmPassword.sendKeys(invalidconfirmPasswordText);
		Thread.sleep(2000);
		signUpConfirmPasswordEye.click();
		Thread.sleep(2000);
		signUpPolicy.click();
		Thread.sleep(2000);
		signUpMain.click();
		Thread.sleep(5000);
		
	}
	public String retrieveDifferentPasswordHeading() {
		
		String differentPasswordWarningHeadingText = differentPasswordWarningHeading.getText();
		return differentPasswordWarningHeadingText;
	}
	
	public String retrieveAccountSuccessHeading() {
		
		String accountSuccesHeadingText = accountSuccesHeading.getText();
		return accountSuccesHeadingText;
	}

	public String retrieveNamesWarning() {
		
		String namesWarningText = namesWarning.getText();
		return namesWarningText;
	}
	
	
	public String retrieveEmailWarning() {
		
		String emailWarningText = emailWarning.getText();
		return emailWarningText;
	}
	
	public String retrieveCountryWarning() {
		
		String countryWarningText = countryWarning.getText();
		return countryWarningText;
	}
	
	public String retrieveAccountTypeWarning() {
		
		String accountTypeWarningText = accountTypeWarning.getText();
		return accountTypeWarningText;
	}
	
	public String retrievePasswordWarning() {
		
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
	}
	
	public String retrieveCofirmPasswordWarning() {
		
		String cofirmPasswordWarningText = cofirmPasswordWarning.getText();
		return cofirmPasswordWarningText;
		
	}
	
	public String retrieveTermsWarning() {

		String termsWarningText = termsWarning.getText();
		return termsWarningText;

	}
	

	public void EmptyCredintialsFields() throws InterruptedException {
	    
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll1);
	    
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    Thread.sleep(5000);
	    signUpMain.click();
	    Thread.sleep(2000);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll1);
	    
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	public boolean displayStatusOfWarningMessages(String expectedNamesWarning,String expectedEmailWarning,String expectedCountryWarning,
			String expectedAccountTypeWarning,String expectedpasswordWarning,String expectedCofirmPasswordWarning, String expectedTermsWarning) {
		
		boolean namesWarningStatus = namesWarning.getText().contains(expectedNamesWarning);
		boolean emailWarningStatus = emailWarning.getText().equals(expectedEmailWarning);
		boolean countryWarningStatus = countryWarning.getText().equals(expectedCountryWarning);
		boolean accountTypeWarningStatus = accountTypeWarning.getText().equals(expectedAccountTypeWarning);
		boolean passwordWarningStatus = passwordWarning.getText().equals(expectedpasswordWarning);
		boolean cofirmPasswordWarningStatus = cofirmPasswordWarning.getText().equals(expectedCofirmPasswordWarning);
		boolean termsWarningStatus = termsWarning.getText().equals(expectedTermsWarning);
		return namesWarningStatus && emailWarningStatus && countryWarningStatus && accountTypeWarningStatus &&
				passwordWarningStatus && cofirmPasswordWarningStatus && termsWarningStatus;
	}

}













