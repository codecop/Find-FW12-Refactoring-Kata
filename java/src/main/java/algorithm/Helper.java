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

public class Helper {

    public List<String> l(String s) throws IOException {
        String f = "src/test/java/algorithm/" + s;
        Path p = Paths.get(f);
        return Files.readAllLines(p);
    }

    public <D extends Data> D find(List<D> data, OneTwo ot) {
        switch (ot) {
        case ONE:
            data.sort(Comparator.comparing(Data::sort));
            break;
        case TWO:
            data.sort(Comparator.comparing(Data::sort).reversed());
            break;
        default:
            throw new IllegalArgumentException(ot.toString());
        }
        return data.get(0);
    }

    public <D extends Data> List<D> p(List<String> data, Predicate<String> pred, Function<String[], D> fun) {
        return data.stream(). //
                filter(pred). //
                map(this::sp). //
                map(fun). //
                collect(Collectors.toList());
    }

    private String[] sp(String s) {
        return s.trim().split("\\s+");
    }
}
