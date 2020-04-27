Feature: Testing Parking Lot

  Scenario Outline: Enter the parking lot
    Given I enter the parking lot at <EnterDate>
    When I leave at <LeaveDate>
    Then my charge is <Charge>

    Examples: 
      | EnterDate  | LeaveDate  | Charge |
      | "4/24 00:00" | "4/26 00:00" |     30 |
