
public class NrTelefoniczny{
    String nrKierunkowy;
    String nrTelefoniczny;
    String nazwaUlicy;
    NrTelefoniczny(String kier, String tel, String ulica){
        this.nrKierunkowy = kier;
        this.nrTelefoniczny = tel;
        this.nazwaUlicy = ulica;
    }
    void printAddress(){
        System.out.println("+" + this.nrKierunkowy + " " + this.nrTelefoniczny + ", " + this.nazwaUlicy);
    }
}