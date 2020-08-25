package com.wheather.forcast;

import com.weather.forecast.controller.WeatherController;
import com.weather.forecast.model.FinalEntity;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
public class TestCases extends JerseyTest {

    private static final String URI = "http://localhost:8080";

    @Override
    protected Application configure() {
        return new ResourceConfig(WeatherController.class);
    }

    @Test
    public void testNameAndTimeApi() {
        Client client = ClientBuilder.newClient();

        Response response = client
                .target(URI + "/weather/london/12:00:00/18:00:00")
                .request().header("Content-type", MediaType.APPLICATION_JSON)
                .get();
        assertEquals("Http Response should be 200: ", Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("Http Content-Type should be: ", MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
        FinalEntity finalEntity = response.readEntity(FinalEntity.class);
        Assert.assertTrue("At least one list is present",finalEntity.getData().size() > 0);
    }

    @Test
    public void testForTimeFailure() {
        Client client = ClientBuilder.newClient();

        Response response = client
                .target(URI + "/weather/london/12/18")
                .request().header("Content-type", MediaType.APPLICATION_JSON)
                .get();
        assertEquals("Http Response should be 500: ", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    @Test
    public void testForCityNameFailure() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target(URI + "/weather/l/10:00:00/18:00:00")
                .request().header("Content-type", MediaType.APPLICATION_JSON)
                .get();
        assertEquals("Http Response should be 500: ", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    @Test
    public void testForRemoteAPI() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target(URI + "/weather/london/10:00:00/18:00:00")
                .request().header("Content-type", MediaType.APPLICATION_JSON)
                .get();
        assertEquals("Http Response should be 200: ", Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("Http Content-Type should be: ", MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
    }

    /**
     * when Internet is not up
     */
    @Test
    public void testForInternet() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target(URI + "/weather/london/10:00:00/18:00:00")
                .request().header("Content-type", MediaType.APPLICATION_JSON)
                .get();
        assertEquals("Http Response should be 500: ", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }
}
