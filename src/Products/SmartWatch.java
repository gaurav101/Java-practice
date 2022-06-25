package Products;

public class SmartWatch extends SmartDevice  {
    public SmartWatch(String name, String model, int price) {
        super(name, model, price);
    }

    @Override
    public void PlayGame() {
        System.out.println("Smart Watch can not play Game");
    }
}
