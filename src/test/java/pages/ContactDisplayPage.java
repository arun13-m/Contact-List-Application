package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ContactDisplayPage extends ProjectSpecificationMethods {

	ContactDisplayPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//td[contains(text(),'John Doe')]")
	WebElement contact1;
	
	@FindBy(xpath="//td[contains(text(),'Anna John')]")
	WebElement contact2;
	
	@FindBy(xpath="//td[contains(text(),'Amy Miller')]")
	WebElement contact3;
	
	@FindBy(xpath="//td[contains(text(),'Amy Miller')]")
	WebElement contact4;
	
	@FindBy(xpath="//td[contains(text(),'8005555555')]")
	WebElement pnum;
	
	//validationMethod
	public ContactDisplayPage contactValidation() {
		Assert.assertTrue(contact1.isDisplayed());
		Assert.assertTrue(contact2.isDisplayed());
		Assert.assertTrue(contact3.isDisplayed());
		Assert.assertTrue(contact4.isDisplayed());
		return this;
	}
	
	public HomePage numberExtensionValidation() {
		expectedResult = "+918005555555";
		String actualResult = driver.findElement(By.xpath("//td[contains(text(),'8005555555')]")).getText();
		Assert.assertEquals(actualResult, expectedResult, "Extension is available with the number");
		return new HomePage(driver);
	}
	
}
