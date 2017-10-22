package parsers;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateDelimitedRangeStrategyTest {

    @Test
    public void returnsRangeFromOneToFive() throws Exception {
        CalculateDelimitedRangeStrategy delimitedRangeStrategy = new CalculateDelimitedRangeStrategy();

        List<Integer> range = delimitedRangeStrategy.parse("1-5");

        assertThat(range.size(), is(5));
        assertThat(range, hasItems(1, 2, 3, 4, 5));
    }
}