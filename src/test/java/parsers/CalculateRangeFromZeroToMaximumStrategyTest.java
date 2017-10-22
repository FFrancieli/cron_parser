package parsers;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateRangeFromZeroToMaximumStrategyTest {

    @Test
    public void returnsRangeFromToFive() throws Exception {
        CalculateRangeFromZeroToMaximumStrategy zeroToMaximumStrategy = new CalculateRangeFromZeroToMaximumStrategy(5);

        List<Integer> range = zeroToMaximumStrategy.parse();

        assertThat(range.size(), is(6));
        assertThat(range, hasItems(0, 1, 2, 3, 4, 5));
    }
}