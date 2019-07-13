package com.crm.qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;


import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	
	//initialize page objects
	
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactsLabel() {
		return contactslabel.isDisplayed();
		
	}
	
	public void selectContactsByName(String name) {
	//The method selectContactsByName is not returning anything just clicking on contacts so it is void
		//We are not defining page factory for contacts name i.ebhims pk,Bheemshankar pk if so we have to define xpath for every contacts names so we are using dynamic xpath as below
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String ftName,String ltName,String comp) {
		//is not making hardcoded so passing string variable i.e String value
		
		
		
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	
	
	     
	}
	
	
}

