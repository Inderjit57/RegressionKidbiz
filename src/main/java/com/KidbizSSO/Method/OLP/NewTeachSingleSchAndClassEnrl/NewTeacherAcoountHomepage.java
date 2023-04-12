package com.KidbizSSO.Method.OLP.NewTeachSingleSchAndClassEnrl;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class NewTeacherAcoountHomepage extends BaseClass {
	public NewTeacherAcoountHomepage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = ".filter-group button[title='Create a Class']")
	WebElement createClassBtn;

	@FindBy(xpath = "//div[@role='tablist']/ div/span[text()=' Achieve3000 Literacy ']")
	WebElement productAch3000Lit;

	@FindBy(css = "#className")
	WebElement className;

	@FindBy(css = "select[id='subject']")
	WebElement subject;

	@FindBy(css = "select[id='gradeLevel']")
	WebElement gradeLevel;

	@FindBy(css = "#dlg-submit-button")
	WebElement complete;

	String randomClassName = "class" + properties.getProperty("currentDateForUsers")
			+ RandomStringUtils.randomAlphabetic(4);

	private int randomSubjectSelection;
	private int randomGradeSelection;

	public void clickCreateClassBtn() {
		Utils.waitForElementToBeClickable(createClassBtn, Utils.Explicit_Wait);
		Utils.clickOnElement(createClassBtn);
	}

	public void clickProduct() {
		Utils.clickOnElement(productAch3000Lit);
	}

	public void createClassInfo() {
		Utils.sendData(className, randomClassName);
		System.out.println("ClassName: " + randomClassName);

	}

	public void selectSubject() {
		Random randomIntForSubjectSelection = new Random();
		List<WebElement> subjectList = wd.findElements(By.cssSelector("select[id='subject'] option"));

		randomSubjectSelection = randomIntForSubjectSelection.nextInt(subjectList.size());

		Utils.selectFromDropDownUsingIndex(subject, randomSubjectSelection);
	}

	public void selectGrade() {
		Random randomIntForGradeSelection = new Random();
		List<WebElement> olpGradeList = wd.findElements(By.cssSelector("select[id='gradeLevel'] option"));

		randomGradeSelection = randomIntForGradeSelection.nextInt(olpGradeList.size());

		Utils.selectFromDropDownUsingIndex(gradeLevel, randomGradeSelection);
		Utils.waitForElementToBeSelectable(gradeLevel, Utils.Explicit_Wait);
	}

	public void clickComplete() throws Exception {
		Utils.javascriptClick(complete);
		Thread.sleep(1500);
	}
}
