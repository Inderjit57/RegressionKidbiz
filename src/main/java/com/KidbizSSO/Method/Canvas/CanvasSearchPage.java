package com.KidbizSSO.Method.Canvas;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;

import net.bytebuddy.utility.RandomString;

public class CanvasSearchPage extends BaseClass {

	CanvasSearchPage() {
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

	// create user in a form
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
	
	//Variables declared to fill the form to create new teacher
	String enterFullName = RandomStringUtils.randomAlphabetic(5) + "," + RandomStringUtils.randomAlphabetic(4);
	String sortable = enterFullName;
	String enterEmail = enterFullName + "@gmail.com";
	String enterSISID = enterFullName;

	public void fillForm() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form[aria-label='Add a New User'] div")));
		javascriptExecutor.executeScript("arguments[0].click();", fullName);

		System.out.println("Full Name: " + enterFullName + "\nSortable Name: " + sortable);

		fullName.sendKeys(enterFullName);
		sortableName.clear();
		sortableName.sendKeys(sortable);
		email.sendKeys(enterEmail);
		sisID.sendKeys(enterSISID);
		addUserBtn.submit();
	}
	
	//Search for newly created teacher
	@FindBy(css = "input[type='search']")
	WebElement searchBtn;
	
	public void searchForNewTeacher() {
		searchBtn.sendKeys(enterFullName);

	}

}
