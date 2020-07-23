package com.webstraunt.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webstraunt.runner.Runner;
import com.webstraunt.utilities.ConfigurationReader;
import com.webstraunt.utilities.Driver;
import com.webstraunt.utilities.ToolBox;

public class POsHomePage {

	public POsHomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//input[@id='searchval']")
	public WebElement searchBox;

	@FindBy(xpath = "//input[@id='buyButton']")
	public WebElement addCart;

	@FindBy(xpath = "//div[@class='success-container']//button[@class='btn btn-primary']")
	public WebElement viewCart;

	@FindBy(xpath = "//a[.='Empty Cart']")
	public WebElement emptyCart;

	@FindBy(xpath = "//button[.='Empty Cart']")
	public WebElement emptyCartPopUp;

	@FindBy(xpath = "//p[.='Your cart is empty.']")
	public WebElement emptyCartMessage;

//
	public void navigateTo() {
		Driver.getDriver().navigate().to(ConfigurationReader.getProperty("url"));

	}

	public void searchAnItem() {
		searchBox.sendKeys("Stainless Work Table", Keys.ENTER);
	}

	public void verifySearchResult() {

		List<WebElement> titles = Driver.getDriver()
				.findElements(By.xpath("//div[@id='search-elastic']//a[contains(@class, 'description')]"));

		for (int i = 0; i < titles.size(); i++) {
			assertTrue(titles.get(i).getText().toLowerCase().contains("table"));

		}

		ToolBox.scrollWindow(titles.get(titles.size() - 1));
		titles.get(titles.size() - 1).click();
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void addLatestItemToCart() {

		addCart.click();
		viewCart.click();
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void emptyCart() {
		emptyCart.click();
		
		
		ToolBox.waitElementClickable(emptyCartPopUp);
		
		emptyCartPopUp.click();
		
		ToolBox.waitElementClickable(emptyCartMessage);
	}

	public void validateSuccessMessage() {
		String actualMessage = emptyCartMessage.getText();
		System.out.println(actualMessage);
		String expectedMessage = "Your cart is empty.";

		assertTrue(actualMessage.equals(expectedMessage));

	}

}
