package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripLoginPage {
    WebDriver driver;

    public FhcTripLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "UserName")
    public WebElement userName;
    @FindBy (id = "Password")
    public WebElement sifreKutusu;
    @FindBy (xpath = "//button[@class= 'btn btn-success uppercase']")
    public WebElement logIn;
}
