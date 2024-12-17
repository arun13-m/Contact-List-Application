package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ContactDeletingPage extends ProjectSpecificationMethods{

	public ContactDeletingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="delete")
	WebElement deleteButton;
	
	//after seleting ac contact click the delete button
	public ContactDeletingPage clickDeleteButton() throws InterruptedException {
		Thread.sleep(5000);
		deleteButton.click();
		return this;
	}
	
	//handeling the alert to confirm the delete
	public HomePage alertHandle() {
		a = driver.switchTo().alert();
		a.accept();
		driver.switchTo().defaultContent();
		ele = driver.findElement(By.xpath("//h1[contains(text(),'Contact List')]"));
		Assert.assertTrue(ele.isDisplayed(), "Contact successfully deleted");
		return new HomePage(driver);
	}
}
