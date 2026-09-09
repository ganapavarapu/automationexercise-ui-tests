# QA Automation Framework

A maintainable and scalable UI test automation framework built using Java, Selenium WebDriver, TestNG and Maven, with API-assisted test data management, parallel execution, CI/CD integration and test reporting.

The framework is currently being developed incrementally with a focus on improving maintainability, reliability and scalability of automated test execution.

## Overview

This project automates selected user workflows of the [Automation Exercise](https://automationexercise.com/) application.

The primary focus of the framework is UI test automation. REST Assured is also used to support UI test scenarios through API-based test data setup and cleanup.

The framework is designed to demonstrate practical QA automation engineering practices rather than simply automating individual test cases.

## Tech Stack

- **Language:** Java 25
- **UI Automation:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **API Support:** REST Assured
- **CI/CD:** Jenkins
- **CI Platform:** GitHub
- **Reporting:** Allure
- **Version Control:** Git
- **Execution:** Local and Jenkins-based execution

## Framework Capabilities

### UI Test Automation

The framework uses Selenium WebDriver to automate web application workflows.

The test implementation follows reusable page and test components to keep test cases readable and reduce duplication.

### API-Assisted Test Data Management

REST Assured is used to perform API operations that support UI test execution.

For example:

- Create a user through the API before a login-related UI test
- Execute the corresponding UI workflow
- Delete the test user after execution

This approach helps keep UI tests independent from manually created test data and reduces unnecessary UI operations for test setup and cleanup.

> REST Assured is currently used primarily for test data management and setup/cleanup support rather than as a standalone API test suite.

### Parallel Test Execution

TestNG is configured to support parallel execution of test methods.

This allows independent tests to execute concurrently and helps reduce overall execution time.

The framework is being designed with scalable execution in mind so that parallel execution can be extended further as the framework evolves.

### CI/CD Integration

Jenkins is integrated into the framework to execute the automated test suite as part of the CI/CD process.

The project also includes **pre-merge CI validation**. When a new Pull Request is created, the automated test suite is triggered to provide early feedback before changes are merged.

This helps identify automation failures and regressions earlier in the development workflow.

### Test Reporting

Allure reporting is integrated to provide a consolidated view of test execution results.

The reports help in quickly understanding:

- Passed tests
- Failed tests
- Execution results
- Test duration
- Overall test execution status

### Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.vikram.qa.automationexercise
│   │       ├── annotations
│   │       ├── api
│   │       │   └── model
│   │       ├── components
│   │       ├── constants
│   │       ├── core
│   │       ├── models
│   │       ├── pages
│   │       └── utils
│   │
│   └── resources
│       └── testdata
│
└── test
    ├── java
    │   └── com.vikram.qa.automationexercise
    │       ├── base
    │       ├── suites
    │       ├── testdata
    │       └── tests
    │
    └── resources

allure-results