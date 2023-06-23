package com.KidbizSSO.Method.OLP;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;
import com.KidbizSSO.Util.WriteIntoExcel;

public class OLPCreateNewStudentPage extends BaseClass {

	public OLPCreateNewStudentPage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = "span[class='ng-star-inserted']")
	private WebElement createStudentPageHeader;

	@FindBy(css = "#givenName")
	private WebElement firstNameOlpStudent;

	@FindBy(css = "#familyName")
	private WebElement lastNameOlpStudent;

	@FindBy(css = "main[data-automation-id='sideapps-main-content'] div[id='studentCreateEdit'] div form div:nth-of-type(5) button")
	private WebElement studentGradeLevel;

	@FindBy(css = "div[class='cdk-overlay-container'] div ul li")
	private WebElement gradeList;

	@FindBy(css = "#email")
	private WebElement emailOlpStudent;

	@FindBy(css = "#userName")
	private WebElement userNameOlpStudent;

	@FindBy(css = "#password")
	private WebElement passwordOlpStudent;

	@FindBy(css = "button[class='btn btn-sm dropdown-toggle btn-secondary']")
	private WebElement schoolOlpStudent;

	@FindBy(css = "input[role='searchbox']")
	private WebElement searchbox;

	@FindBy(css = "label[class='ahe-ui-checkbox']")
	private WebElement schoolSearched;

	@FindBy(css = "#studentId")
	private WebElement studentIdOlp;

	@FindBy(css = "button[data-automation-id='student-create-submit-button']")
	private WebElement createBtn;

	private String[] a3kSchool = { "A3K LITERACY TEST SCHOOL 1", "A3K LITERACY TEST SCHOOL 2",
			"A3K LITERACY TEST SCHOOL 3" };

	private String pickOlpSchool;

	private int randomOLPGradeSelection;

	public void inputCredentials() throws Exception {
		Utils.waitForElementToBeVisible(createStudentPageHeader, 10);

		/*
		 * Variables declared a to fill the form to create new teacher. Variables are
		 * declared and initialised in the scope of this method, so that for a new
		 * webDriver instance(when invocation count is >1) new random value will be
		 * created. If they are declared at class level, Webdriver takes the old value
		 */
		String firstName = Utils.fakeFirstNameGenerator();
		String lastName = Utils.fakeLastNameGenerator();
		String emailOLP = firstName + "." + lastName + properties.getProperty("mhEmailDomain");
		String userName = firstName;
		String password = properties.getProperty("passwordToSet");
		String studentId = firstName + "." + lastName;

		Utils.sendData(firstNameOlpStudent, firstName);
		Utils.sendData(lastNameOlpStudent, lastName);

		Utils.waitForElementToBeClickable(studentGradeLevel, Utils.Explicit_Wait);
		Utils.clickOnElement(studentGradeLevel);
		Thread.sleep(1000);

		// Select grade from the list randomly
		Random randomIntForGradeSelection = new Random();
		List<WebElement> olpGradeList = wd.findElements(By.cssSelector("div[class='cdk-overlay-container'] div ul li"));

		randomOLPGradeSelection = randomIntForGradeSelection.nextInt(olpGradeList.size());

		for (int i = 0; i <= olpGradeList.size(); i++) {
			if (i == randomOLPGradeSelection) {
				olpGradeList.get(i).click();
				break;
			} else
				continue;
		}

		Utils.sendData(emailOlpStudent, emailOLP);
		Utils.sendData(userNameOlpStudent, userName);
		Utils.sendData(passwordOlpStudent, password);

		// Select School from List
		Utils.clickOnElement(schoolOlpStudent);

		/*
		 * Selecting random school from the arraylist above to send to subacount
		 */
		Random randomIntForOlpSchool = new Random();
		int randomIntToSelectSchool = randomIntForOlpSchool.nextInt(a3kSchool.length);
		pickOlpSchool = a3kSchool[randomIntToSelectSchool];
		System.out.println("School Name: " + pickOlpSchool);

		Utils.sendData(searchbox, pickOlpSchool);
		Utils.waitForTextToBePresestInElementValue(Utils.Explicit_Wait, searchbox, pickOlpSchool);
		Thread.sleep(500);
		Utils.clickOnElement(schoolSearched);
		Utils.clickOnElement(schoolOlpStudent);

		Utils.sendData(studentIdOlp, studentId);

		System.out.println("UserName: " + firstName);
		System.out.println("Email: " + emailOLP + "\nPassword: " + password);
		WriteIntoExcel.writeNewUserName(emailOLP);
	}

	public void clickCreate() throws Exception {

		Utils.javascriptClick(createBtn);
		Thread.sleep(2000);
	}
}
