package com.mazum.hooks;

import com.mazum.utilities.TestSettings;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.Properties;

public class Hooks {
    public static TestSettings testSettings;
    public Properties constants;

    public Hooks() {
        System.out.println("_____________ INITIALIZE HOOKS _____________");
        testSettings = TestSettings.getInstance();
        constants = testSettings.getConstantsProp();
    }

    @Before
    public void initiate(Scenario scenario) {
        System.out.println("_____________ BEFORE SCENARIO _____________");
        System.out.println("SCENARIO ID AND NAME:" + scenario.getId() + scenario.getName());
        System.out.println(constants);
        System.out.println("SCENARIO ID: " + scenario.getId());
        System.out.println("SCENARIO NAME: " + scenario.getName());
        String testName = scenario.getId();
    }

    @After
    public void terminate(Scenario scenario) {
        System.out.println("_____________ AFTER SCENARIO _____________");
        String status = scenario.getStatus();
        System.out.println("SCENARIO STATUS: " + status);
    }
}
