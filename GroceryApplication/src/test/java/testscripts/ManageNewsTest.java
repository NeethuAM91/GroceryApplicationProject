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

	@Test(priority=0,description="User is able to add news in Manage news page")
	public void verifyManageNewsPageWithnewNews() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET );
		LoginPage login=new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue);
		login.enterPasswordonPasswordField(passwordValue);
		login.clickOnLoginButton();
		HomePage homepage=new HomePage(driver);
		homepage.manageNewsTileClick();
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.newInManageNewsClick();
		managenewspage.textAreaNews();
		managenewspage.saveButtonClickInManageNews();
		String actual=managenewspage.isTextFoundInManageNews();
		String expected="Enter News Informations";
		Assert.assertEquals(actual,expected,"User not in manage news page");
	}
	@Test(priority=1,description="User is able to search news in Manage news page")
	public void verifySearchInManageNewsPage() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
		LoginPage login=new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue);
		login.enterPasswordonPasswordField(passwordValue);
		login.clickOnLoginButton();
		HomePage homepage=new HomePage(driver);
		homepage.manageNewsTileClick();
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.searchInManageNewsClick();
		managenewspage.searchInManageNewsTextField();
		managenewspage.searchNewsinTextField();
		String actual=managenewspage.isTextFoundInSearchManageNews();
		String expected="Search Manage News";
		Assert.assertEquals(actual,expected,"User not in manage news page");
		
	}
	@Test(priority=2,description="User is able to reset in Manage news page")
	public void verifyResetInManageNewsPage() throws IOException
	{
		String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
		LoginPage login=new LoginPage(driver);
		login.enterUsernameonUsernameField(usernameValue);
		login.enterPasswordonPasswordField(passwordValue);
		login.clickOnLoginButton();
		HomePage homepage=new HomePage(driver);
		homepage.manageNewsTileClick();
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.resetNewsinManageNews();
		boolean resettable=managenewspage.isTableFoundInResetManageNews();
		Assert.assertTrue(resettable, "User is unable to access manage news page");
}
}

