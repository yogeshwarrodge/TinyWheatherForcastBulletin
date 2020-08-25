package com.wheather.forcast.service;

import com.weather.forecast.model.JsonRequest;
import com.weather.forecast.model.Result;
import com.weather.forecast.model.WeatherEntity;
import com.weather.forecast.model.WeatherList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class WeatherService {

    private static final String INSIDE_WORKING = "inside";
    private static final String OUTSIDE_WORKING = "outside";
    @Value("${startDay}")
    private int DEFAULT_START;
    @Value("${endDay}")
    private int DEFAULT_END;
    /**
     * Modify the response obtain from openweather.org
     * @param jsonRequest
     * @param startTime
     * @param endTime
     * @return
     */
    public List<WeatherEntity> getData(JsonRequest jsonRequest, LocalTime startTime, LocalTime endTime) {
        List<WeatherEntity> newDataList = new ArrayList<>();
        List<WeatherList> listData = jsonRequest.getList();
        IntStream.rangeClosed(DEFAULT_START, DEFAULT_END)
                .boxed().forEach(integer -> {
            List<WeatherList> collect = getForDate(listData,  LocalDate.now().plusDays(integer));
            List<WeatherList> inside = getInsideWorkingList(collect, startTime, endTime);
            collect.removeAll(inside);

            float avgMaxTemp = getMaxTempAvg(inside).floatValue();
            float avgMinTemp = getMinTempAvg(inside).floatValue();
            float avgHumidity = getHumidityAvg(inside).floatValue();
            Result list = new Result(INSIDE_WORKING, avgMaxTemp, avgMinTemp, avgHumidity);

            avgMaxTemp = getMaxTempAvg(collect).floatValue();
            avgMinTemp = getMinTempAvg(collect).floatValue();
            avgHumidity = getHumidityAvg(collect).floatValue();
            Result list2 = new Result(OUTSIDE_WORKING, avgMaxTemp, avgMinTemp, avgHumidity);

            WeatherEntity data1 = new WeatherEntity( LocalDate.now().plusDays(integer), Arrays.asList(list,list2) );
            newDataList.add(data1);
        });

        return newDataList;
    }

    /**
     * Modify data by date
     * @param listData
     * @param localDateTime
     * @return
     */
    private List<WeatherList> getForDate(List<WeatherList> listData, LocalDate localDateTime){
        return listData.stream().filter(e -> e.getDtTxt().getDayOfMonth() == localDateTime.getDayOfMonth()).collect(Collectors.toList());
    }

    /**
     * Modify data by time
     * @param collect
     * @param sTime
     * @param eTime
     * @return
     */
    private List<WeatherList> getInsideWorkingList(List<WeatherList> collect, LocalTime sTime, LocalTime eTime) {
        return collect.stream().filter(e -> e.getDtTxt().toLocalTime().isAfter(sTime) && e.getDtTxt().toLocalTime().isBefore(eTime)).collect(Collectors.toList());
    }

    /**
     * get average for max temperature
     * @param weatherLists
     * @return
     */
    private Double getMaxTempAvg(List<WeatherList> weatherLists){
        return weatherLists.stream().mapToDouble(e -> e.getMain().getTempMax()).average().orElse(0.0);
    }

    /**
     * get average for min temperature
     * @param weatherLists
     * @return
     */
    private Double getMinTempAvg(List<WeatherList> weatherLists){
        return weatherLists.stream().mapToDouble(e -> e.getMain().getTempMin()).average().orElse(0.0);
    }

    /**
     * get average for humidity
     * @param weatherLists
     * @return
     */
    private Double getHumidityAvg(List<WeatherList> weatherLists){
        return weatherLists.stream().mapToDouble(e -> e.getMain().getHumidity()).average().orElse(0.0);
    }
}
