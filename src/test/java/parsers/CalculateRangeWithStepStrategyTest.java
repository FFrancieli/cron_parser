package parsers;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateRangeWithStepStrategyTest {

    @Test
    public void returnsRangeFromOneToTwentyCountingThenByThen() throws Exception {
        CalculateRangeWithStepStrategy calculateRangeWithStepStrategy = new CalculateRangeWithStepStrategy(20);

        List<Integer> range = calculateRangeWithStepStrategy.parse("1/10");

        assertThat(range.size(), is(2));
        assertThat(range, hasItems(1, 11));
    }
}