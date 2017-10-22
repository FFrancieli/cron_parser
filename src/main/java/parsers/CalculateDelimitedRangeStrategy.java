package parsers;

import range.Range;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateDelimitedRangeStrategy implements Parser {

    @Override
    public List<Integer> parse(String value) {
        List<Integer> rangeDelimiters = splitIntervalIntoIntegerList(value, "-");

        int start = rangeDelimiters.get(0);
        int end = rangeDelimiters.get(1);

        return Range.range(start, end);
    }

    private List<Integer> splitIntervalIntoIntegerList(String minute, String delimiter) {
        return Arrays.stream(minute.split(delimiter))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
