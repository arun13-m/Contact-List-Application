package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class SignUpPage extends ProjectSpecificationMethods {

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="firstName")
	WebElement fName;
	
	@FindBy(id="lastName")
	WebElement lName;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement pWord;
	
	@FindBy(id="submit")
	WebElement signUpSubmit;
	
	//entering the firtname
	public SignUpPage firstName(String signFname) {
		fName.sendKeys(signFname);
		return this;
	}
	
	//entering the lastname
	public SignUpPage lastName(String signLname) {
		lName.sendKeys(signLname);
		return this;
	}
	
	//entering the email id
	public SignUpPage emailId(String signEmail) {
		email.sendKeys(signEmail);
		return this;
	}
	
	//entering the password
	public SignUpPage passWord(String signPassword) {
		pWord.sendKeys(signPassword);
		return this;
	}
	
	//entering the password
	public HomePage signUpSubmitButton() {
		signUpSubmit.click();
		ele = driver.findElement(By.xpath("//span[contains(text(),'Email address is already in use')]"));
		Assert.assertFalse(ele.isDisplayed());
		return new HomePage(driver);
	}
}
