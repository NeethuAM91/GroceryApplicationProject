package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public WebDriver driver;
	
	//constructor creation is mandatory
	public HomePage(WebDriver driver)
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
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")private WebElement admin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")private WebElement logout;
	public void clickAdmin()
	{
		admin.click();
	}
	public void logout()
	{
		logout.click();
	}
}
