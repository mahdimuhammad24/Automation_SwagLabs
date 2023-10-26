Feature: Failed Login

  Scenario: Login dengan invalid username dan password
    Given User buka halaman saucedemo login
    When User input invalid username
    And User input invalid password
    And Klik tombol login
    Then User tidak masuk ke halaman dashboard saucedemo

  Scenario: Login dengan invalid password
    Given User buka halaman saucedemo login
    When User input valid username
    And User input invalid password
    And Klik tombol login
    Then User tidak masuk ke halaman dashboard saucedemo

  Scenario: Login dengan invalid username
    Given User buka halaman saucedemo login
    When User input invalid username
    And User input valid password
    And Klik tombol login
    Then User tidak masuk ke halaman dashboard saucedemo
