package com.techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseCross {
    protected WebDriver driver;

    //bize parametre olarak browser gelecek,bizde o parametreyi kullanacagiz
    //bu parametre, xml dosyasindan gelecek
    @Parameters("browser")
    @BeforeMethod
    //@Optional guvenlik icin yazdik, belki parametre gelmezse bile burasi calissin diye yazildi
    public void setUp(@Optional String browser){
        driver= DriverCross.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        DriverCross.closeDriver();
    }
}
