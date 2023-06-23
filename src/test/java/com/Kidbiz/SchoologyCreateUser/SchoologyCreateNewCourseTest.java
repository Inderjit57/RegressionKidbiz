package com.Kidbiz.SchoologyCreateUser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Schoology.Schoology;
import com.KidbizSSO.Method.Schoology.SchoologyCreateNewCourse;
import com.KidbizSSO.Method.Schoology.SchoologyHomepage;
import com.KidbizSSO.Method.Schoology.SchoologyNewUserAndClass.SchoologyMyCourseListPage;

public class SchoologyCreateNewCourseTest extends BaseClass {

	Schoology schoology;
	SchoologyHomepage homepage;
	SchoologyCreateNewCourse schoologyCreateNewCourse;
	SchoologyMyCourseListPage schoologyMyCourseListPage;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("schoologyUrl"));

		schoology = new Schoology();
	}

	@Test(invocationCount = 1)
	public void createNewCourseSchoologyTest() throws Exception {
		System.out.println("Current URL: " + wd.getCurrentUrl());
		softAssert.assertEquals(wd.getCurrentUrl(), properties.getProperty("schoologyUrl"),
				"Not a valid Page. Expecting Schoology Login Page");

		schoology.email(properties.getProperty("emailSchoology"));
		schoology.pass(properties.getProperty("passSchoology"));
		homepage = schoology.signIn();

		// Redirecting to course page
		schoologyCreateNewCourse = homepage.clickcourseBtnOnHomepage();
		schoologyMyCourseListPage = schoologyCreateNewCourse.clickMyCourseBtn();
		schoologyMyCourseListPage.clickCreateSchoologyCourse();
		schoologyMyCourseListPage.clickSchool();
		schoologyMyCourseListPage.inputCourseAndSection();
		schoologyMyCourseListPage.subjectAreaSelect();
		schoologyMyCourseListPage.selectLevelAndGrade();
		schoologyMyCourseListPage.clickCreateBtn();
		
		softAssert.assertAll();

	}

	@AfterMethod(enabled = false)
	public void teardown() {
		quitDriver();
	}

}
