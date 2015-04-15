@restApiIntegration
Feature: User Realm Resource Integration Test

  Scenario: get EXISTING user realm by id
    Given the web context is set
    Given the db is empty
    Given the following user realms exist:
      | name              |  description | key  |
      | tamas.lang        |  desc...     | 1233 |
      | tamas.lang2       |  desc...     | 1234 |
    When client request GET /service/user/realm/1000000
    Then the response code should be 200
    Then the result json should be:
    """
    {"name":"tamas.lang","description":"desc...","key":"1233"}
    """

  Scenario: get NON-EXISTING user realm by id
    Given the web context is set
    Given the db is empty
    When client request GET /service/user/realm/1000000
    Then the response code should be 404
    Then the result string should be:
    """
    {"code":"RealmNotFound"}
    """

  Scenario: get user realm by INVALID
    Given the web context is set
    Given the db is empty
    When client request GET /service/user/realm/abc
    Then the response code should be 400
    Then the result string should be:
    """
    {"code":"InvalidArgument"}
    """

  Scenario: create a user realm
    Given the web context is set
    Given the db is empty
    When client request POST /service/user/realm with json data:
    """
    {"name":"name","description":"description"}
    """
    Then the response code should be 201
    Then the following headers should present "Location"
    Then the result json should be:
    """
    {"name":"name","description":"description","key":"01234567890123456789012345678912"}
    """

  Scenario: create a user realm with EXISTING NAME
    Given the web context is set
    Given the db is empty
    Given the following user realms exist:
      | name              |  description | key  |
      | tamas.lang        |  desc...     | 1233 |
    When client request POST /service/user/realm with json data:
    """
    {"name":"tamas.lang","description":"description"}
    """
    Then the response code should be 400
    Then the result string should be:
    """
    {"code":"DuplicateRealmName"}
    """
