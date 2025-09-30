package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtlility {
	public WebDriver driver;

	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void clicktheButton() {

		WebElement element = driver.findElement(By.id("example"));
		element.click();

	}

	public void rightClick() {
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.id("example"));
		actions.contextClick(element).perform();

	}

	public void mouseHover() {
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.id("example"));
		actions.moveToElement(element).perform();

	}

	public void doubleClick() {
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.id("example"));
		actions.doubleClick(element).perform();

	}

	public void radiobutto() {
		WebElement radioButton = driver.findElement(By.id("radio1"));
		if (!radioButton.isSelected()) {
			radioButton.click();
		}

	}
}
