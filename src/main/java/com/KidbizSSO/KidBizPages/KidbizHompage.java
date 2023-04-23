package com.KidbizSSO.KidBizPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class KidbizHompage extends BaseClass {

	public KidbizHompage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = "select[id='active_school']")
	WebElement schoolSelector;

	@FindBy(css = "select[id='active_pgm']")
	WebElement chooseProgram;

	@FindBy(css = "select[id='active_class']")
	WebElement chooseClass;

	@FindBy(id = "loginButton")
	WebElement login;

	public void selectSchool() {
		Select school = new Select(schoolSelector);
		school.selectByVisibleText("Schoology Luda's Test School K only");
	}

	public void chooseProgramAndClass() {
		Utils.selectFromDropDownUsingVisibleText(chooseProgram, "Literacy MS");
		Utils.selectFromDropDownUsingVisibleText(chooseClass, "N Sveta course 9 K only");
	}

	public UserAccount clickLoginBtn() {
		login.click();
		return new UserAccount();
	}
}
