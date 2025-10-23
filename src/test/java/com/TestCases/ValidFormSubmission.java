package com.TestCases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.BaseTest;
import com.PageObjects.FormPageObjects;




public class ValidFormSubmission extends BaseTest{
	
	
	@Test
	public void validInput() throws InterruptedException { 
	
		PageFactory.initElements(driver, FormPageObjects.class);	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(FormPageObjects.fname));		
		FormPageObjects.fname.sendKeys("Puva");
		
		wait.until(ExpectedConditions.visibilityOf(FormPageObjects.lname));
		FormPageObjects.lname.sendKeys("Thivani");
		
		wait.until(ExpectedConditions.visibilityOf(FormPageObjects.email));
		FormPageObjects.email.sendKeys("thivani728@gmail.com");
                
		wait.until(ExpectedConditions.elementToBeClickable(FormPageObjects.gender)).click();
		
		wait.until(ExpectedConditions.visibilityOf(FormPageObjects.telephonenumber));
		FormPageObjects.telephonenumber.sendKeys("0777777777");
		
		wait.until(ExpectedConditions.visibilityOf(FormPageObjects.dob));
		FormPageObjects.dob.clear();
		FormPageObjects.dob.sendKeys("28 Sep 1999");
		
		wait.until(ExpectedConditions.visibilityOf(FormPageObjects.subjects));
		FormPageObjects.telephonenumber.sendKeys("Maths");		
		
		wait.until(ExpectedConditions.elementToBeClickable(FormPageObjects.hobby)).click();
		
		wait.until(ExpectedConditions.visibilityOf(FormPageObjects.image));
		String filePath = "C:\\Users\\Visagan\\Downloads\\pngtree-free-hd-wallpaper-4k-new-background-picture-image_15546678.jpg";
		FormPageObjects.image.sendKeys(filePath);
		
		wait.until(ExpectedConditions.visibilityOf(FormPageObjects.address));
		FormPageObjects.address.sendKeys("Colombo, Sri Lanka");
		
		WebElement dropdown = driver.findElement(By.cssSelector(". css-1wa3eu0-placeholder"));
		dropdown.click(); 

		WebElement option = driver.findElement(By.xpath("//li[text()='NCR']"));
		option.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(FormPageObjects.submitbtn)).click();
		
		wait.until(ExpectedConditions.textToBePresentInElement(FormPageObjects.CnfMsg,
				"Thanks for submitting the form"));

		Assert.assertEquals(FormPageObjects.CnfMsg.getText().trim(), "Thanks for submitting the form",
				"Form submission didn't work!");
		
		
}
	}
