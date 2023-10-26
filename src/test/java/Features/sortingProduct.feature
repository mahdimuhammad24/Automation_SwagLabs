Feature: Sortir Product
  Scenario: Sortir Harga Product Termahal ke Termurah
    Given User sukses login dan berada di halaman Products
    When User klik ikon dropdown sebelah kanan atas halaman
    And User pilih price high to low
    Then List product tersortir dari termahal ke termurah
