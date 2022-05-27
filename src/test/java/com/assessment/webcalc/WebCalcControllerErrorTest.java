package com.assessment.webcalc;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebCalcControllerErrorTest extends JerseyTest {

    @Override
    protected Application configure() {
        forceSet(TestProperties.CONTAINER_PORT, "0");
        return new ResourceConfig(WebCalcController.class);
    }

    @Test
    public void shouldReturnErrorResponseWhenEndCommandNoSpace() {
        Entity<String> requestEntity = Entity.entity("endround", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/")
                .request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("Wrong command", content);
    }

    @Test
    public void shouldReturnErrorResponseWhenEndCommandIsWrong() {
        Entity<String> requestEntity = Entity.entity("stop round", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/")
                .request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("Wrong command", content);
    }

    @Test
    public void shouldReturnErrorResponseWhenEndCommandWithoutRoundName() {
        Entity<String> requestEntity = Entity.entity("end", MediaType.TEXT_PLAIN_TYPE);
        Response response = target("/")
                .request()
                .post(requestEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String content = response.readEntity(String.class);
        assertEquals("Wrong command", content);
    }
}
