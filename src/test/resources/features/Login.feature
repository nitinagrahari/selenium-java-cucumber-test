Feature: User Login Feature

  # Valid Login scenario cannot be covered as it is a prod env. We can cover login functionality with valid credentials in test env.
  Scenario Outline: Login with invalid user details
    Given Application Login Page is displayed
    When I login with the invalid user id <user id> and invalid password <password>
    Then I see a error message <error message>

    Examples:
      | user id            | password | error message |
      | test1@dummy.xyza | dummypassword | Login incorrect. Either the user ID or password combination is incorrect or the account has been locked. Please try again or reset your password. |

    # Here we are just validating till reset password using different ways steps. Further steps are not including due to lack of valid test data like OTP, etc
  Scenario Outline: Reset password using userID
    Given Application Login Page is displayed
    When I want to reset my password with user id <User Id>
    Then I see different methods for resetting the password

    Examples:
      | User Id |
      | Dummy123 |