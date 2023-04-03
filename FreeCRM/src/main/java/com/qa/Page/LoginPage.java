package com.qa.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class LoginPage<HomePage> extends TestBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'sign up')]")
	WebElement signBtn;
	
	@FindBy(xpath="(//img[@class='img-responsive'])[1]")
	WebElement crmLogo;
	
	//initialize page obgect
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean crmImage() {
	 return	crmLogo.isDisplayed();
	}
	public HomePage Login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

}










