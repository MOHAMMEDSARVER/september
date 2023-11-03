package org.example.jdbc.basics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

record User(String name, String email) {
}

public class PropertiesManager {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try {
            properties.load(PropertiesManager.class.getResourceAsStream("/message.properties"));
            String appName = properties.getProperty("app.name");
            System.out.println(appName + " is started...");
            List<User> list = getUser(properties);
            System.out.println(list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<User> getUser(Properties properties) {

        List<User> list = new ArrayList<>();
        String value;
        for (int i = 0; (value = properties.getProperty("user." + i + ".name")) != null; i++) {
            String name = value;
            String email = properties.getProperty("user." + i + ".email");
            list.add(new User(name, email));
        }
        return list;
    }
}
