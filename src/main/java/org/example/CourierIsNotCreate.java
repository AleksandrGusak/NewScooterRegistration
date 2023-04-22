package org.example;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierIsNotCreate {

    public String login;

    public String password;

    public CourierIsNotCreate(String login, String password) {

        this.login = login;
        this.password = password;
    }
    public static Courier loginCourier() {
        String login = "aa12333444433a";
        String password = "bbb";
        return new Courier(login, password);
    }

    public static CourierIsNotCreate from(Courier courier) {
        return new CourierIsNotCreate(courier.login, courier.password);
    }


}

