import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) {
        Osoba o1 = new Osoba("Jan","Kowalski","48","123456789","Kwiatowa");
        Osoba o2 = new Osoba("Jakub","Nowak","48","555666777","Piotrkowska");
        Osoba o3 = new Osoba("Marek","Iksinski","48","666666666","Politechniki");
        Firma f1 = new Firma("Amazon", "50", "111222333", "Sezamkowa");
        Firma f2 = new Firma("Facebook", "52", "442111222", "Politechniki");
        Firma f3 = new Firma("Allegro", "51", "448999110", "Kwiatowa");

        TreeMap<NrTelefoniczny, Wpis> map = new TreeMap<NrTelefoniczny, Wpis>();
        map.put(o1.getAddress(),o1);
        map.put(o2.getAddress(),o2);
        map.put(o3.getAddress(),o3);
        map.put(f1.getAddress(),f1);
        map.put(f2.getAddress(),f2);
        map.put(f3.getAddress(),f3);
        
        //Iterate
        System.out.println("Before:");
        for(Map.Entry<NrTelefoniczny, Wpis> entry : map.entrySet()){
            entry.getValue().opis();
        }
    
        //Delete
        Set<NrTelefoniczny> keys = new HashSet<NrTelefoniczny>();
        for(Map.Entry<NrTelefoniczny, Wpis> entry1 : map.entrySet()){
            for(Map.Entry<NrTelefoniczny, Wpis> entry2 : map.entrySet()){
                if(entry1 == entry2){
                    continue;
                }
                if(entry1.getKey().getStreet().equals(entry2.getKey().getStreet()) && keys.contains(entry1.getKey()) == false){
                    keys.add(entry2.getKey());
                }
            }
        }
        map.keySet().removeAll(keys);

        //Iterate again
        System.out.println("After:");
        for(Map.Entry<NrTelefoniczny, Wpis> entry : map.entrySet()){
            entry.getValue().opis();
        }

    }
}