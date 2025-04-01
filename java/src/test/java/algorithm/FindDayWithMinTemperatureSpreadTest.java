package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import algorithm.FindDayWithMinTemperatureSpread;
import algorithm.WeatherData;

class FindDayWithMinTemperatureSpreadTest {

    FindDayWithMinTemperatureSpread minSpread = new FindDayWithMinTemperatureSpread("does_not_exist");

    @Test
    void shouldParseSingleLineIntoListOfWeatherData() {
        List<String> lines = Collections.singletonList(
                "   2  79    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5");
        List<WeatherData> data = minSpread.parse(lines);

        assertEquals(2, data.get(0).day);
        assertEquals(79, data.get(0).maxTemperature);
        assertEquals(63, data.get(0).minTemperature);
    }

    @Test
    void shouldIgnoreHeader() {
        List<String> lines = Arrays.asList(//
                "  Dy MxT   MnT   AvT   HDDay  AvDP 1HrP TPcpn WxType PDir AvSp Dir MxS SkyC MxR MnR AvSLP",
                "  16  79    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5");

        List<WeatherData> data = minSpread.parse(lines);

        assertEquals(1, data.size());
        assertEquals(16, data.get(0).day);
    }

    @Test
    void shouldIgnoreEmptyLine() {
        List<String> lines = Arrays.asList(//
                "", "\t", "            ",
                "  16  79    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5");

        List<WeatherData> data = minSpread.parse(lines);

        assertEquals(1, data.size());
    }

    @Test
    void shouldIgnoreLinesNotStartingWithNumber() {
        List<String> lines = Arrays.asList(//
                "  21  79    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5",
                "  mo  82.9  60.5  71.7    16  58.8       0.00              6.9          5.3");

        List<WeatherData> data = minSpread.parse(lines);

        assertEquals(1, data.size());
        assertEquals(21, data.get(0).day);
    }

    @Test
    void shouldIgnoreTrailingAsteriskInTemperatures() {
        List<String> lines = Collections.singletonList(
                "  9  86*    32*   59       6  61.5       0.00         240  7.6 220  12  6.0  78 46 1018.6");

        List<WeatherData> data = minSpread.parse(lines);

        assertEquals(86, data.get(0).maxTemperature);
        assertEquals(32, data.get(0).minTemperature);
    }

    @Test
    void shouldFindMinSpreadDayNumberOfPureLines() throws IOException {
        minSpread = new FindDayWithMinTemperatureSpread("pure_lines.dat");

        String day = minSpread.findDay();

        assertEquals("2", day);
    }

}
