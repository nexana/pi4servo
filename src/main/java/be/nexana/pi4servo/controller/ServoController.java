package be.nexana.pi4servo.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServoController {

    private static GpioPinDigitalOutput pin = null;

    @RequestMapping("/")
    public String greeting() {
        return "hi";
    }

    @RequestMapping("/open")
    public String open() throws InterruptedException {
        if (pin == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "ServoPulse", PinState.LOW);
        }
//long netraulPulse = TimeUnit.MICROSECONDS.

        pin.pulse(1,true);

        Thread.sleep(2500);

        pin.pulse(2, true);
        return "ok done";
    }

}
