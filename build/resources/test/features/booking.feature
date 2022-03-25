#lenguage: en
#encoding: UTF-8
Feature: As user of restful booker herokuapp api
  i want to create, search and update bookings

  Scenario: Create a booking
    Given the user put the baseurl
    When the user consume the api post
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    Then the api retuns the booking id and the booking data

  Scenario: Get a booking
    Given the user put the baseurl
    When the user consume the api post
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    When the user consume the api get
    Then the api retuns the booking searched

  Scenario: Update booking
    Given the user put the baseurl
    When the user consume the auth
      | username | password |
      | admin    | password123    |
    When the user consume the api post
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    When the user consume the api put
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jorge       | Brown    | 200        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    Then the api retuns the updated booking data

