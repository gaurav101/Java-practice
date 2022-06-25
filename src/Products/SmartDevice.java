package Products;

public abstract class SmartDevice implements IDeviceDetail {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    String Name;
    String Model;

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    int Price;

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    SmartDevice(String name, String model, int price){
        Name=name;
        Model=model;
        Price=price;

    }
    public void TurnOn(){
        System.out.println("Turning On");
    }
    public  void  TurnOff(){
        System.out.println("Turning Off");
    }
    public void getDetails(){
        System.out.println("Name : "+Name);
        System.out.println("Model : "+Model);
        System.out.println("Price : "+Price);

    }
    public  abstract void PlayGame();

}
