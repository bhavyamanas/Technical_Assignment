package assignmentjava;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class TechnicalAssignment2 {

    @Test
    public void testPostRequest() {
        // Define the endpoint URL
        String url = "https://api.example.com/endpoint"; // replace with your API URL

        // Create a JSON body for the POST request
        String jsonBody = "{\n" +
                          "  \"name\": \"John Doe\",\n" +
                          "  \"email\": \"johndoe@example.com\",\n" +
                          "  \"age\": 30\n" +
                          "}";

        // Send the POST request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonBody)  // set request body
                .when()
                .post(url);  // send POST request

        // Assert the response status code
        response.then().statusCode(201);  // 201 Created, or change according to expected response

        // Optionally check response body
        response.then().body("message", equalTo("User created successfully")); // Example validation
    }
}