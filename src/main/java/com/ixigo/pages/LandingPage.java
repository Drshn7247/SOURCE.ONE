package com.ixigo.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.ixigo.base.TestBase;

public class LandingPage extends TestBase {
	
	
	@FindBy(xpath="//span[@data=\"1\"]")
	WebElement roundTripBtn;
	
	@FindBy(xpath="//div[text()='From']/following-sibling:: input[@class='c-input u-v-align-middle']")
	WebElement fromCity;
	
	@FindBy(xpath="//div[@class=\"clear-input ixi-icon-cross\"]")
	WebElement crossBtn;
	
	@FindBy(xpath="//div[text()='To']/following-sibling::input")
	WebElement toCity;
	
	@FindBy(xpath="//input[@data-rome-id=\\\"0\\\"]")
	WebElement departureDate;
	
	@FindBy(className = "rd-month-label")
	WebElement monthYearValue;
	
	@FindBy(xpath = "//button[@class=\"ixi-icon-arrow rd-next\"]")
	WebElement nextBtn;
	
	@FindBys(@FindBy(xpath = "//div[@class=\"day has-info\"]"))
	List<WebElement> allDates;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement searchBtn;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clearFields() {
		crossBtn.click();
	}
	
	public String inputOriginData(String from) throws InterruptedException {
		roundTripBtn.click();
		fromCity.sendKeys(from);
		Thread.sleep(1000);
		fromCity.sendKeys(Keys.ENTER);
		return from;
		
	}
	
	public String inputreturnData(String to) throws InterruptedException {
		toCity.sendKeys(to);
		Thread.sleep(1000);
		toCity.sendKeys(Keys.ENTER);
		return to;
	}
	
	public void datePicker(String monthYear, String traveldate) throws InterruptedException {
	
		while(!(monthYearValue.getText().contains(monthYear))) {
			//Thread.sleep(1000);
			nextBtn.click();
		}
		for(WebElement date:allDates) {
			String day=date.getText();
			if(day.equalsIgnoreCase(traveldate)) {
				date.click();	
				break;
			}
		}
		
	}
	
	public void search() {
		searchBtn.click();
	
	}

}
