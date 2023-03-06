package com.KidbizSSO.Method.Schoology;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;

public class CoursePage extends BaseClass{
	
	public CoursePage() {
		PageFactory.initElements(wd, this);
	}
	
	// A3K Qa
	@FindBy(css="#app-run-6352196336 > a > span")
	WebElement clickButtonA3KQA;
	
	public void clickA3KQA() {
		clickButtonA3KQA.click();
	}
	
	//Framebusting
	@FindBy(css="#instructions")
	WebElement clickToFramebustingA3KQA;
	
	public KidbizHompage framebusting() {
		clickToFramebustingA3KQA.click();
		return new KidbizHompage();
	}
	
}
