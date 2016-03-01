/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author tjekel
 */
public class NewEmptyJUnitTest {

    
    @Test
    public void hello() {
        //FF
        WebDriver driver = new FirefoxDriver();
        //chrome
        //WebDriver driver = new ChromeDriver();
        //IE
        //WebDriver driver = new InternetExplorerDriver();
        Actions action = new Actions(driver);
        WebElement el ;
        driver.get("http://devsummerfields.qg.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        el = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        el.sendKeys("admin");
        el = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        el.sendKeys("Boulder1");
        el.submit();
        
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu")));
        WebElement li = menu.findElement(By.xpath(".//li[3]/a"));
        

        if (li.isEnabled()) {
            System.out.println("yes " + li.getAttribute("href"));
            action.moveToElement(li).click().build().perform();
        } else {
            System.out.println("no");
        }
      
        WebElement con = driver.findElement(By.id("mgNavContainer"));

        
        el = con.findElement(By.xpath(".//ul/li[1]/a"));
        String ss = el.getAttribute("href");
        System.out.println(ss);
        el.click();
        el = wait.until(ExpectedConditions.elementToBeClickable(By.className("mce-item-table")));

        System.out.println(el.getAttribute("data-mce-selected"));
        
        menu = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu")));
        el = menu.findElement(By.xpath(".//li[5]"));
        con = el.findElement(By.xpath("./ul/li[1]"));
        action.moveToElement(el).perform();
        con = wait.until(ExpectedConditions.elementToBeClickable(con));
        
        action.moveToElement(con).perform();
        el = wait.until(ExpectedConditions.elementToBeClickable(con.findElement(By.xpath(".//ul/li[1]/a"))));
        action.moveToElement(el).click().build().perform();
       


        WebElement srch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@type,'search')]")));
        srch.sendKeys("w");
        el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), 'Wayt')]")));
        action.moveToElement(el).doubleClick().build().perform();
        WebElement logged = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loggedUserName")));
        Assert.assertTrue(logged.getText().contains("Wayt"));


        driver.quit();
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
