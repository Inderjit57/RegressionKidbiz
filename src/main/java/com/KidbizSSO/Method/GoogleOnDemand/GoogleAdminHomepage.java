package com.KidbizSSO.Method.GoogleOnDemand;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;
import com.KidbizSSO.Util.WriteIntoExcel;

public class GoogleAdminHomepage extends BaseClass {
	/*
	 * Add New User on Google Admin Page
	 */
	public GoogleAdminHomepage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = ".vQa6Je.Rn1nec div[aria-label='Add a user']")
	private WebElement AddUserBtn;

	// Credentials for new google User

	@FindBy(css = "input[aria-Label='First name *']")
	private WebElement firstNameField;

	@FindBy(css = "input[aria-Label='Last name *']")
	private WebElement lastNameField;

	@FindBy(css = ".IiN9nd div[aria-Label='Add new user']")
	private WebElement addNewUserBtn;

	// New User email and password window
	@FindBy(css = "div[class='sT5Ksb']")
	private WebElement newUserName;

	@FindBy(css = "div[class='oxkSlb'] div:nth-of-type(2) div[role='button']")
	private WebElement doneBtn1;

	// Done Button on copy password window
	@FindBy(css = "span[class='PbnGhe oJeWuf fb0g6 MR2XUb'] div[class='nL3Jpb J9fJmf'] span[class='CwaK9']")
	private WebElement doneBtn2;

	public static String firstName = Utils.fakeFirstNameGenerator();

	public static String lastName = Utils.fakeLastNameGenerator() + RandomStringUtils.randomAlphabetic(2);

	public void clickAddUserBtn() {
		Utils.clickOnElement(AddUserBtn);
	}

	public void inputInfo() {
		Utils.waitForElementToBeVisible(firstNameField, Utils.Explicit_Wait);
		Utils.sendData(firstNameField, firstName);
		Utils.sendData(lastNameField, lastName);
		System.out.println("FirstName: " + firstName);
	}

	public void clickAddNewUserBtn() {
		Utils.clickOnElement(addNewUserBtn);
	}

	public GoogleUserProfilePage getNewUserInfo() throws Exception {
		Utils.waitForElementToBeVisible(newUserName, Utils.Explicit_Wait);

		String newUserEmail = newUserName.getText().substring(10);
		System.out.println("User Email: " + newUserEmail);
		Utils.clickOnElement(doneBtn1);
		Utils.clickOnElement(doneBtn2);

		WriteIntoExcel.writeNewUserName(newUserEmail);

		return new GoogleUserProfilePage();
	}

}
