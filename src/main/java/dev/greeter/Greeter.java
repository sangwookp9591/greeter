package dev.greeter;


import static dev.greeter.GreeterConfigParams.*;

import java.time.LocalDateTime;

public class Greeter {

    private GreetingConfig greetingConfig;

    public Greeter(GreetingConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }

    public String greet(LocalDateTime localDateTime) {

        String name = greetingConfig.getProperty(USER_NAME);
        int hourOfDay = localDateTime.getHour();

        if (hourOfDay >= 5 && hourOfDay < 12) {
            return String.format("Hello %s, %s", name, greetingConfig.getProperty(MORNING_MESSAGE));
        } else if (hourOfDay >= 12 && hourOfDay < 17) {
            return String.format("Hello %s, %s", name, greetingConfig.getProperty(AFTERNOON_MESSAGE));
        } else if (hourOfDay >= 17 && hourOfDay < 20) {
            return String.format("Hello %s, %s", name, greetingConfig.getProperty(EVENING_MESSAGE));
        } else {
            return String.format("Hello %s, %s", name, greetingConfig.getProperty(NIGHT_MESSAGE));
        }
    }

    public String greet() {
        return greet(LocalDateTime.now());
    }
}
