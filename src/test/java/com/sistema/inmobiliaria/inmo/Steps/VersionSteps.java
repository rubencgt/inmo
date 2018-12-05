package com.sistema.inmobiliaria.inmo.Steps;

import cucumber.api.java.en.When;

public class VersionSteps extends StepsRestBaseIT {

    @When("the client calls /version")
    public void the_client_issues_GET_version() {
        restTemplate.getForEntity("http://localhost:" + port + "/version", String.class);
    }

}
