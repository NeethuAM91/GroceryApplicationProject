package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	HomePage homepage;
	
	@Test(groups= {"smoke"},priority=1,description="User can login with valid credentials",retryAnalyzer = retry.Retry.class)
	 public void verifyUserLoginWithValidCredentials() throws IOException
	 {
		
			String usernameValue=ExcelUtility.getStringData(0, 0,Constants.LOGINSHEET);
			String passwordValue=ExcelUtility.getStringData(0, 1,Constants.LOGINSHEET);
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue);
			homepage=login.clickOnLoginButton();
			boolean	dashboarddisplay = login.isDashboardDisplayed();
		    Assert.assertTrue(dashboarddisplay,Constants.VALIDCREDENTIALERROR);
	 
	}
	 @Test(priority=2,description="User is unable to login with invalid username and valid password")
		public void verifyUserLoginWithIvalidUsernameandValidPassword() throws IOException
		 {
			String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
			String passwordValue=ExcelUtility.getStringData(1, 1,Constants.LOGINSHEET);
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue).clickOnLoginButton();
			String actual=login.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDCREDENTIALERROR);
		}
		@Test(priority=3,description="User is unable to login with valid username and invalid password")
		public void verifyUserLoginWithValidUsernameandInvalidPassword() throws IOException
		 {
			String usernameValue=ExcelUtility.getStringData(2, 0,Constants.LOGINSHEET);
			String passwordValue=ExcelUtility.getStringData(2, 1,Constants.LOGINSHEET);
			LoginPage login= new LoginPage(driver);
			login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue).clickOnLoginButton();
			boolean	remembermedisplay = login.isRemembermeDisplayed();
		    Assert.assertTrue(remembermedisplay,Constants.INVALIDCREDENTIALERROR);
	 
		 
		}
		@Test(groups= {"smoke"},priority=4,description="User is unable to login with invalid credentials",dataProvider="loginProvider")
		public void verifyUserLoginWithInvalidCredentials(String usernameValue, String passwordValue) throws IOException
		 {
			//String usernameValue=ExcelUtility.getStringData(3, 0,Constants.LOGINSHEET);
			//String passwordValue=ExcelUtility.getStringData(3, 1,Constants.LOGINSHEET);
			LoginPage login= new LoginPage(driver);

			login.enterUsernameonUsernameField(usernameValue).enterPasswordonPasswordField(passwordValue).clickOnLoginButton();
			String actual=login.isSigninButtonPresent();
			String expected="Sign In";
			Assert.assertEquals(actual, expected,Constants.INVALIDCREDENTIALERROR);
		 
		}
		@DataProvider(name = "loginProvider")
		public Object[][] getDataFromDataProvider() throws IOException {

			return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
					// new Object[] {ExcelUtility.getStringData(3,
					// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
				};
		}

}
