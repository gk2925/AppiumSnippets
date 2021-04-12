package appiumscripts.day02;

public abstract class Fruit implements Food {
    public void getTotalCalorie(){
        System.out.println("Total calories are 20");
    }

    public abstract void getOrigin();
}
