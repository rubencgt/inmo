Feature: entities are being save with audit fields filled

  Scenario:
    Given a new user is registered
    When the user creates a new add via rest
    Then the user can retrieve his advertisements
