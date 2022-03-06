package com.techfios.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/features/",
glue = "com.techfios.stepDefinition",
tags = "",
monochrome = true,
dryRun = false,
plugin = {
    "pretty",
    "html:target/cucumber",
    "json:target/cucumber.json"
}
)


public class Testrunner {
    
}
