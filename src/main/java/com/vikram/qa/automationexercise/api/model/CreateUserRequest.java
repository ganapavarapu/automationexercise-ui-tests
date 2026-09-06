package com.vikram.qa.automationexercise.api.model;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequest {

    private String name;
    private String email;
    private String password;
    private String title;
    private int birthDate;
    private int birthMonth;
    private int birthYear;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String zipcode;
    private String state;
    private String city;
    private String mobileNumber;

}
