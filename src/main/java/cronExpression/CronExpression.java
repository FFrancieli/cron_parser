package cronExpression;

import range.Range;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CronExpression {
    private final int MAXIMUM_MINUTES = 59;

    private final List<Integer> minute;
    private final List<Integer> hour;

    public CronExpression(String minute, String hour) {
        this.minute = parseToMinutesList(minute);
        this.hour = parseToHoursList(hour);
    }

    private List<Integer> parseToMinutesList(String minute) {
        if (minute.contains(",")) {
            return splitIntervalIntoIntegerList(minute, ",");
        }
        if (minute.contains("-")) {
            return calculateRange(minute);
        }
        if(minute.contains("*/")) {
            int step = Integer.parseInt(minute.split("/")[1]);

            return Range.range(0, 59, step);
        }
        if (minute.contains("/")) {
            List<Integer> minutesInterval = splitIntervalIntoIntegerList(minute, "/");

            Integer rangeStart = minutesInterval.get(0);
            Integer rangeStep = minutesInterval.get(1);

           return Range.range(rangeStart, MAXIMUM_MINUTES, rangeStep);
        }
        if (minute.equals("*")) {
            return Range.range(0, MAXIMUM_MINUTES);
        }


        return Collections.singletonList(Integer.parseInt(minute));
    }

    private List<Integer> parseToHoursList(String hour) {
        if (hour.contains(",")) {
            return splitIntervalIntoIntegerList(hour, ",");
        }

        if (hour.contains("-")) {
            return calculateRange(hour);
        }
        return Collections.singletonList(Integer.parseInt(hour));
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
