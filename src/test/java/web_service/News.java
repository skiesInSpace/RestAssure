package web_service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import web_service.model.post.Post;

/**
 * Created by Artur_Barkou on 9/1/2017.
 */
public class News {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }

    @Test
    public void checkStatusCode() {
        Response rp = RestAssured.given().get("/posts").andReturn();
        int actualStatusCode = rp.getStatusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);

    }
    @Test
    public void checkResponseBody() {
        Response rp = RestAssured.given().get("/posts").andReturn();
        Post[] posts = rp.as(Post[].class);
        Assert.assertEquals(posts.length, 100);
    }

}
