import java.util.ArrayList;
import java.util.List;

public class HomeWorkOOP2 {
    public static void main(String[] args) {
        Human a = new Human("vladislav");
        System.out.println(a.getName());
        Market.takeOrder(a);
    }
}
class Market implements QueueBehaviour {
 private List<Actor> aktors = new ArrayList<>();

    public static void takeOrder(Human a) {
    }


    @Override
    public void takeInQueue(Actor act) {
        aktors.add(act);

    }

    @Override
    public void takeOrders() {

    }

    @Override
    public void giveOrders() {
        System.out.println("возьмите ваш заказ");


    }

    @Override
    public void releaseFromQueue() {

    }
}

interface QueueBehaviour{
    public void takeInQueue(Actor actor);

    void takeOrders();
    void giveOrders();
    void releaseFromQueue();
}

abstract class Actor implements ActorBehaviour{
    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;
    abstract String getName();


}
interface ActorBehaviour{
    void setMakeOrder();

    void setTakeOrder();

    boolean isMakeOrder();
    boolean isTakeOrder();
}

class Human extends Actor{
    Human(String name){
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }


    @Override
    public void setMakeOrder() {

    }

    @Override
    public void setTakeOrder() {

    }

    @Override
    public boolean isMakeOrder() {
        return false;
    }

    @Override
    public boolean isTakeOrder() {
        return false;
    }
}