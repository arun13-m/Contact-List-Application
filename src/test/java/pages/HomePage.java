package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//validate the signUp button
	public SignUpPage signUpButton() {
		ele = driver.findElement(By.id("signup"));
		Assert.assertTrue(ele.isDisplayed());
		driver.findElement(By.id("signup")).click();
		ele = driver.findElement(By.xpath("//p[contains(text(),'Sign up to begin adding your contacts!')]"));
		Assert.assertTrue(ele.isDisplayed());
		return new SignUpPage(driver);
	}
	
	//validate the login submit button functions
	public LoginPage loginSubmitValidation() {
		ele = driver.findElement(By.id("submit"));
		Assert.assertTrue(ele.isEnabled(), "Submit button is displayed");
		return new LoginPage(driver);
	}
	
	//clicking a add new contact button
	public ContactAdditionPage clickNewContact() {
		driver.findElement(By.id("add-contact")).click();
		return new ContactAdditionPage(driver);
	}
	
	//Method redirect to the contact display page
	public ContactDisplayPage contactList() {
		ele = driver.findElement(By.xpath("//h1[contains(text(),'Contact List')]"));
		Assert.assertTrue(ele.isDisplayed(), "User in the contact list page");
		return new ContactDisplayPage(driver);
	}
	
	//clicking the contact name for edit
	public ContactEditingPage contactName() {
		driver.findElement(By.xpath("//tr[contains(@class,'contactTableBodyRow')]")).click();
		ele = driver.findElement(By.xpath("//h1[contains(text(),'Contact Details')]"));
		Assert.assertTrue(ele.isDisplayed(), "Redirect to the contact details page");
		return new ContactEditingPage(driver);
	}
	
	//deleting a contact
	public ContactDeletingPage clickContact() {
		driver.findElement(By.xpath("(//tr[contains(@class,'contactTableBodyRow')])[4]")).click();
		return new ContactDeletingPage(driver);
	}
	
	//validating the logout button
	public LogoutPage logoutValidate() {
		ele = driver.findElement(By.id("logout"));
		Assert.assertTrue(ele.isDisplayed(), "Logout button is displayed");
		return new LogoutPage(driver);	
	}
	
	//common logout
	public HomePage logOut() {
		driver.findElement(By.id("logout")).click();
		return new HomePage(driver);
	}
}