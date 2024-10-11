package com.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        app.getDriver().get("https://telranedu.web.app/home");
    }

    @Test
    public void isHomeComponentPresentTest(){
       // app.getDriver().get("https://telranedu.web.app/home");
      //  driver.findElement(By.xpath("//html/body/div/div/div/div/h1"));
       // driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
        Assert.assertTrue(app.getHomeHelper().isHomeComponentPresent(), "Item not found on page");
        System.out.println("Element 'Home Component' found on the home page");
    }


}
