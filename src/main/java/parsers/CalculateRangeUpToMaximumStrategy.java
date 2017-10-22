package parsers;

import range.Range;

import java.util.List;

public class CalculateRangeUpToMaximumStrategy implements Parser {
    private final int endOfRange;
    private final int rangeStart;

    public CalculateRangeUpToMaximumStrategy(int endOfRange, int rangeStart) {
        this.endOfRange = endOfRange;
        this.rangeStart = rangeStart;
    }

    @Override
    public List<Integer> parse() {
        return Range.range(rangeStart, endOfRange);
    }
}
