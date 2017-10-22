package parsers;

import range.Range;

import java.util.List;

public class CalculateRangeFromZeroToMaximumWithStepStrategy implements Parser {
    private final int endOfRange;
    private final String fieldValue;
    private int rangeStart;

    public CalculateRangeFromZeroToMaximumWithStepStrategy(int endOfRange, String fieldValue) {
        this.endOfRange = endOfRange;
        this.fieldValue = fieldValue;
    }

    public CalculateRangeFromZeroToMaximumWithStepStrategy(int endOfRange, String fieldValue,  int rangeStart) {
        this(endOfRange, fieldValue);
        rangeStart = rangeStart;
    }

    @Override
    public List<Integer> parse() {
        int step = Integer.parseInt(fieldValue.split("/")[1]);

        return Range.range(0, endOfRange, step);
    }
}
