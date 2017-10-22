package parsers;

import range.Range;

import java.util.List;

public class CalculateRangeFromZeroToMaximumWithStepStrategy implements Parser {
    int endOfRange;

    public CalculateRangeFromZeroToMaximumWithStepStrategy(int endOfRange) {
        this.endOfRange = endOfRange;
    }

    @Override
    public List<Integer> parse(String value) {
        int step = Integer.parseInt(value.split("/")[1]);

        return Range.range(0, endOfRange, step);
    }
}
