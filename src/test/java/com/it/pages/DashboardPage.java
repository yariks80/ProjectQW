package com.it.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

	@FindBy(xpath = "//span[@class='sn_menu_title']")
	private WebElement linkUserEmail;

	public String getLinkUserEmail() {
		driver.wait.until(ExpectedConditions.visibilityOf(linkUserEmail));
		return linkUserEmail.getText();
	}


}
