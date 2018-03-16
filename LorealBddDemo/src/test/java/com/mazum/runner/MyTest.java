package com.mazum.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/mazum/features/",
        glue = {"com.mazum.stepdefinitions","com.mazum.hooks"},
        plugin = "html:target/selenium-reports"
)

public class MyTest {
}
