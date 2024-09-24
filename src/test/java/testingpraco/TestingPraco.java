package testingpraco;

import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.Test;

import pages.DoctorsPage;
import pages.LocationPage;

public class TestingPraco {
	
	LocationPage locationPage=new LocationPage();
	DoctorsPage doctorPage=new DoctorsPage();
	
	
	@Test(priority=1)
	public void verifyCategoryList() throws IOException, InterruptedException {
		locationPage.setUp();
		locationPage.openUrl();
		locationPage.selectLocation();
		doctorPage.validateSpeciality();
		doctorPage.navigateToHomePage();
		
		
	}
	
	@Test(priority=2)
	public void verifyDoctorDetailsTimeSlotAndDate() throws IOException, InterruptedException, ParseException {

		Thread.sleep(1000);
		locationPage.selectLocation();
		doctorPage.bookSlot();
		doctorPage.validateName();
		doctorPage.validateDate();
		doctorPage.validateTimeSlot();		
		doctorPage.navigateToHomePage();
		
		
	}
	@Test(priority=3)
	public void validateFilterValues() throws InterruptedException {
		locationPage.selectLocation();
		doctorPage.validateAllFilters();
		locationPage.saveReports();
	}
	
}
