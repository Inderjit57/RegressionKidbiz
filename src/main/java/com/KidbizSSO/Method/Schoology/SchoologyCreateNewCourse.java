package com.KidbizSSO.Method.Schoology;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class SchoologyCreateNewCourse extends BaseClass {

	/*
	 * My Course list page and My course Button
	 */
	public SchoologyCreateNewCourse() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "a[href='/courses']")
	WebElement myCourseBtn;

	public SchoologyMyCourseListPage clickMyCourseBtn() {
		Utils.clickOnElement(myCourseBtn);
		return new SchoologyMyCourseListPage();
	}

}
