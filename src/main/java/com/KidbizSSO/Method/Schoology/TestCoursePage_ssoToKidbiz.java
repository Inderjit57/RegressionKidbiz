package com.KidbizSSO.Method.Schoology;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.KidBizPages.KidbizHompage;

public class TestCoursePage_ssoToKidbiz extends BaseClass {

	public TestCoursePage_ssoToKidbiz() {
		PageFactory.initElements(wd, this);
	}

	// A3K Qa
	@FindBy(css = "#app-run-6352196336 > a > span")
	WebElement clickButtonA3KQA;

	public void clickA3KQA() {
		clickButtonA3KQA.click();
	}

	// Framebusting
	@FindBy(css = "#openachieve")
	WebElement clickToFramebustingA3KQA;

	@FindBy(css = "iframe[id='schoology-app-container']")
	WebElement iframe;

	public KidbizHompage framebusting() {
		wd.switchTo().frame(iframe);
		clickToFramebustingA3KQA.click();

		wd.switchTo().defaultContent();

		// Redirecting to Kidbiz using WindowsHandle
		String parentHandle = wd.getWindowHandle();
		String kidbizHandle = "";

		Set<String> handle1 = wd.getWindowHandles();
		for (String handle : handle1) {
			if (!handle.equals(parentHandle)) {
				kidbizHandle = handle;
			}
		}
		wd.switchTo().window(kidbizHandle);
		String kidbizandleTitle = wd.getTitle();
		System.out.println("Homepage Title: " + kidbizandleTitle);

		return new KidbizHompage();
	}

}
