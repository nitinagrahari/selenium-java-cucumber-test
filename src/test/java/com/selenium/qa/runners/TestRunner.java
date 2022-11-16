package com.selenium.qa.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com/selenium/qa/stepDefinitions"},
        plugin = {"pretty",
                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                 "timeline:test-output-thread/"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
