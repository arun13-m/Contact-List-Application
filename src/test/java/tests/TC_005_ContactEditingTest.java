package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_005_ContactEditingTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void reportSetUp() {
		testName = "Contact Editing Functionality";
	    testDescription = "Editing the contact details"; 
	    testAuthor = "ArunPrasath Mohanraj";
	}
	
	@BeforeClass
	public void testDetailsAndData() {
		tDetails();
		sheetName ="ContactEditingTestData";
	}
	
	@Test(dataProvider="excelRead")
	public void contactEditingTest(String loginEmail, String loginpassword, String editFName, 
			String editLName, String editEmail, String editPhoneNum) throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.loginSubmitValidation()
		.loginEmailId(loginEmail)
		.loginPassWord(loginpassword)
		.clickLoginSubmit()
		.contactName()
		.editContactButton()
		.editFirstName(editFName)
		.editLastName(editLName)
		.editEmailId(editEmail)
		.editPhoneNumber(editPhoneNum)
		.clickEditSubmit()
		.returnButton()
		.logOut();
	}
}