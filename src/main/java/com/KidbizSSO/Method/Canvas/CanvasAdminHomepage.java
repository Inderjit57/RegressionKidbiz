package com.KidbizSSO.Method.Canvas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Canvas.CanvasNewClassAndUser.CanvasCreateNewTeacher;
import com.KidbizSSO.Method.Canvas.CanvasNewClassAndUser.CanvasCreateStudent;
import com.KidbizSSO.Method.Canvas.CanvasNewClassAndUser.CanvasNewClass;
import com.KidbizSSO.Util.Utils;

public class CanvasAdminHomepage extends BaseClass {

	/*
	 * Canvas Admin account page
	 */

	public CanvasAdminHomepage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
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
	public CanvasCreateStudent clickOnALStudent() {
		Utils.waitForElementToBeClickable(clickAL, Utils.waitForSeconds);
		Utils.javascriptClick(clickAL);
		return new CanvasCreateStudent();
	}
	
	public CanvasCreateNewTeacher clickOnALTeacher() {
		Utils.waitForElementToBeClickable(clickAL, Utils.waitForSeconds);
		Utils.javascriptClick(clickAL);
		return new CanvasCreateNewTeacher();
	}

	// This method invokes CanvasNewClass
	public CanvasNewClass clickAL1() {
		Utils.waitForElementToBeClickable(clickAL, Utils.waitForSeconds);
		Utils.javascriptClick(clickAL);
		return new CanvasNewClass();
	}

}
