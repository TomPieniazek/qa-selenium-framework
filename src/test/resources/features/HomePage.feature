Feature: Login

  Scenario: User verifies Rolnopol Home Page
    Given user opens Rolnopol Home Page
    When user waits for correct Home Page statistics
      | Active Users | Managed Farms | Total Area | Total Staff | Stock Animals |
      | 10           | 10            | 5,8K ha    | 15          | 2,6K          |
    Then Home Page main header should be "Rolnopol"