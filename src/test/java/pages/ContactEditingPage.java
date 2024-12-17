package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class ContactEditingPage extends ProjectSpecificationMethods {

	public ContactEditingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="edit-contact")
	WebElement editbutton;
	
	@FindBy(id="firstName")
	WebElement editfname;
	
	@FindBy(id="lastName")
	WebElement editlname;
	
	@FindBy(id="email")
	WebElement editemail;
	
	@FindBy(id="phone")
	WebElement editphone;
	
	@FindBy(xpath="//button[contains(@form,'edit-contact')]")
	WebElement editsubmit;
	
	@FindBy(id="return")
	WebElement editreturn;
	
	//go to the contact edit page
	public ContactEditingPage editContactButton() {
		editbutton.click();
		return this;
	}
	
	//edit the first name
	public ContactEditingPage editFirstName(String editFName) throws InterruptedException {
		Thread.sleep(2000);
		editfname.clear();
		Thread.sleep(2000);
		editfname.sendKeys(editFName);
		return this;
	}
	
	//edit the last name
	public ContactEditingPage editLastName(String editLName) throws InterruptedException {
		editlname.clear();
		Thread.sleep(2000);
		editlname.sendKeys(editLName);
		return this;
	}
	
	//edit the email
	public ContactEditingPage editEmailId(String editEmail) throws InterruptedException {
		editemail.clear();
		Thread.sleep(2000);
		editemail.sendKeys(editEmail);
		return this;
	}
	
	//edit the phone number
	public ContactEditingPage editPhoneNumber(String editPhoneNum) throws InterruptedException {
		editphone.clear();
		Thread.sleep(2000);
		editphone.sendKeys(editPhoneNum);
		return this;
	}
	
	//clicking the submit button after edit the details
	public ContactEditingPage clickEditSubmit() {
		editsubmit.click();
		return this;
	}
	
	//return to the contact page
	public HomePage returnButton() {
		editreturn.click();
		return new HomePage(driver);
	}
	
}