Feature: Login input

  @smoke
  Scenario: login input by valid email
    When user enters valid email
    And click on input button
    Then is displayed "Подтвердить другим способом"

  @regression
  Scenario: login input by invalid email
    When user enters invalid email
    And click on input button
    Then user see invalid credentials message on login page