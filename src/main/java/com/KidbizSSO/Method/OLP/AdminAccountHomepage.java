package com.KidbizSSO.Method.OLP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

import bsh.util.Util;

public class AdminAccountHomepage extends BaseClass {

	/*
	 * OLP/MH - Admin account landing page
	 */
	public AdminAccountHomepage() {

		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = "div[class='dropdown ng-tns-c109-0']")
	WebElement dropdownMenu;

	@FindBy(css = "button[aria-label='administrator']")
	WebElement administratorBtn;

	public void clickDropdown() {
		Utils.waitForElementToBeClickable(dropdownMenu, 10);
		Utils.clickOnElement(dropdownMenu);
	}

	public AdministratorPage clickAdministrator() {
//		Utils.waitForElementToBeClickable(dropdownMenu, 10);
		Utils.actionClick(administratorBtn);
		return new AdministratorPage();
	}

}
