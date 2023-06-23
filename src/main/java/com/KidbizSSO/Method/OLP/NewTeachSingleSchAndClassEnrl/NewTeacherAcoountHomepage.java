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

	@FindBy(css = "button[title='Create a Class']")
	private WebElement createClassBtn;

	@FindBy(xpath = "//fieldset[@data-automation-id='ilp-product-container']//div[1]/div//label")
	private WebElement productAch3000Lit;
	
	@FindBy(css = "button[aria-label='Continue']")
	private WebElement continuebtn;

	@FindBy(css = "#className")
	private WebElement className;

	@FindBy(css = "select[id='subject']")
	private WebElement subject;

	@FindBy(css = "select[id='gradeLevel']")
	private WebElement gradeLevel;

	@FindBy(css = "#dlg-submit-button")
	private WebElement complete;

	String randomClassName = "OLP" + Utils.fakeClassNameGenerator() + RandomStringUtils.randomAlphabetic(2);

	private int randomSubjectSelection;
	private int randomGradeSelection;

	public void clickCreateClassBtn() {
		Utils.waitForElementToBeClickable(createClassBtn, Utils.Explicit_Wait);
		Utils.clickOnElement(createClassBtn);
	}

	public void clickProduct() {
		Utils.clickOnElement(productAch3000Lit);
		Utils.javascriptClick(continuebtn);
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
		Utils.waitForElementToBeSelectable(subject, Utils.Explicit_Wait);
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
