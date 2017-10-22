package ParserFactory;

import parsers.*;

public class CronFieldParserFactory {
    private int maximumRangeValue;

    public CronFieldParserFactory(int maximumRangeValue) {
        this.maximumRangeValue = maximumRangeValue;
    }

    public Parser getStrategy(String fieldValue) {
        if (fieldValue.contains(",")) {
            return new MultipleNumbersToListStrategy(fieldValue);
        }
        if (fieldValue.contains("-")) {
            return new CalculateDelimitedRangeStrategy(fieldValue);
        }
        if(fieldValue.contains("*/")) {
            return new CalculateRangeFromZeroToMaximumWithStepStrategy(maximumRangeValue, fieldValue);
        }
        if (fieldValue.contains("/")) {
            return new CalculateRangeWithStepStrategy(maximumRangeValue, fieldValue);
        }
        if (fieldValue.equals("*")) {
            return new CalculateRangeFromZeroToMaximumStrategy(maximumRangeValue);
        }

        return new NumberToListStrategy(fieldValue);
    }
}
