package com.geekbrains.backend.test.imgur;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ImgurApiFunctionalTest extends ImgurApiAbstractTest {

    private static String CURRENT_IMAGE_ID;

    @Test
    @Order(1)
    void getAccountBase() {
        String userName = "nordy86";
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("data.id", is(158044357))
                .log()
                .all()
                .when()
                .get("account/" + userName);
    }

    @Test
    @Order(2)
    void postImageTest() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("image.jpg"))
                .formParam("name", "Hackerman")
                .formParam("title", "pepe the hacker!")
                .log()
                .all()
                .expect()
                .body("data.size", is(45428))
                .body("data.type", is("image/jpeg"))
                .body("data.name", is("Hackerman"))
                .body("data.title", is("pepe the hacker!"))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");

    }
    @Test
    @Order(3)
    void deleteImage() {
        given()
                .spec(requestSpecification)
                .formParam("id", CURRENT_IMAGE_ID)
                .log()
                .all()
                .expect()
                .body("status", is(200))
                .log()
                .all()
                .when()
                .delete("image/" + CURRENT_IMAGE_ID);
    }

    @Test
    void addImageToAlbumTest() {
        given()
                .spec(requestSpecification)
                .formParam("ids[]", "heo9WsG")
                .log()
                .all()
                .expect()
                .body("status", is(200))
                .log()
                .all()
                .when()
                .post("album/ih0figh/add");
    }

    @Test
    void commentToPost() {
        given()
                .spec(requestSpecification)
                .formParam("image_id", "heo9WsG")
                .formParam("comment", "Java backEnd testing in progress")
                .log()
                .all()
                .expect()
                .body("success", is(true))
                .body("status", is(200))
                .log()
                .all()
                .when()
                .post("comment");

    }

    @Test
    void deleteImageById() {
        given()
                .spec(requestSpecification)
                .formParam("id", "DB85BBH")
                .log()
                .all()
                .expect()
                .body("status", is(200))
                .log()
                .all()
                .when()
                .delete("image/" + "DB85BBH");
    }
    @Test
    void deleteAlbum() {
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("status", is(200))
                .log()
                .all()
                .when()
                .delete("album/" + "S0tzlVy");
    }
    @Test
    void favouriteImage() {
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("status", is(200))
                .body("success", is (true))
                .log()
                .all()
                .when()
                .post("image/heo9WsG/favorite");
    }
}


