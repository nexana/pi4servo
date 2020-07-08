package be.nexana.pi4servo.controller;

import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;
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
            pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01, "pulsePin");
            Gpio.pwmSetRange(2000);
            Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
            Gpio.pwmSetClock(192);
        }
        pin.setPwm(Integer.parseInt(pwmValue));

        gpio.shutdown();

        return "value :" + pwmValue + "<br>";
    }

}
