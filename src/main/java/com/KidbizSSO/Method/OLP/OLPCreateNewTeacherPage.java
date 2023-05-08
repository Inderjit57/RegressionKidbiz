package com.KidbizSSO.Method.OLP;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;
import com.KidbizSSO.Util.WriteIntoExcel;

public class OLPCreateNewTeacherPage extends BaseClass {
	public OLPCreateNewTeacherPage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = "span[class='ng-star-inserted']")
	private WebElement createTeacherPageHeader;

	@FindBy(css = "#givenName")
	private WebElement firstNameOlpTeacher;

	@FindBy(css = "#familyName")
	private WebElement lastNameOlpTeacher;

	@FindBy(css = "#email")
	static WebElement emailOlpTeacher;

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

//	private String[] a3kSchool = { "A3K LITERACY TEST SCHOOL 1", "A3K LITERACY TEST SCHOOL 2",
//			"A3K LITERACY TEST SCHOOL 3" }; 
//	WADE THOMAS SCHOOL/ MANOR ELEMENTARY SCHOOL / BROOKSIDE
	private String[] a3kSchool = { "MANOR ELEMENTARY SCHOOL" };

	private String pickOlpSchool;

	public static String firstName = "teacher" + properties.getProperty("currentDateForUsers")
			+ RandomStringUtils.randomAlphabetic(4);
	public static String lastName = RandomStringUtils.randomAlphabetic(3);
	public static String emailOLP = firstName + "_" + lastName + properties.getProperty("mhEmailDomain");
	String userName = firstName;
	public static String password = properties.getProperty("passwordToSet");
	String staffId = firstName + "." + lastName;

	public void inputCredentials() throws Exception {

		Utils.waitForElementToBeVisible(createTeacherPageHeader, 10);

		Utils.sendData(firstNameOlpTeacher, firstName);
		Utils.sendData(lastNameOlpTeacher, lastName);
		Utils.sendData(emailOlpTeacher, emailOLP);
		Utils.sendData(userNameOlpTeacher, userName);
		Utils.sendData(passwordOlpTeacher, password);
		Utils.clickOnElement(roleOlpTeacher);
		Utils.sendData(staffOlpId, staffId);

		System.out.println("UserName: " + firstName);
		System.out.println("Email: " + emailOLP + "\nPassword: " + password);
		WriteIntoExcel.writeNewUserName(emailOLP);

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
