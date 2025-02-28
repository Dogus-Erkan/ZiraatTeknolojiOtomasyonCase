package tr.com.ziraatbank.pages;

import org.openqa.selenium.By;

public class TuketiciKredisiPage extends BasePage{

    public static final String TUKETICI_KREDISI="//*[text()='Tüketici Kredisi Hesaplama Aracı ']";
    public static final String CALC_TUTAR="calc-tutar";
    public static final String CALC_VADE="calc-vade";
    public static final String FAIZ_ORANI="faiz-orani";
    public static final String HESAPLA_BUTONU="//a[text()='HESAPLA']";
    public static final String TAKSIT_TUTARI="//label[text()='Taksit Tutarı']";
    public static final String ODEME_PLANI="//h2[text()='Ödeme Planı']";
    public static final String ODEME_PLANI_KONTROL="//td[text()='0,00']";

    public void tuketiciKredisiSayfaKontrol(){
        clickElement(By.xpath(TUKETICI_KREDISI));
    }

    public void tutarMiktariniGir(String tutar){
        sendKeys(By.id(CALC_TUTAR),tutar);
    }

    public void vadeMiktariniGir(String vade){
        sendKeys(By.id(CALC_VADE),vade);
    }

    public void faizOraniniGir(String faiz){
        sendKeys(By.id(FAIZ_ORANI),faiz);
    }

    public void hesaplaButonunaTikla(){
        clickElement(By.xpath(HESAPLA_BUTONU));
    }

    public void taksitTutariKontrol(){
        isElementExist(By.xpath(TAKSIT_TUTARI));
    }

    public void odemePlaniKontrol(){
        clickElement(By.xpath(ODEME_PLANI));
        waitInSeconds(3);
        isElementExist(By.xpath(ODEME_PLANI_KONTROL));
    }

}
