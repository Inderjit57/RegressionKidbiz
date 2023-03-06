package com.KidbizSSO.Method;

import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;

public class CoursePage extends BaseClass{
	
	public CoursePage() {
		PageFactory.initElements(wd, this);
	}

}
