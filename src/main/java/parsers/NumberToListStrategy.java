package parsers;

import java.util.Collections;
import java.util.List;

public class NumberToListStrategy implements Parser {

    @Override
    public List<Integer> parse(String value) {
        return Collections.singletonList(Integer.parseInt(value));
    }
}
