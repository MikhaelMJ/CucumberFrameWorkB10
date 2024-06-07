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

  @DDT
  Scenario: login input by email from feature file
    When user enters "dzhenkov_mihail@mail.ru122"
    And click on input button
    Then user see invalid credentials message on login page

    @examples
    Scenario Outline: login input by email from feature file
      When user enters "<email>"
      And click on input button
      Then user see invalid credentials message on login page
      Examples:
      |email|
      |dzhenkov_mihail@mail.ru122|
      |dzhenkov_mihail@mail.ru|
      |dzhenkov@mail.ru|
      |dzhenkovkjkjlk@mail.ru|

      @datatable
      Scenario: login input using data table
        //When - пишется общий шаг и проверка
        // далее данные из таблицы добавляются в список карт
          |dzhenkov_mihail@mail.ru122|
          |dzhenkov_mihail@mail.ru|
          |dzhenkov@mail.ru|
          |dzhenkovkjkjlk@mail.ru