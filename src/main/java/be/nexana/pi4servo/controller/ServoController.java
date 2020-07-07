package be.nexana.pi4servo.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;

public class ServoController {

    private static GpioPinDigitalOutput pin = null;

    @RequestMapping("/")
    public String greeting() {
        return "hi";
    }

    @RequestMapping("/open")
    public String open() {
        if (pin == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "ServoPulse", PinState.LOW);
        }

        return "ok";
    }

}
