package parsers;

import range.Range;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateDelimitedRangeStrategy implements Parser {

    private final String fieldValue;

    public CalculateDelimitedRangeStrategy(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public List<Integer> parse() {
        List<Integer> rangeDelimiters = splitIntervalIntoIntegerList(fieldValue, "-");

        int start = rangeDelimiters.get(0);
        int end = rangeDelimiters.get(1);

        return Range.range(start, end);
    }

    private List<Integer> splitIntervalIntoIntegerList(String minute, String delimiter) {
        return Arrays.stream(minute.split(delimiter))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
