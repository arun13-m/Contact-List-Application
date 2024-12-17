package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_006_ContactDeletingTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void reportSetUp() {
		testName = "Contact Deleting Functionality";
	    testDescription = "Deleting the contact"; 
	    testAuthor = "ArunPrasath Mohanraj";
	}
	
	@BeforeClass
	public void testDetailsAndData() {
		tDetails();
		sheetName ="ContactDeletingTestData";
	}
	
	@Test(dataProvider="excelRead")
	public void contactDeletingTest(String loginEmail, String loginpassword) throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.loginSubmitValidation()
		.loginEmailId(loginEmail)
		.loginPassWord(loginpassword)
		.clickLoginSubmit()
		.clickContact()
		.clickDeleteButton()
		.alertHandle()
		.logOut();
	}
}
