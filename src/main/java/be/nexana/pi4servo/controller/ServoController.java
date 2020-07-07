package be.nexana.pi4servo.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServoController {

    private static GpioPinPwmOutput pin = null;

    @RequestMapping("/")
    public String greeting() {
        return "hi";
    }

    @RequestMapping("/open")
    public String open() throws InterruptedException {
        if (pin == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_24, "pulsePin");

        }
//long netraulPulse = TimeUnit.MICROSECONDS.
        pin.setPwm(5);

        Thread.sleep(2500);
        pin.setPwm(500);
        Thread.sleep(2500);
        pin.setPwm(50);

        return "ok done";
    }

}
