package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	// constructor creation is mandatory
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// for initializing the driver
	}

	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement logout;

	public HomePage clickAdmin() {
		admin.click();
		return this;
	}

	public LoginPage logout() {
		logout.click();
		return new LoginPage(driver);
	}

	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminUserMoreinfoTile;

	public AdminPage adminUserTileClick() {
		adminUserMoreinfoTile.click();
		return new AdminPage(driver);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class=\"active nav-link\"]")
	private WebElement managenewstile;

	public ManageNewsPage manageNewsTileClick() {
		managenewstile.click();
		return new ManageNewsPage(driver);
	}

	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement textinloginpage;

	public String isLoginTextDisplayed() {
		return textinloginpage.getText();
	}

}
