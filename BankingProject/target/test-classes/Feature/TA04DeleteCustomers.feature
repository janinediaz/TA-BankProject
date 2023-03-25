Feature: Delete Customers
  @DeleteCustomers
  Scenario Outline: Delete customers
    Given I search customer "<FirstName>" "<LastName>" "<PostCode>" and delete customer
    Then customer "<FirstName>" "<LastName>" "<PostCode>" should be deleted successfully

    Examples:
      | FirstName | LastName | PostCode |
      | Jackson | Frank | L789C349 |
      | Christopher | Connely | L789C349 |
