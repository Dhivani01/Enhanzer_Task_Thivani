package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPageObjects {
	
	@FindBy(id = "firstName")
	public static WebElement fname;
	
	@FindBy(id = "lastName")
	public static WebElement lname;
	
	@FindBy(id = "userEmail")
	public static WebElement email;
	
	@FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
	public static WebElement gender;
	
	@FindBy(id = "userNumber")
	public static WebElement telephonenumber;
	
	@FindBy(id = "dateOfBirthInput")
	public static WebElement dob;
	
	@FindBy(xpath = "//*[@id=\"subjectsContainer\"]/div/div[1]")
	public static WebElement subjects;
		
	@FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")
	public static WebElement hobby;
	
	@FindBy(id = "uploadPicture")
	public static WebElement image;
	
	@FindBy(id = "currentAddress")
	public static WebElement address;
	
	@FindBy(id = "submit")
	public static WebElement submitbtn;
	
	@FindBy(id = "example-modal-sizes-title-lg")
	public static WebElement CnfMsg;
	
}
