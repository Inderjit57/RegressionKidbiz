package com.KidbizSSO.KidBizPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.KidbizSSO.BasePackage.BaseClass;

public class KidbizHompage extends BaseClass {

	public KidbizHompage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "school_selector")
	WebElement schoolSelector;

	@FindBy()			//need locator
	WebElement chooseClass;

	public void selectSchool() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#active_school")));
		WebElement kidbizIcon = wd.findElement(By.cssSelector("#active_school"));
		kidbizIcon.click();
		Select school = new Select(schoolSelector);
		school.selectByVisibleText("Schoology Luda's Test School K only");
	}

	@FindBy(id = "loginButton")
	WebElement login;

	public UserAccount clickLoginBtn() {
		login.click();
		return new UserAccount();
	}
}
