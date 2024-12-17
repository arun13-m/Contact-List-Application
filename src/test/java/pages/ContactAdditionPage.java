package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ContactAdditionPage extends ProjectSpecificationMethods {

	public ContactAdditionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstName")
	WebElement fName;
	
	@FindBy(id="lastName")
	WebElement lName;
	
	@FindBy(id="birthdate")
	WebElement bdate;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id="street1")
	WebElement address1;
	
	@FindBy(id="street2")
	WebElement address2;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="stateProvince")
	WebElement state;
	
	@FindBy(id="postalCode")
	WebElement postcode;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="submit")
	WebElement submit;
	
	//entering the firstname
	public ContactAdditionPage firstName(String name) {
		fName.sendKeys(name);
		return this;
	}
	
	//entering the lastname
	public ContactAdditionPage lastName(String lastn) {
		lName.sendKeys(lastn);
		return this;
	}
	
	//entering the birth date
	public ContactAdditionPage birthDate(String bd) {
		bdate.sendKeys(bd);
		return this;
	}
	
	//entering the email
	public ContactAdditionPage contactEmailId(String eid) {
		email.sendKeys(eid);
		return this;
	}
	
	//entering the phone number
	public ContactAdditionPage contactPhoneNumber(String mobile) {
		phone.sendKeys(mobile);
		return this;
	}
	
	//entering the street address 1
	public ContactAdditionPage streetAddress1(String st1) {
		address1.sendKeys(st1);
		return this;
	}
	
	//entering the street address 2
	public ContactAdditionPage streetAddress2(String st2) {
		address2.sendKeys(st2);
		return this;
	}
	
	//entering the city
	public ContactAdditionPage ciTy(String cty) {
		city.sendKeys(cty);
		return this;
	}
	
	//entering the state or province
	public ContactAdditionPage stateOrProvince(String province) {
		state.sendKeys(province);
		return this;
	}
	
	//entering the state or province
	public ContactAdditionPage postalCode(String pCode) {
		postcode.sendKeys(pCode);
		return this;
	}
	
	//entering the state or province
	public ContactAdditionPage counTry(String countries) {
		country.sendKeys(countries);
		return this;
	}
	
	//clicking the submit button and validate
	public HomePage contactAddSubmitButton() throws InterruptedException {
		submit.click();
		Thread.sleep(5000);
		ele = driver.findElement(By.xpath("//button[contains(text(),'Add a New Contact')]"));
		Assert.assertTrue(ele.isDisplayed(), "Contact Successfully Added");
		return new HomePage(driver);
	}
}