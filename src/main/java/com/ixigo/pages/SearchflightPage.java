package com.ixigo.pages;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.ixigo.base.TestBase;

public class SearchflightPage extends TestBase {

	
	@FindBy(xpath="//div[@class=\"srt-cntnr rtrn\"]/div[1]/div[2]/nav/span[3]")
	WebElement originQuickest;
	
	@FindBy(xpath="//div[@class=\"srt-cntnr rtrn\"]/div[2]/div[2]/nav/span[3]")
	WebElement returnQuickest;
	
	@FindBy(xpath="//div[@class=\"result-wrpr\"]/div[1]/div/div/div/div[3]/div[4]/div[@class=\"u-text-ellipsis\"]")
	WebElement flightName;
	
	@FindBys(@FindBy(xpath="//div[@class=\"result-wrpr\"]/div[1]/div/div/div/div[3]/div[4]"))
	List<WebElement> originFlights;
	
	@FindBy(xpath="//div[@class=\"result-wrpr\"]/div[2]/div/div/div/div[3]/div[4]")
	List<WebElement> returnFlights;
	
	@FindBy(xpath="(//div[@class=\"price-group\"])[1]")
	WebElement originPrice;
	
	@FindBy(xpath="//div[@class=\"result-wrpr\"]/div[2]/div/div[14]/div/div[5]/div/div/span[2]")
	WebElement returnPrice;
	
	@FindBy(xpath="//div[contains(@class,'fare-provider-list u-fb')]/div/div/div/div/span[2]")
	WebElement totalprice;

	;
	
	public SearchflightPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void flightType() throws InterruptedException {
		Thread.sleep(10000);
		originQuickest.click();
		Thread.sleep(1000);
		returnQuickest.click();
		
	}
	
	public void selectOriginFlight() throws InterruptedException {
		
		for(WebElement allFlights:originFlights) {
			String flight=allFlights.getText();
			if(flight.equalsIgnoreCase("IndiGo")) {
				allFlights.click();	
			}
		}
		
	}
	
	public void selectreturnFlight() throws InterruptedException {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		for(WebElement allRFlights:returnFlights) {
			String Rflight=allRFlights.getText();
			if(Rflight.equalsIgnoreCase("Air India  AI680, AI442, AI853")) {
				allRFlights.click();	
			}
		}
		
	}
	
	public String originflightPrice() {
		String origin=originPrice.getText();
		System.out.println("Origin flight price = "+origin);
		return origin;
	}
	
	public String returnflightPrice(){
		
		String ret=returnPrice.getText();
		System.out.println("Return flight price = "+ret);
		return ret;
	}
	
	public String invoiceOfflightPrice() {
		String tot=totalprice.getText();
		return tot;
	}

}
