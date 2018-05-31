Feature: Welcome

Scenario: Welcome and go to Sign In
Given User is on Welcome Screen
  When User tap to Sign In Button
  Then User is on Sign In screen

  Scenario: Welcome and go to Sign Up
    Given User is on Welcome Screen
    When User tap to Start Button
    Then User is on Sign Up screen




