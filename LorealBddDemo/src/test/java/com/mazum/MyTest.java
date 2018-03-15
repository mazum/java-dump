package com.mazum;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:test.feature",
        glue = {"classpath:com.mazum","com.mazum.hooks"},
        plugin = "html:target/selenium-reports"
)

public class MyTest {
}
