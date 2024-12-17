package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_002_LoginTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void reportSetUp() {
		testName = "Login Functionality";
	    testDescription = "Login with valid & invalid credentials"; 
	    testAuthor = "ArunPrasath Mohanraj";
	}
	
	@BeforeClass
	public void testDetailsAndData() {
		tDetails();
		sheetName ="LoginTestData";
	}
	
	@Test(dataProvider="excelRead")
	public void loginTest(String loginEmail, String loginpassword) {
		HomePage obj = new HomePage(driver);
		obj.loginSubmitValidation()
		.loginEmailId(loginEmail)
		.loginPassWord(loginpassword)
		.clickLoginSubmit()
		.logOut();
	}
}