
public class Osoba extends Wpis{
    private String imie;
    private String nazwisko;
    private NrTelefoniczny adres;
    
    public Osoba(String im, String nazw, String kier, String tel, String ulica){
        this.imie = im;
        this.nazwisko = nazw;
        this.adres = new NrTelefoniczny(kier,tel,ulica);
    }

    @Override
    public void opis(){
        System.out.print(imie + " " + nazwisko + ", ");
        adres.printAddress();
    }

    @Override
    public NrTelefoniczny getAddress() {return adres;}
}