package range;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Range {

    public static List<Integer> range(int start, int end) {
        return IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }

    public static List<Integer> range(int start, int end, int step) {
        List<Integer> range = new ArrayList<>();

        for (int i = start; i <= end; i += step) {
            range.add(i);
        }

        return range;
    }
}
