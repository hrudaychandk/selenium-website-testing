package org.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserAuthenticationTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before executing user authentication test");
    }

    @Test(groups = "web")
    public void userAuthenticationTest() {
        System.setProperty("webdriver.chrome.driver", "usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        // Opens a website hosted on below machine
        driver.get("https://localhost:3001");
        // Setting an implicit time out for loading of different elements on the website
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Find the username element and pass the username
        driver.findElement(By.id("email")).sendKeys("");
        // Find the password element and pass the password
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("");
        // Find the submit button and click to authenticate the user
        driver.findElement(By.id("u_0_2")).click();
        // TODO: Assert

    }

    @AfterTest
    public void afterTest() {
        System.out.println("After executing user authentication test");
    }
}
