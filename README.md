# Test Automation for Bank Project

#### By Janine Diaz

#### This is Simple Test Automation Script

## Technologies Used

* Cucumber
* Selenium
* Java
* JUnit

## Description

This Simple Test Automation performs the following bank functionalities:

Scenario 1:
1. Login as Bank Manager
2. Create customers
3. Verifies customer creation
4. Delete customers
5. Verifies customer deletion

Scenario 2:
1. Login as Customer
2. Performs deposit and withdrawal transactions
3. Validates balance for each transaction

## Setup/Installation Requirements
### Installation guide for Cucumber setup with IntelliJ IDEA

• Install Latest Java version 19.

• Install IntelliJ IDEA -community version

• Install Cucumber Plugin

• Add dependencies:
      -junit.jar
      -hamcrest.jar
      
• Install Chromedriver

## Guide to Run the Test automation

There are two Test Runners that can be executed - one for each scenario mentioned in the Description section.

1. Q1TestRunner (Path: "src/test/java/StepDefinitions/Q1TestRunner.java")
2. Q2TestRunner (Path: "src/test/java/StepDefinitions/Q2TestRunner.java")


## Test Report

Cucumber reports are automatically generated for every test run.


Test reports of successful test runs can be found on below links:


Q1TestReport: https://reports.cucumber.io/reports/ef04fb6b-bc09-4001-b0b3-56389dfbd549 

Q2TestReport: https://reports.cucumber.io/reports/c0445c98-3ca9-4daf-acfa-3f9eba997ad4


## Source Directories


Cucumber Features: "src\test\java\StepDefinitions"

Step Definitions: "src\test\Resources\Feature"

Test Reports: "target\CucumberReports"




Copyright (c) 25-03-2023 Janine Margate Diaz
