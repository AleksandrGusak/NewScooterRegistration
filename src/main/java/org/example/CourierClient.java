package org.example;

import io.restassured.mapper.ObjectMapperType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class CourierClient{

    public boolean create (Courier courier) {
       return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("https://qa-scooter.praktikum-services.ru/api/v1/courier")
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");

    }

    public boolean create2 (Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("https://qa-scooter.praktikum-services.ru/api/v1/courier")
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");

    }

    public String create3 (Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("https://qa-scooter.praktikum-services.ru/api/v1/courier")
                .then()
                .assertThat()
                .statusCode(409)
                .extract()
                .path("false");

    }

    public String create4 (Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("https://qa-scooter.praktikum-services.ru/api/v1/courier")
                .then()
                .assertThat()
                .statusCode(409)
                .extract()
                .path("false");

    }

    public Integer login (CourierIsNotCreate courierIsNotCreate) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierIsNotCreate)
                .when()
                .post("https://qa-scooter.praktikum-services.ru/api/v1/courier/login")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");

    }

    public Integer login2 (CourierIsNotCreate courierIsNotCreate) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierIsNotCreate)
                .when()
                .post("https://qa-scooter.praktikum-services.ru/api/v1/courier/login")
                .then()
                .assertThat()
                .statusCode(404)
                .extract()
                .path("id");

    }

    public Integer login3 (CourierIsNotCreate courierIsNotCreate) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierIsNotCreate)
                .when()
                .post("https://qa-scooter.praktikum-services.ru/api/v1/courier/login")
                .then()
                .assertThat()
                .statusCode(400)
                .extract()
                .path("id");

    }

    public boolean delete (int courierId) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierId)
                .when()
                .delete("https://qa-scooter.praktikum-services.ru/api/v1/courier/" + courierId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("ok");

    }


}
