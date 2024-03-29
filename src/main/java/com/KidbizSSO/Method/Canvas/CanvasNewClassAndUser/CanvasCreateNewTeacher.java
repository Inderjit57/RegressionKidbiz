package com.KidbizSSO.Method.Canvas.CanvasNewClassAndUser;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;
import com.KidbizSSO.Util.WriteIntoExcel;

public class CanvasCreateNewTeacher extends BaseClass {

	/*
	 * Canvas - Actively learn page after clicking on AL in the navigation bar - To
	 * create users
	 */

	public CanvasCreateNewTeacher() {
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

	public void fillTeacherForm() throws Exception {
		Utils.waitForElementToBeVisible(addNewUserFormWindow, 10);

		/*
		 * Variables are declared and initialised in the scope of this method, so that
		 * for a new webDriver instance(when invocation count is >1) new random value
		 * will be created. If they are declared at class level, Webdriver takes the old
		 * value
		 */

		String teacherFirstName = "tch" + Utils.fakeFirstNameGenerator(); // Generic for Student and Teacher Account
		String teacherLastName = Utils.fakeLastNameGenerator(); // Generic for Student and Teacher Account
		String teacherEnterFullName = teacherFirstName + ", " + teacherLastName; // Last name needs a space on
																					// Canvas while creating user
		String teacherEnterSortable = " " + teacherLastName; // Issue on Canvas side, it doesn't put the last name
																// in sortable name
		String teacherEnterEmail = teacherFirstName + properties.getProperty("emailDomain");
		String teacherEnterSISID = teacherLastName;

		Utils.javascriptClick(fullName);

		System.out.println("Full Name: " + teacherEnterFullName + "\nSIS ID: " + teacherEnterSISID);

		// Send random user created to excel file using the following method
		WriteIntoExcel.writeNewUserName(teacherEnterFullName);

		Utils.sendData(fullName, teacherEnterFullName);
		sortableName.clear();
		Utils.sendData(sortableName, teacherEnterSortable);
		Utils.sendData(email, teacherEnterEmail);
		Utils.sendData(sisID, teacherEnterSISID);

	}

	public void clickSubmitBtn() throws Exception {
		Utils.submitInfo(addUserBtn);
		Thread.sleep(1000);
	}

}
