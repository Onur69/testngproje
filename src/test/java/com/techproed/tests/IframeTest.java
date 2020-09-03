package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void iframeTest1(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        //index ile iframe'e gecis yapabiliyoruz
        driver.switchTo().frame(0);

        WebElement paragraf = driver.findElement((By.xpath("//p")));
        paragraf.clear();//iframe'in icini temizledik sonra alttaki yaziyi yazdiracagiz
        paragraf.sendKeys("Merhaba Iframe");
    }
    @Test
    public void iframeTest2(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        //id attribute'u ile de iframe'e gecis yapabiliyoruz
        driver.switchTo().frame("mce_0_ifr");

        WebElement paragraf = driver.findElement((By.xpath("//p")));
        paragraf.clear();//iframe'in icini temizledik sonra alttaki yaziyi yazdiracagiz
        paragraf.sendKeys("Merhaba Iframe");
    }
    @Test
    public void iframeTest3(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        //WebElement ile de iframe'e gecis yapabiliyoruz
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement paragraf = driver.findElement((By.xpath("//p")));
        paragraf.clear();//iframe'in icini temizledik sonra alttaki yaziyi yazdiracagiz
        paragraf.sendKeys("Merhaba Iframe");
    }
    @Test
    public void iframeTest4(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        //index ile iframe'e gecis yapabiliyoruz
        driver.switchTo().frame(0);

        WebElement paragraf = driver.findElement(By.partialLinkText("Elemental Selenium"));
        paragraf.clear();//iframe'in icini temizledik sonra alttaki yaziyi yazdiracagiz
        paragraf.sendKeys("Merhaba Iframe");

        driver.switchTo().defaultContent();//web sayfamizin ana govdesine geri donus yapar.En ust parenta dondurur.
        driver.switchTo().parentFrame();//bir ustteki parent olan web sayfasina geri doner

        WebElement element = driver.findElement(By.partialLinkText("Elemental Selenium"));
        element.click();
    }
}
