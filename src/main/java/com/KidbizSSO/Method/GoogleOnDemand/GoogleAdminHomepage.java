package com.KidbizSSO.Method.GoogleOnDemand;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

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
	WebElement doneBtn1;

	// Done Button on copy password window
	@FindBy(css = "span[class='PbnGhe oJeWuf fb0g6 MR2XUb'] div[class='nL3Jpb J9fJmf'] span[class='CwaK9']")
	WebElement doneBtn2;

	// Search for newUSer
	@FindBy(css = "input[aria-label='Search for users, groups or settings']")
	WebElement searchBar;

	@FindBy(xpath = "//div[@class=' tWfTvb'] /div[@role='listbox']/ div/div[1]/div[2]")
	private WebElement searchItem;

	public static String firstName = "Googletch" + properties.getProperty("currentDateForUsers")
			+ RandomStringUtils.randomAlphabetic(4);

	public static String lastName = RandomStringUtils.randomAlphabetic(3);

	public void clickAddUserBtn() {
		Utils.clickOnElement(AddUserBtn);
	}

	public void inputInfo() {
		Utils.waitForElementToBeVisible(firstNameField, Utils.Explicit_Wait);
		Utils.sendData(firstNameField, firstName);
		Utils.sendData(lastNameField, lastName);
		System.out.println("FirstName: "+ firstName);
	}

	public void clickAddNewUserBtn() {
		Utils.clickOnElement(addNewUserBtn);
	}

	public void getNewUserInfo() {
		Utils.waitForElementToBeVisible(newUserName, Utils.Explicit_Wait);
		System.out.println("User Email: " + newUserName.getText());
		Utils.clickOnElement(doneBtn1);
		Utils.clickOnElement(doneBtn2);
		
	}

	public GoogleUserProfilePage searchForUser() throws Exception{
		Thread.sleep(1500);
		Utils.sendData(searchBar, firstName);
		Utils.waitForTextToBePresestInElementValue(Utils.Explicit_Wait, searchBar, firstName);
		Utils.waitForElementToBeClickable(searchBar, Utils.Explicit_Wait);
		Utils.clickOnElement(searchItem);

		return new GoogleUserProfilePage();
	}

}
