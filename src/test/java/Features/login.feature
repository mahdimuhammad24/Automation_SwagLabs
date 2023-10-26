Feature: Login

  Scenario : Login dengan valid username dan password
    Given User masuk ke halaman saucedemo login
    When User input username
    And User input password
    And User klik tombol login
    Then User masuk ke halaman dashboard saucedemo

