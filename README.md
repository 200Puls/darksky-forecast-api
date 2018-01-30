# darksky-forecast-api

* darksky-forecast-api is a Java library to access the [darksky.net](https://darksky.net) weather API
* **No dependencies** for the the base library
* You can pipe the response to the **JSON framework** of choice or use it directly as String, Stream or byte[] (e.g. poxying)
* For Jackson users there is **darksky-forecast-api-jackson** to get the Forecast parsed as Java beans. This library includes the base library as dependency.
* deployed to Maven Central
* Javadoc available: https://200puls.github.io/darksky-forecast-api/
* Java 9 module names configured in release version for stable module names. Preview version of full Java 9 support in branch https://github.com/200Puls/darksky-forecast-api/tree/java9

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
        .exdclude(ForecastRequestBuilder.Block.minutely)
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
            <version>1.2.1</version>
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
            <version>1.2.1</version>
    </dependency>
```

It pulls in the base library automatically.

For more information about Request and Response format see: [DarkSky documentation](https://darksky.net/dev/docs/forecast).
