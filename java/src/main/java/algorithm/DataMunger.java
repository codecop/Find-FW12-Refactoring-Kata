package algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataMunger {

    public List<String> load(String dataFileName) throws IOException {
        String resource = "src/test/java/algorithm/" + dataFileName;
        Path dataFile = Paths.get(resource);
        return Files.readAllLines(dataFile);
    }

    public <D extends Data> D findMinDifference(List<D> data) {
        data.sort(Comparator.comparing(Data::sortBy));
        return data.get(0);
    }

    public <D extends Data> List<D> parse(List<String> dataLines, Predicate<String> isDataLine, Function<String[], D> parseLine) {
        return dataLines.stream().
                filter(isDataLine).
                map(this::split).
                map(parseLine).
                collect(Collectors.toList());
    }

    private String[] split(String line) {
        return line.trim().split("\\s+");
    }
}
