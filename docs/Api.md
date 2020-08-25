Tiny weather bulletin is a weather forecast application used to check the weather conditions of the cities.
This service uses the OpenWeather API (​ https://openweathermap.org/api​ ) to retrieve the weather forecast.
Given a city name and the working hours it gives the average temperature and humidity inside and outside
working hours for the next three days.
The application contains following Rest APi

1. Fetch Data given city name and working hours.

URL for fetching data id:
[GET] http://localhost:8080/weather/{cityName}/{startTime}/{endTime}
It takes as an input city name and will return the weather forecast that is average temperature and humidity
for inside and outside working hours for next three days by using the city name and start time and end time for
working hours provided.