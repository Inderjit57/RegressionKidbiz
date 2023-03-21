package com.KidbizSSO.Method.Canvas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;

public class CanvasAdminHomepage extends BaseClass {

	public CanvasAdminHomepage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
	}

	// Admin
	@FindBy(css = "#global_nav_accounts_link")
	WebElement adminbtn;

	public void clickAdmin() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#global_nav_accounts_link")));
		adminbtn.click();

	}

	// Actively Learn
	@FindBy(css = ".tray-with-space-for-global-nav div ul li:nth-of-type(1) a")
	WebElement clickAL;

	public CanvasSearchPage clickOnAL() {

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector(".tray-with-space-for-global-nav div ul li:nth-of-type(1)")));
		javascriptExecutor.executeScript("arguments[0].click();", clickAL);
		return new CanvasSearchPage();
	}

}
