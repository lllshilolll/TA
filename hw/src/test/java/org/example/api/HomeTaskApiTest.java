package org.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.example.model.Order;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class HomeTaskApiTest {
    @BeforeClass
    public void prepare() throws IOException {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .addHeader("api_key", "api.key")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.filters(new ResponseLoggingFilter());
    }
    
    @Test
    public void checkObjectSave() {
        Order order = new Order(); // создаём экземпляр POJO объекта Pet
        int id = new Random().nextInt(500000); // просто нужно создать произвольный айди
        order.setId(id);
        order.setStatus("placed");
        order.setComplete(true);
        given()
                .body(order)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200);

        Order actual =
                given()
                        .pathParam("orderId", id)
                        .when()
                        .get("/store/order/{orderId}")
                        .then()
                        .statusCode(200)
                        .extract().body()
                        .as(Order.class);
        // TODO можно переопределить методы equals у объектов Pet и других, чтобы происходило корректное сравнение
        Assert.assertEquals(actual.getShipDate(), order.getShipDate());

    }

    @Test
    public void tetDelete() throws IOException {
        Order order = new Order();
        int id = new Random().nextInt(500000);
        order.setId(id);

        given()
                .body(order)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200);

        given()
                .pathParam("orderId", id)
                .when()
                .delete("/store/order/{orderId}")
                .then()
                .statusCode(200);
        given()
                .pathParam("orderId", id)
                .when()
                .get("/store/order/{orderId}")
                .then()
                .statusCode(404);
    }

    //Возвращает карту кодов состояния для количества
    @Test
    public void checkInventory() {
        HashMap<String, Integer> integerHashMap = new HashMap<>(given()
                .when()
                .get("/store/inventory")
                .then()
                .statusCode(200)
                .extract().body()
                .as(HashMap.class));
        Assert.assertTrue(integerHashMap.containsKey("sold"));
        Assert.assertFalse(integerHashMap.containsKey("id"));

    }

}
