Feature: Order
  Scenario: User berhasil menyelasaikan order
    Given User buka halaman saucedemo
    When User login sebagai standard user
    And User pilih product Sauce Labs Backpack
    Then User berada di halaman detail product
    And User menambahkan product ke cart
    And User ke halaman cart
    And User memproses checkout
    And User masuk dan mangikuti checkout information:
    And User melanjutkan checkout
    And User menyelesaiakn order
    Then User mendapatkan pesan konfirmasi THANK YOU FOR YOUR ORDER