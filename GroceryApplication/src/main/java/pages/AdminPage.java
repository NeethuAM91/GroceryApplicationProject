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

public AdminPage newUserButtonClick()
{
	newUserButton.click();
	return this;
}
public AdminPage enterusername(String newusername)
{
	usernameField.sendKeys(newusername);
	return this;
}
public AdminPage enterpassword(String newpassword)
{
	passwordField.sendKeys(newpassword);
	return this;
	
}
public AdminPage selectUserType()
{
	Select select=new Select(userTypeDropdown);
	select.selectByVisibleText("Admin");
	return this;
	
}
public AdminPage clickSaveButton()
{
	saveButton.click();
	return this;
}
public AdminPage searchButtonInAdminPage()
{
	searchbutton.click();
	return this;
}
/*public void enterUsernmaeInSearchField()
{
	usernameInSearch.sendKeys("neethu");
}
public void enterUserTypeInSearchField()
{
	Select select=new Select(usertypeInSearch);
	select.selectByVisibleText("Admin");
}*/
public AdminPage searchInSearchField()
{
	searchInSearchfield.click();
	return this;
}
public AdminPage resetInAdminPage()
{
	resetInAdminPage.click();
	return this;
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
@FindBy(xpath="//input[@id='un']")private WebElement userSearchInAdmin;
public AdminPage searchUsernameInAdmin(String user) {
	userSearchInAdmin.sendKeys(user);
	return this;
}
@FindBy(xpath="//select[@id='ut']")private WebElement searchtype;
public AdminPage searchInAdminPage(String type) {
	searchtype.sendKeys(type);
	return this;
}

}
