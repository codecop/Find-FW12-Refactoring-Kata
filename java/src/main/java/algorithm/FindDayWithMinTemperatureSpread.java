package algorithm;

import java.io.IOException;
import java.util.List;

public class FindDayWithMinTemperatureSpread {

    private final DataMunger dataMunger = new DataMunger();
    private final String dataFileName;

    public FindDayWithMinTemperatureSpread(String dataFileName) {
        this.dataFileName = dataFileName;
    }

    public String findDay() throws IOException {
        List<String> rawData = dataMunger.load(dataFileName);
        List<WeatherData> weatherDataList = parse(rawData);
        WeatherData weatherDataWithMinSpread = dataMunger.findMinDifference(weatherDataList);
        return weatherDataWithMinSpread.resultId();
    }

    List<WeatherData> parse(List<String> weatherDataLines) {
        return dataMunger.parse(weatherDataLines, //
                this::startsWithDayOfMonth, //
                this::parseDayWithTemperatureRange);
    }

    private boolean startsWithDayOfMonth(String line) {
        return line.matches("\\s*\\d+\\s.*");
    }

    private WeatherData parseDayWithTemperatureRange(String[] columns) {
        int colDy = 0;
        int colMxt = 1;
        int colMnT = 2;

        int day = Integer.parseInt(columns[colDy]);
        int max = Integer.parseInt(removeTrailing(columns[colMxt], "*"));
        int min = Integer.parseInt(removeTrailing(columns[colMnT], "*"));

        return new WeatherData(day, max, min);
    }

    private String removeTrailing(String field, String noise) {
        if (field.endsWith(noise)) {
            int beforeNoise = field.length() - noise.length();
            return field.substring(0, beforeNoise);
        }
        return field;
    }

}
