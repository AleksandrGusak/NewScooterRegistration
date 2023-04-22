package org.example;

import org.apache.commons.lang3.RandomStringUtils;

public class Courier {

    public String login;
    public String password;
    public String name;

    public Courier(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public Courier(String login, String name) {
    }

    public static Courier getRandom() {
        String login = RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, password, name);
    }
    public static Courier getRandom2() {
        String login = "aa123334224443ew344a";
        String password = "bbb";
        String name = "ccc";
        return new Courier(login, password, name);
    }

    public static Courier getRandom3() {
        String login = "aa123332244a";
        String password = "xxxxxx";
        String name = "";
        return new Courier(login, password, name);
    }

    public static Courier getRandom4() {
        String login = "aa123334224443ew344a";
        String password = "bbb";
        String name = "ccc";
        return new Courier(login, password, name);
    }

}
