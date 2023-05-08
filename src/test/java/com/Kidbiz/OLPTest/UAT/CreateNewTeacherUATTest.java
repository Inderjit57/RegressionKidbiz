package com.Kidbiz.OLPTest.UAT;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.OLP.AdminAccountHomepage;
import com.KidbizSSO.Method.OLP.AdministratorPage;
import com.KidbizSSO.Method.OLP.ConnectEdDashboardPage;
import com.KidbizSSO.Method.OLP.OLPCreateNewTeacherPage;
import com.KidbizSSO.Method.OLP.OLPLoginPage;
import com.KidbizSSO.Method.OLP.NewTeachSingleSchAndClassEnrl.NewTeacherAccountPolicyConfirmPage;
import com.KidbizSSO.Method.OLP.NewTeachSingleSchAndClassEnrl.NewTeacherAcoountHomepage;
import com.KidbizSSO.Method.OLP.NewTeachSingleSchAndClassEnrl.NewTeacherConnectEdHomepage;

public class CreateNewTeacherUATTest extends BaseClass {
	OLPLoginPage olpLoginPage;
	AdminAccountHomepage adminAccountHomepage;
	AdministratorPage administratorPage;
	OLPCreateNewTeacherPage olpCreateNewTeacherPage;
	ConnectEdDashboardPage connectEdDashboardPage;
	NewTeacherAcoountHomepage newTeacherAcountHomepage;

	NewTeacherAccountPolicyConfirmPage newTeacherAccountPolicyConfirmPage;
	NewTeacherConnectEdHomepage newTeacherConnectEdHomepage;

	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("mhURL"));

		olpLoginPage = new OLPLoginPage();
	}

	@Test(invocationCount = 1)
	public void createNewTeacherForUATTest() throws Exception {

		System.out.println("Current URL: " + wd.getCurrentUrl());
		softAssert.assertEquals(wd.getCurrentUrl(), properties.getProperty("mhURL"),
				"Not a valid Page. Expecting MH Login Page");
		olpLoginPage.inputEmailPassword();
		connectEdDashboardPage = olpLoginPage.loginToConnectEDdash();
		adminAccountHomepage = connectEdDashboardPage.clickA3KLit();

		adminAccountHomepage.clickDropdown();

		administratorPage = adminAccountHomepage.clickAdministrator();
		administratorPage.clickStaff();

		olpCreateNewTeacherPage = administratorPage.clickCreateStaffBtn();
		olpCreateNewTeacherPage.inputCredentials();
		olpCreateNewTeacherPage.clickAffiliations();
		olpCreateNewTeacherPage.clickCreate();

		wd.get(properties.getProperty("mhLogoutUrl"));
		olpLoginPage.getEmailPasswordFromNewTeacherPage();
		newTeacherAccountPolicyConfirmPage = olpLoginPage.loginToNewTeacher();
		newTeacherAccountPolicyConfirmPage.clickCheckBox();
		newTeacherConnectEdHomepage = newTeacherAccountPolicyConfirmPage.clickContinueBtn();
		newTeacherAcountHomepage = newTeacherConnectEdHomepage.clickAchive3000Lit();
		newTeacherAcountHomepage.clickCreateClassBtn();
		newTeacherAcountHomepage.clickProduct();
		newTeacherAcountHomepage.createClassInfo();
		newTeacherAcountHomepage.selectSubject();
		newTeacherAcountHomepage.selectGrade();
		newTeacherAcountHomepage.clickComplete();

	}

	@AfterMethod(enabled = false)
	public void tearDown() {

		wd.quit();
	}

}
