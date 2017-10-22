package cronExpression;

import ParserFactory.CronFieldParserFactory;
import parsers.Parser;
import range.Range;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CronExpression {
    private final int MAXIMUM_MINUTES = 59;
    private final int MAXIMUM_HOURS = 23;

    private final List<Integer> minute;
    private final List<Integer> hour;

    public CronExpression(String minute, String hour) {
        this.minute = parseToMinutesList(minute);
        this.hour = parseToHoursList(hour);
    }

    private List<Integer> parseToMinutesList(String minute) {
        CronFieldParserFactory fieldParserFactory = new CronFieldParserFactory(MAXIMUM_MINUTES);
        Parser parser = fieldParserFactory.getStrategy(minute);

        return parser.parse(minute);
    }

    private List<Integer> parseToHoursList(String hour) {
        CronFieldParserFactory fieldParserFactory = new CronFieldParserFactory(MAXIMUM_HOURS);

        Parser parser = fieldParserFactory.getStrategy(hour);

        return parser.parse(hour);
    }

    public List<Integer> getMinute() {
        return minute;
    }

    public List<Integer> getHour() {
        return hour;
    }
}
