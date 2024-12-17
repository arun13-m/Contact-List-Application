package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_007_FinalLogoutTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void reportSetUp() {
		testName = "Final Logout Functionality";
	    testDescription = "deleting all the contacts and logged out the account"; 
	    testAuthor = "ArunPrasath Mohanraj";
	}
	
	@BeforeClass
	public void testDetailsAndData() {
		tDetails();
		sheetName ="FinalLogoutTestData";
	}
	
	@Test(dataProvider="excelRead")
	public void finalLogoutTest(String loginEmail, String loginpassword) throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.loginSubmitValidation()
		.loginEmailId(loginEmail)
		.loginPassWord(loginpassword)
		.clickLoginSubmit()
		.logoutValidate()
		.delete1()
		.delete2()
		.delete3()
		.logOut();
	}
}
