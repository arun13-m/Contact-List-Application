package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_003_ContactAdditionTest extends ProjectSpecificationMethods{

	@BeforeTest
	public void reportSetUp() {
		testName = "Add Contact Functionality";
	    testDescription = "Adding the contact with valid & invalid details"; 
	    testAuthor = "ArunPrasath Mohanraj";
	}
	
	@BeforeClass
	public void testDetailsAndData() {
		tDetails();
		sheetName ="ContactAdditionTestData";
	}
	
	@Test(dataProvider="excelRead")
	public void contactAddtionTest(String loginEmail, String loginpassword, String name, String lastn, String bd, 
	String eid, String mobile, String st1 , String st2,
	String cty, String province, String pCode, String countries) throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.loginSubmitValidation()
		.loginEmailId(loginEmail)
		.loginPassWord(loginpassword)
		.clickLoginSubmit()
		.clickNewContact()
		.firstName(name)
		.lastName(lastn)
		.birthDate(bd)
		.contactEmailId(eid)
		.contactPhoneNumber(mobile)
		.streetAddress1(st1)
		.streetAddress2(st2)
		.ciTy(st2)
		.stateOrProvince(province)
		.postalCode(pCode)
		.counTry(countries)
		.contactAddSubmitButton()
		.logOut();
	}
}