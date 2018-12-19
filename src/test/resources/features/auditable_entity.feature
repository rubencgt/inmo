Feature: entities are being save with audit fields filled

  Scenario:
    Given a new person
    Then the person audit fields are filled
#    And the person is modified
#    Then the person audit modified fields are filled