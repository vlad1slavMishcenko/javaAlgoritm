import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Drink a = new Drink("water", 12);
        Drink c = new Drink("coca-cola", 122);
        HotDrink b = new HotDrink("coffee", 200, 88);
        Vanding.setProduct(a);
        Vanding.setProduct(b);
        Vanding.setProduct(c);
        System.out.println(Vanding.getDrink(2));
        System.out.println(Vanding.getDrink(1));
    }
}
class Drink{
    private String Name;
    private int Volume;
    Drink(String name, int volume){
        this.Name = name;
        this.Volume = volume;
    }

    public String getName() {
        return Name;
    }

    public int getVolume() {
        return Volume;
    }
}

class HotDrink extends Drink{
    private int Temperature;
    HotDrink(String name, int volume, int temperature){
        super(name,volume);
        this.Temperature = temperature;

    }
    public int getTemperature() {
        return Temperature;
    }

}

class Vanding{
    static List<Drink> list = new ArrayList<>();
    public static void setProduct(Drink name){
        list.add(name);
    }
    public static String getDrink(int index){
        if(index < list.size()) {
            String res = list.get(index).getName();
            return res + " " + list.get(index).getVolume();
        }
        return null;
    }
}