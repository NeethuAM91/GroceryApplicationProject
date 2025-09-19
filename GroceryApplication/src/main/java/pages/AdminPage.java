package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {

public WebDriver driver;

public AdminPage( WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements( driver,this);
}
	
//@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement adminUserMoreinfoTile;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newUserButton;
@FindBy(xpath="//input[@id='username']")private WebElement usernameField;
@FindBy(xpath="//input[@id='password']")private WebElement passwordField;
@FindBy(xpath="//select[@id='user_type']")private WebElement userTypeDropdown;
@FindBy(xpath="//i[@class='fa fa-save']")private WebElement saveButton;
@FindBy(xpath="//i[@class=' fa fa-search']")private WebElement searchbutton;
@FindBy(xpath="//input[@id='un']")private WebElement usernameInSearch;
@FindBy(xpath="//select[@id='ut']")private WebElement usertypeInSearch;
@FindBy(xpath="//i[@class='fa fa-search']")private WebElement searchInSearchfield;
@FindBy(xpath="//i[@class='ace-icon fa fa-sync-alt']")private WebElement resetInAdminPage;
/*public void adminUserTileClick()
{
	adminUserMoreinfoTile.click();
}*/
public void newUserButtonClick()
{
	newUserButton.click();
}
public void enterusername(String newusername)
{
	usernameField.sendKeys(newusername);
}
public void enterpassword(String newpassword)
{
	passwordField.sendKeys(newpassword);
}
public void selectUserType()
{
	Select select=new Select(userTypeDropdown);
	select.selectByVisibleText("Admin");
	
}
public void clickSaveButton()
{
	saveButton.click();
}
public void searchButtonInAdminPage()
{
	searchbutton.click();
}
public void enterUsernmaeInSearchField()
{
	usernameInSearch.sendKeys("neethu");
}
public void enterUserTypeInSearchField()
{
	Select select=new Select(usertypeInSearch);
	select.selectByVisibleText("Admin");
}
public void searchInSearchField()
{
	searchInSearchfield.click();
}
public void resetInAdminPage()
{
	resetInAdminPage.click();
}
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertmessage;
public boolean isAlertMessageFound()
{
	return alertmessage.isDisplayed();
}
@FindBy(xpath="//td[text()='Neethu']")private WebElement searchusers;
public boolean searchUserInAdminPage() {
	return searchusers.isDisplayed();
}
@FindBy(xpath="//section[@class='content']")private WebElement resettablefound;
public boolean isResetTableFound()
{
	return resettablefound.isDisplayed();
}
}
