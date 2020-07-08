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

    private static Integer STATE_LOCK = 55;
    private static Integer STATE_UNLOCK = 210;


    @RequestMapping("/")
    public String greeting() {
        return "hi";
    }

    @RequestMapping("/test/{pwmValue}")
    public String test(@PathVariable String pwmValue) throws InterruptedException {
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

    @RequestMapping("/open")
    public String open() throws InterruptedException {
        if (pin == null) {
            gpio = GpioFactory.getInstance();
            pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01, "pulsePin");
            Gpio.pwmSetRange(2000);
            Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
            Gpio.pwmSetClock(192);
        }
        pin.setPwm(STATE_UNLOCK);

        gpio.shutdown();

        return "value :" + STATE_UNLOCK + "(unlocked)";
    }

    @RequestMapping("/close")
    public String close() throws InterruptedException {
        if (pin == null) {
            gpio = GpioFactory.getInstance();
            pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01, "pulsePin");
            Gpio.pwmSetRange(2000);
            Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
            Gpio.pwmSetClock(192);
        }
        pin.setPwm(STATE_LOCK);

        gpio.shutdown();

        return "value :" + STATE_LOCK + "(locked)";
    }
}
