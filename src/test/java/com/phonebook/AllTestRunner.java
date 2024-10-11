package com.phonebook;


import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import java.util.List;
import java.util.ArrayList;


public class AllTestRunner {


    public static void main(String[] args) {
        TestNG testNG = new TestNG();

        List<String> suites = new ArrayList<>();
        suites.add("path.to.LoginTest");
        suites.add("path.to.addContactTest");
        suites.add("path.to.HomePageTest");
        suites.add("path.to.CreateAccountTest");
        suites.add("path.to.DeleteContactTest");

        testNG.setTestClasses(new Class[]{
                LoginTests.class,
                AddContactsTests.class,
                HomePageTests.class,
                CreateAccountTests.class,
                DeleteContactTests.class
        });
        testNG.run();
    }
}
