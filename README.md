# darksky-forecast-api

===================
* darksky-forecast-api is a Java library to access the [darksky.net](https://darksky.net) weather API.
* MIT licene so feel free to do what you want with this.
* The base library **darksky-forecast-api** has no dependencies besides Java 1.8.
* You can pipe the response to the **JSON framework** of choice. For Jackson users there is **darksky-forecast-api-jackson** to get the Forecast parsed as Java beans. This library includes the base library as dependency.
* Javadoc available: https://200puls.github.io/darksky-forecast-api/

Example usage for base library:

```java
    ForecastRequest request = new ForecastRequestBuilder()
        .key(new APIKey("your-private-key"))
        .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275))).build();

    DarkSkyClient client = new DarkSkyClient();
    String forecast = client.forecastJsonString(request);
```

The response can be returned as byte[], String or InputStream. Useful if you want to proxy the API or only save the result.

The API also supports time machine requests and modifying requests paramters:

The Maven dependency is:

      <dependency>
            <groupId>tk.plogitech</groupId>
            <artifactId>darksky-forecast-api</artifactId>
            <version>0.9</version>
     </dependency>

```java
    ForecastRequest request = new ForecastRequestBuilder()
        .key(new APIKey("your-private-key"))
        .time(Instant.now().minus(5, ChronoUnit.DAYS))
        .language(ForecastRequestBuilder.Language.de)
        .units(ForecastRequestBuilder.Units.us)
        .exdclude(ForecastRequestBuilder.Block.minutely)
        .extendHourly()
        .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275))).build();

    DarkSkyClient client = new DarkSkyClient();
    String forecast = client.forecastJsonString(request);
```

Example usage for jackson library:

```java
    ForecastRequest request = new ForecastRequestBuilder()
        .key(new APIKey("your-private-key"))
        .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275))).build();

    DarkSkyJacksonClient client = new DarkSkyJacksonClient();
    Forecast forecast = client.forecast(request);
    System.out.println("forecast " + forecast);
    System.out.println("forecast " + forecast.getCurrently().getTemperature());
```      
The Maven dependency for the Jackson library is. It pulls in the base library automatically.

    <dependency>
            <groupId>tk.plogitech</groupId>
            <artifactId>darksky-forecast-api-jckson</artifactId>
            <version>0.9</version>
    </dependency>

For information about Request and Response format see: [DarkSky documentation](https://darksky.net/dev/docs/forecast).
