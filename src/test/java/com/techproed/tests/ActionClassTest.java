package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionClassTest extends TestBase {
    @Test
    public void sagTiklama(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        // bir webelement'e sağ tıklamak için bu kodu kullanırız.
        // actions class ile işlem yaparsanız, HER SEFERİNDE "PERFORM" yapmak zorundasınız.
        actions.contextClick(element).perform();
    }
    @Test
    public void ciftTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        // bir webelement'e iki kere tıklamak istiyorsak, doubleClick
        // methodunu kullanabiliriz.
        actions.doubleClick(button).perform();
    }
    @Test
    public void hoverOver() {
        driver.get("http://amazon.com");
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        // mouse'u istediğimiz webelement'in üzerine götürmek istiyorsak,
        // moveToElement methodunu kullabiliriz.
        actions.moveToElement(menu).perform();
    }
    @Test
    public void asagiYukari() throws InterruptedException {
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.END).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.END).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//arrow== yon tuslarini kontrol ediyor.
          }
}