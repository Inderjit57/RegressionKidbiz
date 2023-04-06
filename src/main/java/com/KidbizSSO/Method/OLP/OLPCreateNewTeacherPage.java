package com.KidbizSSO.Method.OLP;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class OLPCreateNewTeacherPage extends BaseClass {
	public OLPCreateNewTeacherPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "span[class='ng-star-inserted']")
	private WebElement createTeacherPageHeader;

	@FindBy(css = "#givenName")
	private WebElement firstNameOlpTeacher;

	@FindBy(css = "#familyName")
	private WebElement lastNameOlpTeacher;

	@FindBy(css = "#email")
	private WebElement emailOlpTeacher;

	@FindBy(css = "#userName")
	private WebElement userNameOlpTeacher;

	@FindBy(css = "#password")
	private WebElement passwordOlpTeacher;

	@FindBy(css = "input[value='instructor']")
	private WebElement roleOlpTeacher;

	@FindBy(css = "button[class='btn btn-sm dropdown-toggle btn-secondary']")
	private WebElement orgOlpTeacher;

	@FindBy(css = "input[role='searchbox']")
	private WebElement searchbox;

	@FindBy(css = "label[class='ahe-ui-checkbox']")
	private WebElement schoolSearched;

	@FindBy(css = "#staffIdInstructor")
	private WebElement staffOlpId;

	@FindBy(xpath = "//button[@class='btn ngx-shared btn-primary btn btn-primary ms-2']")
	private WebElement createBtn;

	private String[] a3kSchool = { "A3K LITERACY TEST SCHOOL 1", "A3K LITERACY TEST SCHOOL 2",
			"A3K LITERACY TEST SCHOOL 3" };

	private String pickOlpSchool;

	public void inputCredentials() {
		Utils.waitForElementToBeVisible(createTeacherPageHeader, 10);

		/*
		 * Variables declared a to fill the form to create new teacher. Variables are
		 * declared and initialised in the scope of this method, so that for a new
		 * webDriver instance(when invocation count is >1) new random value will be
		 * created. If they are declared at class level, Webdriver takes the old value
		 */
		String firstName = "OLPTeacher" + properties.getProperty("currentDateForUsers")
				+ RandomStringUtils.randomAlphabetic(4);
		String lastName = RandomStringUtils.randomAlphabetic(3);
		String emailOLP = firstName + "_" + lastName + properties.getProperty("emailDomain");
		String userName = firstName;
		String password = properties.getProperty("passwordToSet");
		String staffId = firstName + "." + lastName;

		Utils.sendData(firstNameOlpTeacher, firstName);
		Utils.sendData(lastNameOlpTeacher, lastName);
		Utils.sendData(emailOlpTeacher, emailOLP);
		Utils.sendData(userNameOlpTeacher, userName);
		Utils.sendData(passwordOlpTeacher, password);
		Utils.clickOnElement(roleOlpTeacher);
		Utils.sendData(staffOlpId, staffId);

		System.out.println("UserName: " + firstName);
		System.out.println("Email: " + emailOLP + "\nPassword: " + password);
	}

	public void clickAffiliations() throws Exception {

		/*
		 * Selecting random school from the arraylist above to send to subacount
		 */
		Random randomOlpSchool = new Random();
		int randomOLPSelection = randomOlpSchool.nextInt(a3kSchool.length);

		pickOlpSchool = a3kSchool[randomOLPSelection];
		System.out.println("Course Name: " + pickOlpSchool);
		Utils.clickOnElement(orgOlpTeacher);
		Utils.sendData(searchbox, pickOlpSchool);
		Utils.waitForTextToBePresestInElementValue(Utils.Explicit_Wait, searchbox, pickOlpSchool);
		Thread.sleep(500);
		Utils.clickOnElement(schoolSearched);

		Utils.clickOnElement(orgOlpTeacher);

	}

	public void clickCreate() throws Exception {

		Utils.javascriptClick(createBtn);
		Thread.sleep(2000);
	}
}
