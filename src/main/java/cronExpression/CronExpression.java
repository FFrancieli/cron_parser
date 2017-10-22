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

    private List<Integer> calculateRange(String hour, int end) {
        List<Integer> minutesInterval = splitIntervalIntoIntegerList(hour, "/");

        Integer rangeStart = minutesInterval.get(0);
        Integer rangeStep = minutesInterval.get(1);

        return Range.range(rangeStart, end, rangeStep);
    }

    private List<Integer> calculateRange(String hour) {
        List<Integer> rangeBoundaries = splitIntervalIntoIntegerList(hour,"-");

        int startOfRange = rangeBoundaries.get(0);
        int endOfRange = rangeBoundaries.get(1);

        return Range.range(startOfRange, endOfRange);
    }

    private List<Integer> splitIntervalIntoIntegerList(String minute, String delimiter) {
        return Arrays.stream(minute.split(delimiter))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<Integer> getMinute() {
        return minute;
    }

    public List<Integer> getHour() {
        return hour;
    }
}
