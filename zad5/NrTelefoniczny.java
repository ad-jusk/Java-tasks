
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
        if(this.nrTelefoniczny == nr.getNumber() && this.nrKierunkowy == nr.getKier() && this.nazwaUlicy == nr.getStreet()){
            return 0;
        }
        else if(Long.parseLong(this.nrTelefoniczny) > Long.parseLong(nr.getNumber())){
            return 1;
        }
        return -1;
    }
    String getNumber() {return this.nrTelefoniczny;}
    String getStreet() {return this.nazwaUlicy;}
    String getKier() {return this.nrKierunkowy;}
}