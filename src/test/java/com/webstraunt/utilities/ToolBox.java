package com.webstraunt.utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolBox {

	public static void scrollWindow(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

		try {
			js.executeScript("arguments[0].scrollIntoView();", target);
		} catch (NullPointerException e) {
			e.getStackTrace();
		}

	}


	public static void waitElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
