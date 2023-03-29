package com.KidbizSSO.TestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.KidBizPages.KidbizHompage;
import com.KidbizSSO.KidBizPages.UserAccount;
import com.KidbizSSO.Method.Schoology.TestCoursePage_ssoToKidbiz;
import com.KidbizSSO.Method.Schoology.Schoology;
import com.KidbizSSO.Method.Schoology.SchoologyHomepage;

public class SchoologyTest extends BaseClass {

	Schoology schoology;
	SchoologyHomepage homepage;
	TestCoursePage_ssoToKidbiz testCoursePage_ssoToKidbiz;
	KidbizHompage kidbizHompage;
	UserAccount userAccount;

	SoftAssert sf = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("schoologyUrl"));
		schoology = new Schoology();
	}

	@Test
	public void schoologyPage() {

		schoology.email(properties.getProperty("emailSchoology"));
		schoology.pass(properties.getProperty("passSchoology"));
		homepage = schoology.signIn();
		// need to put assertion check for this page
//		sf.assertEquals(null, null, null);

		// Redirecting to course page
		testCoursePage_ssoToKidbiz = homepage.clickOnCourse();
		testCoursePage_ssoToKidbiz.clickA3KQA();
		kidbizHompage = testCoursePage_ssoToKidbiz.framebusting();
		
//		sf.assertEquals(wd.getCurrentUrl(), properties.getProperty("schoologyUrl"),"Error while loading Kidbiz Page");
		kidbizHompage.selectSchool();

		userAccount = kidbizHompage.clickLoginBtn();

	}

	@AfterMethod(enabled = false)
	public void teardown() {
		wd.quit();
	}

}
