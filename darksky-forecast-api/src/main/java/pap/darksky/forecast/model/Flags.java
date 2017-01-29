package pap.darksky.forecast.model;

public class Flags {

    private String units;
    private boolean darkskyUunavailable;
    private boolean metnoLicense;

    public void setUnits(String units) {
        this.units = units;
    }

    public String getUnits() {
        return units;
    }

    public boolean isDarkskyUunavailable() {
        return darkskyUunavailable;
    }

    public void setDarkskyUunavailable(boolean darkskyUunavailable) {
        this.darkskyUunavailable = darkskyUunavailable;
    }

    public boolean isMetnoLicense() {
        return metnoLicense;
    }

    public void setMetnoLicense(boolean metnoLicense) {
        this.metnoLicense = metnoLicense;
    }

}
