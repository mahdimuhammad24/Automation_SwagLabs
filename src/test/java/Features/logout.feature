Feature: Logout

  Scenario: Logout dari halaman saucedemo
    Given User telah login ke halaman saucedemo
    And User klik sidebar kiri atas
    When User klik tombol logout
    Then User kembali ke halaman login