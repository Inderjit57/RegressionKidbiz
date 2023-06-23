package com.Kidbiz.SchoologyCreateUser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Schoology.Schoology;
import com.KidbizSSO.Method.Schoology.SchoologyHomepage;
import com.KidbizSSO.Method.Schoology.SchoologyNewUserAndClass.SchoologyCreateNewStudent;
import com.KidbizSSO.Method.Schoology.SchoologyNewUserAndClass.SchoologyCreateNewTeacher;

public class SchoologyCreateNewTeacherTest extends BaseClass {

	Schoology schoology;
	SchoologyHomepage homepage;
	SchoologyCreateNewTeacher schoologyCreateNewTeacher;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("schoologyUrl"));

		schoology = new Schoology();
	}

	@Test(invocationCount = 1)
	public void createSchoologyUserTest() throws Exception {
		System.out.println("Current URL: " + wd.getCurrentUrl());
		softAssert.assertEquals(wd.getCurrentUrl(), properties.getProperty("schoologyUrl"),
				"Not a valid Page. Expecting Schoology Login Page");

		schoology.email(properties.getProperty("emailSchoology"));
		schoology.pass(properties.getProperty("passSchoology"));
		homepage = schoology.signIn();
		homepage.clickTools();

		schoologyCreateNewTeacher = homepage.clickUserManagementNewTeacher();
		schoologyCreateNewTeacher.clickCreateUserLeftNavigation();
		schoologyCreateNewTeacher.selectSchool();
		schoologyCreateNewTeacher.clickTeacherRole();
		schoologyCreateNewTeacher.clickEmailConflicts();
		schoologyCreateNewTeacher.fillTeacherCredentials();
		schoologyCreateNewTeacher.clickCreateUserSubmitBtn();

		softAssert.assertAll();

	}

	@AfterMethod(enabled = true)
	public void teardown() {
		quitDriver();
	}
}
