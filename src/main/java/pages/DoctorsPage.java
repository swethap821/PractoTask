package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import base.Base;


public class DoctorsPage extends Base {
	
	By cityInputPath=By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input");
	By locationsDivPath=By.className("c-omni-suggestion-group");
	By doctorPath=By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input");
	By heading=By.tagName("h1");
	By doctorsListPath=By.xpath("//div[@class=\"u-d-flex\"]/child::span");
	By bookButtonPath=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[2]/div/div/div[2]/div/button");
	By todaySlotPath=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[1]/div[2]/span");
//	By todayTimePath=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div");
	By todayTimePath=By.
			xpath
			("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]");
	By tomorrowSlotPath=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]");
	By tomorrowTimePath=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]");
	By selectedNamePath=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[2]/a/div/h2");
	By appointedNamePath=By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[3]/div/div[2]/div[1]");
	By appointedDatePath=By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div[1]/span[2]");
	By appointedTimePath=By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/span[2]");
	By filterDropdownPath=By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[4]");
	By feesPath=By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[2]/div/label[4]");
	By allfeesPath=By.xpath("//div[@class=\"uv2-spacer--xs-top\"]/child::span[1]");
	
	String displayedCityName;
	String selectedcityName;
	String userSelectedTime;
	String appointedDate;
	LocalDate todayDate= LocalDate.now();
	LocalDate tomorrowDate= todayDate.plusDays(1);
	String selectedName;
	String appointedName;
	String appointedTimeSlot;
	String selectedFees;
	public void validateSpeciality() throws InterruptedException {

		selectedcityName=driver.findElement(cityInputPath).getAttribute("value");
		System.out.println("User selected location:"+selectedcityName);
		displayedCityName=driver.findElement(heading).getText();
		System.out.println("Heading on doctors page:"+displayedCityName);

		
		String selectedSpeciality=driver.findElement(doctorPath).getAttribute("value");
		System.out.println("user selected speciality:"+selectedSpeciality);
		//storing all doctors specialisation
		List<WebElement> doctorsList=driver.findElements(doctorsListPath);
		boolean isValidSpeciality=false;
		//validating doctor speciality 
		
		for(WebElement speciality:doctorsList) {
			String information=speciality.getText().toLowerCase();
			if(information.equals(selectedSpeciality)) {
				isValidSpeciality=true;
				
			}
		
		}
		System.out.println("validate:"+isValidSpeciality);
		if(isValidSpeciality) {
			System.out.println("TestCase1 is succeed: all the list of doctors in 1st page are same speciality category that is:"+selectedSpeciality);
			test=report.createTest("Validate speciality");
        	test.log(Status.PASS, "The speciality has the expected value");
        	
        }
        else
        {	
        	System.out.println("else condoition");
        	test=report.createTest("Validate speciality");
        	test.log(Status.FAIL, "Thespeciality not matching expected value");
        }
		Thread.sleep(3000);		
	}
		
	public void navigateToHomePage() throws InterruptedException {
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		
	}
	
	public void bookSlot() throws InterruptedException {
		
		selectedName=driver.findElement(selectedNamePath).getText();
		System.out.println("seleted name :"+selectedName);
		Thread.sleep(1000);
		
		System.out.println("in bookslot method ");
		driver.findElement(bookButtonPath).click();
		Thread.sleep(2000);
		String todaySlotDetails=driver.findElement(todaySlotPath).getText();
		System.out.println("today slot"+todaySlotDetails);
		//if today slots are not available go to tomorrow slot
//		if(todaySlotDetails.contains("No")) {
			driver.findElement(tomorrowSlotPath).click();
			Thread.sleep(2000);
			WebElement tomorrowTime=driver.findElement(tomorrowTimePath);
			userSelectedTime=tomorrowTime.getText();
			System.out.println("booked time:"+userSelectedTime);
			tomorrowTime.click();
			
			
			
			
//		}
//		//for today slot
//		else {
//			driver.findElement(todaySlotPath).click();
//			Thread.sleep(2000);
//			WebElement todayTime=driver.findElement(todayTimePath);
//			userSelectedTime=todayTime.getText();
//			System.out.println("booked time:"+userSelectedTime);
//			todayTime.click();
//			
//		}
		
		
	}
	
	
	public void validateName() {
		
		appointedName=driver.findElement(appointedNamePath).getText();
		System.out.println("appointed name:"+appointedName);
		if(selectedName.equals(appointedName)) {
			System.out.println("seleted name :"+selectedName+"appointed name:"+appointedName);
			System.out.println("Both selected name and appointed name are same");
			test=report.createTest("Validate Doctor name");
        	test.log(Status.PASS, "Both  user selected name and appointed name are same");
        	
        }
        else
        {	
        	
        	test=report.createTest("Validate Doctor name ");
        	test.log(Status.FAIL, "Both  user selected name and appointed name are not same");
		}
	}
	
	public void validateDate() throws ParseException {
		
		System.out.println("in validate date method");
		appointedDate=driver.findElement(appointedDatePath).getText();
		SimpleDateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = inputFormat.parse(appointedDate);
        
        String convertedAppointedDate = outputFormat.format(date);
        System.out.println("appointed date:"+convertedAppointedDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Adjust the pattern as needed
        
        // Convert LocalDate to String
        String convertedSelectedDate = tomorrowDate.format(formatter);
        
      	System.out.println("selected date:"+convertedSelectedDate);
      	
        if(convertedAppointedDate.trim().equals(convertedSelectedDate.trim())) {
        	System.out.println("seleted date :"+convertedSelectedDate+"appointed date:"+convertedAppointedDate);
			System.out.println("Both selected date and appointed date are same");
			test=report.createTest("Validate date");
        	test.log(Status.PASS, "Both user selected date and appointed date are same");
        	
        }
        else
        {	
        	
        	test=report.createTest("Validate date");
        	test.log(Status.FAIL, "Both  user selected date and appointed date are not same");
		}
        
	}
	
	public void validateTimeSlot() throws InterruptedException {
		appointedTimeSlot=driver.findElement(appointedTimePath).getText();
		System.out.println("appointedTimeSlot is:"+appointedTimeSlot);
		System.out.println("userSelectedTime is:"+userSelectedTime);
		
		if(appointedTimeSlot.equals(userSelectedTime)) {
			System.out.println("seleted time slot is :"+userSelectedTime+"appointed timeslot is:"+appointedTimeSlot);
			System.out.println("Both selected timeslot and appointed timeslot are same");
			test=report.createTest("Validate TimeSlot");
        	test.log(Status.PASS, "Both selected timeslot and appointed timeslot are same");
        	
        }
        else
        {	
        	
        	test=report.createTest("Validate TimeSlot");
        	test.log(Status.FAIL, "Both selected timeslot and appointed timeslot are not same");
		
		}
		driver.navigate().back();
		Thread.sleep(1000);
		
	}
	
	public void validateAllFilters() throws InterruptedException {
		driver.findElement(filterDropdownPath).click();
		Thread.sleep(2000);
		WebElement fees=driver.findElement(feesPath);
		selectedFees=fees.getText();
		System.out.println("selected fees:"+selectedFees);
		fees.click();
		List<WebElement>allFeesList=driver.findElements(allfeesPath);
		boolean isValidfee=true;
		for(WebElement allfees:allFeesList) {
			String onlyfees=allfees.getText().substring(1);
			System.out.println(onlyfees);
			System.out.println("integer fee:"+Integer.parseInt(onlyfees));
			System.out.println("interger selected fee"+Integer.parseInt(selectedFees.substring(7)));
			
			if(Integer.parseInt(onlyfees)<=Integer.parseInt(selectedFees.substring(7))) {
				isValidfee=false;
				break;
			}
		}
		System.out.println("boolean value:"+isValidfee);
		if(isValidfee) {
			test=report.createTest("Validate Fee");
        	test.log(Status.PASS, "The filters values are expected");
        }
        else{
        
        	System.out.println("fee failed");
        	test=report.createTest("Validate Fee");
        	test.log(Status.FAIL, "The filter values are not expected");
        }
			
	}
}
		
	

	
	


