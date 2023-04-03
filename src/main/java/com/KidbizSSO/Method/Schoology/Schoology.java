package com.KidbizSSO.Method.Schoology;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;

public class Schoology extends BaseClass {
	public Schoology() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = "#edit-mail")
	WebElement inputEmail;

	@FindBy(css = "#edit-pass")
	WebElement inputPass;

	@FindBy(css = "#edit-submit")
	WebElement clickLogin;

	public void email(String em) {
		inputEmail.sendKeys(em);
	}

	public void pass(String password) {
		inputPass.sendKeys(password);
	}

	public SchoologyHomepage signIn() {
		clickLogin.click();
		return new SchoologyHomepage();
	}

}
