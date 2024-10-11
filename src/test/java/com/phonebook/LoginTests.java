package com.phonebook;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @BeforeMethod
    public void preCondition() {
        /*if (app.getUserHelper().isSignOutButtonPresent()) {
            app.getUserHelper().logout();
        }
        app.driver.get("https://telranedu.web.app/login");*/
    }

    @Test
    public void loginExistedUserPositiveTest1() {        //logger.info("Hello ********@Test");
        //1. click on login link
        //click(By.xpath("//a[.='LOGIN']"));
        app.getUserHelper().clickLoginLink();
        //2. enter email
        //type(By.name("email"), "sam_sam34@gmail.com");
        //3. enter password
        //type(By.name("password"),"Aaaaabb1!");
        // fillInRegistrationForm(new User("sam_sam365@gmail.com", "Aaaaabb1!"));
        app.getUserHelper().fillInRegistrationForm(new User()
                .setEmail("sam_sam365@gmail.com")
                .setPassword("Aaaaabb1!"));
        //4.click on Login button
        app.getUserHelper().clickOnLoginButton();
        //5. assert that Sign out button is present
        Assert.assertTrue(app.getUserHelper().isSignOutButtonPresent());
    }

    @Test
    public void loginExistedUserPositiveTest2(ITestContext context) {
        String email = "sam_sam365@gmail.com";
        String password = "Aaaaabb1!";
        context.setAttribute("email", email);
        context.setAttribute("password", password);
        app.getUserHelper().login(email, password );
    }

    @Test
    public void loginNegativeWOEmailTest() {
        app.getUserHelper().clickLoginLink();
        app.getUserHelper().fillInRegistrationForm(new User()
                .setPassword("Aaaaabb1!"));
        app.getUserHelper().clickOnLoginButton();
        Assert.assertEquals(app.getUserHelper().alertTextPresent(), "Wrong email or password", "Messegese are not equals");
        Assert.assertTrue(app.getUserHelper().isAlertPresent());
    }

    @AfterMethod(enabled = true)
    public void postConditions() {
        try {
            app.getUserHelper().logout();
        } catch (Exception e) {
           // throw new RuntimeException(e);
        }
    }
}
