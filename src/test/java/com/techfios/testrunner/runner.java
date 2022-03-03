package com.techfios.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/features/",
glue = "com.techfios.stepDefinition",
tags = {},
monochrome = true,
dryRun = false,
plugin = {
    "pretty",
    "html:target/cucumber",
    "json:target/cucumber.json"
}
)


public class runner {
    
}
