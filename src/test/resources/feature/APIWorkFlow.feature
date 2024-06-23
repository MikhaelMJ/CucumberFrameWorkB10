Feature: Syntax HRM API workflow

  Background:
    Given a JWT is generated


  @APIWorkFlow
  Scenario: Creating an employee
    Given a request is prepared for creating an employee
    When a Post call is made to create and employee
    Then the status code for creating an employee is 201
    And the employee create contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable to be used for other calls