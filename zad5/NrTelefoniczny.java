
public class NrTelefoniczny implements Comparable<NrTelefoniczny>{
    private String nrKierunkowy;
    private String nrTelefoniczny;
    private String nazwaUlicy;
    
    public NrTelefoniczny(String kier, String tel, String ulica){
        this.nrKierunkowy = kier;
        this.nrTelefoniczny = tel;
        this.nazwaUlicy = ulica;
    }

    public void printAddress(){
        System.out.println("+" + nrKierunkowy + " " + nrTelefoniczny + ", " + nazwaUlicy);
    }
    
    public int compareTo(NrTelefoniczny nr){
        if(nrTelefoniczny == nr.getNumber() && nrKierunkowy == nr.getKier() && nazwaUlicy == nr.getStreet()){
            return 0;
        }
        else if(Long.parseLong(nrTelefoniczny) > Long.parseLong(nr.getNumber())){
            return 1;
        }
        return -1;
    }

    public String getNumber() {return nrTelefoniczny;}
    public String getStreet() {return nazwaUlicy;}
    public String getKier() {return nrKierunkowy;}
}