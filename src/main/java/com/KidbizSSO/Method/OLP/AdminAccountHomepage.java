package com.KidbizSSO.Method.OLP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class AdminAccountHomepage extends BaseClass {

	/*
	 * OLP/MH - Admin account landing page
	 */
	public AdminAccountHomepage() {

		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = "div[id='menu-user-role']")
	private WebElement roleMenu;

	@FindBy(css = "div[id='menu-user-role'] div a:nth-of-type(1)")
	private WebElement administratorRole;

	public void clickDropdown() {
		Utils.waitForElementToBeClickable(roleMenu, Utils.Explicit_Wait);
		Utils.clickOnElement(roleMenu);
	}

	public AdministratorPage clickAdministrator() {
		Utils.javascriptClick(administratorRole);
		return new AdministratorPage();
	}

}
