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

    public List<String> load(String s) throws IOException {
        String f = "src/test/java/algorithm/" + s;
        Path p = Paths.get(f);
        return Files.readAllLines(p);
    }

    public <D extends Data> D findMinDifference(List<D> data, MinMax mode) {
        switch (mode) {
        case ONE:
            data.sort(Comparator.comparing(Data::sort));
            break;
        case TWO:
            data.sort(Comparator.comparing(Data::sort).reversed());
            break;
        default:
            throw new IllegalArgumentException(mode.toString());
        }
        return data.get(0);
    }

    public <D extends Data> List<D> parse(List<String> data, Predicate<String> isDataLine,
            Function<String[], D> parseLine) {
        return data.stream(). //
                filter(isDataLine). //
                map(this::split). //
                map(parseLine). //
                collect(Collectors.toList());
    }

    private String[] split(String s) {
        return s.trim().split("\\s+");
    }
}
