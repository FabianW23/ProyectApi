#lenguage: en
#encoding: UTF-8
Feature: As user of restful booker herokuapp api
  i want to create, search and update bookings

  Scenario: Trying get token with bad credentials
    Given the user put the baseurl
    When the user consume the auth
      | username | password |
      | admin    | password123ad   |
    Then The api returns a reason bad credentials

  Scenario: tryin Update a booking with a bad token
    Given the user put the baseurl
    When the user consume the api post
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    When the user put a bad token
    When the user consume the api put
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jorge       | Brown    | 200        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    Then the api retuns status 403
