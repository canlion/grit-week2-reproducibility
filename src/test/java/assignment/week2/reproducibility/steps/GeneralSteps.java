package assignment.week2.reproducibility.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.hamcrest.Matchers.equalTo;

public class GeneralSteps {

    @LocalServerPort
    private int port;

    private Response response;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Given("시스템이 정상 동작합니다.")
    public void system_is_functioning_normally() {
    }

    @When("{string} 엔드포인트로 GET 요청을 보냅니다.")
    public void send_request_to_endpoint(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("응답의 상태코드는 {int}이며")
    public void status_code_check(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("응답 본문은 {string} 입니다.")
    public void response_body_check(String body) {
        response.then().body(equalTo(body));
    }
}
