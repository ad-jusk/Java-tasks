
public class NrTelefoniczny implements Comparable<NrTelefoniczny>{
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
    public int compareTo(NrTelefoniczny nr){
        if(this.nazwaUlicy.equals(nr.nazwaUlicy)){
            return 0;
        }
        return 1;
    }
    String getNumber() {return this.nrTelefoniczny;}
    String getStreet() {return this.nazwaUlicy;}
}