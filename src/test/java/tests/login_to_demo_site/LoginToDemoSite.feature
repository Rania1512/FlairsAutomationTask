Feature:LogIn into Demo Site
  I want to logIn into Demo Site

  @login
  Scenario Outline:User can login into cloud portal
    Given user login with "<username>" and "<password>" in demo site
    Then  user access dashboard successfully

    Examples:
      | username       | password       |
      | UserName | Password |
