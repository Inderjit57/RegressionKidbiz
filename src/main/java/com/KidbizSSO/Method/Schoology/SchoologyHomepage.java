package com.KidbizSSO.Method.Schoology;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;

public class SchoologyHomepage extends BaseClass {

	public SchoologyHomepage(){
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css="div[data-reactid='.2.0.0.1.0.0:$0/=1$=01$6274068430.$=1$6274068430.0']")
	WebElement BTS2022course;
	
	public CoursePage clickOnCourse() {
		BTS2022course.click();
		return new CoursePage();
	}
	
}
