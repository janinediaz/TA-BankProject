Feature: Login to Banking page as Bank Manager

  @Manager
  Scenario: Login to banking page as banking manager
    Given I would like to launch the Banking Page URL "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"
    Then I login as Bank Manager

    @Customer
    Scenario: Login to banking page as customer
      Given I would like to launch the Banking Page URL "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"
      Then I login as "Hermoine Granger"