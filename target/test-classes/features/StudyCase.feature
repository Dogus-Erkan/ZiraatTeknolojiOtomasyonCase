Feature: StudyCase

  Scenario: Tüketici Kredisi Akışı
  Given "https://www.ziraatbank.com.tr/tr/hesaplama-araclari" sitesi ziyaret edilir.
  And Tüketici Kredisi sayfasına giriş yapılır ve kontrol edilir.
  And Tüketici Kredisi için tutar "100000", vade "24" ve faiz "3,33" oranları girilir.
  Then Taksit tutarı ve ödeme planı kontrol edilir.

  Scenario: Mevduat Getirisi Hesaplama Akışı
    Given "https://www.ziraatbank.com.tr/tr/hesaplama-araclari" sitesi ziyaret edilir.
    And Mevduat Getirisi sayfasına giriş yapılır ve kontrol edilir.
    And Mevduat Getirisi için vade "62" ve tutar "20000" bilgileri girilir.
    Then Vade Sonu Tutarı kontrol edilir.

  Scenario: IBAN Hesaplama Akışı
    Given "https://www.ziraatbank.com.tr/tr/hesaplama-araclari" sitesi ziyaret edilir.
    And IBAN Hesaplama sayfasına giriş yapılır ve kontrol edilir.
    And IBAN Hesaplama için şube kodlarına göre sıralanır, müşteri no "111111111" ve ek no "1111" bilgileri girilir.
    Then IBAN kontrol edilir.
