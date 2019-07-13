package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.uti.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName="contacts";
	
public ContactsPageTest() {
	
	super();	
}


@BeforeMethod
public void setUp() {
	initialization();
	testUtil=new TestUtil();
	contactsPage=new ContactsPage();
	loginPage=new LoginPage();
	homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));// since 
	//we have to select contacts in home page so we have created contacts link created in home page i.e part of home page
	testUtil.switchToFrame();//have to use after login to appn no need to write inside clickoncontacts mehod
	contactsPage=homePage.clickonContactslink();
	//One more catch is there After clicking here it comes in HomePage.java give error again there is a frame then use switchToFrame mathod from Util class
     //since we have to use for both test cases writing switchToFRame as common
}


   @Test(priority=1)
   public void verifyContactsPageLabel() {
	   
	   Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
	   
   }

@Test(priority=2)
public void selectSingleContactsTest() {
	contactsPage.selectContactsByName("bhims pk");
}

@Test(priority=3)
public void selectMultipleContactsTest() {
	contactsPage.selectContactsByName("bhims pk");
	contactsPage.selectContactsByName("chandru pk");
}

@DataProvider
public Object[][] getCRMTestData() {
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
}



 @Test(priority=4,dataProvider="getCRMTestData")
 public void validateCreateNewContact(String title,String firstname,String lastname,String company) {
	 //4 columns are there in excel sheet so have to create 4 variables inside @Test method also
	 homePage.clickOnNewContactLink();
	 //contactsPage.createNewContact("Mr.", "bhimskr", "pk", "capgemini");
	 contactsPage.createNewContact(title, firstname, lastname, company);
 }
	
@AfterMethod
public void tearDown(){
	//driver.quit();



}
}
