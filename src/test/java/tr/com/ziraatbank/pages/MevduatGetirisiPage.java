package tr.com.ziraatbank.pages;

import org.openqa.selenium.By;

public class MevduatGetirisiPage extends BasePage{

    public static final String VADE_SURESI="//label[text()='Vade Süresi']";
    public static final String DEPOSIT_CALC_VADE="deposit-calc-vade";
    public static final String TUTAR="tutar";
    public static final String VADE_TUTARI="//label[text()='Vade Sonu Tutarı']";
    public static final String HESAPLA_BUTONU="//a[text()='HESAPLA']";

    public void mevduatGetirisiSayfaKontrol(){
        clickElement(By.xpath(VADE_SURESI));
    }

    public void vadeMiktariniGir(String vade){
        sendKeys(By.id(DEPOSIT_CALC_VADE),vade);
    }

    public void tutarGir(String tutar){
        sendKeys(By.id(TUTAR),tutar);
    }

    public void hesaplaButonunaTikla(){
        clickElement(By.xpath(HESAPLA_BUTONU));
    }

    public void vadeTutariKontrol(){
        isElementExist(By.xpath(VADE_TUTARI));
    }

}
