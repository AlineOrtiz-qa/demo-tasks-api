package com.training.tasks.api.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.response.Response;

public class TasksSteps {

    private Response response;

    @When("the client calls GET Tasks")
    public void the_client_calls_GET_Tasks() {
        response = when().get("/tasks");
    }

    @Then("the api returns with status code {int}")
    public void the_api_returns_status_code_of(int statusCode) {
        assertThat(response.getStatusCode()).isEqualTo(statusCode);
    }

@When("the client sends a POST request to Tasks with payload")
public void the_client_sends_a_POST_request_to_Tasks_with_payload(String payload) {
    response = given()
        .header("Content-Type", "application/json")
        .body(payload)
        .when()
        .post("/tasks");
}

@Then("the api returns a success status code {int}")
public void the_api_returns_a_success_status_code(int statusCode) {
    assertThat(response.getStatusCode()).isEqualTo(statusCode);
}

@And("the response contains the created task with title {string}")
public void the_response_contains_the_created_task_with_title(String title) {
    String responseBody = response.getBody().asString();
    assertThat(responseBody).contains("\"title\":\"" + title + "\"");
}

}


