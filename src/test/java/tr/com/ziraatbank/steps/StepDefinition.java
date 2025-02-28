package tr.com.ziraatbank.steps;
import tr.com.ziraatbank.pages.*;
import tr.com.ziraatbank.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class StepDefinition {
    private final BasePage basePage;
    private final HesaplamaAraclariPage hesaplamaAraclariPage;
    private final IbanHesaplamaPage ibanHesaplamaPage;
    private final MevduatGetirisiPage mevduatGetirisiPage;
    private final TuketiciKredisiPage tuketiciKredisiPage;

    public StepDefinition() {
        basePage = new BasePage();
        hesaplamaAraclariPage = new HesaplamaAraclariPage();
        ibanHesaplamaPage = new IbanHesaplamaPage();
        mevduatGetirisiPage = new MevduatGetirisiPage();
        tuketiciKredisiPage = new TuketiciKredisiPage();
    }


    @Before
    public static void setUp() {
        DriverManager.setup();
    }


    @Given("{string} sitesi ziyaret edilir.")
    public void visitWebsiteSt(String website){
        basePage.visitWebsite(website);
    }

    @And("Tüketici Kredisi sayfasına giriş yapılır ve kontrol edilir.")
    public void tuketiciKredisiSt(){
        hesaplamaAraclariPage.tuketiciKredisiniAc();
        tuketiciKredisiPage.tuketiciKredisiSayfaKontrol();
    }

    @And("Tüketici Kredisi için tutar {string}, vade {string} ve faiz {string} oranları girilir.")
    public void tuketiciKredisiBilgileriSt(String tutar,String vade,String faiz){
        tuketiciKredisiPage.tutarMiktariniGir(tutar);
        tuketiciKredisiPage.faizOraniniGir(faiz);
        tuketiciKredisiPage.vadeMiktariniGir(vade);
        tuketiciKredisiPage.hesaplaButonunaTikla();
    }
    @Then("Taksit tutarı ve ödeme planı kontrol edilir.")
    public void taksitTutariveOdemeBilgisiKontrol(){
        tuketiciKredisiPage.taksitTutariKontrol();
        tuketiciKredisiPage.odemePlaniKontrol();
    }

    @And("Mevduat Getirisi sayfasına giriş yapılır ve kontrol edilir.")
    public void mevduatGetirisiSt(){
        hesaplamaAraclariPage.mevduatGetirisiniAc();
        mevduatGetirisiPage.mevduatGetirisiSayfaKontrol();
    }

    @And("Mevduat Getirisi için vade {string} ve tutar {string} bilgileri girilir.")
    public void mevduatGetirisiBilgileriSt(String vade,String tutar){
        mevduatGetirisiPage.vadeMiktariniGir(vade);
        mevduatGetirisiPage.tutarGir(tutar);
        mevduatGetirisiPage.hesaplaButonunaTikla();
    }

    @Then("Vade Sonu Tutarı kontrol edilir.")
    public void vadeSonuKontrol(){
        mevduatGetirisiPage.vadeTutariKontrol();
    }

    @And("IBAN Hesaplama sayfasına giriş yapılır ve kontrol edilir.")
    public void ibanHesaplamaSt(){
       hesaplamaAraclariPage.ibanHesaplamaAc();
       ibanHesaplamaPage.ibanHesaplamaSayfaKontrol();
    }

    @And("IBAN Hesaplama için şube kodlarına göre sıralanır, müşteri no {string} ve ek no {string} bilgileri girilir.")
    public void ibanHesaplamaBilgileriSt(String musteriNo,String ekNo){
        ibanHesaplamaPage.subeKodlaraGoreSirala();
        ibanHesaplamaPage.musteriNoGir(musteriNo);
        ibanHesaplamaPage.ekNoGir(ekNo);
        ibanHesaplamaPage.hesaplaButonunaTikla();
    }

    @Then("IBAN kontrol edilir.")
    public void ibanKontrol(){
        ibanHesaplamaPage.ibanKontrol();
    }

    @After
    public static void tearDown() {
        DriverManager.teardown();
    }
}
