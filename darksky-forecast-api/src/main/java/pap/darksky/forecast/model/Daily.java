package pap.darksky.forecast.model;

import java.util.List;

/**
 * Represents the forecast for a whole day.
 *
 * @author Puls
 */
public class Daily {

    private String summary;
    private String icon;
    private List<DailyWeatherData> data;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return List containing multiple forecast for whole days.
     */
    public List<DailyWeatherData> getData() {
        return data;
    }

    /**
     * @param data List containing multiple forecast for whole days.
     */
    public void setData(List<DailyWeatherData> data) {
        this.data = data;
    }

}
