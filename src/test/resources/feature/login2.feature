Feature:

  @errorvalidation
  Scenario: on login page error validation
    When user enters invalid email and click on input button and verify the error
      |login                     |errorMessage|
      |dzhenkov_mihail@mail.ru122|Аккаунт не найден. Повторите попытку или зарегистрируйтесь по номеру телефона|
      |1234                      |Телефон указан некорректно []|

  @excel
  Scenario: login input using excel
    When user enters email from excel file usin "LoginData"
