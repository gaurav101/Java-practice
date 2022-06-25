package Products;

import java.util.Objects;

public class SmartPhone extends SmartDevice implements IDeviceDetail,Comparable<SmartPhone> {
    public SmartPhone(String name, String model, int price) {
        super(name, model, price);
    }

    @Override
    public void PlayGame() {
        System.out.println("Yes Smart Phone can play game");
    }
    @Override
    public String toString(){
        return  "Name: "+super.Name+" Model: "+super.Model+" Price : Rs "+super.Price;
    }
    @Override
    public  int hashCode(){
        return Objects.hash(super.Model,super.Name);
    }
    @Override
    public  boolean equals(Object o){
        if(this==o) {return true;}
        if(o==null) {return  false;}
        if(getClass()!=o.getClass()){ return false;}
        SmartPhone o1= (SmartPhone)o;
        return  Objects.equals(super.Model,o1.Model) && super.Name==o1.Name;

    }

    @Override
    public int compareTo(SmartPhone o) {
        if(super.Price>o.Price) {return  1;} else if (super.Price<o.Price) {
            return -1;
        }else { return 0;}
    }
}
