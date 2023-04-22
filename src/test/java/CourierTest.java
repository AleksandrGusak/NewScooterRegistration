import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.Courier;
import org.example.CourierClient;
import org.example.CourierIsNotCreate;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Predicate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CourierTest {

    private CourierClient courierClient;
    private boolean courierId;


    @Before

    public void setUp() {
        courierClient = new CourierClient();
    }



    public ArrayList<String> registerNewCourierAndReturnLoginPassword() {

        String courierLogin = RandomStringUtils.randomAlphabetic(10);
        String courierPassword = RandomStringUtils.randomAlphabetic(10);
        String courierFirstName = RandomStringUtils.randomAlphabetic(10);

        ArrayList<String> loginPass = new ArrayList<>();

        String registerRequestBody = "{\"login\":\"" + courierLogin + "\","
                + "\"password\":\"" + courierPassword + "\","
                + "\"firstName\":\"" + courierFirstName + "\"}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(registerRequestBody)
                .when()
                .post("https://qa-scooter.praktikum-services.ru/api/v1/courier")
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");

        if (response.statusCode() == 201) {
            loginPass.add(courierLogin);
            loginPass.add(courierPassword);
        }
        return loginPass;

    }

    @Test
    public void registrationUserWithAllCredentionals() {
        Courier courier = Courier.getRandom();

        boolean isCourierCreated = courierClient.create(courier);

        assertTrue("Courier is created", isCourierCreated);

    }
    @Test
    public void registrationUserWithAllCredentionals2() {
        Courier courier = Courier.getRandom2();

        boolean isCourierCreated = courierClient.create2(courier);

        assertTrue("Courier is created", isCourierCreated);

    }

    @Test
    public void registrationUserWithAllCredentionals3DontPassword() {
        Courier courier = Courier.getRandom3();

        String isCourierCreated = courierClient.create3(courier);

        assertFalse("Courier is dont created", Boolean.parseBoolean(isCourierCreated));

    }

    @Test
    public void registrationUserWithAllCredentionals4() {
        Courier courier = Courier.getRandom4();

        String isCourierCreated = courierClient.create4(courier);

        assertFalse("Courier is dont created", Boolean.parseBoolean(isCourierCreated));

    }


    @Test
    public void loginUser() {

        Integer isCourierLogin = courierClient.login(new CourierIsNotCreate("aa12333444433a", "bbb"));
        assertEquals("Courier is not created", "185541", "185541");


    }
    @Test
    public void userINcorrectPassword() {

        Integer isCourierLogin = courierClient.login2(new CourierIsNotCreate("aa12333444433a", "ccc"));
        assertEquals("Courier is dont have in DB", "185541", "185541");


    }

    @Test
    public void userIsDontLogin() {

        Integer isCourierLogin = courierClient.login3(new CourierIsNotCreate("","ccc"));
        assertEquals("Courier have in DB", "185541", "185541");


    }
    @Test
    public void userIsDontLogin2() {

        Integer isCourierLogin = courierClient.login3(new CourierIsNotCreate("","ccc"));
        assertEquals("Courier have in DB", "185541", "185541");


    }
}
