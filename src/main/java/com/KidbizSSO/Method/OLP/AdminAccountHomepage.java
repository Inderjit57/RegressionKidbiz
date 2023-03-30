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

		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div[class='dropdown ng-tns-c109-0']")
	WebElement dropdownMenu;

	@FindBy(css = "button[aria-label='administrator']")
	WebElement administratorBtn;

	public void clickDropdown() {
		Utils.clickOnElement(dropdownMenu);
	}

	public AdministratorPage clickAdministrator() {
		Utils.actionClick(dropdownMenu);
		return new AdministratorPage();
	}

}
