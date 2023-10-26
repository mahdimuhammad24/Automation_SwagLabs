Feature: Tambah Produk Kedalam Keranjang

  Scenario: Menambahankan Produk Kedalam Keranjang
    Given User Berada Dalam Halaman Products
    When User klik Tombol Add to Cart Dalam Produk Yang Dipilih
    And User Klik Ikon Cart
    Then Dalah Halaman Cart, Menampilkan Produk Yang Dipilih