package com.Kidbiz.SchoologyCreateUser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Schoology.SchoologyMyCourseListPage;
import com.KidbizSSO.Method.Schoology.Schoology;
import com.KidbizSSO.Method.Schoology.SchoologyCreateNewCourse;
import com.KidbizSSO.Method.Schoology.SchoologyHomepage;

public class SchoologyCreateNewCourseTest extends BaseClass {

	Schoology schoology;
	SchoologyHomepage homepage;
	SchoologyCreateNewCourse schoologyCreateNewCourse;
	SchoologyMyCourseListPage schoologyMyCourseListPage;

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("schoologyUrl"));

		schoology = new Schoology();
	}

	@Test(invocationCount = 5)
	public void createNewCourseSchoologyTest() {
		schoology.email(properties.getProperty("emailSchoology"));
		schoology.pass(properties.getProperty("passSchoology"));
		homepage = schoology.signIn();
		// need to put assertion check for this page
//		sf.assertEquals(null, null, null);

		// Redirecting to course page
		schoologyCreateNewCourse = homepage.clickcourseBtnOnHomepage();
		schoologyMyCourseListPage = schoologyCreateNewCourse.clickMyCourseBtn();
		schoologyMyCourseListPage.clickCreateSchoologyCourse();
		schoologyMyCourseListPage.clickSchool();
		schoologyMyCourseListPage.inputCourseAndSection();
		schoologyMyCourseListPage.subjectAreaSelect();
		schoologyMyCourseListPage.selectLevelAndGrade();
		schoologyMyCourseListPage.clickCreateBtn();

	}

	@AfterMethod(enabled = true)
	public void teardown() {
		quitDriver();
	}

}
