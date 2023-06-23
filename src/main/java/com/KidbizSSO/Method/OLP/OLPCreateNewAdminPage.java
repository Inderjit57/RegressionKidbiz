package com.KidbizSSO.Method.OLP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class OLPCreateNewAdminPage extends BaseClass{
	public OLPCreateNewAdminPage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}
	
	@FindBy(css = "span[class='ng-star-inserted']")
	private WebElement createTeacherPageHeader;

	@FindBy(css = "#givenName")
	private WebElement firstNameOlpTeacher;

	@FindBy(css = "#familyName")
	private WebElement lastNameOlpTeacher;

	@FindBy(css = "#email")
	static WebElement emailOlpTeacher;

	@FindBy(css = "#userName")
	private WebElement userNameOlpTeacher;

	@FindBy(css = "#password")
	private WebElement passwordOlpTeacher;

	@FindBy(css = "input[value='instructor']")
	private WebElement roleOlpTeacher;

	@FindBy(css = "button[class='btn btn-sm dropdown-toggle btn-secondary']")
	private WebElement orgOlpTeacher;

	@FindBy(css = "input[role='searchbox']")
	private WebElement searchbox;

	@FindBy(css = "label[class='ahe-ui-checkbox']")
	private WebElement schoolSearched;

	@FindBy(css = "#staffIdInstructor")
	private WebElement staffOlpId;

	@FindBy(xpath = "//button[@class='btn ngx-shared btn-primary btn btn-primary ms-2']")
	private WebElement createBtn;

	private String[] a3kSchool = { "A3K LITERACY TEST SCHOOL 1", "A3K LITERACY TEST SCHOOL 2",
			"A3K LITERACY TEST SCHOOL 3" }; 
//	WADE THOMAS SCHOOL/ MANOR ELEMENTARY SCHOOL / BROOKSIDE
//	private String[] a3kSchool = { "MANOR ELEMENTARY SCHOOL" };

	private String pickOlpSchoolForAdmin;

	public static String firstName = Utils.fakeFirstNameGenerator();
	public static String lastName = Utils.fakeLastNameGenerator();
	public static String emailOLP = firstName + "."+lastName+ properties.getProperty("mhEmailDomain");
	String userName = firstName;
	public static String password = properties.getProperty("passwordToSet");
	String staffId = firstName + "." + lastName;

}
