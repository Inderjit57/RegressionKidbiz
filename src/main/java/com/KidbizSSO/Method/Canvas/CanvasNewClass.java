package com.KidbizSSO.Method.Canvas;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;
import com.KidbizSSO.Util.WriteIntoExcel;

public class CanvasNewClass extends BaseClass {
	/*
	 * Canvas add new course page. School selection is random from arraylist
	 * provided in the class below
	 */
	public CanvasNewClass() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
	}

	String pickSchool;

	@FindBy(css = "button[aria-label='Create new course']")
	private WebElement addCourseBtn;

	@FindBy(xpath = "//form[@aria-label='Add a New Course']/ div[2] // fieldset// span// span/ span/span/span/span[1]/label/span/span/span[2]/span/input")
	private WebElement courseName;

	@FindBy(xpath = "//form[@aria-label='Add a New Course']/ div[2] // fieldset// span// span/ span/span/span/span[2]/label/span/span/span[2]/span/input")
	private WebElement referenceCode;

	@FindBy(css = "input[id='accountSelector']")
	private WebElement subaccount;

	@FindBy(css = "input[id='termSelector']")
	private WebElement enrolmentTerm;

	@FindBy(css = "button[type='submit']")
	private WebElement submitAddCourse;

	@FindBy(css = "form[aria-label='Add a New Course']")
	private WebElement addNewCourseWindow;

	private String[] schoolName = { "CANVAS Luda's Test School K+S+A", "CANVAS Luda's Test School K+S+M",
			"CANVAS Luda's Test School K+M", "CANVAS Luda's Test School K+A", "CANVAS Luda's Test School K only",
			"CANVAS Luda's Test School K+S" };

	private String term = "Default Term";

	public void clickCourse() {

		Utils.clickOnElement(addCourseBtn);

	}

	public void inputCourseAndReferenceCode() {
		Utils.waitForElementToBeVisible(addNewCourseWindow, 10);
		Utils.javascriptClick(courseName);
		/*
		 * Variables declared a to fill the form to create new teacher. Variables are
		 * declared and initialised in the scope of this method, so that for a new
		 * webDriver instance(when invocation count is >1) new random value will be
		 * created. If they are declared at class level, Webdriver takes the old value
		 */
		String enterCourseName = "CanvasClass_" + properties.getProperty("currentDateForUsers")
				+ RandomStringUtils.randomAlphabetic(5);
		Utils.sendData(courseName, enterCourseName);
		System.out.println("Course Name: " + enterCourseName);

		Utils.sendData(referenceCode, enterCourseName);

	}

	public void selectSubaccount() throws Exception {
		Utils.javascriptClick(subaccount);
		/*
		 * Selecting random school from the arraylist above to send to subacount
		 */
		Random rand = new Random();
		int randomSelection = rand.nextInt(schoolName.length);

		pickSchool = schoolName[randomSelection];
		System.out.println("Course Name: " + pickSchool);

		Utils.sendData(subaccount, pickSchool);
		Utils.waitForTextToBePresestInElementValue(Utils.Explicit_Wait, subaccount, pickSchool);

		Utils.clickOnElement(subaccount);
		Thread.sleep(2000);
		// Send random user created to excel file using the following method
//		WriteIntoExcel.writeNewCourseName(CanvasNewClass.enterCourseName);
	}

	public void selectEnrolmentTerm() {
		Utils.sendData(enrolmentTerm, term);
	}

	public void clickAddCourse() {
		Utils.clickOnElement(submitAddCourse);
	}

}
