package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory OR
    @FindBy(name="username")
    WebElement username;
    
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up']")

		WebElement SignUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the Page Objects
	public LoginPage() {
		
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login(String un,String pwd) {
	username.sendKeys(un);
	password.sendKeys(pwd); 
	//loginBtn.click();
	WebDriverWait wait=new WebDriverWait(driver,3);
	//WebElement loginBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
	//loginBtn.click();
	boolean invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
	if(invisible) {
		WebElement loginBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
		loginBtn.click();
	}
	
	return new HomePage();
	
}
}