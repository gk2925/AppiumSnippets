package appiumscripts.day04;

import org.testng.annotations.Test;

public class Execution {

    @Test
    public void test1(){

        Fruit fruit = new Fruit();
        fruit.citrusFruit();
        fruit.sweetFruit();
    }


    @Test
    public void test2(){
        Mango mango = new Mango();
        mango.sweetFruit();
        mango.citrusFruit();
        mango.mangoFruit();

    }

    @Test
    public void test3(){
        Fruit fruit1 = new Mango();
        fruit1.sweetFruit();
        fruit1.citrusFruit();

    }

    @Test
    public void test4(){

        if(new Fruit()instanceof Mango){

            System.out.println("downcasting is possible and no classcast exception");
            Mango mango1=(Mango)new Fruit();
            mango1.mangoFruit();
            mango1.citrusFruit();
            mango1.sweetFruit();
        }

        else{
            System.out.println("downcasting is not possible. Sorry ");

        }

    }
}
