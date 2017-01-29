# darksky-forecast-api

===================
darksky-forecast-api is a Java library to access the [darksky.net](https://darksky.net) API.
The base library **darksky-forecast-api** has no dependencies besides Java 1.8.
If you are are Jackson user you can just use **darksky-forecast-api-jackson** to get the Forecast parsed as Java beans. This library includes the base library as dependency.

Example usage for base library:

```java
        ForecastRequest request = new ForecastRequestBuilder()
                .key(new APIKey("your-private-key"))
                .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275))).build();

        DarkSkyClient client = new DarkSkyClient();
        String forecast = client.forecastJsonString(request);

The response can be returned as byte[], String or InputStream. Useful if you want to proxy the API or only save the result.

Example usage for jackson library:

```java
         ForecastRequest request = new ForecastRequestBuilder()
                .key(new APIKey("your-private-key"))
                .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275))).build();

        DarkSkyJacksonClient client = new DarkSkyJacksonClient();
        Forecast forecast = client.forecast(request);
        System.out.println("forecast " + forecast);
        System.out.println("forecast " + forecast.getCurrently().getTemperature());


For information about Request and Response format see: [DarkSky documentation](https://darksky.net/dev/docs/forecast).
