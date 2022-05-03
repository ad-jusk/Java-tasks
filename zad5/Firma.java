
public class Firma extends Wpis{
    private String nazwaFirmy;
    private NrTelefoniczny adres;

    public Firma(String nazwa, String kier, String tel, String ulica){
        nazwaFirmy = nazwa;
        adres = new NrTelefoniczny(kier, tel, ulica);
    }
    @Override
    public void opis(){
        System.out.print(nazwaFirmy + ", ");
        adres.printAddress();
    }
    @Override
    public NrTelefoniczny getAddress() {return adres;}
}