package com.vikram.qa.automationexercise.testdata;

import com.vikram.qa.automationexercise.api.model.CreateUserRequest;
import com.vikram.qa.automationexercise.models.SignUpData;

import java.util.UUID;

public class TestDataGenerator {

    public CreateUserRequest generateUser() {

        String uniqueId = generateUniqueId();

        return CreateUserRequest.builder()
                .name("TestUser_" + uniqueId)
                .email("testUser_" + uniqueId + "@example.com")
                .password("Test@12345")
                .title("Mr")
                .birthDate(15)
                .birthMonth(6)
                .birthYear(1995)
                .firstName("Test")
                .lastName("User")
                .company("Test Company")
                .address1("123 Test Street")
                .address2("Test Area")
                .country("Germany")
                .zipcode("12345")
                .state("Berlin")
                .city("Berlin")
                .mobileNumber("0123456789")
                .build();
    }

    public SignUpData generateValidSignUpData() {

        SignUpData data = new SignUpData();
        String uniqueId = generateUniqueId();

        data.setName("JohnDoe");
        data.setEmail("signUpUser_" + uniqueId + "@example.com");
        data.setPassword("Pass@123");
        data.setFirstName("John");
        data.setLastName("Doe");
        data.setAddress("Test Address");
        data.setState("Test State");
        data.setCity("Test City");
        data.setZipcode("12345");
        data.setMobileNumber("112233445566");

        return data;
    }

    private String generateUniqueId(){
        return UUID.randomUUID().toString().substring(0, 8);
    }

}
