package ParserFactory;

import parsers.*;

public class CronFieldParserFactory {
    private int maximumRangeValue;
    private int minimumValueForRange;

    public CronFieldParserFactory(int maximumRangeValue) {
        this.maximumRangeValue = maximumRangeValue;
    }

    public CronFieldParserFactory(int maximumRangeValue, int minimumValueForRange) {
        this.maximumRangeValue = maximumRangeValue;
        this.minimumValueForRange = minimumValueForRange;
    }

    public Parser getStrategy(String fieldValue) {
        if (fieldValue.contains(",")) {
            return new MultipleNumbersToListStrategy(fieldValue);
        }
        if (fieldValue.contains("-")) {
            return new CalculateDelimitedRangeStrategy(fieldValue);
        }
        if(fieldValue.contains("*/")) {
            return new CalculateRangeFromZeroToMaximumWithStepStrategy(maximumRangeValue, fieldValue, minimumValueForRange);
        }
        if (fieldValue.contains("/")) {
            return new CalculateRangeWithStepStrategy(maximumRangeValue, fieldValue);
        }
        if (fieldValue.equals("*")) {
            return new CalculateRangeUpToMaximumStrategy(maximumRangeValue, minimumValueForRange);
        }

        return new NumberToListStrategy(fieldValue);
    }
}
