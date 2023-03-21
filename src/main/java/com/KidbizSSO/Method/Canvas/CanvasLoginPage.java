package com.KidbizSSO.Method.Canvas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;

public class CanvasLoginPage extends BaseClass {
	public CanvasLoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
	}
	
	//Email
	@FindBy(css = "#pseudonym_session_unique_id")
	WebElement email;

	public void inputEmail() {
		email.sendKeys(properties.getProperty("emailCanvas"));
	}

	//Password
	@FindBy(css = "#pseudonym_session_password")
	WebElement password;

	public void inputPassword() {
		password.sendKeys(properties.getProperty("passCanvas"));
	}
	
	//LoginButton
	@FindBy(css = "#login_form div div button[class='Button Button--login']")
	WebElement loginBtn;
	public CanvasAdminHomepage clickLogin() {
		loginBtn.click();
		return new CanvasAdminHomepage();
	}

}
