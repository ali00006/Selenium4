package com.google.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

// Project Done by Suhail Abbas 
public class GoogleSearchPage {
    WebDriver driver;
    String url = "https://www.google.com/";
    
    @BeforeTest
    public void launchApplication() {
        // Setup Firefox driver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        
        // Initialize Firefox driver with options
        driver = new FirefoxDriver();
        
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Window is maximised.");
        driver.get(url);
        //Code is added by Ali
        System.out.println("Google search page is opened.");
    }
    
    @Test
    public void search() {
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        searchInput.sendKeys("Telus International");
        System.out.println("Input is entered.");
        
        // Updated XPath to be more reliable
        //WebElement searchBtn = driver.findElement(By.xpath("//input[@name='btnK' and (@type='submit' or @value='Google Search')]"));
        //searchBtn.click();
        WebElement searchBtn = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
	searchBtn.click();
        System.out.println("Search button is clicked.");
        //added by Suhail.
        System.out.println("Search result is displayed.");
    }
    
    @AfterTest
    public void closeApplication() {
        driver.quit(); // Changed from close() to quit() to ensure all resources are released
        System.out.println("Application is closed.");
    }
}
