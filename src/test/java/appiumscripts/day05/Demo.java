package appiumscripts.day05;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class Demo {

    @Test
    public void listDemo(){

        ArrayList list1 = new ArrayList<String>();
        list1.add("day1");
        list1.add("day2");
        list1.add("Day03");


        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));








    }
}
