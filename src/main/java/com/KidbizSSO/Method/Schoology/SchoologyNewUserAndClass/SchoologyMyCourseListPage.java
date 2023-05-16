package com.KidbizSSO.Method.Schoology.SchoologyNewUserAndClass;

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

public class SchoologyMyCourseListPage extends BaseClass {
	/*
	 * Schoology: Mycourse page which shows a whole list of courses and Create a
	 * course button
	 */

	public SchoologyMyCourseListPage() {

		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	// Create New Course button
	@FindBy(css = "div[class='course-action-btns'] a:nth-of-type(2)")
	private WebElement createCourseBtn;

	// Popup to create new course
	@FindBy(css = "a[class='select2-choice']")
	private WebElement school;

	@FindBy(css = "#s2id_autogen1_search")
	private WebElement schoolSelection;

	@FindBy(css = "input[id='edit-course-name']")
	private WebElement courseName;

	@FindBy(css = "input[id='edit-section-name-1']")
	private WebElement sectionName;

	@FindBy(css = "select[id='edit-subject-area']")
	private WebElement subjectArea;

	@FindBy(css = "select[id='edit-grade-level-range-start']")
	private WebElement level;

	@FindBy(css = "div[class='existing-grading-period-item']")
	private WebElement gradingPeriods;

	@FindBy(css = ".submit-buttons input[type='submit']")
	private WebElement createBtn;

	// select Random School from the list and send it to UI
	private String[] schoologySchoolName = { "SCHOOLOGY Luda's Test School K+M", "SCHOOLOGY Luda's Test School K+A",
			"SCHOOLOGY Luda's Test School K only", "SCHOOLOGY Luda's Test School K+S" };
	Random randomSchoologySchool;
	private String pickSchoologySchool;
	private int randomSelection1;
	private int randomSelection2;
	private int randomSelection3;

	public void clickCreateSchoologyCourse() {
		wd.navigate().refresh();
		Utils.clickOnElement(createCourseBtn);

	}

	public void clickSchool() throws Exception {

		wait.until(ExpectedConditions.elementToBeClickable(school));
		Utils.clickOnElement(school);

		randomSchoologySchool = new Random();
		randomSelection1 = randomSchoologySchool.nextInt(schoologySchoolName.length);
		pickSchoologySchool = schoologySchoolName[randomSelection1];

		System.out.println("School picked: " + pickSchoologySchool);

		List<WebElement> selectPickedSchool = wd.findElements(By.xpath("// div[@id='select2-drop']/ ul/li"));
		for (WebElement element : selectPickedSchool) {

			if (element.getText().equals(pickSchoologySchool)) {
				element.click();
				break;
			} else
				continue;
		}
		Thread.sleep(2000);

	}

	public void inputCourseAndSection() {

		String enterSchoologyCourseName = "SchoologyClass_" + properties.getProperty("currentDateForUsers")
				+ RandomStringUtils.randomAlphabetic(4);

		Utils.sendData(courseName, enterSchoologyCourseName);
		System.out.println("CourseName: " + enterSchoologyCourseName);

		sectionName.clear();
		Utils.clickOnElement(sectionName);
		Utils.sendData(sectionName, enterSchoologyCourseName);
	}

	public void subjectAreaSelect() {
		List<WebElement> selectSubject = wd.findElements(By.xpath("//select[@id='edit-subject-area'] / option"));
		randomSelection2 = randomSchoologySchool.nextInt(selectSubject.size());
		Utils.selectFromDropDownUsingIndex(subjectArea, randomSelection2);
		Utils.waitForElementToBeSelectable(subjectArea, Utils.Explicit_Wait);
	}

	public void selectLevelAndGrade() {
		List<WebElement> levelselect = wd
				.findElements(By.xpath("//select[@id='edit-grade-level-range-start']/optgroup[1]/option"));
		randomSelection3 = randomSchoologySchool.nextInt(levelselect.size());
		Utils.selectFromDropDownUsingIndex(level, randomSelection3);
		Utils.waitForElementToBeSelectable(level, Utils.Explicit_Wait);

		Utils.clickOnElement(gradingPeriods);
	}

	public void clickCreateBtn() throws Exception {
		Utils.submitInfo(createBtn);
		Thread.sleep(2000);
	}

}
