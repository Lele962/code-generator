package org.yeort.cli.pattern;

import javax.swing.*;
import java.util.SortedMap;

public class Device {

    private String name;
    public Device (String name){
        this.name = name;
    }
    public void turnOn(){
        System.out.println(name+" : turn on the device");
    }
    
    public void turnOff(){
        System.out.println(name+" : turn off the device");
    }
}
