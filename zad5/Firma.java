
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
        this.adres.printAddress();
    }
    @Override
    NrTelefoniczny getAddress() {return this.adres;}
}