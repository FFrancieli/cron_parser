package parsers;

import java.util.Collections;
import java.util.List;

public class NumberToListStrategy implements Parser {
    private final String fieldValue;

    public NumberToListStrategy(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public List<Integer> parse() {
        return Collections.singletonList(Integer.parseInt(fieldValue));
    }
}
