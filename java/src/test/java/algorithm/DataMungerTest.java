package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import algorithm.DataMunger;
import algorithm.WeatherData;

class DataMungerTest {

    DataMunger dataMunger = new DataMunger();

    @Test
    void shouldLoadSingleLineIntoListOfLines() throws IOException {
        List<String> lines = dataMunger.load("single_pure_line.dat");

        assertEquals(1, lines.size());
        assertEquals("   2  79    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5",
                lines.get(0));
    }

    @Test
    void shouldOutputDayOfMinTimeSpread() {
        List<WeatherData> data = Arrays.asList( //
                new WeatherData(3, 89, 50), //
                new WeatherData(5, 89, 55), // has min spread
                new WeatherData(7, 89, 54));

        WeatherData minSpreadWeather = dataMunger.findMinDifference(data);

        assertEquals(5, minSpreadWeather.day);
    }

}
