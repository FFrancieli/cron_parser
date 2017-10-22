package ParserFactory;

import org.junit.Before;
import org.junit.Test;
import parsers.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class CronFieldParserFactoryTest {

    private CronFieldParserFactory parserFactory;

    @Before
    public void setUp() throws Exception {
        parserFactory = new CronFieldParserFactory(0);
    }

    @Test
    public void returnsNumberToListStrategyObjectWhenCronFieldIsSingleNumber() throws Exception {
        Parser parser = parserFactory.getStrategy("12");

        assertThat(parser, is(instanceOf(NumberToListStrategy.class)));
    }

    @Test
    public void returnsCalculateDelimitedRangeStrategyObjectWhenCronFieldContainsDashSymbol() throws Exception {
        Parser parser = parserFactory.getStrategy("1-10");

        assertThat(parser, is(instanceOf(CalculateDelimitedRangeStrategy.class)));
    }

    @Test
    public void returnsMultipleNumbersToListStrategyWhenCronFieldContainsCommaSymbol() throws Exception {
        Parser parser = parserFactory.getStrategy("9,22");

        assertThat(parser, is(instanceOf(MultipleNumbersToListStrategy.class)));
    }

    @Test
    public void returnsCalculateRangeWithStepStrategyWhenCronFieldContainsSlashSymbol() throws Exception {
        Parser parser = parserFactory.getStrategy("9/22");

        assertThat(parser, is(instanceOf(CalculateRangeWithStepStrategy.class)));
    }

    @Test
    public void returnsCalculateRangeWithStepStrategyWhenCronFieldStartsWithAsteriskFollowedBySlash() throws Exception {
        Parser parser = parserFactory.getStrategy("*/22");

        assertThat(parser, is(instanceOf(CalculateRangeFromZeroToMaximumWithStepStrategy.class)));
    }

    @Test
    public void returnsCalculateRangeFromZeroToMaximumWhenRangeContainsOnlyAsteriskSymbol() throws Exception {
        Parser parser = parserFactory.getStrategy("*");

        assertThat(parser, is(instanceOf(CalculateRangeFromZeroToMaximumStrategy.class)));
    }
}