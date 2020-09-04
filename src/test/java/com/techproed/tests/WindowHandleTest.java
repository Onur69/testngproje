package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {
    @Test
    public void cokluPencereTest () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfaninHandle = driver.getWindowHandle();
        System.out.println(sayfaninHandle);

        //<a href="/windows/new" ,="" target="_blank">Click Here</a>
        driver.findElement(By.partialLinkText("Click Here")).click();

        Thread.sleep(7000);

        System.out.println("-----------------------");
        Set<String> tumPencereler = driver.getWindowHandles();
        /*
        int i=1;
        for (String handle : tumPencereler ) {
            System.out.println(i+" "+handle);
            i++;
        }
         */
        //for ile acilan tum pencerelerin handle'larini ekrana yazdirabiliriz.

        //ikinci sayfanin handlesi ni alalim
        Object[] arr = (Object[]) tumPencereler.toArray();
        Object ikinciHandle = arr [arr.length-1];
        System.out.println(ikinciHandle);

        driver.switchTo().window(sayfaninHandle);//

    }
}
