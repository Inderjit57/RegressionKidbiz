package com.KidbizSSO.Method.Canvas;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;
import com.KidbizSSO.Util.WriteIntoExcel;

import net.bytebuddy.utility.RandomString;

public class CanvasCreateUserPage extends BaseClass {

	/*
	 * Canvas - Actively learn page after clicking on AL in the navigation bar - To
	 * create users
	 */

	public CanvasCreateUserPage() {
		PageFactory.initElements(wd, this);
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
	WebElement fullName;

	@FindBy(css = "input[label='Sortable Name']")
	WebElement sortableName;

	@FindBy(css = "input[label='Email']")
	WebElement email;

	@FindBy(css = "input[label='SIS ID']")
	WebElement sisID;

	@FindBy(css = "button[type='submit']")
	WebElement addUserBtn;

	@FindBy(css = "form[aria-label='Add a New User'] div")
	WebElement addNewUserFormWindow;

	public void fillForm() {
		Utils.waitForElementToBeVisible(addNewUserFormWindow, 10);

		/*
		 * Variables declared a to fill the form to create new teacher. Variables are
		 * declared and initialised in the scope of this method, so that for a new
		 * webDriver instance(when invocation count is >1) new random value will be
		 * created. If they are declared at class level, Webdriver takes the old value
		 */
		String firstName = RandomStringUtils.randomAlphabetic(4); // Generic for Student and Teacher Account
		String lastName = RandomStringUtils.randomAlphabetic(3); // Generic for Student and Teacher Account
		String enterFullName = firstName + ", " + lastName; // Last name needs a space on Canvas while creating user
		String enterSortable = " " + lastName; // Issue on Canvas side, it doesn't put the last name in sortable name
		String enterEmail = firstName + "@gmail.com";
		String enterSISID = lastName;

		Utils.javascriptClick(fullName);

		System.out.println("Full Name: " + enterFullName + "\nSIS ID: " + enterSISID);

		Utils.sendData(fullName, enterFullName);
		sortableName.clear();
		Utils.sendData(sortableName, enterSortable);
		Utils.sendData(email, enterEmail);
		Utils.sendData(sisID, enterSISID);
		Utils.submitInfo(addUserBtn);

		// Send random user created to excel file using the following method
//		WriteIntoExcel.writeNewUserName(enterFullName);

	}

}
