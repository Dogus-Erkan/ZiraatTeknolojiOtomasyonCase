package tr.com.ziraatbank.pages;

import org.openqa.selenium.By;

public class IbanHesaplamaPage extends BasePage{

    public static final String RADIO1="radio-1";
    public static final String MUSTERI_NO="musteriNo";
    public static final String EK_NO="ekNo";
    public static final String HESAPLA_BUTONU="//a[text()='HESAPLA']";
    public static final String IBAN_KONTROL="//a[text()='IBAN']";

    public void ibanHesaplamaSayfaKontrol(){
        isElementExist(By.id(EK_NO));
    }

    public void subeKodlaraGoreSirala(){
        clickElement(By.id(RADIO1));
    }

    public void musteriNoGir(String musteriNo){
        sendKeys(By.id(MUSTERI_NO),musteriNo);
    }
    public void ekNoGir(String ekNo){
        sendKeys(By.id(EK_NO),ekNo);
    }

    public void hesaplaButonunaTikla(){
        clickElement(By.xpath(HESAPLA_BUTONU));
    }

    public void ibanKontrol(){
        isElementExist(By.xpath(IBAN_KONTROL));
    }

}
