package com.techfios.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (how = How.XPATH, using = "//span[text()='Bank & Cash']") WebElement bankButton;
    @FindBy (how = How.XPATH, using = "//a[text()='New Account']") WebElement newAccountButton;

    public void clickBankButton(){
        bankButton.click();
    }

    public void clickNewAccount(){
        newAccountButton.click();
    }

    public void waitForDashboardPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()=' Dashboard ']")));
        System.out.println("Dashboard Loaded!");
    }
 
}
