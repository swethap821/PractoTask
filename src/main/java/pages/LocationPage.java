package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;



import base.Base;

public class LocationPage extends Base{
	By cityPath=By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]");
	By cancelIcon=By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/span[2]/span");
	By cityInputPath=By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input");
	By doctorPath=By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input");
	By cancelIconSpecialisation=By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/span[2]/span");

	
	public void selectLocation() throws InterruptedException {
		
		WebElement city=driver.findElement(cityPath);
		city.click();
		driver.findElement(cancelIcon).click();
		WebElement cityName=driver.findElement(cityInputPath);
		cityName.sendKeys("hyder");
		Thread.sleep(1000);
		cityName.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		cityName.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		cityName.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		cityName.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		WebElement speciliasation=driver.findElement(doctorPath);
		speciliasation.sendKeys("gen");
		Thread.sleep(2000);
		speciliasation.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		speciliasation.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		speciliasation.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	
		
		
		
		
	
		
	
}
