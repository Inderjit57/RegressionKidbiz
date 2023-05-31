package com.KidbizSSO.Method.OLP;

import org.openqa.selenium.By;
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

	@FindBy(css = "div[class='user-name-container ng-star-inserted'] div")
	private WebElement dropdownMenu;

	public void clickDropdown() {
		Utils.waitForElementToBeClickable(dropdownMenu, Utils.Explicit_Wait);
		Utils.clickOnElement(dropdownMenu);
	}

	public AdministratorPage clickAdministrator() {

		WebElement administratorBtn = wd.findElement(By.cssSelector(
				"div[class='cdk-overlay-pane shell-dropdown-menu dropdown-menu ngx-shared d-block overflow-auto p-0'] div ul li:nth-of-type(4)"));
		Utils.waitForElementToBeClickable(administratorBtn, Utils.Explicit_Wait);
		Utils.javascriptClick(administratorBtn);
		return new AdministratorPage();
	}

}
