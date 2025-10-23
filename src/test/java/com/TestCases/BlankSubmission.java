package com.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseTest;
import com.PageObjects.FormPageObjects;

public class BlankSubmission extends BaseTest {
	
	  @Test
	    public void mandatoryFieldValidation() throws InterruptedException { 
	        
	        PageFactory.initElements(driver, FormPageObjects.class);    
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	       
	        wait.until(ExpectedConditions.elementToBeClickable(FormPageObjects.submitbtn)).click();
	        Thread.sleep(2000); 
	       
	        WebElement firstNameField = FormPageObjects.fname;
	        String borderColor = firstNameField.getCssValue("border-color");
	   
	        
	        Assert.assertTrue(
	            borderColor.equals("rgb(220, 53, 69)") || borderColor.equals("red"),
	            "Mandatory field validation not triggered for First Name!" );

	    }
	}

