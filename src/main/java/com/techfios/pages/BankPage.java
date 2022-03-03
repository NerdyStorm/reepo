package com.techfios.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankPage {

    WebDriver driver;
    String texts;

    public BankPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElement Library
    @FindBy(how = How.XPATH, using = "//input[@name='account']")
    WebElement accountField;
    @FindBy(how = How.XPATH, using = "//input[@name='description']")
    WebElement descriptionField;
    @FindBy(how = How.XPATH, using = "//input[@name='balance']")
    WebElement balanceField;
    @FindBy(how = How.XPATH, using = "//input[@name='account_number']")
    WebElement accountNumberField;
    @FindBy(how = How.XPATH, using = "//input[@name='contact_person']")
    WebElement contactPersonField;
    @FindBy(how = How.XPATH, using = "//input[@name='contact_phone']")
    WebElement contactPhoneField;
    @FindBy(how = How.XPATH, using = "//input[@name='ib_url']")
    WebElement urlField;
    @FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/div[3]/div[1]/div/div/div[2]/form/button")
    WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//div[@class='wrapper wrapper-content animated fadeIn']")
    WebElement alert;

    public void fillAccount(String s) {
        accountField.sendKeys(s);
    }

    public void fullDescription(String s) {
        descriptionField.sendKeys(s);
    }

    public void fillBalance(String s) {
        balanceField.sendKeys(s);
    }

    public void fillAccountNumber(String s) {
        accountNumberField.sendKeys(s);
    }

    public void fillContactPerson(String s) {
        contactPersonField.sendKeys(s);
    }

    public void fillContactPhone(String s) {
        contactPhoneField.sendKeys(s);
    }

    public void fillUrl(String s) {
        urlField.sendKeys(s);
    }

    public void submit() {
        submitButton.click();
    }// div[@class='alert alert-success fade in']/i

    public void confirmAccountCreation() {
        texts = alert.getText();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success fade in']")));
        Assert.assertEquals("Account Not Created !", " Account Created Successfully ", checkText());

    }

    public String checkText() {
        if (texts.contains("Account Created Successfully")) {
            return " Account Created Successfully ";
        }
        return "";
    }
}
