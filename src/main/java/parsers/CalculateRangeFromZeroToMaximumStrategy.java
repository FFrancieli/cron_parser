package parsers;

import range.Range;

import java.util.List;

public class CalculateRangeFromZeroToMaximumStrategy implements Parser {
    int endOfRange;

    public CalculateRangeFromZeroToMaximumStrategy(int endOfRange) {
        this.endOfRange = endOfRange;
    }

    @Override
    public List<Integer> parse(String value) {
        return Range.range(0, endOfRange);
    }
}
