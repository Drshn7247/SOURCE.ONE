package com.ixigo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ixigo.base.TestBase;
import com.ixigo.pages.LandingPage;
import com.ixigo.pages.SearchflightPage;

public class IxigoTest extends TestBase{
	
	LandingPage landingpage;
	SearchflightPage searchFlightPage;
	
	public IxigoTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		landingpage=new LandingPage();
		searchFlightPage=new SearchflightPage();
	}
	
	@Test(priority=1)
	public void clearData() {
		landingpage.clearFields();
	}
	
	@Test(priority=2)
	public void landingPageData() throws InterruptedException {
		String startCity=landingpage.inputOriginData(prop.getProperty("from"));
		Assert.assertEquals(startCity, startCity);
		
		String toCity=landingpage.inputreturnData(prop.getProperty("to"));
		Assert.assertEquals(toCity, toCity);
		
	}
	
	@Test(priority=3)
	public void datePickerData() throws InterruptedException {
		landingpage.datePicker(prop.getProperty("monthyear"),prop.getProperty("traveldate"));
	}
	
	@Test(priority=4)
	public void clickSearch() {
		landingpage.search();
	}
	
	@Test(priority=5)
	public void selectFlight() throws InterruptedException {
		searchFlightPage.flightType();
		searchFlightPage.selectOriginFlight();
		searchFlightPage.selectreturnFlight();
	}
	
	@Test(priority=6)
	public void checkFlightPrices(){
		String op=searchFlightPage.originflightPrice();
		int ofp=Integer.parseInt(op);
		
		String rp=searchFlightPage.returnflightPrice();
		int rfp=Integer.parseInt(rp);
		int totalFlightprice=ofp+rfp;
		System.out.println("Sum Of RoundTrip = "+totalFlightprice);
		String invoice=searchFlightPage.invoiceOfflightPrice();
		int invoflight=Integer.parseInt(invoice);
		System.out.println("Invoice value = "+invoflight);
		Assert.assertEquals(totalFlightprice, invoflight);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
