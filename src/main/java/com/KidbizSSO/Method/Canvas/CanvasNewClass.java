package com.KidbizSSO.Method.Canvas;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;
import com.KidbizSSO.Util.WriteIntoExcel;

public class CanvasNewClass extends BaseClass {
	/*
	 * Canvas add new course page School selection is random from arraylist provided
	 * in the class below
	 */
	public CanvasNewClass() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
	}

	Random rand;
	String pickSchool;

	@FindBy(css = "button[aria-label='Create new course']")
	WebElement addCourseBtn;

	@FindBy(xpath = "//form[@aria-label='Add a New Course']/ div[2] // fieldset// span// span/ span/span/span/span[1]/label/span/span/span[2]/span/input")
	WebElement courseName;

	@FindBy(xpath = "//form[@aria-label='Add a New Course']/ div[2] // fieldset// span// span/ span/span/span/span[2]/label/span/span/span[2]/span/input")
	WebElement referenceCode;

	@FindBy(css = "input[id='accountSelector']")
	WebElement subaccount;

	@FindBy(css = "input[id='termSelector']")
	WebElement enrolmentTerm;

	@FindBy(css = "button[type='submit']")
	WebElement submitAddCourse;

	@FindBy(css = "form[aria-label='Add a New Course']")
	WebElement addNewCourseWindow;

	String enterCourseName = "Canvas_Class_" + RandomStringUtils.randomAlphabetic(3)
			+ RandomStringUtils.randomAlphabetic(2);

	private String[] schoolName = { "CANVAS Luda's Test School K+S+A", "CANVAS Luda's Test School K+S+M",
			"CANVAS Luda's Test School K+M", "CANVAS Luda's Test School K+A", "CANVAS Luda's Test School K only",
			"CANVAS Luda's Test School K+S" };

	private String term = "Default Term";

	public void addcourse() throws Exception {

		Utils.clickOnElement(addCourseBtn);
		Utils.waitForElementToBeVisible(addNewCourseWindow, 10);
		Utils.javascriptClick(courseName);

		Utils.sendData(courseName, enterCourseName);
		System.out.println("Course Name: " + enterCourseName);

		Utils.sendData(referenceCode, enterCourseName);

		Utils.javascriptClick(subaccount);

		/*
		 * Selecting random school from the arraylist above to send to subacount
		 */
		rand = new Random();
		int randomSelection = rand.nextInt(schoolName.length);

		pickSchool = schoolName[randomSelection];
		Utils.sendData(subaccount, pickSchool);

		Utils.sendData(enrolmentTerm, term);

		Utils.clickOnElement(submitAddCourse);

		System.out.println("Course Name: " + pickSchool);

		// Send random user created to excel file using the following method
		WriteIntoExcel.writeNewCourseName(enterCourseName);
	}

}
