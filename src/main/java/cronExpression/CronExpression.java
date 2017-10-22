package cronExpression;

import ParserFactory.CronFieldParserFactory;
import parsers.Parser;

import java.util.List;

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

        return parseField(fieldParserFactory, minute);
    }

    private List<Integer> parseToHoursList(String hour) {
        CronFieldParserFactory fieldParserFactory = new CronFieldParserFactory(MAXIMUM_HOURS);

        return parseField(fieldParserFactory, hour);
    }

    private List<Integer> parseField(CronFieldParserFactory factory, String fieldValue) {
        Parser parser = factory.getStrategy(fieldValue);

        return parser.parse(fieldValue);
    }

    public List<Integer> getMinute() {
        return minute;
    }

    public List<Integer> getHour() {
        return hour;
    }
}
