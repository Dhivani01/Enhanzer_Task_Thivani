package com.TestCases;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseTest;
import com.PageObjects.FormPageObjects;

public class FileUpload extends BaseTest {

	
	@Test(priority = 0)
	public static void validFileUpload() throws InterruptedException {

		PageFactory.initElements(driver, FormPageObjects.class);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(FormPageObjects.image));
		String filePath = "C:\\Users\\Thivani\\Downloads\\pngtree-free-hd-wallpaper-4k-new-background-picture-image_15546678.jpg";

		FormPageObjects.image.sendKeys(filePath);
				
        Thread.sleep(2000); 

        String uploadedValue = FormPageObjects.image.getAttribute("value");
        
        Assert.assertTrue(
            uploadedValue.contains("pngtree-free-hd-wallpaper-4k-new-background-picture-image_15546678.jpg"),
            "File not uploaded correctly!"
        );

        System.out.println("File uploaded successfully");

	}
	
	
	@Test(priority = 1)
	public static void invalidFileUpload() throws InterruptedException {

		PageFactory.initElements(driver, FormPageObjects.class);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(FormPageObjects.image));
		String filePath = "C:\\Users\\Thivani\\Downloads\\Gyazo-5.8.6.exe";

		FormPageObjects.image.sendKeys(filePath);
		
		Thread.sleep(2000); 
		
		String uploadedValue = FormPageObjects.image.getAttribute("value");
	    System.out.println("Uploaded file value: " + uploadedValue);

	    
	    if (uploadedValue.contains(".exe")) {
	        Assert.fail("BUG FOUND: .exe file was accepted — file type validation missing!");
	    } else {
	        System.out.println("Only image type files are accepted.");
	    }
		
	}
}
