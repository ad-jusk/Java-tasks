import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) {
        Osoba o1 = new Osoba("Jan","Kowalski","48","123456789","Sezamkowa");
        Osoba o2 = new Osoba("Jakub","Nowak","48","555666777","Piotrkowska");
        Firma f1 = new Firma("Amazon", "50", "111222333", "Kwiatowa");
        Firma f2 = new Firma("Facebook", "52", "442111222", "Kwiatowa");

        TreeMap<String, Wpis> map = new TreeMap<String, Wpis>();
        map.put(o1.getNumber(),o1);
        map.put(o2.getNumber(),o2);
        map.put(f1.getNumber(),f1);
        map.put(f2.getNumber(),f2);
        
        //Iterate
        System.out.println("Before:");
        for(Map.Entry<String, Wpis> entry : map.entrySet()){
            entry.getValue().opis();
        }

        //Delete
        Set<String> keys = new HashSet<String>();
        for(Map.Entry<String, Wpis> entry1 : map.entrySet()){
            for(Map.Entry<String, Wpis> entry2 : map.entrySet()){
                if(entry1.getKey().equals(entry2.getKey())){
                    continue;
                }
                if(entry1.getValue().getStreet().equals(entry2.getValue().getStreet())){
                    keys.add(entry1.getKey());
                    keys.add(entry2.getKey());
                }
            }
        }
        map.keySet().removeAll(keys);

        //Iterate again
        System.out.println("After:");
        for(Map.Entry<String, Wpis> entry : map.entrySet()){
            entry.getValue().opis();
        }

    }
}