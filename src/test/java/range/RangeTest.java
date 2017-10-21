package range;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class RangeTest {
    @Test
    public void returnsRangeFromOneToFive() throws Exception {
        List<Integer> range = Range.range(1, 5);

        assertThat(range, hasItems(1, 2, 3, 4, 5));
    }

    @Test
    public void returnsRangeFromOneToTenWithStep() throws Exception {
        List<Integer> range = Range.range(1, 10, 3);

        assertThat(range, hasItems(1, 4, 7, 10));
    }
}