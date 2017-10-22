package parsers;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NumberToListStrategyTest {
    @Test
    public void returnsListWithInputNumberOnly() throws Exception {
        NumberToListStrategy numberToListStrategy = new NumberToListStrategy("2");

        List<Integer> numberAsList = numberToListStrategy.parse();

        assertThat(numberAsList.size(), is(1));
        assertThat(numberAsList, hasItem(2));
    }
}