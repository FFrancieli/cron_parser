package parsers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleNumbersToListStrategy implements Parser {
    private final String fieldValue;

    public MultipleNumbersToListStrategy(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public List<Integer> parse() {
        return stringArrayToIntegerList(fieldValue.split(","));
    }

    private List<Integer> stringArrayToIntegerList(String[] array) {
        return Arrays.stream(array).map(Integer::parseInt).collect(Collectors.toList());
    }
}
