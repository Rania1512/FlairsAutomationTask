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
      | UserName | Password |    user955d |    Password@123        |   Admin     |Enable      |  test          |

  @DeleteUser
  Scenario Outline: Delete new user
    Given user login with "<username>" and "<password>" in demo site
    When user press admin tap
    And user get the current NumberOfRecords
    And user search with "<user>"
    And user click on remove button
    And user press confirm delete user
    And user refresh page
    And user get the new current Number of records
    Then user deleted successfully

    Examples:
      | username | password |user|
      | UserName | Password |user955d|