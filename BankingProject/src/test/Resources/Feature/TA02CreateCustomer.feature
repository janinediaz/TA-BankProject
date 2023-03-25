Feature: Create customers
  @CreateCustomer
  Scenario Outline: Create customers
    Given I click on Add New Customer Button
    Given I input the customer first name "<FirstName>"
    Given I input the customer last name "<LastName>"
    Given I input the customer post code "<PostCode>"
    When I click Add customer
    Then the customers should be created successfully

    Examples:
      | FirstName | LastName | PostCode |
      | Christopher | Connely | L789C349 |
      | Frank | Christopher | A897N450 |
      | Christopher | Minka | M098Q585 |
      | Connely | Jackson | L789C349 |
      | Jackson | Frank | L789C349 |
      | Minka | Jackson | A897N450 |
      | Jackson | Connely | L789C349 |
