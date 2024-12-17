package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_001_SignUpTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void reportSetUp() {
		testName = "SignUp Functionality";
	    testDescription = "SignUp with valid & invalid credentials"; 
	    testAuthor = "ArunPrasath Mohanraj"; 
	}
	
	@BeforeClass
	public void testDetailsAndData() {
		tDetails();
		sheetName ="SignUpTestData";
	}
	
	@Test(dataProvider="excelRead")
	public void signUpTest(String signName, String signLname, String signEmail, String signPassword) {
		HomePage obj = new HomePage(driver);
		obj.signUpButton()
		.firstName(signName)
		.lastName(signLname)
		.emailId(signEmail)
		.passWord(signPassword)
		.signUpSubmitButton();
	}
}