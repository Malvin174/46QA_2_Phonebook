package com.phonebook;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {



    @Test
    public void createAccountPositiveTest1() {
        //1.click on Login link //a[.='LOGIN']
        app.getUserHelper().clickLoginLink();
        //2.enter email in input By.name("email")
        //driver.findElement(By.name("email")).click();
        //3.enter email in input By.name("password")
        app.getUserHelper().fillInRegistrationForm(new User()
                .setEmail("sam_sam365@gmail.com")
                .setPassword("Aaaaabb1!"));
        //4. click on registration button By.name ("registration")
        app.getUserHelper().clickInRegistrationButton();
        //Assert that button //button[.='Sign Out'] is present
        Assert.assertTrue(app.getUserHelper().isSignOutButtonPresent());
    }

    @Test
    public void createAccountPositiveTest2() {
        String email = "delete_account_" + System.currentTimeMillis() + "@gmail.com";
        String password = "Aaaaabb1!";
        app.getUserHelper().register("sam_sam6@gmail.com", "Aaaaabb1!");
    }

    @Test
    public void createAccountLoginPositiveTest() {
        String email = "delete_account_" + System.currentTimeMillis() + "@gmail.com";
        String password = "Aaaaabb1!";
        app.getUserHelper().register(email, password);
        //click(By.xpath("//button[.='Sign Out']"));
        app.getUserHelper().logout();
        app.getUserHelper().login(email, password);

    }

    @Test
    public void createAccountNegativeTest1() {
        SoftAssert softAssert = new SoftAssert();

        app.getUserHelper().clickLoginLink();
        app.getUserHelper().fillInRegistrationForm(new User()
                .setEmail("sam_sam365@gmail.com")
                .setPassword("Aaaaabb1!"));
        app.getUserHelper().clickInRegistrationButton();
        //Assert.assertFalse(isSignOutButtonPresent());
        //Assert.assertTrue(isAlertPresent());
        //Assert.assertTrue(isElementPresent(isError409Present()));
        /*
         * В Java, SoftAssert — это класс, предоставляемый библиотекой TestNG, который используется для выполнения "мягких"
         * утверждений (soft assertions) в тестах. В отличие от "жестких" (hard assertions), которые немедленно прерывают
         * выполнение теста при ошибке, мягкие утверждении позволяют продолжить выполнение теста даже если одно из утверждений не прошло.
         * Цель: SoftAssert используется для проверки нескольких условий в рамках одного теста, не прерывая его выполнение при первой неудаче
         */
        softAssert.assertTrue(app.getUserHelper().isAlertPresent());
        softAssert.assertTrue(app.getUserHelper().isElementPresent(app.getUserHelper().isError409Present()));
        softAssert.assertAll();
        /*
         * Назначение: assertAll() используется для проверки всех утверждений, сделанных с помощью SoftAssert, в конце теста.
         * Если одно или несколько утверждений не прошли, assertAll() вызовет исключение и тест будет помечен как неудавшийся
         */
    }



}
