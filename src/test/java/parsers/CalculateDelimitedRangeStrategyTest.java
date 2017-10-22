package parsers;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateDelimitedRangeStrategyTest {

    @Test
    public void returnsRangeFromOneToFive() throws Exception {
        CalculateDelimitedRangeStrategy delimitedRangeStrategy = new CalculateDelimitedRangeStrategy("1-5");

        List<Integer> range = delimitedRangeStrategy.parse();

        assertThat(range.size(), is(5));
        assertThat(range, hasItems(1, 2, 3, 4, 5));
    }
}