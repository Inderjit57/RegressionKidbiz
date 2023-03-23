package com.KidbizSSO.Method.Canvas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class CanvasAdminHomepage extends BaseClass {
	
	/*
	 * Canvas Admin account page
	 */

	public CanvasAdminHomepage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
	}

	// Admin
	@FindBy(css = "#global_nav_accounts_link")
	WebElement adminbtn;

	public void clickAdmin() {
		Utils.waitForElementToBeClickable(adminbtn, Utils.waitForSeconds);
		Utils.clickOnElement(adminbtn);

	}

	// Actively Learn
	@FindBy(css = ".tray-with-space-for-global-nav div ul li:nth-of-type(1) a")
	WebElement clickAL;
	
	// This methods invokes CanvasCreateUserPage
	public CanvasCreateUserPage clickOnAL() {
		Utils.waitForElementToBeClickable(clickAL, Utils.waitForSeconds);
		Utils.javascriptClick(clickAL);
		return new CanvasCreateUserPage();
	}
	
	// This method invokes CanvasNewClass
	public CanvasNewClass clickAL1() {
		Utils.waitForElementToBeClickable(clickAL, Utils.waitForSeconds);
		Utils.javascriptClick(clickAL);
		return new CanvasNewClass();
	}

}
