package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_004_ContactDisplayTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void reportSetUp() {
		testName = "Contact Display Functionality";
	    testDescription = "Validating the contact list is displayed or not"; 
	    testAuthor = "ArunPrasath Mohanraj";
	}
	
	@BeforeClass
	public void testDetailsAndData() {
		tDetails();
		sheetName ="ContactDisplayTestData";
	}
	
	@Test(dataProvider="excelRead")
	public void contactDisplatTest(String loginEmail, String loginpassword) throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.loginSubmitValidation()
		.loginEmailId(loginEmail)
		.loginPassWord(loginpassword)
		.clickLoginSubmit()
		.contactList()
		.contactValidation()
		.numberExtensionValidation()
		.logOut();
	}
}
