package parsers;

import range.Range;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateRangeWithStepStrategy implements Parser {
    int endOfRange;

    public CalculateRangeWithStepStrategy(int endOfRange) {
        this.endOfRange = endOfRange;
    }

    @Override
    public List<Integer> parse(String value) {
        List<Integer> rangeDelimiters = stringArrayToIntegerList(value.split("/"));

        int start = rangeDelimiters.get(0);
        int step = rangeDelimiters.get(1);

        return Range.range(start, endOfRange, step);
    }
    private List<Integer> stringArrayToIntegerList(String[] array) {
        return Arrays.stream(array).map(Integer::parseInt).collect(Collectors.toList());
    }
}