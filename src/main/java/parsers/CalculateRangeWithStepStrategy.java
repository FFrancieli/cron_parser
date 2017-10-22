package parsers;

import range.Range;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateRangeWithStepStrategy implements Parser {
    private final int endOfRange;
    private final String fieldValue;

    public CalculateRangeWithStepStrategy(int endOfRange, String fieldValue) {
        this.endOfRange = endOfRange;
        this.fieldValue = fieldValue;
    }

    @Override
    public List<Integer> parse() {
        List<Integer> rangeDelimiters = stringArrayToIntegerList(fieldValue.split("/"));

        int start = rangeDelimiters.get(0);
        int step = rangeDelimiters.get(1);

        return Range.range(start, endOfRange, step);
    }
    private List<Integer> stringArrayToIntegerList(String[] array) {
        return Arrays.stream(array).map(Integer::parseInt).collect(Collectors.toList());
    }
}