package com.KidbizSSO.Method.OLP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.OLP.NewTeachSingleSchAndClassEnrl.NewTeacherAccountPolicyConfirmPage;
import com.KidbizSSO.Method.OLP.NewTeachSingleSchAndClassEnrl.NewTeacherConnectEdHomepage;
import com.KidbizSSO.Util.Utils;

public class OLPLoginPage extends BaseClass {

	public OLPLoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = "input[query-id='login.username']")
	private WebElement email;

	@FindBy(css = "input[query-id='login.password']")
	private WebElement password;

	@FindBy(css = "button[type='submit']")
	private WebElement loginBtn;

	public void inputEmailPassword() {
		Utils.waitForElementToBeVisible(email, Utils.Explicit_Wait);
		Utils.sendData(email, properties.getProperty("emailMH"));
		Utils.sendData(password, properties.getProperty("passwordMH"));
	}

	public AdminAccountHomepage clickLoginBtn() {
		Utils.clickOnElement(loginBtn);
		return new AdminAccountHomepage();
	}

	/*
	 * Getting Email and Password generated in OLPCreateNewTeacherPage and Login to
	 * new teacher account
	 * 
	 */

	public void getEmailPasswordFromNewTeacherPage() {
		Utils.waitForElementToBeVisible(email, Utils.Explicit_Wait);
		Utils.sendData(email, OLPCreateNewTeacherPage.emailOLP);
		Utils.sendData(password, OLPCreateNewTeacherPage.password);
	}

	public NewTeacherAccountPolicyConfirmPage loginToNewTeacher() {
		Utils.clickOnElement(loginBtn);
		return new NewTeacherAccountPolicyConfirmPage();
	}
	
	public NewTeacherConnectEdHomepage loginToNewTeachConnectEDdash() {
		Utils.clickOnElement(loginBtn);
		return new NewTeacherConnectEdHomepage();
	}
	
	//For UAT Admin account
	public ConnectEdDashboardPage loginToConnectEDdash() {
		Utils.clickOnElement(loginBtn);
		return new ConnectEdDashboardPage();
	}

}
