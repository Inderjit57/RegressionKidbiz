package com.KidbizSSO.Method.OLP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class AdministratorPage extends BaseClass {

	/*
	 * Administrator account page to create Create Users/Manager Class Rosters
	 */
	public AdministratorPage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = "h1[class='header-title']")
	private WebElement headerTitle;

	@FindBy(css = "ul[class='nav nav-tabs mb-3'] li:nth-of-type(2)")
	private WebElement staffSection;
	
	@FindBy(css = "a[class='btn btn-primary d-inline-flex flex-column justify-content-center']")
	private WebElement createStaffBtn;

	@FindBy(css = "ul[class='nav nav-tabs mb-3'] li:nth-of-type(1)")
	private WebElement studentsSection;
	
	@FindBy(css = "a[class='btn btn-primary d-inline-flex flex-column justify-content-center']")
	private WebElement createStudentBtn;

	

	public void clickStaff() {
		Utils.waitForElementToBeVisible(headerTitle, Utils.waitForSeconds);
		Utils.clickOnElement(staffSection);
	}

	public void clickStudent() {
		Utils.clickOnElement(studentsSection);
	}

	public OLPCreateNewTeacherPage clickCreateStaffBtn() {
		Utils.clickOnElement(createStaffBtn);
		return new OLPCreateNewTeacherPage();
	}
	
	public OLPCreateNewStudentPage clickCreateStudentBtn() {
		Utils.clickOnElement(createStudentBtn);
		return new OLPCreateNewStudentPage();
	}

}
