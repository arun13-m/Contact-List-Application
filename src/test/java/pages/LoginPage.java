package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class LoginPage extends ProjectSpecificationMethods {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="submit")
	WebElement submit;
	
	//login Email
	public LoginPage loginEmailId(String loginEmail) {
		email.sendKeys(loginEmail);
		return this;
	}
	
	//login password
	public LoginPage loginPassWord(String loginpassword) {
		password.sendKeys(loginpassword);
		return this;
	}
	
	//click the login submit button and valiadate is redirect to the home page or not
	public HomePage clickLoginSubmit() {
		submit.click();
		ele = driver.findElement(By.xpath("//button[contains(text(),'Add a New Contact')]"));
		Assert.assertTrue(ele.isDisplayed(), "User in the home page");
		return new HomePage(driver);
		
	}
}
