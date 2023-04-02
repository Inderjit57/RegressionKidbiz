package com.Kidbiz.OLPTest;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.OLP.AdminAccountHomepage;
import com.KidbizSSO.Method.OLP.AdministratorPage;
import com.KidbizSSO.Method.OLP.OLPCreateNewStudentPage;
import com.KidbizSSO.Method.OLP.OLPCreateNewTeacherPage;
import com.KidbizSSO.Method.OLP.OLPLoginPage;
import com.KidbizSSO.Util.Utils;

public class OLPCreateNewStudentTest extends BaseClass {
	OLPLoginPage olpLoginPage;
	AdminAccountHomepage adminAccountHomepage;
	AdministratorPage administratorPage;
	OLPCreateNewStudentPage olpCreateNewStudentPage;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("mhURL"));

		olpLoginPage = new OLPLoginPage();
	}

	@Test(invocationCount = 5)
	public void createNewOLPStudentTest() throws Exception {
		System.out.println("Current URL: " + wd.getCurrentUrl());
		softAssert.assertEquals(wd.getCurrentUrl(), properties.getProperty("canvasUrl"),
				"Not a valid Page. Expecting Canvas Login Page");
		olpLoginPage.inputEmailPassword();

		adminAccountHomepage = olpLoginPage.clickLoginBtn();
		adminAccountHomepage.clickDropdown();

		administratorPage = adminAccountHomepage.clickAdministrator();
		administratorPage.clickStudent();

		olpCreateNewStudentPage = administratorPage.clickCreateStudentBtn();
		olpCreateNewStudentPage.inputCredentials();

		olpCreateNewStudentPage.clickCreate();
	}

	@AfterMethod(enabled = true)
	public void tearDown() {
		wd.quit();
	}

}
