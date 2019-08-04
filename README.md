# darksky-forecast-api

* darksky-forecast-api is a Java library to access the [darksky.net](https://darksky.net) weather API
* **No dependencies** for the the base library
* You can pipe the response to the **JSON framework** of choice or use it directly as String, Stream or byte[] (e.g. poxying)
* For Jackson users there is **darksky-forecast-api-jackson** to get the Forecast parsed as Java beans. This library includes the base library as dependency.
* deployed to Maven Central
* Javadoc available: https://200puls.github.io/darksky-forecast-api/
* Full Java 9 module support (2.0.2 use 1.3.1 for java 8 sources)

Example usage for base library:

```java
    ForecastRequest request = new ForecastRequestBuilder()
        .key(new APIKey("your-private-key"))
        .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275))).build();

    DarkSkyClient client = new DarkSkyClient();
    String forecast = client.forecastJsonString(request);
```

The response can be returned as byte[], String or InputStream. Useful if you want to proxy the API or only save the result.

The API also supports time machine requests and other API parameters:

```java
    ForecastRequest request = new ForecastRequestBuilder()
        .key(new APIKey("your-private-key"))
        .time(Instant.now().minus(5, ChronoUnit.DAYS))
        .language(ForecastRequestBuilder.Language.de)
        .units(ForecastRequestBuilder.Units.us)
        .exclude(ForecastRequestBuilder.Block.minutely)
        .extendHourly()
        .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275))).build();

    DarkSkyClient client = new DarkSkyClient();
    String forecast = client.forecastJsonString(request);
```

The Maven dependency is:

```xml
      <dependency>
            <groupId>tk.plogitech</groupId>
            <artifactId>darksky-forecast-api</artifactId>
            <version>2.0.2</version>
     </dependency>
```

Example usage for the Jackson library:

```java
    ForecastRequest request = new ForecastRequestBuilder()
        .key(new APIKey("your-private-key"))
        .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275))).build();

    DarkSkyJacksonClient client = new DarkSkyJacksonClient();
    Forecast forecast = client.forecast(request);
    System.out.println("forecast " + forecast);
    System.out.println("forecast " + forecast.getCurrently().getTemperature());
```      
The Maven dependency for the Jackson library is:

```xml
    <dependency>
            <groupId>tk.plogitech</groupId>
            <artifactId>darksky-forecast-api-jackson</artifactId>
            <version>2.0.2</version>
    </dependency>
```

It pulls in the base library automatically.

For more information about Request and Response format see: [DarkSky documentation](https://darksky.net/dev/docs/forecast).
