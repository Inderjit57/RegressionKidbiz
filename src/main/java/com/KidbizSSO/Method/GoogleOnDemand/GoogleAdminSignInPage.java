package com.KidbizSSO.Method.GoogleOnDemand;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class GoogleAdminSignInPage extends BaseClass {
	public GoogleAdminSignInPage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = "input[type='email']")
	private WebElement googleEmailField;

	@FindBy(css = "#identifierNext")
	private WebElement emailNextBtn;

	@FindBy(css = "input[type='password']")
	private WebElement googlPassword;

	@FindBy(css = "#passwordNext")
	private WebElement passwordNextButton;

	public void inputEmail() {
		Utils.waitForElementToBeVisible(googleEmailField, Utils.Explicit_Wait);
		Utils.sendData(googleEmailField, properties.getProperty("googleOnDemandLogin"));
		Utils.clickOnElement(emailNextBtn);
		
	}
	
	public void inputPassword() {
		Utils.sendData(googlPassword, properties.getProperty("googleOnDemandPassword"));
		
	}

	public GoogleAdminHomepage clickNext() {
		Utils.clickOnElement(passwordNextButton);
		return new GoogleAdminHomepage();
	}

}
