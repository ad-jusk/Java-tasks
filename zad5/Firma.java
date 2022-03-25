
public class Firma extends Wpis{
    String nazwaFirmy;
    NrTelefoniczny adres;
    Firma(String nazwa, String kier, String tel, String ulica){
        this.nazwaFirmy = nazwa;
        this.adres = new NrTelefoniczny(kier, tel, ulica);
    }
    @Override
    void opis(){
        System.out.print(this.nazwaFirmy + ", ");
        adres.printAddress();
    }
    @Override
    String getNumber() {return this.adres.getNumber();}
    @Override
    String getStreet() {return this.adres.getStreet();}
}