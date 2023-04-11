package com.Kidbiz.SchoologyCreateUser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Schoology.Schoology;
import com.KidbizSSO.Method.Schoology.SchoologyCreateNewUser;
import com.KidbizSSO.Method.Schoology.SchoologyHomepage;

public class SchoologyCreateNewUserTest extends BaseClass {

	Schoology schoology;
	SchoologyHomepage homepage;
	SchoologyCreateNewUser schoologyCreateNewUser;

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("schoologyUrl"));

		schoology = new Schoology();
	}

	@Test(invocationCount = 3, enabled = true)
	public void createSchoologyUserTest() {
		schoology.email(properties.getProperty("emailSchoology"));
		schoology.pass(properties.getProperty("passSchoology"));
		homepage = schoology.signIn();
		homepage.clickTools();

		schoologyCreateNewUser = homepage.clickUserManagement();
		schoologyCreateNewUser.clickCreateUserLeftNavigation();
		schoologyCreateNewUser.selectSchool();
		schoologyCreateNewUser.clickStudentRole();
		schoologyCreateNewUser.clickEmailConflicts();
		schoologyCreateNewUser.fillcredentials(properties.getProperty("accountToCreate"));
		schoologyCreateNewUser.clickCreateUserSubmitBtn();

	}

	@AfterMethod(enabled = true)
	public void teardown() {
		quitDriver();
	}
}
