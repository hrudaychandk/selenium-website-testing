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
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(chromeOptions);
        // Opens a website hosted on below machine
        driver.get("http://localhost:3001");
        //driver.get("https://www.google.com");
        // Setting an implicit time out for loading of different elements on the website
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        // Find the username element and pass the username
        driver.findElement(By.name("login")).sendKeys("devops");
        // Find the password element and pass the password
        driver.findElement(By.name("password")).sendKeys("test");
        // Find the submit button and click to authenticate the user
        driver.findElement(By.name("click")).click();
        //Access alert
        System.out.println(driver.findElement(By.className("alert alert-dismissible alert-success")).getText());
        //Quit the driver
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After executing user authentication test");
    }
}
