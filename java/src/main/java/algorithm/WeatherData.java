package algorithm;

public class WeatherData implements Data {

    public final int day;
    public final int maxTemperature;
    public final int minTemperature;

    public WeatherData(int day, int maxTemperature, int minTemperature) {
        this.day = day;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }

    private int tempSpread() {
        return maxTemperature - minTemperature;
    }

    @Override
    public String resultId() {
        return Integer.toString(day);
    }

    @Override
    public int sortBy() {
        return tempSpread();
    }

}
