package com.javarush.task.task39.task3906;

public class ElectricPowerSwitch {
  //  private SecuritySystem securitySystem;
  
  private Switchable sw;

    public ElectricPowerSwitch(Switchable sw) {
        this.sw = sw;
    }

    public void press() {
        System.out.println("Power switch flipped.");
        if (sw.isOn()) {
            sw.turnOff();
        } else {
            sw.turnOn();
        }
    }
}
