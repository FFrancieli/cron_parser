package parsers;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MultipleNumbersToListStrategyTest {

    @Test
    public void returnsListWithAllNumbersPresentOnString() throws Exception {
        MultipleNumbersToListStrategy multipleNumbersToListStrategy = new MultipleNumbersToListStrategy("1,5,10,12,15");

        List<Integer> numbers = multipleNumbersToListStrategy.parse();

        assertThat(numbers.size(), is(5));
        assertThat(numbers, hasItems(1, 5, 10, 12, 15));
    }
}