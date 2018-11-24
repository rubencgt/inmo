Feature: entities are being save with audit fields filled

  Scenario:
    When a new person is created
    Then the person audit fields are filled
#    And the person is modified
#    Then the person audit modified fields are filled