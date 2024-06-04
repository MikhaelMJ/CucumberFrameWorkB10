Feature: Login input

  Scenario: login input by valid email
    Given user is navigate to the page authorization
    When user enters valid email
    And click on input button
    Then is displayed "Подтвердить другим способом"

  Scenario: login input by invalid email
    Given user is navigate to the page authorization
    When user enters invalid email
    And click on input button
    Then user see invalid credentials message on login page