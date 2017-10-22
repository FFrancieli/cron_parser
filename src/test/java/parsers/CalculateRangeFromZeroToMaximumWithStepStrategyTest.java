package parsers;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateRangeFromZeroToMaximumWithStepStrategyTest {

    @Test
    public void calculateRangeFromZeroToMaximumWith10AsStep() throws Exception {
        CalculateRangeFromZeroToMaximumWithStepStrategy rangeStrategy =
                new CalculateRangeFromZeroToMaximumWithStepStrategy(50, "*/10");

        List<Integer> range = rangeStrategy.parse();

        assertThat(range.size(), is(6));
        assertThat(range, hasItems(0, 10, 20, 30, 40, 50));
    }
}