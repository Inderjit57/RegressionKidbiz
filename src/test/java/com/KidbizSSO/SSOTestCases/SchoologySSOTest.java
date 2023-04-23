package com.KidbizSSO.SSOTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.KidBizPages.KidbizHompage;
import com.KidbizSSO.KidBizPages.UserAccount;
import com.KidbizSSO.Method.Schoology.Schoology;
import com.KidbizSSO.Method.Schoology.SchoologyHomepage;
import com.KidbizSSO.Method.Schoology.SchoologySSO.TestCoursePage_ssoToKidbiz;

public class SchoologySSOTest extends BaseClass {

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
	public void schoologySSOTest() {

		schoology.email(properties.getProperty("emailSchoology"));
		schoology.pass(properties.getProperty("passSchoology"));
		homepage = schoology.signIn();
		// need to put assertion check for this page
		WebElement schHomepageTitle = wd.findElement(By.cssSelector(".site-navigation a[title='Home']"));
		sf.assertEquals(schHomepageTitle.getText(), "Home", "Schoology Homepage not found");

		// Redirecting to course page
		testCoursePage_ssoToKidbiz = homepage.clickOnCourse();
		testCoursePage_ssoToKidbiz.clickA3KQA();
		kidbizHompage = testCoursePage_ssoToKidbiz.framebusting();

		kidbizHompage.selectSchool();
		kidbizHompage.chooseProgramAndClass();
		userAccount = kidbizHompage.clickLoginBtn();
		sf.assertEquals(wd.getCurrentUrl(), "https://core-qa-portal.achieve3000.com/home", "wrong Kidbiz URl");

		sf.assertAll();
	}

	@AfterMethod(enabled = true)
	public void teardown() {
		wd.quit();
	}

}
