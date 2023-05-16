package com.KidbizSSO.Method.Schoology;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Schoology.SchoologyNewUserAndClass.SchoologyCreateNewStudent;
import com.KidbizSSO.Method.Schoology.SchoologyNewUserAndClass.SchoologyCreateNewTeacher;
import com.KidbizSSO.Method.Schoology.SchoologySSO.TestCoursePage_ssoToKidbiz;
import com.KidbizSSO.Util.Utils;

public class SchoologyHomepage extends BaseClass {

	public SchoologyHomepage(){
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}
	
	//Test Course on Homepage
	@FindBy(css="div[data-reactid='.2.0.0.1.0.0:$0/=1$=01$6274068430.$=1$6274068430.0']")
	WebElement BTS2022course;
	
	public TestCoursePage_ssoToKidbiz clickOnCourse() {
		BTS2022course.click();
		return new TestCoursePage_ssoToKidbiz();
	}
	
	//Course Button on Homepage
	@FindBy(css = "div[id='header'] nav ul:nth-of-type(1) li:nth-of-type(2) button")
	WebElement courseBtnHomepage;
	
	public SchoologyCreateNewCourse clickcourseBtnOnHomepage() {
		Utils.clickOnElement(courseBtnHomepage);
		return new SchoologyCreateNewCourse();
	}
	
	//Go to Tools- User Management
	@FindBy(css = "nav[role='navigation'] ul:nth-of-type(1) li:nth-of-type(5)" )
	WebElement toolsBtn;
	
	@FindBy(css = " nav[role='navigation'] ul:nth-of-type(1) li:nth-of-type(5) ul a:nth-of-type(3)")
	WebElement userManagement;
	
	public void clickTools() {
		Utils.clickOnElement(toolsBtn);
	}
	
	public SchoologyCreateNewTeacher clickUserManagementNewTeacher() {
		Utils.clickOnElement(userManagement);
		return new SchoologyCreateNewTeacher();
	}
	public SchoologyCreateNewStudent clickUserManagementNewStudent() {
		Utils.clickOnElement(userManagement);
		return new SchoologyCreateNewStudent();
	}
}
