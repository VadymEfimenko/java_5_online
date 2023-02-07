package ua.com.alevel.test;

import org.apache.commons.lang3.math.NumberUtils;

public class Text {
    public void textMessage(){
        System.out.println("Text.textMessage");
    }

    public void compareIntegers(int x, int y){
        int response = NumberUtils.compare(x, y);
        if(response == -1){
            System.out.println(x + " is less than -> " + y);
        } else if (response == 1) {
            System.out.println(x + " is greater than -> " + y);
        }
    }
}