Feature: Verify customers are added on the table
  @VerifyCustomerTable
  Scenario Outline: Verify customers are added on the table
    Given I click on Customers
    When I browse Customer Table
    Then I see the customer on the table "<FirstName>" "<LastName>"

    Examples:
      | FirstName | LastName |
      | Christopher | Connely |
      | Frank | Christopher |
      | Christopher | Minka |
      | Connely | Jackson |
      | Jackson | Frank |
      | Minka | Jackson |
      | Jackson | Connely |