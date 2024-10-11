package com.phonebook.fw;

import com.phonebook.core.BaseHelper;
import com.phonebook.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserHelper  extends BaseHelper {
    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static By isError409Present() {
        return By.xpath("//div[.='Registration failed with code 409']");
    }

    public void login(String email, String password) {
        //1. click on login link
        click(By.xpath("//a[.='LOGIN']"));
        //2. enter email
        type(By.name("email"), email);
        //3. enter password
        type(By.name("password"), password);
        //4.click on Login button
        click(By.name("login"));
        //5. assert that Sign out button is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    /**
     * Method for <code>registering a new user<code/> on the site.
     *
     * @param email Email used for registration.
     * @param password The password that will be set for the account.
     *
     *The registration process involves the following steps:
     * 1. Click on the "LOGIN" link.
     * 2. Enter your email in the email field.
     * 3. Enter the password in the appropriate field.
     * 4. Click on the registration button.
     * 5. Check that the "Sign Out" button is displayed after successful registration.
     *
     * Exception: If the "Sign Out" element is not found, the assertion will throw an exception.
     */

    public void register(String email, String password) {
        //1.click on Login link //a[.='LOGIN']
        click(By.xpath("//a[.='LOGIN']"));
        //2.enter email in input By.name("email")
        //driver.findElement(By.name("email")).click();
        type(By.name("email"), email);
        //3.enter email in input By.name("password")
        type(By.name("password"), password);
        //4. click on registration button By.name ("registration")
        click(By.name("registration"));
        //Assert that button //button[.='Sign Out'] is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    public void logout() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public void fillInRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickInRegistrationButton() {
        click(By.name("registration"));
    }

    public void clickLoginLink() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
                click(By.name("login"));
    }
}
