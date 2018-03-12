package com.mazum;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test1 {
    @When("^I am on x page$")
    public void i_am_on_x_page() throws Throwable {
        System.out.println("Go to the page");
    }

    @Then("^I see that element$")
    public void i_see_that_element() throws Throwable {
        System.out.println("see that element");
    }
}
