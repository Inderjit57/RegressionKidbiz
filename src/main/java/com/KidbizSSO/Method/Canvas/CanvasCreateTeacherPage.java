package com.KidbizSSO.Method.Canvas;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class CanvasCreateTeacherPage extends BaseClass {

	/*
	 * Canvas - Actively learn page after clicking on AL in the navigation bar - To
	 * create users
	 */

	public CanvasCreateTeacherPage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	// People - in left Navigation
	@FindBy(css = "a[class='users']")
	WebElement peopleBtn;

	public void clickPeople() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='users']")));
		peopleBtn.click();
	}

	// People btn to create new user
	@FindBy(css = "button[aria-label='Add people']")
	WebElement peopleBtnCreateUser;

	public void clickpeopleForm() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Add people']")));
		peopleBtnCreateUser.click();
	}

	/*
	 * Add new User Form
	 */
	@FindBy(css = "form[aria-label='Add a New User'] input[label='Full Name']")
	private WebElement fullName;

	@FindBy(css = "input[label='Sortable Name']")
	private WebElement sortableName;

	@FindBy(css = "input[label='Email']")
	private WebElement email;

	@FindBy(css = "input[label='SIS ID']")
	private WebElement sisID;

	@FindBy(css = "button[type='submit']")
	private WebElement addUserBtn;

	@FindBy(css = "form[aria-label='Add a New User'] div")
	private WebElement addNewUserFormWindow;

	public void fillForm() throws Exception {
		Utils.waitForElementToBeVisible(addNewUserFormWindow, 10);

		/*
		 * Variables declared a to fill the form to create new teacher. Variables are
		 * declared and initialised in the scope of this method, so that for a new
		 * webDriver instance(when invocation count is >1) new random value will be
		 * created. If they are declared at class level, Webdriver takes the old value
		 */
		String firstName = "Teacher" + properties.getProperty("currentDateForUsers")
				+ RandomStringUtils.randomAlphabetic(4); // Generic for Student and Teacher Account
		String lastName = RandomStringUtils.randomAlphabetic(3); // Generic for Student and Teacher Account
		String enterFullName = firstName + ", " + lastName; // Last name needs a space on Canvas while creating user
		String enterSortable = " " + lastName; // Issue on Canvas side, it doesn't put the last name in sortable name
		String enterEmail = firstName + properties.getProperty("emailDomain");
		String enterSISID = lastName;

		Utils.javascriptClick(fullName);

		System.out.println("Full Name: " + enterFullName + "\nSIS ID: " + enterSISID);

		Utils.sendData(fullName, enterFullName);
		sortableName.clear();
		Utils.sendData(sortableName, enterSortable);
		Utils.sendData(email, enterEmail);
		Utils.sendData(sisID, enterSISID);
		Utils.submitInfo(addUserBtn);
		Thread.sleep(1000);

		// Send random user created to excel file using the following method
//		WriteIntoExcel.writeNewUserName(enterFullName);

	}

}
