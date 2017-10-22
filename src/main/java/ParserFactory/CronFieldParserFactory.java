package ParserFactory;

import parsers.*;

public class CronFieldParserFactory {
    private int maximumRangeValue;

    public CronFieldParserFactory(int maximumRangeValue) {
        this.maximumRangeValue = maximumRangeValue;
    }

    public Parser getStrategy(String fieldValue) {
        if (fieldValue.contains(",")) {
            return new MultipleNumbersToListStrategy();
        }
        if (fieldValue.contains("-")) {
            return new CalculateDelimitedRangeStrategy();
        }
        if(fieldValue.contains("*/")) {
            return new CalculateRangeFromZeroToMaximumWithStepStrategy(maximumRangeValue);
        }
        if (fieldValue.contains("/")) {
            return new CalculateRangeWithStepStrategy(maximumRangeValue);
        }
        if (fieldValue.equals("*")) {
            return new CalculateRangeFromZeroToMaximumStrategy(maximumRangeValue);
        }

        return new NumberToListStrategy();
    }
}
