package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class LogoutPage extends ProjectSpecificationMethods {

	public LogoutPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//tr[contains(@class,'contactTableBodyRow')])[3]")
	WebElement del1;
	
	@FindBy(xpath="(//tr[contains(@class,'contactTableBodyRow')])[2]")
	WebElement del2;
	
	@FindBy(xpath="(//tr[contains(@class,'contactTableBodyRow')])[1]")
	WebElement del3;
	
	@FindBy(id="delete")
	WebElement deleteButton;
	
	
	
	public LogoutPage delete1() throws InterruptedException {
		del1.click();
		Thread.sleep(5000);
		deleteButton.click();
		a = driver.switchTo().alert();
		a.accept();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public LogoutPage delete2() throws InterruptedException {
		del2.click();
		Thread.sleep(5000);
		deleteButton.click();
		a = driver.switchTo().alert();
		a.accept();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public LogoutPage delete3() throws InterruptedException {
		del3.click();
		Thread.sleep(5000);
		deleteButton.click();
		a = driver.switchTo().alert();
		a.accept();
		driver.switchTo().defaultContent();
		return this;
	}
	
	
	//logout method
	public HomePage logOut() {
		driver.findElement(By.id("logout")).click();
		return new HomePage(driver);
	}
}