package tr.com.ziraatbank.pages;

import org.openqa.selenium.By;

public class HesaplamaAraclariPage extends BasePage{

   public static final String TUKETICI_KREDISI="(//a[text()='Tüketici Kredisi'])[1]";
   public static final String MEVDUAT_GETIRISI="(//a[text()='Mevduat Getirisi Hesaplama'])[1]";
   public static final String IBAN_HESAPLAMA="(//a[text()='IBAN Hesaplama'])[1]";

   public void tuketiciKredisiniAc(){
       clickElement(By.xpath(TUKETICI_KREDISI));
   }
    public void mevduatGetirisiniAc(){
        clickElement(By.xpath(MEVDUAT_GETIRISI));
    }
    public void ibanHesaplamaAc(){
        clickElement(By.xpath(IBAN_HESAPLAMA));
    }



}
