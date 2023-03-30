package com.Kidbiz.SchoologyCreateUser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Schoology.Schoology;
import com.KidbizSSO.Method.Schoology.SchoologyCreateNewTeacher;
import com.KidbizSSO.Method.Schoology.SchoologyHomepage;

public class SchoologyCreateNewTeacherTest extends BaseClass {

	Schoology schoology;
	SchoologyHomepage homepage;
	SchoologyCreateNewTeacher schoologyCreateNewTeacher;

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("schoologyUrl"));

		schoology = new Schoology();
	}

	@Test(invocationCount = 5)
	public void createSchoologyTeacherTest() {
		schoology.email(properties.getProperty("emailSchoology"));
		schoology.pass(properties.getProperty("passSchoology"));
		homepage = schoology.signIn();
		homepage.clickTools();

		schoologyCreateNewTeacher = homepage.clickUserManagement();
		schoologyCreateNewTeacher.clickCreateUserLeftNavigation();
		schoologyCreateNewTeacher.selectSchool();
		schoologyCreateNewTeacher.clickRole();
		schoologyCreateNewTeacher.clickEmailConflicts();
		schoologyCreateNewTeacher.fillcredentials();
		schoologyCreateNewTeacher.clickCreateUserSubmitBtn();

	}
	
	@AfterMethod(enabled = true)
	public void teardown() {
		quitDriver();
	}
}
