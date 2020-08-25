package com.weather.forecast.controller;

import com.weather.forecast.exception.APINotValidException;
import com.weather.forecast.model.FinalEntity;
import com.weather.forecast.model.JsonRequest;
import com.weather.forecast.model.WeatherEntity;
import com.wheather.forcast.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalTime;
import java.util.List;

@RestController
//@RequestMapping("/weather")
public class WeatherController {

	

    private final WeatherService weatherService;

    @Value("${default.startTime}")
    private String DEFAULT_START;
    @Value("${default.endTime}")
    private String DEFAULT_END;
    @Value("${api-key}")
    private  String API_KEY;
    @Value("${url}")
    private String URL;
    @Value("${description}")
    private String DESCRIPTION;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * returns weather forecast for three days given city name and
     * start and end time for working hours
     * @param name
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping( "/weather/{name}/{startTime}/{endTime}")
    public FinalEntity get(@PathVariable("name") String name, @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime) {
        long start =  System.currentTimeMillis();
        try {
            LocalTime lt = LocalTime.parse(startTime);
            LocalTime lt1 = LocalTime.parse(endTime);
            if(lt.isAfter(lt1) || lt.equals(lt1)) {
                throw new APINotValidException("Please enter valid date");
            }
            Client client = ClientBuilder.newClient();
            Response response = client.target(URL)
                    .queryParam("q", name)
                    .queryParam("appid", API_KEY)
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            if(response.getStatus() == 200) {
                JsonRequest jsonRequest = response.readEntity(JsonRequest.class);
                List<WeatherEntity> data = weatherService.getData(jsonRequest, lt, lt1);
                long end = System.currentTimeMillis();
                return new FinalEntity(response.getStatus(), response.getStatusInfo().getReasonPhrase(), (int) (end-start), DESCRIPTION, data);
            } else {
                throw new APINotValidException(response.getStatus() + ":" + response.getStatusInfo());
            }
        } catch (Exception e) {
            throw new APINotValidException(e.getMessage());
        }
    }
}
