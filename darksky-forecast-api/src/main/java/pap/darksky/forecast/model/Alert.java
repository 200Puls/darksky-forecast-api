package pap.darksky.forecast.model;

import java.time.Instant;

public class Alert {

    private String title;
    private String description;
    private Instant time;
    private Instant expires;
    private String uri;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public Instant getExpires() {
        return expires;
    }

    public void setExpires(Instant expires) {
        this.expires = expires;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
