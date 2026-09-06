package com.vikram.qa.automationexercise.api;

import com.vikram.qa.automationexercise.utils.ConfigReader;
import com.vikram.qa.automationexercise.api.model.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    public String createUser(CreateUserRequest request) {

        return given()
                .baseUri(ConfigReader.getProperty("baseUrl"))
                .formParam("name", request.getName())
                .formParam("email", request.getEmail())
                .formParam("password", request.getPassword())
                .formParam("title", request.getTitle())
                .formParam("birth_date", String.valueOf(request.getBirthDate()))
                .formParam("birth_month", String.valueOf(request.getBirthMonth()))
                .formParam("birth_year", String.valueOf(request.getBirthYear()))
                .formParam("firstname", request.getFirstName())
                .formParam("lastname", request.getLastName())
                .formParam("company", request.getCompany())
                .formParam("address1", request.getAddress1())
                .formParam("address2", request.getAddress2())
                .formParam("country", request.getCountry())
                .formParam("zipcode", request.getZipcode())
                .formParam("state", request.getState())
                .formParam("city", request.getCity())
                .formParam("mobile_number", request.getMobileNumber())
                .when()
                .post("/api/createAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
    }

    public String deleteUser(String email, String password){
        return given()
                .baseUri(ConfigReader.getProperty("baseUrl"))
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .delete("/api/deleteAccount")
                .then()
                .statusCode(200)
                .extract()
                .asString();
    }

}
