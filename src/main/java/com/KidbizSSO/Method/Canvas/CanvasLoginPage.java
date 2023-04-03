package com.KidbizSSO.Method.Canvas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class CanvasLoginPage extends BaseClass {

	/*
	 * Canvas Login page
	 */

	public CanvasLoginPage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	// Email
	@FindBy(css = "#pseudonym_session_unique_id")
	WebElement email;

	public void inputEmail() {
		Utils.sendData(email, properties.getProperty("emailCanvas"));
	}

	// Password
	@FindBy(css = "#pseudonym_session_password")
	WebElement password;

	public void inputPassword() {
		Utils.sendData(password, properties.getProperty("passCanvas"));
	}

	// LoginButton
	@FindBy(css = "#login_form div div button[class='Button Button--login']")
	WebElement loginBtn;

	public CanvasAdminHomepage clickLogin() {
		Utils.clickOnElement(loginBtn);
		return new CanvasAdminHomepage();
	}

}
