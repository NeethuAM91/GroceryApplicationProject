package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newInmanageNews;
public ManageNewsPage newInManageNewsClick()
{
	newInmanageNews.click();
	return this;
}
@FindBy(xpath="//textarea[@id='news']")private WebElement textarea;
public ManageNewsPage textAreaNews(String value)
{
	textarea.sendKeys(value);
	return this;

}
@FindBy(xpath="//button[@name='create']")private WebElement saveInmanageNews;

public ManageNewsPage saveButtonClickInManageNews()
{
	saveInmanageNews.click();
	return this;

}
@FindBy(xpath="//a[@href='javascript:void(0)']")private WebElement searchInmanageNews;
public ManageNewsPage searchInManageNewsClick()
{
	searchInmanageNews.click();
	return this;

}
@FindBy(xpath="//input[@name='un']")private WebElement searchNews;
public ManageNewsPage searchInManageNewsTextField(String value)
{
	searchNews.sendKeys(value);
	return this;

}
@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")private WebElement searchnewsbutton;
public ManageNewsPage searchNewsinTextField()
{
	searchnewsbutton.click();
	return this;

}
@FindBy(xpath="//i[@class='ace-icon fa fa-sync-alt']")private WebElement resetbuttoninmanagenews;
public void resetNewsinManageNews()
{
	resetbuttoninmanagenews.click();
}
@FindBy(xpath="//h3[@class='card-title']")private WebElement textinmanagenews;
public String isTextFoundInManageNews()
{
	return textinmanagenews.getText();
}
@FindBy(xpath="//h4[text()='Search Manage News']")private WebElement textinmanagenewssearch;
public String isTextFoundInSearchManageNews()
{
	return textinmanagenewssearch.getText();
}
@FindBy(xpath="//section[@class='content']")private WebElement tableinmanagenewsreset;
public boolean isTableFoundInResetManageNews()
{
	return tableinmanagenewsreset.isDisplayed();
}
}
