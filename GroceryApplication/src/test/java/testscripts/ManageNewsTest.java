package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
HomePage homepage;
ManageNewsPage managenewspage;
	@Test(priority=2,description="User is able to add news in Manage news page")
	public void verifyManageNewsPageWithnewNews() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET );
		LoginPage login=new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue);
		homepage=login.clickOnLoginButton();
		managenewspage=homepage.manageNewsTileClick();
		managenewspage.newInManageNewsClick();
		String value=ExcelUtility.getStringData(0, 0, "ManagenewsPage");
		managenewspage.textAreaNews(value).saveButtonClickInManageNews();
		String actual=managenewspage.isTextFoundInManageNews();
		String expected="Enter News Informations";
		Assert.assertEquals(actual,expected,Constants.NOTINMANAGENEWSPAGE);
	}
	@Test(priority=1,description="User is able to search news in Manage news page")
	public void verifySearchInManageNewsPage() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
		LoginPage login=new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue);
		homepage=login.clickOnLoginButton();
		managenewspage=homepage.manageNewsTileClick();
		managenewspage.searchInManageNewsClick();
		String value=ExcelUtility.getStringData(0, 0, "ManagenewsPage");
		managenewspage.searchInManageNewsTextField(value).searchNewsinTextField();
		String actual=managenewspage.isTextFoundInSearchManageNews();
		String expected="Search Manage News";
		Assert.assertEquals(actual,expected,Constants.NOTINMANAGENEWSPAGE);
		
	}
	@Test(priority=0,description="User is able to reset in Manage news page")
	public void verifyResetInManageNewsPage() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
		LoginPage login=new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue);
		homepage=login.clickOnLoginButton();
		managenewspage=homepage.manageNewsTileClick();
		managenewspage.resetNewsinManageNews();
		boolean resettable=managenewspage.isTableFoundInResetManageNews();
		Assert.assertTrue(resettable,Constants.NOTINMANAGENEWSPAGE);
}
}

