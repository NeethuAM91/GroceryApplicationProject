package automationcore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver;
	
	@Parameters("browsers")
	@BeforeMethod(alwaysRun=true)
	public void initializeBrowser(String browsers) throws Exception
	{
		if(browsers.equalsIgnoreCase("Chrome"))
		{
			driver =new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("Firefox"))
		{
			driver =new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().clearResolutionCache().forceDownload().setup();
			driver =new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid browser");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Duration is a class-here wait for 5sec
	}
	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

		ScreenshotUtility screenShot = new ScreenshotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();

		}


}
