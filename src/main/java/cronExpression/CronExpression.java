package cronExpression;

import ParserFactory.CronFieldParserFactory;
import parsers.Parser;

import java.util.List;

public class CronExpression {
    private final int MAXIMUM_MINUTES = 59;
    private final int MAXIMUM_HOURS = 23;
    private final int MAXIMUM_DAYS_OF_MONTH = 31;
    private final int MAXIMUM_MONTHS = 12;
    private final int MAXIMUM_DAYS_OF_WEEK = 7;

    private final List<Integer> minute;
    private final List<Integer> hour;
    private final List<Integer> dayOfMonth;
    private final List<Integer> month;
    private final List<Integer> dayOfWeek;

    public CronExpression(String minute, String hour, String dayOfMonth, String month, String dayOfWeek, String command) {
        this.minute = parseToMinutesList(minute);
        this.hour = parseToHoursList(hour);
        this.dayOfMonth = parseToListOfDaysOfMonth(dayOfMonth);
        this.month = parseToListOfMonths(month);
        this.dayOfWeek = parseToListOfDaysOfWeek(dayOfWeek);
    }

    private List<Integer> parseToMinutesList(String minute) {
        CronFieldParserFactory fieldParserFactory = new CronFieldParserFactory(MAXIMUM_MINUTES);

        return parseField(fieldParserFactory, minute);
    }

    private List<Integer> parseToHoursList(String hour) {
        CronFieldParserFactory fieldParserFactory = new CronFieldParserFactory(MAXIMUM_HOURS);

        return parseField(fieldParserFactory, hour);
    }

    private List<Integer> parseToListOfDaysOfMonth(String daysOfMonth) {
        CronFieldParserFactory fieldParserFactory = new CronFieldParserFactory(MAXIMUM_DAYS_OF_MONTH);

        return parseField(fieldParserFactory, daysOfMonth);
    }

    private List<Integer> parseToListOfMonths(String month) {
        CronFieldParserFactory fieldParserFactory = new CronFieldParserFactory(MAXIMUM_MONTHS);

        return parseField(fieldParserFactory, month);
    }

    private List<Integer> parseToListOfDaysOfWeek(String dayOfWeek) {
        CronFieldParserFactory fieldParserFactory = new CronFieldParserFactory(MAXIMUM_DAYS_OF_WEEK);

        return parseField(fieldParserFactory, dayOfWeek);
    }

    private List<Integer> parseField(CronFieldParserFactory factory, String fieldValue) {
        Parser parser = factory.getStrategy(fieldValue);

        return parser.parse();
    }

    public List<Integer> getMinute() {
        return minute;
    }

    public List<Integer> getHour() {
        return hour;
    }

    public List<Integer> getDayOfMonth() {
        return dayOfMonth;
    }

    public List<Integer> getMonth() {
        return month;
    }

    public List<Integer> getDayOfWeek() {
        return dayOfWeek;
    }
}
