package algorithm;

import java.io.IOException;
import java.util.List;

public class FindDayWithMinTemperatureSpread {

    private final Helper dataMunger = new Helper();
    private final String dataFileName;

    public FindDayWithMinTemperatureSpread(String dataFileName) {
        this.dataFileName = dataFileName;
    }

    public String findDay(OneTwo mode) throws IOException {
        List<String> rawData = dataMunger.l(dataFileName);
        List<W> weatherDataList = parse(rawData);
        W weatherDataWithMinSpread = dataMunger.find(weatherDataList, mode);
        return weatherDataWithMinSpread.i();
    }

    List<W> parse(List<String> weatherDataLines) {
        return dataMunger.p(weatherDataLines, //
                this::startsWithDayOfMonth, //
                this::parseDayWithTemperatureRange);
    }

    private boolean startsWithDayOfMonth(String line) {
        return line.matches("\\s*\\d+\\s.*");
    }

    private W parseDayWithTemperatureRange(String[] columns) {
        int colDy = 0;
        int colMxt = 1;
        int colMnT = 2;

        int day = Integer.parseInt(columns[colDy]);
        int max = Integer.parseInt(removeTrailing(columns[colMxt], "*"));
        int min = Integer.parseInt(removeTrailing(columns[colMnT], "*"));

        return new W(day, max, min);
    }

    private String removeTrailing(String field, String noise) {
        if (field.endsWith(noise)) {
            int beforeNoise = field.length() - noise.length();
            return field.substring(0, beforeNoise);
        }
        return field;
    }

}
