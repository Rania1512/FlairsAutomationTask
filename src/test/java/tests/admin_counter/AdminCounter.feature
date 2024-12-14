Feature: Get numbers of users and Add new user
@counter
  Scenario Outline: Get Number of Existing Users
    Given user login with "<username>" and "<password>" in demo site
    When user press admin tap
    Then user get the current NumberOfRecords

    Examples:
      | username | password |
      | UserName | Password |
@add
  Scenario Outline: Add new user
    Given user login with "<username>" and "<password>" in demo site
    When user press admin tap
    And user get the current NumberOfRecords
    And user press add new user
    And user fill "<userNamefiled>" and "<userPassword>"
    And user choose "<userRole>"
    And user choose user "<status>"
    And user enter "<employeeName>"
    And user press save button
    And user get the new current Number of records
    Then user added successfully
    Examples:
      | username | password |userNamefiled|userPassword|userRole|status|employeeName|
      | UserName | Password |    user55d9 |    Password@123        |   Admin     |Enable      |  test          |