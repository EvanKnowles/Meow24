package za.co.knonchalant.meows24;

import java.util.LinkedHashMap;
import java.util.Map;

public class Meow {
    private static final Map<String, String> PAWTERNS = new LinkedHashMap<String, String>() {{
        put("[A-Z][a-z]+", "Meow");
        put("[a-z]+", "meow");
        put("[A-Z]+", "MEOW");
    }};

    public static String meow(String boringHumanDroolSpeak) {
        for (Map.Entry<String, String> paw : PAWTERNS.entrySet()) {
            String meow = boringHumanDroolSpeak.replaceAll(paw.getKey(), paw.getValue());
            if (!meow.equals(boringHumanDroolSpeak)) {
                return meow;
            }
        }

        return boringHumanDroolSpeak;
    }
}
