Feature: entities are being save with audit fields filled

  Scenario:
    Given a new person is registered
    When the person logs in
    Then the person audit fields are filled
