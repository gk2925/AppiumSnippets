package appiumscripts.day02;

import org.testng.annotations.Test;

public class Implementation {

    @Test
    public void test1(){

        Fruit fruit1= new Apple();
        Fruit fruits2 = new Orange();


      if (fruit1 instanceof Apple){

          System.out.println("downcasting is quite possible");
          Apple apple1= (Apple) fruit1;
          apple1.appleTaste();
          apple1.getOrigin();
        }




      if(fruits2 instanceof Orange){

          System.out.println("downcasting is possible");
          Orange orange = (Orange) fruits2;
          orange.getOrigin();
          orange.ornageTaste();
      }

      else
      {
          System.out.println("Downcasting is not possible and classcastexception " +
                  "will be thrown");
      }



    }
}
