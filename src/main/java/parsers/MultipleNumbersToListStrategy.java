package parsers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleNumbersToListStrategy implements Parser {
    @Override
    public List<Integer> parse(String value) {
        return stringArrayToIntegerList(value.split(","));
    }

    private List<Integer> stringArrayToIntegerList(String[] array) {
        return Arrays.stream(array).map(Integer::parseInt).collect(Collectors.toList());
    }
}
