package com.assessment.webcalc;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.experimental.theories.Theories;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.manipulation.Orderer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebCalcControllerTest extends JerseyTest {

    @Override
    protected Application configure() {
        forceSet(TestProperties.CONTAINER_PORT, "0");
        return new ResourceConfig(WebCalcController.class);
    }

    @Test
    @Order(1)
    public void firstRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(2)
    public void secondRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(3)
    public void thirdRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(4)
    public void forthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(5)
    public void fifthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }


    @Test
    @Order(6)
    public void sixthRequest_Test() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(7)
    public void seventhRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(8)
    public void eighthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(9)
    public void ninthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(10)
    public void tenthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(11)
    public void eleventhRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(12)
    public void twelfthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(13)
    public void thirteenthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(14)
    public void fourteenthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(15)
    public void fifteenthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(16)
    public void sixteenthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(17)
    public void seventeenthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(18)
    public void eighteenthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(19)
    public void nineteenthRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(20)
    public void twentiethRequestTest() {
        Entity<String> requestEntity = Entity.entity("1", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }

    @Test
    @Order(21)
    public void lastRequestTest() throws InterruptedException {
        Thread.sleep(7000);
        Entity<String> requestEntity = Entity.entity("end round", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("20 round", content);
    }
}