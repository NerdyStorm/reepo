package com.techfios.stepDefinition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.techfios.pages.BankPage;
import com.techfios.pages.DashboardPage;
import com.techfios.pages.LoginPage;
import com.techfios.utils.BrowserFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends BrowserFactory {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    BankPage bankPage;

    @Before
    public void initialization() {
        driver = init();

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        bankPage = new BankPage(driver);

    }

    @Given("^User is on the techfios login page$")
    public void user_is_on_the_techfios_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.techfios.com/billing");
    }

    @When("^User enters the \"([^\"]*)\"$")
    public void user_enters_the(String arg1) {
        if (arg1.equals("username")) {
            loginPage.inputUsername("demo@techfios.com");
        } else if (arg1.equals("password")) {
            loginPage.inputPassword("abc123");
        }

    }

    @When("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        if (arg1.equals("login")) {
            loginPage.clickSubmit();
        } else if (arg1.equals("bankCash")) {
            dashboardPage.clickBankButton();
        } else if (arg1.equals("newAccount")) {
            dashboardPage.clickNewAccount();
        } else if (arg1.equals("submit")) {
            try {
               // Thread.sleep(5000);
                bankPage.submit();
            //Thread.sleep(5000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
      
        }
    }

    @Then("^User should land on Dashboard page$")
    public void user_should_land_on_Dashboard_page() {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage.waitForDashboardPage();
    }

    @Then("^User enters \"([^\"]*)\" in accounts page$")
    public void user_enters_in_accounts_page(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        if (arg1.equals("accountTitle")) {
            bankPage.fillAccount((1234+ (new Random()).nextInt(12345)) + "Md Checking");
        } else if (arg1.equals("description")) {
            bankPage.fullDescription("Md's checking account");
        } else if (arg1.equals("initialBalance")) {
            bankPage.fillBalance("1000000");
        } else if (arg1.equals("accountNumber")) {
            bankPage.fillAccountNumber("1100011");
        } else if (arg1.equals("contactPerson")) {
            bankPage.fillContactPerson("Morgan Chase");
        } else if (arg1.equals("Phone")) {
            bankPage.fillContactPhone("3474761234");
        } else if (arg1.equals("internetBankingURL")) {
            bankPage.fillUrl("https://www.chase.com");
        }
    }

    @Then("^User should be able to validate account created successfully$")
    public void user_should_be_able_to_validate_account_created_successfully() {
        // Write code here that turns the phrase above into concrete actions
        bankPage.confirmAccountCreation();

    }

}
