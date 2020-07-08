package be.nexana.pi4servo.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServoController {

    private static GpioPinPwmOutput pin = null;
    private static GpioController gpio = null;

    @RequestMapping("/")
    public String greeting() {
        return "hi";
    }

    @RequestMapping("/open/{pwmValue}")
    public String open(@PathVariable String pwmValue) throws InterruptedException {
        if (pin == null) {
            gpio = GpioFactory.getInstance();
            pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_24, "pulsePin");

        }
        pin.setMode(PinMode.PWM_OUTPUT);
        pin.setPwmRange(1000);
        pin.setPwm(Integer.parseInt(pwmValue));

        gpio.shutdown();

        return "ok done";
    }

}
