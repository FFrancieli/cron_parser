package cronExpression;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CronExpressionTest {

    @Test
    public void returnsListWithMinutesWhenMinutesFieldIsNumericOnCronExpression() throws Exception {
        CronExpression cronExpression = new CronExpression("20", "0");

        List<Integer> minutes = cronExpression.getMinute();
        assertThat(minutes.size(), is(1));
        assertThat(minutes, hasItem(20));
    }

    @Test
    public void returnsListWithEveryNumberSeparatedByComaOnMinutesField() throws Exception {
        CronExpression cronExpression = new CronExpression("1,5", "0");

        List<Integer> minutes = cronExpression.getMinute();
        assertThat(minutes.size(), is(2));
        assertThat(minutes, hasItems(1, 5));
    }

    @Test
    public void returnsListWithRangeOfMinutesWhenMinuteFieldContainsDash() throws Exception {
        CronExpression cronExpression = new CronExpression("1-5", "0");

        List<Integer> minutes = cronExpression.getMinute();
        assertThat(minutes.size(), is(5));
        assertThat(minutes, hasItems(1, 2, 3, 4, 5));
    }

    @Test
    public void parsesMinutesToListAtEveryFifteenMinutesExpressionStartingFromOne() throws Exception {
        CronExpression cronExpression = new CronExpression("1/15", "0");

        List<Integer> minute = cronExpression.getMinute();
        assertThat(minute.size(), is(4));
        assertThat(minute, hasItems(1, 16, 31, 46));
    }

    @Test
    public void parsesMinutesToListAtEveryFifteenMinutesExpression() throws Exception {
        CronExpression cronExpression = new CronExpression("*/15", "0");

        List<Integer> minute = cronExpression.getMinute();
        assertThat(minute.size(), is(4));
        assertThat(minute, hasItems(0, 15, 30, 45));
    }

    @Test
    public void returnsListWithAllNumberFrom0To59ForCronExpressionWithAsteriskOnly() throws Exception {
        CronExpression cronExpression = new CronExpression("*", "0");

        List<Integer> minutes = cronExpression.getMinute();
        List<Integer> everyMinute = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,
                46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59);

        assertThat(minutes, is(everyMinute));
    }

    @Test
    public void returnsListWithNumber4ForCronStartingOn3hous() throws Exception {
        CronExpression cronExpression = new CronExpression("0", "3");

        List<Integer> hours = cronExpression.getHour();
        assertThat(hours.size(), is(1));
        assertThat(hours, hasItem(3));
    }

    @Test
    public void parsesHourFieldsToListWithRangeFromOneToSeven() throws Exception {
        CronExpression cronExpression = new CronExpression("0", "1-7");

        List<Integer> hours = cronExpression.getHour();
        assertThat(hours.size(), is(7));
        assertThat(hours, hasItems(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    public void parsesHourFieldsThatHappenAt2And5An7HoursToHoursList() throws Exception {
        CronExpression cronExpression = new CronExpression("0", "2,5,7");

        List<Integer> hours = cronExpression.getHour();
        assertThat(hours.size(), is(3));
        assertThat(hours, hasItems(2, 5, 7));
    }
}