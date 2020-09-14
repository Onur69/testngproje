package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

    public GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "email")
    public WebElement emailKutusu;
    @FindBy(id = "name")
    public WebElement nameKutusu;
    @FindBy(id="mobile")
    public WebElement mobileKutusu;
    @FindBy(id = "password")
    public WebElement passwordKutusu;
    @FindBy(id = "re_password")
    public WebElement rePasswordKutusu;
    @FindBy(xpath = "//button[@class='btn btn-lg btn-warning btn-block']")
    public WebElement signUpButtonu;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successYazisi;
}

