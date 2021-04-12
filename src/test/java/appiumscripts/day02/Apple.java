package appiumscripts.day02;

public class Apple extends Fruit {
    @Override
    public void getOrigin() {
       System.out.println("Apple origin is Kashmir");
    }

    public void appleTaste(){
        System.out.println("Its super sweet!");
    }
}
