package com.assessment.webcalc;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
class WebCalcControllerTest extends JerseyTest {

    @Override
    protected Application configure() {
        forceSet(TestProperties.CONTAINER_PORT, "0");
        return new ResourceConfig(WebCalcController.class);
    }

    @Test
    @Order(0)
    public void firstRequestTest() {
        Entity<String> requestEntity = Entity.entity("1 round", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("5 round", content);
    }


    @Test
    @Order(1)
    public void secondRequestTest() throws InterruptedException {
        Thread.sleep(2000);
        Entity<String> requestEntity = Entity.entity("2 round", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("5 round", content);
    }

    @Test
    @Order(2)
    public void thirdRequestTest() throws InterruptedException {
        Thread.sleep(2500);
        Entity<String> requestEntity = Entity.entity("2 round", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("5 round", content);
    }

    @Test
    @Order(30)
    public void finalRequestTest() throws InterruptedException {
        Thread.sleep(4000);
        Entity<String> andRequestEntity = Entity.entity("end round", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/").request()
                .post(andRequestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("5 round", content);
    }

}