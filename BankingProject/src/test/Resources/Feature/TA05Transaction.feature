Feature: Perform Debit and Credit Transactions
  @Transactions
  Scenario Outline: Perform transactions
    Given I login as customer and select 1003
    When I make a "<TransactionType>" of "<Amount>"
    Then I verify my balance after "<TransactionType>" of "<Amount>"

    Examples:
      | Amount | TransactionType |
      | 50000 | Credit |
      | 3000 | Debit |
      | 2000 | Debit |
      | 5000 | Credit |
      | 10000 | Debit |
      | 15000 | Debit |
      | 1500 | Credit |
