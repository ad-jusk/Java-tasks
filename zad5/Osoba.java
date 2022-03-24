
public class Osoba extends Wpis{
    String imie;
    String nazwisko;
    NrTelefoniczny adres;
    Osoba(String im, String nazw, String kier, String tel, String ulica){
        this.imie = im;
        this.nazwisko = nazw;
        this.adres = new NrTelefoniczny(kier,tel,ulica);
    }
    @Override
    void opis(){
        System.out.print(this.imie + " " + this.nazwisko + ", ");
        this.adres.printAddress();
    }
}