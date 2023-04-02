package com.KidbizSSO.Method.OLP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class OLPLoginPage extends BaseClass{
	
	public OLPLoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}
	
	@FindBy(css = "input[query-id='login.username']")
	WebElement email;
	
	@FindBy(css = "input[query-id='login.password']")
	WebElement password;
	
	@FindBy(css ="button[type='submit']" )
	WebElement loginBtn;
	
	public void inputEmailPassword() {
		Utils.waitForElementToBeVisible(email, Utils.Explicit_Wait);
		Utils.sendData(email, properties.getProperty("emailMH"));
		Utils.sendData(password, properties.getProperty("passwordMH"));
	}
	
	public AdminAccountHomepage clickLoginBtn() {
		Utils.clickOnElement(loginBtn);
		return new AdminAccountHomepage();
	}

}
