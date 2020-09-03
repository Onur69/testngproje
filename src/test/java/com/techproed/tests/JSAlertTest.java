package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void jsAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //<button onclick="jsAlert()">Click for JS Alert</button>
        //xpath, cssSelector, tagName==>bunlari sirayla dene bakalim

        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();

        //alertin icerdigi mesaji almak icin gettext() kullaniriz.
        String alertMesaji = driver.switchTo().alert().getText();
        System.out.println(alertMesaji);

        //alertin icinde ki ok butonuna tiklamak icin kullanilir
        driver.switchTo().alert().accept();
    }
    @Test
    public void jsConfirm(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //<button onclick="jsConfirm()">Click for JS Confirm</button>
        WebElement cancelButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        cancelButton.click();

        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);

        //alertin icinde ki cancel butonuna tiklar.
        driver.switchTo().alert().dismiss();
    }
    @Test
    public void jsPromt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //<button onclick="jsPrompt()">Click for JS Prompt</button>
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();

        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);

        //
        driver.switchTo().alert().sendKeys("Merhaba testNG");

        driver.switchTo().alert().accept();
    }
            /*  Alert alert = driver.switchTo().alert();
                alert.dismiss();
                alert.accept();
                alert.getText();
                alert.sendKeys("Gerek yok");
                bu sekilde obje olusturarakta kullanabilirdik ama
                gerek yok*/

}
