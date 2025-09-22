package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

public WebDriver driver;
	
	//constructor creation is mandatory
	public LoginPage(WebDriver driver)
	{
    this.driver=driver;
    PageFactory.initElements(driver, this);//for initializing the driver
    }
	
	
	@FindBy(xpath="//input[@placeholder=\"Username\"]")private WebElement username;
	
	public void enterUsernameonUsernameField(String usernameValue)
	{
		username.sendKeys(usernameValue);
	}
	
	@FindBy(xpath="//input[@placeholder=\"Password\"]")private WebElement password;
	
	public void enterPasswordonPasswordField(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
	}
	
	@FindBy(xpath="//button[@type=\"submit\"]")private WebElement login;
	
	public void clickOnLoginButton()
	{
		login.click();
	}
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	
	public  boolean isDashboardDisplayed()
	{
		
			return dashboard.isDisplayed();
		
}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/login']")private WebElement loginpagetitle;
	
	public String getPageTitle()
	{
		return loginpagetitle.getText();
	}
	@FindBy(xpath="//div[@class='icheck-dark']")private WebElement rememberme;
	
	public boolean isRemembermeDisplayed() {
		return rememberme.isDisplayed();
		
	}
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")private WebElement signinbutton;

	public String isSigninButtonPresent()
	{
		return signinbutton.getText();
	}
	}

